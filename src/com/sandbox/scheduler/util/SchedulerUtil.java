/**
 * 
 */
package com.sandbox.scheduler.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import com.sandbox.scheduler.constants.SchedulerConstants;
import com.sandbox.scheduler.model.Task;

/**
 * @author haresh
 *
 */
public class SchedulerUtil {
	
	
/**
 * 
 * @param tasks
 * @param index1
 * @param index2
 */
	public static void swap(ArrayList<Task> tasks, int index1, int index2) {
		Task tsk = tasks.get(index1);
		tasks.set(index1, tasks.get(index2));
		tasks.set(index2, tsk);
	}

	
	/**
	 * 
	 * @param t0
	 * @param t
	 * @return boolean
	 */
	public static boolean compare(Task t0, Task t) {

		if (t0.getUrgency() > t.getUrgency()) {
			return true;
		} else if (t0.getUrgency() == t.getUrgency()) {

			switch (t.getCategory()) {
			case RED:
				if ((t0.getCategory().toString().equalsIgnoreCase(SchedulerConstants.BLUE))
						|| (t0.getCategory().toString().equalsIgnoreCase(SchedulerConstants.GREEN))) {
					return true;

				} else {
					if (t.getTimeStamp().isBefore(t0.getTimeStamp())) {
						return true;
					} else {
						return false;
					}
				}
				// break;
			case BLUE:
				if (t0.getCategory().toString().equalsIgnoreCase(SchedulerConstants.RED)) {
					return false;
				} else if (t0.getCategory().toString().equalsIgnoreCase(SchedulerConstants.GREEN)) {
					return true;
				} else {
					if (t.getTimeStamp().isBefore(t0.getTimeStamp())) {
						return true;
					} else {
						return false;
					}

				}
				// break;
			case GREEN:
				if ((t0.getCategory().toString().equalsIgnoreCase(SchedulerConstants.RED))
						|| (t0.getCategory().toString().equalsIgnoreCase(SchedulerConstants.BLUE))) {
					return false;
				}

				else {
					if (t.getTimeStamp().isBefore(t0.getTimeStamp())) {
						return true;
					} else {
						return false;
					}

				}
				// break;

			default:
				System.out.println("*** "+SchedulerConstants.CATEGORY_ERROR);
				break;

			}

		} else {
			return false;
		}

		return false;

	}
	
	
	/**
	 * Load Data from properties
	 * If required please uncomment SchedulerConstants.java
	 * @return properties
	 */
	
	public static Properties loadProperties()
	{
		  Properties properties = new Properties();
		 try (InputStream input = SchedulerUtil.class.getClassLoader().getResourceAsStream(SchedulerConstants.FILE_NAME)) {

	            if (input == null) {
	                System.out.println("*** "+SchedulerConstants.FILE_ERROR);
	                return null;
	            }

	            properties.load(input);

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		 return properties;
	}

}
