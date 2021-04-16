package com.sandbox.scheduler.constants;

//import java.util.Properties;
//import com.sandbox.scheduler.util.SchedulerUtil;

public class SchedulerConstants {

	/**
	 * Commented - load properties from file
	 */
	/*
	 * static Properties properties= new Properties(); static { properties=
	 * SchedulerUtil.loadProperties(); }
	 */

	// Color constants
	public static final String RED = "RED";
	public static final String BLUE = "BLUE";
	public static final String GREEN = "GREEN";

	// Error constants
	public static final String URGENCY_ERROR = "validation ERROR **** URGENCY not between 0 to 5";
	public static final String CATEGORY_ERROR = "validation ERROR **** Category not any of RED/BLUE/GREEN";
	public static final String FILE_ERROR = "Sorry, unable to find application.properties";

	// Integer Constants
	/***
	 * Comment the following if loading from properties file
	 */
	public static final int ZERO = 0;
	public static final int FIVE = 5;

	/**
	 * Commented - load properties from file
	 */
//	public static final int ZERO=Integer.parseInt(properties.getProperty("Scheduler.urgency.minimum"));
//	public static final int FIVE=Integer.parseInt(properties.getProperty("Scheduler.urgency.maximum"));

	// properties file
	public static final String FILE_NAME = "application.properties";
}
