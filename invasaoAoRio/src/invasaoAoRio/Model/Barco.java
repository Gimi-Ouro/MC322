package invasaoAoRio.Model;

import invasaoAoRio.Model.Mapa.IMapa;

public class Barco {
	protected float velocidade; //celulas/seg ou pilels/seg
	protected boolean existe;
	protected int tipo;
	protected int l, c;
	protected IMapa mapa;
	
	public Barco(float velocidade, boolean existe, int tipo) {
		this.velocidade = velocidade;
		this.existe = existe;
		this.tipo = tipo;
	}
	
	public void connect(IMapa mapa) {
		this.mapa = mapa;
	}
	
	public void setPosicao(int l, int c) {
		this.l = l;
		this.c = c;
	}
	
	public int getTipo() {
		return this.tipo;
	}
	
	public boolean getExiste() {
		return this.existe;
	}
	
	public float getVelocidade() {
		return this.velocidade;
	}
	public void atingir(int dano) {
		
	}
	public int getl() {
		return this.l;
	}
	public int getc() {
		return this.c;
	}
}
