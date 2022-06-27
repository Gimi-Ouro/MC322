package invasaoAoRio.Model;

import invasaoAoRio.Model.Mapa.IMapa;

public class Tanque {
	private int dano;
	private int l;
	private int c;
	private int preco;
	private int qtdTiros;
	private long tirosPorSegundo;
	private boolean existe;
	private IMapa mapa;
	//posição dele na matriz
	public Tanque(int dano, int preco, int qtdTiros, long tirosPorSegundo) {
		this.dano = dano;
		this.preco = preco;
		this.qtdTiros = qtdTiros;
		this.tirosPorSegundo = tirosPorSegundo;
		this.existe = true;
	}
	
	public void connect(IMapa mapa) {
		this.mapa = mapa;
	}
	
	public void setPosicao(int l, int c) {
		this.l = l;
		this.c = c;
	}
	
	public boolean getExiste() {
		return this.existe;
	}
	public void setExiste(boolean existe){this.existe = existe;}
	public void explodir() {
		this.existe = false;
		mapa.removerTanque(this);
	}
	
	public int getQtdTiros() {
		return this.qtdTiros;
	}
	public void setQtdTiros(int qtdTiros){this.qtdTiros = qtdTiros;}
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
