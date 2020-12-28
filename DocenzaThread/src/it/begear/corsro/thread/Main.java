package it.begear.corsro.thread;

public class Main {

	public static void main(String[] args) {
		
		Runner corri1 = new Runner(20, "Pinuccia");
		Runner corri2 = new Runner(20, "Zircone");
		Thread thread1 = new Thread(corri1);
		Thread thread2 = new Thread(corri2); 
		thread1.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
	}

}
