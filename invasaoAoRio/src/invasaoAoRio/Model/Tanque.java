package invasaoAoRio.Model;

public class Tanque {
	private int dano;
	private int l;
	private int c;
	private int preco;
	private int qtdTiros;
	private long tirosPorSegundo;
	private boolean existe;
	//posição dele na matriz
	public Tanque(int dano, int preco, int qtdTiros, long tirosPorSegundo) {
		this.dano = dano;
		this.preco = preco;
		this.qtdTiros = qtdTiros;
		this.tirosPorSegundo = tirosPorSegundo;
		this.existe = true;
	}
	public void setPosicao(int l, int c) {
		this.l = l;
		this.c = c;
	}
	
	public boolean getExiste() {
		return existe;
	}
	
	public void explodir() {
		this.existe = false;
	}
	
	public int getQtdTiros() {
		return this.qtdTiros;
	}
	public long getTirosPorSegundo() {
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
