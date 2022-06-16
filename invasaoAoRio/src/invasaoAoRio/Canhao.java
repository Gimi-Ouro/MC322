package invasaoAoRio;

public class Canhao{
	private int dano;
	private int x;
	private int y;
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
	public void setPosicao(int x, int y) {
		this.x = x;
		this.y = y;
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

	public int getX(){return this.x;}
	public int getY(){return this.y;}
}
