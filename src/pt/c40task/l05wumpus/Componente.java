package pt.c40task.l05wumpus;

public class Componente {
	protected char caracter; 
	protected boolean vida;
	protected boolean artefato;
	Componente(char caracter) {
		this.caracter = caracter;
		this.vida = true;
		this.artefato = false;
	}
	
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
