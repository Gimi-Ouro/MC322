package invasaoAoRio;

public class Celula {
	protected boolean vazia; // se tem algum elemento como barco ou canhão
	protected boolean agua;
	protected boolean terra;
	protected Barco barco;
	protected Equipamento equipamento;
	
	public Celula(boolean vazia, boolean agua, boolean terra) {
		this.vazia = vazia;
		this.agua = agua;
		this.terra = terra;
	}
	
	//public boolean isTerra() {
		//return false;
	//}
	
	public boolean isAgua() {
		return false;
	}
	
	public void addBarco(Barco barco) {
		return;
	}
	
	public void addEquipamento(Equipamento equipamento) {
		return;
	}
	
	public Barco getBarco() {
		return null;
	}
	
	public Equipamento getEquipamento() {
		return null;
	}
	
}
