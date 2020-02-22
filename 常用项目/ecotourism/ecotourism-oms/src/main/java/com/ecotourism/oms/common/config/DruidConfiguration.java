/**
 * 
 */
package com.ecotourism.oms.common.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
* @Title: DruidConfiguration
* @Description: 
* druid监控界面设置
* @Version:1.0.0  
* @author pancm
* @date 2018年4月27日
 */
@Configuration
public class DruidConfiguration {

	@Bean
	public ServletRegistrationBean druidStatViewServle() {
		//注册服务
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
				new StatViewServlet(), "/druid/*");
		// 白名单(为空表示,所有的都可以访问,多个IP的时候用逗号隔开)
		servletRegistrationBean.addInitParameter("allow", ""); //白名单
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean druidStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		filterRegistrationBean.addInitParameter("profileEnable", "true");
		filterRegistrationBean.addInitParameter("principalCookieName","USER_COOKIE");
		filterRegistrationBean.addInitParameter("principalSessionName","USER_SESSION");
		filterRegistrationBean.addInitParameter("DruidWebStatFilter","/*");
		return filterRegistrationBean;
	}
}
