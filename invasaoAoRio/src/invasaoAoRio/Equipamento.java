package invasaoAoRio;

public class Equipamento {
	private char tipo; //C - canhão; B - barreira; K - kamikaze
	private int x, y;
	
	public Equipamento(char tipo) {
		this.tipo = tipo;
	}
	
	public void setPosicao(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public char getTipo() {
		return this.tipo;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
