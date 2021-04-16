package com.sandbox.scheduler;


import java.util.Arrays;
import java.util.List;

import com.sandbox.scheduler.model.Category;
import com.sandbox.scheduler.model.Task;
import com.sandbox.scheduler.util.SchedulerUtil;


public class App {
	
	public static void main(String[] args) {
		
		
		
		Task task1 = new Task(7, Category.RED);
		Task task2 = new Task(2, Category.BLUE);
		Task task3 = new Task(1, Category.GREEN);
		Task task4 = new Task(0, Category.GREEN);
		Task task5 = new Task(0, Category.RED);
		Task task6 = new Task(4, Category.RED);
		Task task7 = new Task(3, Category.BLUE);
		Task task8 = new Task(0, Category.BLUE);
		Task task9 = new Task(-1, Category.RED);
		Task task10 = new Task(0, Category.RED);
		
		List<Task> unsorted = Arrays.asList(task1, task2, task3, task4, task5, task6, task7, task8, task9,task10);
		
		double dt= System.currentTimeMillis();
		unsorted.forEach(t -> Scheduler.scheduleTask(t));
		
		double dt1= System.currentTimeMillis();
		
		
		
		Scheduler.printSchedule();
		
		System.out.println("*** Time Taken *** "+ (dt1-dt) +" ms");
		
		SchedulerUtil.loadProperties();
	}
}
