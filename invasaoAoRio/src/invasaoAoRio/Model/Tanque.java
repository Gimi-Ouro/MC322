package invasaoAoRio.Model;

public class Tanque {
	private int dano;
	private int l;
	private int c;
	private int preco;
	private long tempoDeVida;
	private long tirosPorSegundo;
	private boolean existe;
	//posição dele na matriz
	public Tanque(int dano, int preco, long tempoDeVida, long tirosPorSegundo) {
		this.dano = dano;
		this.preco = preco;
		this.tempoDeVida = tempoDeVida;
		this.tirosPorSegundo = tirosPorSegundo;
	}
	public void setPosicao(int l, int c) {
		this.l = l;
		this.c = c;
	}
	
	public boolean getExiste() {
		return existe;
	}
	
	public long getTempoDeVida() {
		return this.tempoDeVida;
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
