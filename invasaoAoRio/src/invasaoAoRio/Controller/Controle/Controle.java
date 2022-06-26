package invasaoAoRio.Controller.Controle;

import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Tiro;
import invasaoAoRio.Model.Mapa.IMapa;

import java.util.ArrayList;

public class Controle implements Icontrole{
	private IMapa mapa;
	private Tanque tanque;

	private ArrayList<ThreadMovimentoTiro> threads;

	public Controle(){
		threads = new ArrayList<>();
	}
	
	@Override
	public void connect(IMapa mapa) {
		this.mapa = mapa;
	}
	@Override
	public void conectarTanque(Tanque tanque) {
		this.tanque = tanque;
	}
	
	/*private void atirar(Tiro tiro) {
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
	}*/
	
	private void gerarTiros(Tanque tanque) {
		Tiro tiro = new Tiro(tanque.getL(), tanque.getC() + 1, tanque.getDano());
		mapa.addTiro(tiro);
		ThreadMovimentoTiro t = new ThreadMovimentoTiro(tiro, mapa);
		threads.add(t);
		t.start();
	}
	
	//(l, c) é a coordenada do evento do click
	@Override
	public boolean addTanque(int l, int c) {
		tanque.setPosicao(l, c);
		if(mapa.addTanque(tanque)) {
			//gerarTiros(tanque); //da erro aqui
			return true;
		}
		return false;
	}
	
}
