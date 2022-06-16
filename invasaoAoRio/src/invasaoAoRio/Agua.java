package invasaoAoRio;

public class Agua implements ICelula{

	private boolean vazia;
	private Barco barco;
	
	public Agua() {
		this.vazia = true;
		this.barco = null;
	}

	@Override
	public boolean isTerra() {
		return false;
	}

	@Override
	public boolean isAgua() {
		return true;
	}

	@Override
	public Barco getBarco() {
		return this.barco;
	}

	@Override
	public Canhao getCanhao() {
		return null;
	}
	@Override
	public void addBarco(Barco barco) {
		this.barco = barco;
		this.vazia = false;
	}

	@Override
	public void addCanhao(Canhao canhao){
	}
}
