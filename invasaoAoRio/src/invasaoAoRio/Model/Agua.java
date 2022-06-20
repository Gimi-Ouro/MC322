package invasaoAoRio.Model;

public class Agua implements ICelula{
	private boolean vazia;
	private Barco barco;
	private Tiro tiro;
	
	public Agua() {
		this.vazia = true;
		this.barco = null;
		this.tiro = null;
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
	public Tanque getCanhao() {
		return null;
	}
	@Override
	public void addBarco(Barco barco) {
		this.barco = barco;
		this.vazia = false;
	}

	@Override
	public void addTanque(Tanque tanque){
	}

	@Override
	public void removerElemento() {
		this.barco = null;
		this.tiro = null;
		this.vazia = true;
	}

	@Override
	public boolean isVazia() {
		return this.vazia;
	}

	@Override
	public Tiro getTiro() {		
		return tiro;
	}
	
	@Override
	public void addTiro(Tiro tiro) {
		this.tiro = tiro;
	}
}
