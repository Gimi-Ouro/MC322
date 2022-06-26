package invasaoAoRio.Model.Mapa;

import invasaoAoRio.Controller.Loja.Iloja;
import invasaoAoRio.GameStart.IGameStart;
import invasaoAoRio.Model.Agua;
import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.ICelula;
import invasaoAoRio.Model.Terra;
import invasaoAoRio.Model.Tiro;
import invasaoAoRio.View.AlterarEstado.IAtualizaTela;

public class Mapa implements IMapa{
	private ICelula[][] mapa;
	private IAtualizaTela atualizaTela;
	private Iloja loja;
	private static int qtdNaviosParados = 0;

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
	@Override
	public void connect(IAtualizaTela atualizaTela) {
		this.atualizaTela = atualizaTela;
	}
	@Override
	public void connect(Iloja loja) { this.loja = loja;}
	
	public void removerElemento(int l, int c) {
		mapa[l][c].removerElemento();
	}

	public void removerTiro(Tiro tiro){
		mapa[tiro.getl()][tiro.getc()].removerTiro();
	}
	
	private void verificarEstado() {
		for (int i = 0; i < 6; i++) {
			if(!mapa[i][3].isVazia())
				qtdNaviosParados++;
		}
		if (qtdNaviosParados > 2) {
			atualizaTela.acabarJogo();
		}
	}

	public void movimentarBarco(int origemL, int origemC, int destinoL, int destinoC) {
		Barco barco = mapa[origemL][origemC].getBarco();
		if (barco != null) {
			atualizaTela.moverBarco(barco, destinoL, destinoC);
			barco.setPosicao(destinoL, destinoC);
			this.addBarcoNaMatriz(barco);
			this.removerElemento(origemL, origemC);
			verificarEstado();
		}
	}
	
	@Override
	public boolean moverTiro(Tiro tiro) {
		if(tiro.getc() != 15){
			if(mapa[tiro.getl()][tiro.getc() + 1].isAgua() && !mapa[tiro.getl()][tiro.getc() + 1].isVazia()){
				tiro.atingir(mapa[tiro.getl()][tiro.getc() + 1].getBarco());
				removerTiro(tiro);
				//atualizaTela.removerTiro(tiro);
				return false;
			}
			else{
				removerTiro(tiro);
				tiro.setc(tiro.getc() + 1);
				addTiro(tiro, false);
				atualizaTela.moverTiro(tiro);
				return true;
			}
		}
		else{
			removerTiro(tiro);
			//atualizaTela.removerTiro(tiro);
			return true;
		}


		/*chegou no final da matriz - não movimentou
		if(destinoC > 15) {
			this.removerElemento(origemL, origemC);
			atualizaTela.removerTiro(tiro);
			return false;
		}else if(!mapa[destinoL][destinoC].isVazia()) {
			//atingiu um navio - não movimentou
			mapa[destinoL][destinoC].getBarco().atingir(tiro.getDano());
			this.removerElemento(origemL, origemC);
			atualizaTela.removerTiro(tiro);
			return false;
		}else {
			//celula vazia o tiro se movimentou
			atualizaTela.moverTiro(tiro, destinoL, destinoC);
			tiro.setc(destinoC); 
			tiro.setl(destinoL);
			this.addTiro(tiro);
			this.removerElemento(origemL, origemC);
			return true;
		}*/
	}
	
	@Override
	public void addTiro(Tiro tiro, boolean addNaTela) {
		mapa[tiro.getl()][tiro.getc()].addTiro(tiro);
		if(addNaTela){ atualizaTela.addTiro(tiro);}
	}
	
	public boolean addTanque(Tanque tanque) {
		if (mapa[tanque.getL()][tanque.getC()].isTerra()) {
			tanque.connect(this);
			return mapa[tanque.getL()][tanque.getC()].addTanque(tanque);
		}
		return false;
	}

	public ICelula[][] getMapa() {
		return this.mapa;
	}
	
	public void addBarcoNaMatriz(Barco barco) {
		if (mapa[barco.getl()][barco.getc()].isAgua()
				&& mapa[barco.getl()][barco.getc()].isVazia()) {
			barco.connect(this);
			mapa[barco.getl()][barco.getc()].addBarco(barco);
		}
	}

	public void addBarco(Barco barco) {
		this.addBarcoNaMatriz(barco);
		atualizaTela.adicionarBarco(barco);
		
	}

	@Override
	public void removerTanque(Tanque tanque) {
		mapa[tanque.getL()][tanque.getC()].removerElemento();
		atualizaTela.removerTanque(tanque);
	}

	public void removerBarco(Barco barco) {
		mapa[barco.getl()][barco.getc()].removerElemento();
		loja.navioAbatido(barco.getTipo());
		atualizaTela.removerBarco(barco);
	}


}
