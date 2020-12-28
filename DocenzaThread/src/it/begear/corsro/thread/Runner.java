package it.begear.corsro.thread;

public class Runner implements Runnable {

	private int count;
	private String nome;
	private boolean stopThread;
	
	public Runner(int count, String nome) {
		setCount(count);
		setNome(nome);
	}
	
	public boolean isStopThread() {
		return stopThread;
	}

	public void setStopThread(boolean stopThread) {
		this.stopThread = stopThread;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void run(){
		count = 0;
		while (!stopThread) { 
			System.out.println("Contatore di " + nome + " :" + count++);
			int trap = (int) (Math.random()*10);
			if (trap == 5) stopThread = true;
			if ( count == 20) {
				System.out.println(nome + " ha finito!");
				break; }
			}
	}
	
//	public void run(){
//		count = 0;
//		do {
//			System.out.println("Contatore di " + nome + " :" + count++);
//		} while ( count <= 20);
//		System.out.println(nome + " ha finito!");
//	}
	
}
