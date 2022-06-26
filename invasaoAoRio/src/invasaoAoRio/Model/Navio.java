package invasaoAoRio.Model;

public class Navio extends Barco{

	private boolean caminhoLinhaReta;
	
	
	public Navio(int resistencia, float velocidade, boolean caminhoLinhaReta, int tipo, int id) {
		super(resistencia, velocidade, true, tipo, id);
		this.caminhoLinhaReta = caminhoLinhaReta;
	}
	
	public boolean getCaminhoLinhaReta() {
		return this.caminhoLinhaReta;
	}
	
	@Override
	public void atingir(int dano) {
		if (this.resistencia > 0)
			this.resistencia -= dano;
		else {
			this.existe = false;
			this.mapa.removerBarco(this);
		}
	}
}
