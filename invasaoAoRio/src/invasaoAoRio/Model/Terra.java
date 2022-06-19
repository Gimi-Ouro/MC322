package invasaoAoRio.Model;

public class Terra implements ICelula {
	private boolean vazia;
	private Tanque tanque;

	public Terra() {
		this.vazia = true;
		this.tanque = null;
	}


	@Override
	public boolean isTerra() {
		return true;
	}

	@Override
	public boolean isAgua() {
		return false;
	}

	@Override
	public Barco getBarco() {
		return null;
	}

	@Override
	public Tanque getCanhao() {
		return this.tanque;
	}
	@Override
	public void addBarco(Barco barco) {
	}

	@Override
	public void addTanque(Tanque tanque){
		this.tanque = tanque;
		this.vazia = false;
	}


	@Override
	public void removerElemento() {
		this.tanque = null;
		this.vazia = true;
	}


	@Override
	public boolean isVazia() {
		return this.vazia;
	}
}
