package invasaoAoRio;

public class Tiro {
	private static final long velocidade = 10;
	private int x;
	private int y;
	private final int dano;
	
	public Tiro(int x, int y, int dano) {
		this.x = x;
		this.y = y;
		this.dano = dano;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getDano() {
		return this.dano;
	}
	
	public long getVelocidade() {
		return velocidade;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
