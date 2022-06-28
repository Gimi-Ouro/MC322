package invasaoAoRio.GameStart;

import invasaoAoRio.Controller.Controle.Icontrole;
import invasaoAoRio.Controller.Controle.ThreadMovimentoTiro;
import invasaoAoRio.Controller.GeradorDeOndas.GeradorOnda;
import invasaoAoRio.Controller.GeradorDeOndas.IgeradorDeOndas;
import invasaoAoRio.Controller.Loja.Iloja;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Tiro;
import invasaoAoRio.Model.Mapa.IMapa;
import invasaoAoRio.Model.Mapa.Mapa;
import invasaoAoRio.View.AlterarEstado.IAtualizaTela;
import invasaoAoRio.View.Janela.JanelaPadrao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameStart implements IGameStart{
    private Icontrole controle;
    private IgeradorDeOndas geradorOndas;
    private Iloja loja;
    private Thread k;
	private IAtualizaTela atualizaTela;
    
	@Override
	public void connect(Icontrole controle) {
		this.controle = controle;
	}
	@Override
	public void connect(IgeradorDeOndas geradorOndas) {
		this.geradorOndas = geradorOndas;
	}
	@Override
	public void connect(Iloja loja) {
		this.loja = loja;
	}
	@Override
	public void connect(IAtualizaTela atualizaTela) {
		this.atualizaTela = atualizaTela;
	}
	
	public boolean comprarTanque(int i) {
		Tanque tanque = loja.compraCanhao(i);
		if (tanque != null) {
			controle.conectarTanque(tanque);
			atualizaTela.atualizaCreditos(loja.getCreditos());
			return true;
		}
		return false;
	}
	
	//true se colocou e false se não foi possivel colocar
	public boolean addTanque(int x, int y) throws InterruptedException {
		int l, c;
		l = (y-107/2)/107;
		c = x/88;
		return controle.addTanque(l, c);
	}
	
	public void start() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					atualizaTela.trocaImagemOnda(0, 1);
					geradorOndas.gerarOnda(10, 20000, 1);
					Thread.sleep(5000);
					atualizaTela.trocaImagemOnda(1, 2);
					geradorOndas.gerarOnda(20, 30000, 1);
					Thread.sleep(5000);
					atualizaTela.trocaImagemOnda(2, 3);
					geradorOndas.gerarOnda(10, 10000, 2);
					Thread.sleep(10000);
					atualizaTela.trocaImagemOnda(3, 4);
					geradorOndas.gerarOnda(20, 30000, 2);
					Thread.sleep(10000);
					atualizaTela.trocaImagemOnda(4, 5);
					geradorOndas.gerarOnda(30, 40000, 2);
					Thread.sleep(10000);
					atualizaTela.trocaImagemOnda(5, 6);
					geradorOndas.gerarOnda(10, 20000, 3);
					Thread.sleep(10000);
					atualizaTela.trocaImagemOnda(6, 7);
					geradorOndas.gerarOnda(15, 20000, 3);
					Thread.sleep(10000);
					atualizaTela.trocaImagemOnda(7, 8);
					geradorOndas.gerarOnda(20, 40000, 3);
					Thread.sleep(10000);
					atualizaTela.trocaImagemOnda(8, 9);
					geradorOndas.gerarOnda(15, 20000, 3);
					Thread.sleep(10000);
					atualizaTela.trocaImagemOnda(9, 10);
					geradorOndas.gerarOnda(30, 50000, 3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		k = new Thread(runnable);
		k.start();
	}
	
	public void acabarJogo() {
		controle.encerrar();
		geradorOndas.pararOnda();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		k.interrupt();
	} 
	
	@Override
	public void iniciarJogo(IMapa mapa, IAtualizaTela atualizaTela) {
		JanelaPadrao janela = new JanelaPadrao();
		janela.configuraJanela();
		janela.conectaGame(this);
		janela.conecta(mapa);
		atualizaTela.connect(janela);
		atualizaTela.atualizaCreditos(loja.getCreditos());
	}


}
