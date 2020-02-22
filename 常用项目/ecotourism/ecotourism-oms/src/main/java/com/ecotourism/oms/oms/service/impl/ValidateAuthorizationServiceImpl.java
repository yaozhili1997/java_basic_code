package com.ecotourism.oms.oms.service.impl;

import com.ecotourism.oms.common.exception.MyException;
import com.ecotourism.oms.common.utils.DateUtil;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.config.ResultMsg;
import com.ecotourism.oms.oms.dao.CooperationDistributionDao;
import com.ecotourism.oms.oms.dao.OmsApiDictionaryDao;
import com.ecotourism.oms.oms.domain.CooperationDistributionDO;
import com.ecotourism.oms.oms.domain.OmsApiDictionaryDO;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.service.ValidateAuthorizationService;
import com.ecotourism.oms.oms.util.Error;
import com.ecotourism.oms.oms.util.IpAdrressUtil;
import com.ecotourism.oms.oms.util.express.util.SignUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

@Service
public class ValidateAuthorizationServiceImpl implements ValidateAuthorizationService {
    private static final Logger logger = LoggerFactory.getLogger(ValidateAuthorizationServiceImpl.class);
    /**接收参数名密文种子**/
    private final String SEED_PARAM = "sign";

    @Autowired
    private CooperationDistributionDao cooperationDistributionDao;
    @Autowired
    private OmsApiDictionaryDao omsApiDictionaryDao;
    @Override
    public String validateAuthorization(RequestVo requestVo,HttpServletRequest request) {
        String seed = request.getParameter(SEED_PARAM);
        String cid = requestVo.getCid();
        if (StringUtils.isBlank(cid)) return Error.getError(ApiEnum.paramError.code, "商户号CID不能为空！");
        CooperationDistributionDO cooperationDistributionDO = new CooperationDistributionDO();
        cooperationDistributionDO.setDistributionNo(cid);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String datatemp = "";
            String data = requestVo.getData();
            while ((datatemp = br.readLine()) != null)
                data += datatemp;
            requestVo.setData(data);
            logger.debug("请求参数==》" + requestVo);
            cooperationDistributionDO = cooperationDistributionDao.queryCooperationDistribution(cooperationDistributionDO);
            ResultMsg resultMsg = checkCoo(cooperationDistributionDO);
            if (!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code()))
                return Error.getError(resultMsg.getReturn_code(), resultMsg.getReturn_msg());
            String whetherMoreEncode = cooperationDistributionDO.getWhetherMoreEncode();
            String signdata = cid + cooperationDistributionDO.getAppId()+cooperationDistributionDO.getAppSecret();
            if ("1".equals(whetherMoreEncode)) {//启动动态加密
                signdata = signdata + data;
            }
            String sign = SignUtil.sign(signdata);
            String distributionNo = cooperationDistributionDO.getDistributionNo();
            if (!sign.equals(seed)) return Error.getError(ApiEnum.signError.code, ApiEnum.signError.msg);
            String whetherCheckIp = cooperationDistributionDO.getWhetherCheckIp();
            String ipAdrress = IpAdrressUtil.getIpAdrress(request);
            requestVo.setIP(ipAdrress);
            if ("1".equals(whetherCheckIp)) {//启用ip现在
                String ips = cooperationDistributionDO.getIps();
                if (!ips.contains(ipAdrress)) {
                    logger.debug("IP白名单验证未通过:" + ipAdrress);
                    return Error.getError(ApiEnum.ipError.code, ApiEnum.ipError.msg);
                }
            }
            OmsApiDictionaryDO omsApiDictionaryDO = new OmsApiDictionaryDO();
            omsApiDictionaryDO.setEnabled("1");
            String servletPath = request.getServletPath();
            omsApiDictionaryDO.setApiurl(servletPath);
            omsApiDictionaryDO.setDistributionNo(distributionNo);
            omsApiDictionaryDO = omsApiDictionaryDao.get(omsApiDictionaryDO);//查询接口版本
            if (omsApiDictionaryDO == null) {
                return Error.getError(ApiEnum.noJurisdiction.code, ApiEnum.noJurisdiction.msg);
            }
            requestVo.setApiVersion(omsApiDictionaryDO.getVersion());
            requestVo.setDistributionNo(distributionNo);
            requestVo.setAppKey(cooperationDistributionDO.getAppId());
            requestVo.setSecret(cooperationDistributionDO.getAppSecret());
            requestVo.setApiUrl(servletPath);
            requestVo.setCooperationDistributionDO(cooperationDistributionDO);
            return "success";
        } catch (MyException m) {
            logger.debug(m.getMessage());
            return m.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return Error.getError(ApiEnum.systemError.code, ApiEnum.systemError.msg);
        }
    }

        /**
         * 检测分销商是否可用
         * @param cooperationDistributionDO
         * @return
         */
    public ResultMsg checkCoo(CooperationDistributionDO cooperationDistributionDO) throws Exception {
        if(cooperationDistributionDO !=null) {
            String enable = cooperationDistributionDO.getEnable();//分销商是否启用
            if ("0".equals(enable)) {
                return ResultMsg.getResultMsg(ApiEnum.cooEnable.code, ApiEnum.cooEnable.msg);
            }
            String apiIsOpen = cooperationDistributionDO.getApiIsOpen();//分销商是否开通接口
            if ("0".equals(apiIsOpen)) {
                return ResultMsg.getResultMsg(ApiEnum.apiNotOpen.code, ApiEnum.apiNotOpen.msg);
            }
            Date endDate = cooperationDistributionDO.getEndDate();//分销商是否签约到期
            if (endDate != null && DateUtil.getsdfDayTime() > endDate.getTime()) {
                return ResultMsg.getResultMsg(ApiEnum.cooEnd.code, ApiEnum.cooEnd.msg);
            }
        }else{
            return ResultMsg.getResultMsg(ApiEnum.distributorNotExists.code, ApiEnum.distributorNotExists.msg);
        }
        return ResultMsg.getOK();
    }
}
