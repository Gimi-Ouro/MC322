package invasaoAoRio.Model;

public class Terra implements ICelula {
	private boolean vazia;
	private Canhao canhao;

	public Terra() {
		this.vazia = true;
		this.canhao = null;
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
	public Canhao getCanhao() {
		return this.canhao;
	}
	@Override
	public void addBarco(Barco barco) {
	}

	@Override
	public void addCanhao(Canhao canhao){
		this.canhao = canhao;
		this.vazia = false;
	}
}
