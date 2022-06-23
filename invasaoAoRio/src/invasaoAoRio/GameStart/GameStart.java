package invasaoAoRio.GameStart;

import invasaoAoRio.Controller.Controle.Icontrole;
import invasaoAoRio.Controller.GeradorDeOndas.GeradorOnda;
import invasaoAoRio.Controller.GeradorDeOndas.IgeradorDeOndas;
import invasaoAoRio.Controller.Loja.Iloja;
import invasaoAoRio.View.JanelaPadrao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStart implements IGameStart, ActionListener{
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
	
	@Override
	public void iniciarJogo() {
		JanelaPadrao janela = new JanelaPadrao();
		janela.configuraJanela();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
