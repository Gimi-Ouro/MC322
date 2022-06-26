package invasaoAoRio.GameStart;

import invasaoAoRio.Controller.Controle.Icontrole;
import invasaoAoRio.Controller.GeradorDeOndas.GeradorOnda;
import invasaoAoRio.Controller.GeradorDeOndas.IgeradorDeOndas;
import invasaoAoRio.Controller.Loja.Iloja;
import invasaoAoRio.Model.Tanque;
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
	
	public boolean comprarTanque(int i) {
		Tanque tanque = loja.compraCanhao(i);
		if (tanque != null) {
			controle.conectarTanque(tanque);
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
		try {
			geradorOndas.gerarOnda(10, 20000, 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void acabarJogo() {
		geradorOndas.pararOnda();
	} 
	
	@Override
	public void iniciarJogo(IMapa mapa, IAtualizaTela atualizaTela) {
		JanelaPadrao janela = new JanelaPadrao();
		janela.configuraJanela();
		janela.conectaGame(this);
		janela.conecta(mapa);
		atualizaTela.connect(janela);
		start();
	}

}
