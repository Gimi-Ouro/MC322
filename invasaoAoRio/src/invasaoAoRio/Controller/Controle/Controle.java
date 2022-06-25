package invasaoAoRio.Controller.Controle;

import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Tiro;
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
	
	private void atirar(Tiro tiro) {
		new Thread() {
    	    @Override
    	    public void run() {
    	      int i = 3;
    	      while(mapa.moverTiro(tiro.getl(), i, tiro.getl(), i+1)) {
    	    	  i++;
    	    	  try {
					Thread.sleep(Tiro.velocidade);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    	      }
    	    }
    	  }.start();
	}
	
	/*private void gerarTiros(Tanque tanque) {
		int i = 0;
		while(tanque.getExiste()) {
			Tiro tiro = new Tiro(tanque.getL(), 3, tanque.getDano());
			mapa.addTiro(tiro);
			this.atirar(tiro);
			i++;
			if(i == tanque.getQtdTiros()) {
				tanque.explodir();
			}
			try {
				Thread.sleep(tanque.getTirosPorSegundo());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}da erro aqui*/
	
	//(l, c) é a coordenada do evento do click
	@Override
	public boolean addTanque(int l, int c) {
		tanque.setPosicao(l, c);
		if(mapa.addTanque(tanque)) {
			//gerarTiros(tanque); da erro aqui
			return true;
		}
		return false;
	}
	
}
