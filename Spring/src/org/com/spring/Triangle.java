package org.com.spring;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean, Shape{
/*	private String type;
	private String typ;
	private int height;
	
	public Triangle (String type){
		this.type = type;
	}
	
	public Triangle (int height){
		this.height = height;
	}

	public Triangle (String type, int height){
		this.type = type;
		this.height = height;
	}

	public Triangle (String type, String typ, int height){
		this.type = type;
		this.typ = typ;
		this.height = height;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void draw (){
		System.out.println("Type of Triangle is : " + getType() + " & dummy is : " + getTyp() + " while the height is : " + getHeight());
	}*/

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context = null;
	private List<Point> points;
	
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw (){
		System.out.println("Drawing Triangle");
		System.out.println("PointA is : ( " + getPointA().getX() + ", " + getPointA().getY() + ")");
		System.out.println("PointB is : ( " + getPointB().getX() + ", " + getPointB().getY() + ")");
		System.out.println("PointC is : ( " + getPointC().getX() + ", " + getPointC().getY() + ")");
	}
/*
	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void draw (){
		for (Point point : points){
			System.out.println("Point is : ( " + point.getX() + ", " + point.getY() + ")");
		}
	}*/
	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name is : " + beanName);
	}
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}
	public ApplicationContext getContext() {
		return context;
	}
	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("DissposableBean destory method call");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean afterPropertiesSet method call");
	}
	
	public void myInit(){
		System.out.println("myInit method call");
	}
	
	public void cleanUp(){
		System.out.println("destory method call");
	}
	
}
