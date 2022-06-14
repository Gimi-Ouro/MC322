package invasaoAoRio;

public class Agua extends Celula{
	
	public Agua() {
		super(true, true, false);
	}
	
	public void addBarco(Barco barco) {
		this.barco = barco;
	}
	
	public boolean isTerra() {
		return false;
	}
	
	public boolean isAgua() {
		return true;
	}
	
	public Barco getBarco() {
		if(agua) return this.barco;
		else return null;
	}
	
	
}
