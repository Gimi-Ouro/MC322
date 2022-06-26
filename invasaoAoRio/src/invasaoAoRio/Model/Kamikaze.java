package invasaoAoRio.Model;

public class Kamikaze extends Barco{
	private int dano;
	private int preco;
	
	public Kamikaze(int velocidade, int dano, int preco, int tipo, int id) {
		super(velocidade, true, tipo, id);
		this.dano = dano;
		this.preco = preco;
	}
	
	public int getPreco() {
		return this.preco;
	}
	public int getDano() {
		return this.dano;
	}
	
	public void explodir() {
		this.existe = false;
	}
}
