package com.wdx.manager.listener;

import com.wdx.manager.bean.User;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Application Lifecycle Listener implementation class LogoutUserListener
 *
 */
@WebListener
public class LogoutUserListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public LogoutUserListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    	// 判断监听到的是否为记录用户信息的会话域属性
    	Enumeration<String> attrnames = event.getSession().getAttributeNames();
    	while(attrnames.hasMoreElements()) {
    		System.out.println(attrnames.nextElement());
    		if("SESSION_USER".equals(attrnames.nextElement())) {
    			// 获取会话域属性值：当前登录的用户对象
    			User user = (User)event.getSession().getAttribute("SESSION_USER");
    			// 获取应用上下文对象
    			ServletContext application = event.getSession().getServletContext();
    			// 获取存放在应用域属性中的在线用户信息列表
    			Map<String, User> onlineUserMap = (Map<String,User>)application.getAttribute("ONLINE_USER");
    			if(onlineUserMap != null) {
    				// 将当前登录的用户对象移出应用域属性：在线用户信息列表
    				onlineUserMap.remove(user.getUser_logname());
    				application.setAttribute("ONLINE_USER", onlineUserMap);
    				
    			}
    		}
    	}
    }
	
}
