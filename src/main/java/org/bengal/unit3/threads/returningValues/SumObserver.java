package org.bengal.unit3.threads.returningValues;

import org.bengal.units.common.ResultListener;

public class SumObserver implements ResultListener<Integer> {
	
	private String taskId;
	
	public SumObserver(String taskId) {
		this.taskId = taskId;
	}

	@Override
	public void notifyResult(Integer result) {
		System.out.println("Result for " + taskId + " = " + result);
	}

}
