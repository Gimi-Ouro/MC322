package pt.c40task.l05wumpus;

public class Componente {
	protected char caracter; 
	protected boolean vida;
	protected boolean artefato;
	protected int l, c;
	Caverna caverna;
	Componente(char caracter, int l, int c) {
		this.caracter = caracter;
		this.l = l;
		this.c = c;
		this.vida = true;
		this.artefato = false;
	}
	
	public void conectarCaverna(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public int getLinha() { return this.l; };
	
	public int getColuna() { return this.c; };
	
	public boolean temArtefato() {
		return artefato;
	}
	
	public void setArtefato(boolean artefato) {
		this.artefato = artefato;
	}
	
	public boolean getVida() {
		return vida;
	}
	
	public void setVida(boolean vida) {
		this.vida = vida;
	}
	
	public char getCaracter() {
		return caracter;
	}
 
}
