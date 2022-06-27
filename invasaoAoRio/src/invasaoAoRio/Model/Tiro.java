package invasaoAoRio.Model;

import invasaoAoRio.Model.Mapa.IMapa;

public class Tiro {
	public static final long velocidade = 200;
	private int l;
	private int c;
	private IMapa mapa;
	private final int dano;
	private boolean acertou;

	private int id;
	
	public Tiro(int l, int c, int dano, int id) {
		this.l = l;
		this.c = c;
		this.dano = dano;
		this.id = id;
		this.acertou = false;
	}

	public int getid(){ return this.id;}
	public boolean getAcertou(){return this.acertou;}
	public void setAcertou(boolean acertou){this.acertou = acertou;}
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

    public boolean atingir(Barco barco) throws InterruptedException {
		return barco.atingir(dano);
    }
}
