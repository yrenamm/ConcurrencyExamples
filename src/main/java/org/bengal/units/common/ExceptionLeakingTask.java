package org.bengal.units.common;

public class ExceptionLeakingTask implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}

}
