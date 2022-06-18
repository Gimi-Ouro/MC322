package invasaoAoRio.Model;

public class Canhao{
	private int dano;
	private int l;
	private int c;
	private int preco;
	private long tempoDeVida;
	private float tirosPorSegundo;
	//posição dele na matriz
	public Canhao(int dano, int preco, long tempoDeVida, float tirosPorSegundo) {
		this.dano = dano;
		this.preco = preco;
		this.tempoDeVida = tempoDeVida;
		this.tirosPorSegundo = tirosPorSegundo;
	}
	public void setPosicao(int l, int c) {
		this.l = l;
		this.c = c;
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

	public int getL(){return this.l;}
	public int getC(){return this.c;}
}
