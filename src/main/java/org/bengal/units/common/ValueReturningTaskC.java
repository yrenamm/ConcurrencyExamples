package org.bengal.units.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskC implements Runnable {

	private int a;
	private int b;
	private long sleepTime;
	private int sum;
	
	private static int count = 0;
	private int instanceNumber;
	private String taskId;
	
	public ValueReturningTaskC(int a, int b, long sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		
		this.instanceNumber = ++count;
		this.taskId = "ValueReturningTaskC-" + instanceNumber;
	}
	
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("##### [" + currentThreadName + "] <" + taskId + 
				"> STARTING #####");
		
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sum = a + b;
		
		System.out.println("***** [" + currentThreadName + "] <" + taskId + 
				"> CALCULATION COMPLETED *****");
	}
	
	public int getSum() {
		return sum;
	}

}
