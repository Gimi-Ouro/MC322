package invasaoAoRio.Model.Mapa;

import invasaoAoRio.Model.Agua;
import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Canhao;
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

	public void addCanhao(int x, int y, Canhao canhao) {
		if (mapa[x][y].isTerra())
			mapa[x][y].addCanhao(canhao);
	}

	public ICelula[][] getMapa() {
		return this.mapa;
	}

	public void addBarco(int x, int y, Barco barco) {
		if (mapa[x][y].isAgua())
			mapa[x][y].addBarco(barco);
	}

}
