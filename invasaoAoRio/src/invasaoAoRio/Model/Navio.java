package invasaoAoRio.Model;

public class Navio extends Barco{
	private int resistencia;
	private boolean caminhoLinhaReta;
	
	public Navio(int resistencia, float velocidade, boolean caminhoLinhaReta) {
		super(velocidade, true);
		this.resistencia = resistencia;
		this.caminhoLinhaReta = caminhoLinhaReta;
	}
	
	public boolean getCaminhoLinhaReta() {
		return this.caminhoLinhaReta;
	}
	
	public void atingir(int dano) {
		if (this.resistencia > 0)
			this.resistencia -= dano;
		else
			this.existe = false;
	}
}
