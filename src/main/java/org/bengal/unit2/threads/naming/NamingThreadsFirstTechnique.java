package org.bengal.unit2.threads.naming;

import org.bengal.units.common.LoopTaskB;

public class NamingThreadsFirstTechnique {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		new Thread(new LoopTaskB()).start();
		
		Thread t2 = new Thread(new LoopTaskB());
		t2.start();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
