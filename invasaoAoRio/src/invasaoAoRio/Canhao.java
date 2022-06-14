package invasaoAoRio;

public class Canhao extends Equipamento {
	private int dano;
	private int preco;
	private long tempoDeVida;
	private float tirosPorSegundo;
	//posição dele na matriz
	public Canhao(int dano, int preco, long tempoDeVida, float tirosPorSegundo) {
		super('C');
		this.dano = dano;
		this.preco = preco;
		this.tempoDeVida = tempoDeVida;
		this.tirosPorSegundo = tirosPorSegundo;
	}

	public long getTempoDeVida() {
		return this.tempoDeVida;
	}
	public float getTirosPorSegundo() {
		return this.tirosPorSegundo;
	}
	public int getPreco() {
		return this.preco;
	}
	public int getDano() {
		return this.dano;
	}
}
