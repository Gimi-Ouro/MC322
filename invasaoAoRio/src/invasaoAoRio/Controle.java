package invasaoAoRio;

public class Controle {
	private Mapa mapa;
	private Canhao canhao;
	private int pontuacao = 100;
	
	public void connect(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public void conectarCanhao(Canhao canhao) {
		this.canhao = canhao;
	}
	//(x, y) é a coordenada do evento do click
	public void addCanhao(int x, int y) {
		mapa.addCanhao(x, y, canhao);
	}
	
}
