package invasaoAoRio.Aplicacao;

import invasaoAoRio.Controller.Controle.Controle;
import invasaoAoRio.Controller.Controle.Icontrole;
import invasaoAoRio.Controller.GeradorDeOndas.GeradorOnda;
import invasaoAoRio.Controller.GeradorDeOndas.IgeradorDeOndas;
import invasaoAoRio.Controller.Loja.Iloja;
import invasaoAoRio.Controller.Loja.Loja;
import invasaoAoRio.GameStart.GameStart;
import invasaoAoRio.GameStart.IGameStart;
import invasaoAoRio.Model.Mapa.IMapa;
import invasaoAoRio.Model.Mapa.Mapa;
import invasaoAoRio.View.AlterarEstado.AtualizaTela;
import invasaoAoRio.View.AlterarEstado.IAtualizaTela;
import invasaoAoRio.View.Janela.JanelaPadrao;

public class AppInvasaoAoRIo {
	private static Icontrole controle;
    private static IgeradorDeOndas geradorOndas;
    private static Iloja loja;
    private static IGameStart gameStart;
    private static IMapa mapa;
    private static IAtualizaTela atualizaTela;
    
    public static void main(String[] args) { 
    	gameStart = new GameStart();
    	controle = new Controle();
    	geradorOndas = new GeradorOnda();
    	atualizaTela = new AtualizaTela();
    	loja = new Loja(600); //inicia com 100 créditos
    	mapa = new Mapa();
    	mapa.connect(atualizaTela);
    	geradorOndas.connect(mapa);
    	controle.connect(mapa);
		mapa.connect(loja);
    	///////////////////////
    	gameStart.connect(controle);
    	gameStart.connect(geradorOndas);
    	gameStart.connect(loja);
    	gameStart.iniciarJogo(mapa, atualizaTela);
    }
}
