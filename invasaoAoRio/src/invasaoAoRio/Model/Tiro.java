package invasaoAoRio.Model;

import invasaoAoRio.Model.Mapa.IMapa;

public class Tiro {
	public static final long velocidade = 200;
	private int l;
	private int c;
	private IMapa mapa;
	private final int dano;

	private int id;
	
	public Tiro(int l, int c, int dano, int id) {
		this.l = l;
		this.c = c;
		this.dano = dano;
		this.id = id;
	}

	public int getid(){ return this.id;}
	
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

    public void atingir(Barco barco) {
		barco.atingir(dano);
    }
}
