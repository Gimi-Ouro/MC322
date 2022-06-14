package invasaoAoRio;

public class Barco {
	protected float velocidade; //celulas/seg ou pixels/seg
	protected boolean existe;
	protected int x, y;
	
	public Barco(float velocidade, boolean existe) {
		this.velocidade = velocidade;
		this.existe = existe;
	}
	
	public void setPosicao(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean getExiste() {
		return this.existe;
	}
	
	public float getVelocidade() {
		return this.velocidade;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
