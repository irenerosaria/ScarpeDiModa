package it.begear.corso.entity;

public class Stivale extends Scarpa {
	private int tacco;
	public Stivale() {}
	
	public Stivale(int id, Genere gender, String descrizione, Colore color, Misura numero, String brand, double costo) {
		super(id, gender, descrizione, color, numero, brand, costo);
		// TODO Auto-generated constructor stub
	}

	public void setTacco(int tacco) {
		this.tacco = tacco;
	}

	@Override
	public void getTacco() {
		System.out.println("questo stivale ha tacco"+tacco);
		
	}

}
