package invasaoAoRio.Controller.Controle;

import invasaoAoRio.Model.Canhao;
import invasaoAoRio.Model.Mapa.IMapa;

public class Controle implements Icontrole{
	private IMapa mapa;
	private Canhao canhao;
	
	@Override
	public void connect(IMapa mapa) {
		this.mapa = mapa;
	}
	@Override
	public void conectarCanhao(Canhao canhao) {
		this.canhao = canhao;
	}
	//(x, y) é a coordenada do evento do click
	@Override
	public void addCanhao(int l, int c) {
		mapa.addCanhao(l, c, canhao);
	}
	
}
