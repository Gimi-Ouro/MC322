package invasaoAoRio.GameStart;

import invasaoAoRio.Controller.Controle.Icontrole;
import invasaoAoRio.Controller.GeradorDeOndas.IgeradorDeOndas;
import invasaoAoRio.Controller.Loja.Iloja;
import invasaoAoRio.View.JanelaPadrao;

public class GameStart implements IGameStart{
    private Icontrole controle;
    private IgeradorDeOndas geradorOndas;
    private Iloja loja;
    
	public static void main(String[] args){
        JanelaPadrao janela = new JanelaPadrao();
        janela.configuraJanela();
    }

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
}
