package com.sandbox.scheduler.validator;

import com.sandbox.scheduler.constants.SchedulerConstants;
import com.sandbox.scheduler.model.Category;
import com.sandbox.scheduler.model.Task;

/**
 * @author haresh
 *
 */
public class SchedulerValidator {
	
	
	public static  boolean validTask(Task t) {

		
		boolean validity = false;

		if (t.getUrgency() >= SchedulerConstants.ZERO && t.getUrgency() <= SchedulerConstants.FIVE) {
			if ((t.getCategory().equals(Category.RED)) || (t.getCategory().equals(Category.BLUE))
					|| (t.getCategory().equals(Category.GREEN))) {
				
				validity = true;
			} else {
				System.out.println("**** "+SchedulerConstants.CATEGORY_ERROR);
			}

		} else {
			System.out.println("**** "+ SchedulerConstants.URGENCY_ERROR);
		}

		return validity;
	}


}
