package invasaoAoRio;

public class Celula {
	boolean vazia; // se tem algum elemento como barco ou canhão
	
	public Celula(boolean vazia) {
		this.vazia = vazia;
	}
	
	public boolean isTerra() {
		return false;
	}
	
	public boolean isAgua() {
		return false;
	}
}
