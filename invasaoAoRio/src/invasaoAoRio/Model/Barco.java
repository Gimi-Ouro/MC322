package invasaoAoRio.Model;

public class Barco {
	protected float velocidade; //celulas/seg ou pilels/seg
	protected boolean existe;
	protected int l, c;
	
	public Barco(float velocidade, boolean existe) {
		this.velocidade = velocidade;
		this.existe = existe;
	}
	
	public void setPosicao(int l, int c) {
		this.l = l;
		this.c = c;
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
