package com.ecotourism.oms.cancellation.service.impl;

import com.ecotourism.oms.cancellation.dao.CancellationOrderDao;
import com.ecotourism.oms.cancellation.domain.CancellationDO;
import com.ecotourism.oms.cancellation.domain.UscCancellationDO;
import com.ecotourism.oms.cancellation.service.CancellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CancellationServiceImpl implements CancellationService {

    @Autowired
    CancellationOrderDao cancellationOrderDao;

    /**
     * 优讯订单核销
     * @param list
     * @return
     */
    @Override
    @Transactional
    public String cancellationUscOrder(List<UscCancellationDO> list) {
        for(UscCancellationDO uscCancellationDO:list){
            CancellationDO cancellationDO = new CancellationDO();
            cancellationDO.setOrderNo(uscCancellationDO.getOrderNo());
            cancellationDO.setElectronicTicket(uscCancellationDO.getElectTicket());
            cancellationDO.setProductNo(uscCancellationDO.getProductNo());
            String noticeType = uscCancellationDO.getNoticeType();
            if("ORDER_CHECK".equals(noticeType)){
                cancellationDO.setOrderStatus("004002");
                cancellationDO.setCheckTime(uscCancellationDO.getCheckTime());
            }else if("ORDER_REFUND".equals(noticeType)){
                cancellationDO.setOrderStatus("004004");
                cancellationDO.setRefundStatus("002003");
                cancellationDO.setRefundTime(uscCancellationDO.getCheckTime());
            }
            cancellationOrderDao.cancellationAppOrder(cancellationDO);
            cancellationOrderDao.cancellationOrder(cancellationDO);
        }
        return "success";
    }
}
