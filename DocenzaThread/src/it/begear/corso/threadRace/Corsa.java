package it.begear.corso.threadRace;

public class Corsa {

	public static void main(String[] args) {

		Lumaca lumaca1 = new Lumaca(5, "Caterina");
		Lumaca lumaca2 = new Lumaca(5, "Aldous");
		lumaca1.startThread();
		lumaca2.startThread();
		try {
			Thread.sleep(100);
		}
		catch (Exception e){}
		lumaca1.stopThread();
		lumaca2.stopThread();
	}


}
