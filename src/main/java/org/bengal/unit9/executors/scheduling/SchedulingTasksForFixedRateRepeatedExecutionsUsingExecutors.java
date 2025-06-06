package org.bengal.unit9.executors.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.bengal.units.common.NamedThreadsFactory;
import org.bengal.units.common.ScheduledTaskB;
import org.bengal.units.utils.TimeUtils;

public class SchedulingTasksForFixedRateRepeatedExecutionsUsingExecutors {
	
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
				
		ScheduledExecutorService execService = Executors.newScheduledThreadPool(3, new NamedThreadsFactory());
		
		System.out.println("[" + currentThreadName + "] Current time : " + dateFormatter.format(new Date()));
		
		ScheduledFuture<?> schedFuture1 = execService.scheduleAtFixedRate(new ScheduledTaskB(1000), 4, 2, TimeUnit.SECONDS);
		ScheduledFuture<?> schedFuture2 = execService.scheduleAtFixedRate(new ScheduledTaskB(3000), 4, 2, TimeUnit.SECONDS);
		
//		schedFuture2.cancel(true);
		
//		for (int i = 0; i < 5; i++) {
//			System.out.print("[" + currentThreadName + "] Next run of TASK-1 scheduled at approx.: ");
//			Date scheduledTime = TimeUtils.getFutureTime(new Date(), schedFuture1.getDelay(TimeUnit.MILLISECONDS));
//			System.out.println(dateFormatter.format(scheduledTime));
//			
//			TimeUnit.MILLISECONDS.sleep(3000);
//		}
		
		TimeUnit.MILLISECONDS.sleep(15000);
		execService.shutdown();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}	
}
