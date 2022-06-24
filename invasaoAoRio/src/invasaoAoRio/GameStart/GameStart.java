package invasaoAoRio.GameStart;

import invasaoAoRio.Controller.Controle.Icontrole;
import invasaoAoRio.Controller.GeradorDeOndas.GeradorOnda;
import invasaoAoRio.Controller.GeradorDeOndas.IgeradorDeOndas;
import invasaoAoRio.Controller.Loja.Iloja;
import invasaoAoRio.View.JanelaPadrao;
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
	
	public void botaoApertado(int i) {
		controle.conectarTanque(loja.compraCanhao(i));
	}
	
	//true se colocou e false se não foi possivel colocar
	public boolean addTanque(int x, int y) {
		int l, c;
		l = (int) (y-112)/106;
		c = (int) x/88;
		return controle.addTanque(l, c);
	}
	
	@Override
	public void iniciarJogo() {
		JanelaPadrao janela = new JanelaPadrao();
		janela.configuraJanela();
	}

}
