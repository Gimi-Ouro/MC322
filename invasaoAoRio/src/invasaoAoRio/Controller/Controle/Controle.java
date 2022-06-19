package invasaoAoRio.Controller.Controle;

import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Mapa.IMapa;

public class Controle implements Icontrole{
	private IMapa mapa;
	private Tanque tanque;
	
	@Override
	public void connect(IMapa mapa) {
		this.mapa = mapa;
	}
	@Override
	public void conectarTanque(Tanque tanque) {
		this.tanque = tanque;
	}
	//(x, y) é a coordenada do evento do click
	@Override
	public void addTanque(int l, int c) {
		mapa.addTanque(l, c, tanque);
	}
	
}
