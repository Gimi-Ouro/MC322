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
	public void removerTiroMatriz(Tiro tiro){
		mapa[tiro.getl()][tiro.getc()].removerTiro();
	}
	public void removerTiro(Tiro tiro){
		removerTiroMatriz(tiro);
		atualizaTela.removerTiro(tiro);
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

	public void movimentarBarco(int origemL, int origemC, int destinoL, int destinoC) throws InterruptedException {
		Barco barco = mapa[origemL][origemC].getBarco();
		if (barco != null) {
			if(mapa[destinoL][destinoC].getTiro() != null){
				Thread.sleep(500);
			}
			atualizaTela.moverBarco(barco, destinoL, destinoC);
			barco.setPosicao(destinoL, destinoC);
			this.addBarcoNaMatriz(barco);
			this.removerElemento(origemL, origemC);
			verificarEstado();
		}
	}
	
	@Override
	public boolean moverTiro(Tiro tiro) throws InterruptedException {
		if(tiro.getc() < 15){
			if(mapa[tiro.getl()][tiro.getc() + 1].getBarco() != null && !tiro.getAcertou()){
				System.out.println("TIRO ACERTOU");
				if(tiro.atingir(mapa[tiro.getl()][tiro.getc() + 1].getBarco())){
					atualizaTela.removerBarco(mapa[tiro.getl()][tiro.getc() + 1].getBarco());
				}
				tiro.setAcertou(true);
				removerTiro(tiro);
				return false;
			}
			else{
				removerTiroMatriz(tiro);
				tiro.setc(tiro.getc() + 1);
				addTiro(tiro, false);
				atualizaTela.moverTiro(tiro);
				return true;
			}
		}
		else{
			removerTiro(tiro);
			System.out.println("CHEGOU");
			return true;
		}

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

	public void removerBarco(Barco barco) throws InterruptedException {
		loja.navioAbatido(barco.getTipo());
		mapa[barco.getl()][barco.getc()].removerElemento();
		atualizaTela.atualizaCreditos(loja.getCreditos());
		System.out.println("+50");
		atualizaTela.removerBarco(barco);
	}


}
