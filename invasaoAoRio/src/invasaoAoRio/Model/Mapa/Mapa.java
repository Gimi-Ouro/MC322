package invasaoAoRio.Model.Mapa;

import invasaoAoRio.Model.Agua;
import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.ICelula;
import invasaoAoRio.Model.Terra;

public class Mapa implements IMapa{
	private ICelula[][] mapa;

	public Mapa() {
		mapa = new ICelula[6][16];
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if (j < 3)
					mapa[i][j] = new Terra();
				else
					mapa[i][j] = new Agua();
			}
		}
	}
	
	public void removerElemento(int l, int c) {
		mapa[l][c].removerElemento();
	}

	public void movimentarBarco(int origemL, int origemC, int destinoL, int destinoC) {
		Barco navio = mapa[origemL][origemC].getBarco();
		navio.setPosicao(destinoL, destinoC);
		mapa[destinoL][destinoC].addBarco(navio);
		removerElemento(origemL, origemC);
	}
	
	public void addTanque(int l, int c, Tanque tanque) {
		if (mapa[l][c].isTerra())
			mapa[l][c].addTanque(tanque);
	}

	public ICelula[][] getMapa() {
		return this.mapa;
	}

	public void addBarco(int l, int c, Barco barco) {
		if (mapa[l][c].isAgua())
			mapa[l][c].addBarco(barco);
	}

}
