package com.ecotourism.api.common.config;

public class Constant {
    //超级系统账户
    public static String ADMIN_ACCOUNT = "admin";
    //超级系统账户ID
    public static Long ADMIN_ID = new Long(1);
    //自动去除表前缀
    public static String AUTO_REOMVE_PRE = "true";
    //停止计划任务
    public static String STATUS_RUNNING_STOP = "stop";
    //开启计划任务
    public static String STATUS_RUNNING_START = "start";
    //通知公告阅读状态-未读
    public static String OA_NOTIFY_READ_NO = "0";
    //通知公告阅读状态-已读
    public static int OA_NOTIFY_READ_YES = 1;
    //部门根节点id
    public static Long DEPT_ROOT_ID = 0l;
    //缓存方式
    public static String CACHE_TYPE_REDIS ="redis";

    public static String LOG_ERROR = "error";
    public static String UPDATE_LODE_PATH = "img/";
    public static String UPLOAD_QRCODE_PATH = "Qrcode/";
    //文件上传根路径映射别名 :uploadPath: D:/var/uploaded_files/
    public static String FILE_PATH = "/files/";

    
}
