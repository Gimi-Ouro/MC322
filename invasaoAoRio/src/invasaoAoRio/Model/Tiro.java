package invasaoAoRio.Model;

import invasaoAoRio.Model.Mapa.IMapa;

public class Tiro {
	private static final long velocidade = 10;
	private int l;
	private int c;
	private IMapa mapa;
	private final int dano;
	
	public Tiro(int l, int c, int dano) {
		this.l = l;
		this.c = c;
		this.dano = dano;
	}
	
	public int getl() {
		return this.l;
	}
	public int getc() {
		return this.c;
	}
	public int getDano() {
		return this.dano;
	}	
	public long getVelocidade() {
		return velocidade;
	}	
	public void setl(int l) {
		this.l = l;
	}	
	public void setc(int c) {
		this.c = c;
	}		
}
