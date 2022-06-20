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
	
	private void atirar(Tiro tiro, long tirosPorSeg) {
		new Thread() {
    	    @Override
    	    public void run() {
    	      int i = 3;
    	      while(mapa.moverTiro(tiro.getl(), i, tiro.getl(), i+1)) {
    	    	  i++;
    	    	  try {
					Thread.sleep(tirosPorSeg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    	      }
    	    }
    	  }.start();
	}
	
	private void gerarTiros(Tanque tanque) {
		while(tanque.getExiste()) {
			Tiro tiro = new Tiro(tanque.getL(), 3, tanque.getDano());
			mapa.addTiro(tiro);
			this.atirar(tiro, tanque.getTirosPorSegundo());
		}
	}
	
	//(l, c) é a coordenada do evento do click
	@Override
	public void addTanque(int l, int c) {
		tanque.setPosicao(l, c);
		mapa.addTanque(tanque);
		gerarTiros(tanque);
	}
	
}
