package invasaoAoRio.Model;

public class Navio extends Barco{

	private boolean caminhoLinhaReta;
	
	
	public Navio(int resistencia, long velocidade, boolean caminhoLinhaReta, int tipo, int id) {
		super(resistencia, velocidade, true, tipo, id);
		this.caminhoLinhaReta = caminhoLinhaReta;
	}
	
	public boolean getCaminhoLinhaReta() {
		return this.caminhoLinhaReta;
	}
	
	@Override
	public boolean atingir(int dano) throws InterruptedException {
		//retorna true se o barco for destruído
		if (this.resistencia > 0){
			this.resistencia -= dano;
			return false;
		}
		else {
			this.existe = false;
			this.mapa.removerBarco(this);
			return true;
		}
	}
}
