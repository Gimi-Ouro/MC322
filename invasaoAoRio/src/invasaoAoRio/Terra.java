package invasaoAoRio;

public class Terra implements ICelula {
	private boolean vazia;
	private Equipamento equipamento;

	public Terra() {
		this.vazia = true;
		this.equipamento = null;
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
	public Equipamento getEquipamento() {
		return this.equipamento;
	}
	@Override
	public void addBarco(Barco barco) {
	}

	@Override
	public void addEquipamento(Equipamento equipamento){
		this.equipamento = equipamento;
	}
}
