package com.ecotourism.api.common.utils;

import com.ecotourism.api.api.config.ApiEnum;

/**
 * @Description 返回对象
 * @Author scotte
 * @Date 2018/8/21 17:00
 * @Param 
 * @return 
 */
public class R{

	public static final String SUCCESS = ApiEnum.success.code;
	public static final String FAIL = ApiEnum.fail.code;

	private String return_code;//结果编码
	private String return_msg;//成功失败信息
	private Object obj;//成功返回的结果对象
	private boolean useMsg=true;//true：返回此信息，false：返回枚举信息
	public R() {
	}
	public R(String return_code,String return_msg,Object obj) {
		this.setReturn_code(return_code);
		this.setReturn_msg(return_msg);
		this.setObj(obj);
	}
	public boolean isUseMsg() {
		return useMsg;
	}
	public R setUseMsg(boolean useMsg) {
		this.useMsg = useMsg;
		return this;
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

	public boolean isSuccess() {
		if(SUCCESS.equals(this.return_code)){
			return true;
		}
		return false;
	}

	/**
	 * @Description 获取正确结果模板
	 * @Author scotte
	 * @Date 2018/8/21 17:05
	 * @Param [message, obj]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public static R ok(String message, Object obj) {
		R result = new R();
		result.setReturn_code(SUCCESS);
		result.setReturn_msg(message);
		result.setObj(obj);
		return result;
	}

	public String getStrObj(){
	    return this.obj==null?"":this.obj.toString();
    }

	/**
	 * @Description 获取正确结果模板
	 * @Author scotte
	 * @Date 2018/8/21 17:05
	 * @Param [obj]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public static R ok(Object obj) {
		R result = new R();
		result.setReturn_code(SUCCESS);
		result.setReturn_msg("操作成功");
		result.setObj(obj);
		return result;
	}

	/**
	 * @Description 获取错误结果模板
	 * @Author scotte
	 * @Date 2018/8/21 17:05
	 * @Param [message, obj]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public static R error(String message, Object obj) {
		R result = new R();
		result.setReturn_code(FAIL);
		result.setReturn_msg(message);
		result.setObj(obj);
		return result;
	}
	/**
	 * @Description 获取错误结果模板
	 * @Author scotte
	 * @Date 2018/8/21 17:05
	 * @Param [code, msg]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public static R error(String code,String msg) {
		R result = new R();
		result.setReturn_code(code);
		result.setReturn_msg(msg);
		result.setObj(null);
		return result;
	}
	/**
	 * @Description 获取错误结果模板
	 * @Author scotte
	 * @Date 2018/8/21 17:05
	 * @Param [code, msg]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public static R error(String code,String msg,Object obj) {
		R result = new R();
		result.setReturn_code(code);
		result.setReturn_msg(msg);
		result.setObj(obj);
		return result;
	}
	/**
	 * @Description 获取错误结果模板
	 * @Author scotte
	 * @Date 2018/8/21 17:05
	 * @Param [message]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public static R error(String message) {
		R result = new R();
		result.setReturn_code(FAIL);
		result.setReturn_msg(message);
		result.setObj(null);
		return result;
	}

	/**
	 * @Description 获取错误结果模板
	 * @Author scotte
	 * @Date 2018/8/21 17:06
	 * @Param []
	 * @return com.ecotourism.api.common.utils.R
	 */
	public static R ok() {
		return ok("操作成功", null);
	}


	@Override
	public String toString() {
		return "R [return_code=" + return_code + ", return_msg=" + return_msg + ", obj=" + obj + "]";
	}
}
