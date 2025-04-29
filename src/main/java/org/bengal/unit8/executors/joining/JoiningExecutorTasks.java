package org.bengal.unit8.executors.joining;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bengal.units.common.LoopTaskI;
import org.bengal.units.common.NamedThreadsFactory;

public class JoiningExecutorTasks {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadsFactory());
		
		CountDownLatch doneSignal = new CountDownLatch(2);
		
		execService.execute(new LoopTaskI(doneSignal));
		execService.execute(new LoopTaskI(doneSignal));
		execService.execute(new LoopTaskI(doneSignal));
		execService.execute(new LoopTaskI(doneSignal));
		
		execService.shutdown();
		
		try {
			doneSignal.await();
			System.out.println("[" + currentThreadName + "] " + currentThreadName + " GOT THE SIGNAL TO CONTINUE ...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
