package invasaoAoRio;

public class Terra extends Celula {
	private Equipamento equipamento;
	
	public Terra() {
		super(true, false, true);
	}
	
	public void addEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	public void RemoverEquipamento() {
		this.equipamento = null;
	}
	
	public Equipamento getEquipamento() {
		if(terra) return this.equipamento;
		else return null;
	}
}
