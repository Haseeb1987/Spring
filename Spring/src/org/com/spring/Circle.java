package org.com.spring;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceSupport;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware{

	private Point center;
	@Autowired
	private MessageSource messageSource;
	private ApplicationEventPublisher applicationEventPublisher;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

//	@Required
//	@Autowired
//	@Qualifier ("circleLoad")
	@Resource 
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("Circle point is " + "( " + center.getX() + ", " + center.getY() + ")");
		System.out.println(this.messageSource.getMessage("greet", null, "Default Greeting", null));
		System.out.println(this.messageSource.getMessage("shape.point", new Object [] {center.getX(), center.getY()}, "Default Greeting", null));
//		System.out.println(this.messageSource.getMessage("shape.point", new Object [] {center.getX(), center.getY()}, "Default Greeting", Locale.ENGLISH));
		CustomDrawEvent customDrawEvent = new CustomDrawEvent(this);
		applicationEventPublisher.publishEvent(customDrawEvent);
	}
	
	@PostConstruct
	public void initCircle (){
		System.out.println("Circle Initialized");
	}
	
	@PreDestroy
	public void destoryCircle(){
		System.out.println("Circle Destory");
	}

	@Override
	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
}
