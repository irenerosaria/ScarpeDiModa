package it.begear.corso.threadRace;

public class Lumaca implements Runnable{

	private int kilometri = 0;
	private Thread t;
	private boolean running = true;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lumaca(int p, String name) {
		setName(name);
		t = new Thread(this);
		t.setPriority(p);
	}
	
	public int getKilometri(){
		return kilometri;
	}
	
	public void run() {
		while (running) {
			System.out.println(getName() + " è al kilometro: " + kilometri);
			kilometri++;
		}
	}
	
	public void stopThread() {
		running = false;
	}
	
	public void startThread() {
		t.start();
	}
}
