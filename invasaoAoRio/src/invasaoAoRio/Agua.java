package invasaoAoRio;

public class Agua extends Celula{
	private Barco barco;
	public Agua() {
		super(true);
	}
	
	public void addBarco(Barco barco) {
		this.barco = barco;
	}
}
