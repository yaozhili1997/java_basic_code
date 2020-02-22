package com.ecotourism.supplier.report.service.impl;

import com.ecotourism.supplier.common.utils.PageTotal;
import com.ecotourism.supplier.report.dao.CarReportReadDao;
import com.ecotourism.supplier.report.dao.LineReportReadDao;
import com.ecotourism.supplier.report.dao.SpotOrderReadDao;
import com.ecotourism.supplier.report.domain.CarReportDO;
import com.ecotourism.supplier.report.domain.LineReportDO;
import com.ecotourism.supplier.report.domain.SaleTicketDO;
import com.ecotourism.supplier.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    SpotOrderReadDao spotOrderReadDao;
    @Autowired
    LineReportReadDao lineReportReadDao;
    @Autowired
    CarReportReadDao carReportReadDao;
    @Override
    public String getTodaySaleTotal(Map<String, Object> map) {
        List<SaleTicketDO> list = spotOrderReadDao.getTodaySaleTotal(map);
        StringBuffer ticketNumList = new StringBuffer();
        for(SaleTicketDO pdToday:list){
            //当天实时售票人数
            ticketNumList.append("[");
            ticketNumList.append("'"+pdToday.getProductName()+"',");
            ticketNumList.append(pdToday.getOrderQuantity());
            ticketNumList.append("],");
        }
        if(ticketNumList.length()>0){
            ticketNumList.deleteCharAt(ticketNumList.length()-1);
        }
        System.out.println("ticketNumList================="+ticketNumList.toString());
        return ticketNumList.toString();
    }

    @Override
    public String getTodayLineTotal(Map<String, Object> map) {
        List<LineReportDO> list = lineReportReadDao.getTodayLineTotal(map);
        StringBuffer todayLineList = new StringBuffer();
        for(LineReportDO pdToday:list){
            //当天路线乘车人数
            todayLineList.append("[");
            todayLineList.append("'"+pdToday.getLineName()+"',");
            todayLineList.append(pdToday.getRideNumber());
            todayLineList.append("],");
        }
        if(todayLineList.length()>0){
            todayLineList.deleteCharAt(todayLineList.length()-1);
        }
        return todayLineList.toString();
    }

    @Override
    public String getTodayDeviceTotal(Map<String, Object> map) {
        List<CarReportDO> list = carReportReadDao.getTodayDeviceTotal(map);
        StringBuffer todayDeviceList = new StringBuffer();
        for(CarReportDO pdToday:list){
            //当天车辆乘车人数
            todayDeviceList.append("[");
            todayDeviceList.append("'"+pdToday.getDeviceName()+"("+pdToday.getVehicleNumber()+")',");
            todayDeviceList.append(pdToday.getRideNumber());
            todayDeviceList.append("],");
        }
        if(todayDeviceList.length()>0){
            todayDeviceList.deleteCharAt(todayDeviceList.length()-1);
        }
        return todayDeviceList.toString();
    }

    @Override
    public List<LineReportDO> getLineReport(Map<String, Object> map) {
        return lineReportReadDao.getLineReport(map);
    }

    @Override
    public int getLineReportCount(Map<String, Object> map) {
        return lineReportReadDao.getLineReportCount(map);
    }

    @Override
    public PageTotal getLineReportSum(Map<String, Object> map) {
        return lineReportReadDao.getLineReportSum(map);
    }

    @Override
    public List<LineReportDO> getCarReport(Map<String, Object> map) {
        return lineReportReadDao.getCarReport(map);
    }

    @Override
    public int getCarReportCount(Map<String, Object> map) {
        return lineReportReadDao.getCarReportCount(map);
    }

    @Override
    public PageTotal getCarReportSum(Map<String, Object> map) {
        return lineReportReadDao.getCarReportSum(map);
    }
}
