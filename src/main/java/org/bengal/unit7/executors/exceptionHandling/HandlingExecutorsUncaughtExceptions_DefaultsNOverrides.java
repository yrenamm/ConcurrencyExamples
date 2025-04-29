package org.bengal.unit7.executors.exceptionHandling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bengal.units.common.ExceptionLeakingTask;
import org.bengal.units.common.NamedExceptionHandlingAlternatingThreadFactory;
import org.bengal.units.common.ThreadExceptionHandler;

public class HandlingExecutorsUncaughtExceptions_DefaultsNOverrides {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("THE_DEFAULT_ONE"));
		
		ExecutorService execService = Executors.newCachedThreadPool(new NamedExceptionHandlingAlternatingThreadFactory());
		
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		execService.execute(new ExceptionLeakingTask());
		
		execService.shutdown();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
