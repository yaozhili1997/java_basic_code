package com.ecotourism.oms.oms.config;

/**
 *说明：返回结果值
 * @author 仇科成
 *创建时间：2017年7月20日
 * @version
 */
public class ResultMsg {
	
	public static final String SUCCESS = "SUCCESS";
	public static final String FAIL = "FAIL";
	
	private String return_code;//结果编码 
	private String return_msg;//成功失败信息
	private Object obj;//成功返回的结果对象
	
	public ResultMsg() {
	}
	public ResultMsg(String return_code, String return_msg, Object obj) {
		this.setReturn_code(return_code);
		this.setReturn_msg(return_msg);
		this.setObj(obj);
	}
	
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

    /**
     * 获取正确结果模板
     * @param message 请求返回信息
     * @param obj     请求结果
     * @return ResultMsg
     */
    public static ResultMsg getOK(String message, Object obj) {
    	ResultMsg result = new ResultMsg();
        result.setReturn_code(SUCCESS);
        result.setReturn_msg(message);
        result.setObj(obj);
        return result;
    }

    /**
     * 获取正确结果模板
     * @param obj 请求结果
     * @return AjaxResult
     */
    public static ResultMsg getOK(Object obj) {
        ResultMsg result = new ResultMsg();
        result.setReturn_code(SUCCESS);
        result.setReturn_msg("操作成功");
        result.setObj(obj);
        return result;
    }

    /**
     * 获取错误结果模板
     * @param message 请求返回信息
     * @param obj     请求结果
     * @return AjaxResult
     */
    public static ResultMsg getError(String message, Object obj) {
    	ResultMsg result = new ResultMsg();
        result.setReturn_code(FAIL);
        result.setReturn_msg(message);
        result.setObj(obj);
        return result;
    }
    /**
     * 获取错误结果模板
     * @param message 请求返回信息
     * @param obj     请求结果
     * @return AjaxResult
     */
    public static ResultMsg getError(String message) {
    	ResultMsg result = new ResultMsg();
    	result.setReturn_code(FAIL);
    	result.setReturn_msg(message);
    	result.setObj(null);
    	return result;
    }

    /**
     * 获取正确结果模板
     * @return AjaxResult
     */
    public static ResultMsg getOK() {
        return getOK("操作成功", null);
    }

	/**
	 * 自定义code，msg
	 * @param code
	 * @param msg
	 * @return
	 */
	public static ResultMsg getResultMsg(String code,String msg){
		ResultMsg result = new ResultMsg();
		result.setReturn_code(code);
		result.setReturn_msg(msg);
		return result;
	}

	@Override
	public String toString() {
		return "ResultMsg [return_code=" + return_code + ", return_msg=" + return_msg + ", obj=" + obj + "]";
	}

}
