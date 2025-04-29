package org.bengal.unit9.threads.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.bengal.units.common.ScheduledTaskA;
import org.bengal.units.utils.TimeUtils;

public class SchedulingTasksForFixedDelayRepeatedExecutions {
	
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		Timer timer = new Timer("Timer-Thread", true);
		Date currentTime = new Date();
		
		System.out.println("[" + currentThreadName + "] Current time : " + dateFormatter.format(currentTime));

		Date scheduledTime = TimeUtils.getFutureTime(currentTime, 3000);
		long intervalMillis = 2000;
		
		timer.schedule(new ScheduledTaskA(1000), scheduledTime, intervalMillis);
		
		System.out.println("[" + currentThreadName + "] Task-1 first-run scheduled for " + dateFormatter.format(scheduledTime) +
				" and then repeatedly at an interval of every " + TimeUtils.convertToFractionalSecondsStr(0, intervalMillis));
		
		//**********************************************************************************************************//
		
		long delayMillis = 4000;
		long intervalMillis2 = 2000;
		
		timer.schedule(new ScheduledTaskA(1000), delayMillis, intervalMillis2);
		
		System.out.println("[" + currentThreadName + "] Task-2 first-run scheduled " +
				TimeUtils.convertToFractionalSecondsStr(0, delayMillis) + " after " + dateFormatter.format(currentTime) +
				" and then repeatedly at an interval of every " + TimeUtils.convertToFractionalSecondsStr(0, intervalMillis2));
		
		TimeUnit.MILLISECONDS.sleep(16000);
		
		System.out.println("[" + currentThreadName + "] CANCELLING THE TIMER NOW ...");
		timer.cancel();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}	
}
