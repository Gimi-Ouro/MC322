package invasaoAoRio;

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
	
	public void atingir() {
		if (this.resistencia > 0)
			this.resistencia--;
		else
			this.existe = false;
	}
}
