package org.bengal.unit7.threads.exceptionHandling;

import org.bengal.units.common.ExceptionLeakingTask;
import org.bengal.units.common.ThreadExceptionHandler;
import org.bengal.units.common.ThreadExceptionNotifier;

public class HandlingUncaughtExceptionsDifferentlyPerThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		Thread t1 = new Thread(new ExceptionLeakingTask(), "MyThread-1");
		t1.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		Thread t2 = new Thread(new ExceptionLeakingTask(), "MyThread-2");
		t2.setUncaughtExceptionHandler(new ThreadExceptionNotifier());
		
		t1.start();
		t2.start();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
