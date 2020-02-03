package org.com.spring;

import org.springframework.context.ApplicationEvent;

public class CustomDrawEvent extends ApplicationEvent{

	public CustomDrawEvent(Object source) {
		super(source);
	}
	
	public String toString (){
		return "My CustomDrawEvent !!!";
	}

}
