package invasaoAoRio.Aplicacao;

import invasaoAoRio.Controller.Controle.Controle;
import invasaoAoRio.Controller.Controle.Icontrole;
import invasaoAoRio.Controller.GeradorDeOndas.GeradorOnda;
import invasaoAoRio.Controller.GeradorDeOndas.IgeradorDeOndas;
import invasaoAoRio.Controller.Loja.Iloja;
import invasaoAoRio.Controller.Loja.Loja;
import invasaoAoRio.GameStart.GameStart;
import invasaoAoRio.GameStart.IGameStart;
import invasaoAoRio.View.IJanelaPadrao;
import invasaoAoRio.View.JanelaPadrao;

public class AppInvasaoAoRIo {
	private static Icontrole controle;
    private static IgeradorDeOndas geradorOndas;
    private static Iloja loja;
    private static IGameStart gameStart;
    private static IJanelaPadrao janela;
    
    public static void main(String[] args) { 
    	gameStart = new GameStart();
    	controle = new Controle();
    	geradorOndas = new GeradorOnda();
    	loja = new Loja(100); //inicia com 100 créditos
    	JanelaPadrao janela = new JanelaPadrao();
		janela.configuraJanela();
    	///////////////////////
    	gameStart.connect(controle);
    	gameStart.connect(geradorOndas);
    	gameStart.connect(loja);
    	janela.conectaGame(gameStart);
    	gameStart.iniciarJogo();
    }
}
