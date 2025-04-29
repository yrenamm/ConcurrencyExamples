package org.bengal.unit7.threads.exceptionHandling;

import org.bengal.units.common.ExceptionLeakingTask;
import org.bengal.units.common.ThreadExceptionHandler;

public class HandlingUncaughtExceptionsForEveryThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));
		
		new Thread(new ExceptionLeakingTask(), "MyThread-1").start();
		new Thread(new ExceptionLeakingTask(), "MyThread-2").start();
		new Thread(new ExceptionLeakingTask(), "MyThread-3").start();
		new Thread(new ExceptionLeakingTask(), "MyThread-4").start();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
