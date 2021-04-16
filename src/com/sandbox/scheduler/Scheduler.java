/**
 * 
 */
package com.sandbox.scheduler;

import java.util.ArrayList;
import java.util.List;
import com.sandbox.scheduler.model.Task;
import com.sandbox.scheduler.util.SchedulerUtil;
import com.sandbox.scheduler.validator.SchedulerValidator;

/**
 * @author haresh
 *
 */

public class Scheduler {
	static ArrayList<Task> sortedTasks = new ArrayList<Task>();

	static Scheduler schlr = new Scheduler();

	
	/**
	 * default constructor
	 */
	public Scheduler() {

	}

	/**
	 * 
	 * @param task
	 */
	public static void scheduleTask(Task task) {

		if (SchedulerValidator.validTask(task)) {
			sortedTasks.add(task);
			schlr.recursiveSort(sortedTasks);
		} else {
			System.out.println(" ****" + task.toString());
		}

	}

	
	/**
	 * 
	 * @param task
	 * @return
	 */
	
	private List<Task> recursiveSort(ArrayList<Task> task) {
		boolean sorted = false;
		for (int i = 0; i < task.size() - 1; i++) {
			if (SchedulerUtil.compare(task.get(i), task.get(i + 1))) {
				sorted = true;
				SchedulerUtil.swap(task, i, i + 1);

			}
		}

		if (sorted)
			recursiveSort(task);
		else
			return task;

		return task;
	}

	/**
	 * print the values
	 */
	public static void printSchedule() {
		sortedTasks.forEach((task) -> {
			System.out.println(task.toString() + ", ");
		});

	}

}
