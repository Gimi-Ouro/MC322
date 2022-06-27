package invasaoAoRio.Model;

import invasaoAoRio.Model.Mapa.IMapa;

public class Barco {
	protected long velocidade; //celulas/seg ou pilels/seg
	protected boolean existe;
	protected int tipo;
	protected int l, c;
	protected IMapa mapa;
	protected int id;
	protected int resistencia;
	public int getId() {
		return id;
	}
	
	public Barco(int resistencia, long velocidade, boolean existe, int tipo, int id) {
		this.resistencia = resistencia;
		this.velocidade = velocidade;
		this.existe = existe;
		this.tipo = tipo;
		this.id = id;
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
	public int getResistencia(){ return this.resistencia;}
	
	public boolean getExiste() {
		return this.existe;
	}
	
	public long getVelocidade() {
		return this.velocidade;
	}

	public boolean atingir(int dano) throws InterruptedException {return false;}
	public int getl() {
		return this.l;
	}
	public int getc() {
		return this.c;
	}
}
