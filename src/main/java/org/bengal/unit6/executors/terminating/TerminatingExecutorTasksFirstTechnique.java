package org.bengal.unit6.executors.terminating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.bengal.units.common.FactorialTaskA;
import org.bengal.units.common.LoopTaskE;
import org.bengal.units.common.NamedThreadsFactory;

public class TerminatingExecutorTasksFirstTechnique {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadsFactory());
		
		LoopTaskE task1 = new LoopTaskE();
		FactorialTaskA task2 = new FactorialTaskA(30, 1000);
		
		execService.execute(task1);
		execService.submit(task2);
		
		execService.shutdown();
		
		TimeUnit.MILLISECONDS.sleep(3000);
		task1.cancel();
		task2.cancel();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
