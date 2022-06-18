package invasaoAoRio.Model;

public class Barco {
	protected float velocidade; //celulas/seg ou pilels/seg
	protected boolean existe;
	protected int l, c;
	
	public Barco(float velocidade, boolean eliste) {
		this.velocidade = velocidade;
		this.existe = eliste;
	}
	
	public void setPosicao(int l, int c) {
		this.l = l;
		this.c = c;
	}
	
	public boolean getEliste() {
		return this.existe;
	}
	
	public float getVelocidade() {
		return this.velocidade;
	}
	
	public int getl() {
		return this.l;
	}
	public int getc() {
		return this.c;
	}
}
