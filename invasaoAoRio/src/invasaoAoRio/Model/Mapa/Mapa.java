package invasaoAoRio.Model.Mapa;

import invasaoAoRio.Model.Agua;
import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.ICelula;
import invasaoAoRio.Model.Terra;
import invasaoAoRio.Model.Tiro;

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
		this.addBarco(navio);
		this.removerElemento(origemL, origemC);
	}
	
	@Override
	public boolean moverTiro(int origemL, int origemC, int destinoL, int destinoC) {
		Tiro tiro = mapa[origemL][origemC].getTiro();
		//chegou no final da matriz - não movimentou
		if(destinoC >= 15) {
			this.removerElemento(origemL, origemC);
			return false;
		}
		//atingiu um navio - não movimentou
		if(!mapa[destinoL][destinoC].isVazia()) {
			mapa[destinoL][destinoC].getBarco().atingir(tiro.getDano());
			this.removerElemento(origemL, origemC);
			return false;
		}else {
			//celula vazia o tiro se movimentou
			tiro.setc(destinoC); 
			tiro.setl(destinoL);
			this.addTiro(tiro);
			this.removerElemento(origemL, origemC);
			return true;
		}
	}
	
	@Override
	public void addTiro(Tiro tiro) {
		mapa[tiro.getl()][tiro.getc()].addTiro(tiro);
	}
	
	public void addTanque(Tanque tanque) {
		if (mapa[tanque.getL()][tanque.getC()].isTerra())
			mapa[tanque.getL()][tanque.getC()].addTanque(tanque);
	}

	public ICelula[][] getMapa() {
		return this.mapa;
	}

	public void addBarco(Barco barco) {
		if (mapa[barco.getl()][barco.getc()].isAgua())
			mapa[barco.getl()][barco.getc()].addBarco(barco);
	}


}
