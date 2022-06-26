package invasaoAoRio.Controller.GeradorDeOndas;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Mapa.IMapa;

public class ThreadMovimentoNavio extends Thread {
	private Barco navio;
	private IMapa mapa;
	
	public ThreadMovimentoNavio(IMapa mapa, Barco navio) {
		this.mapa = mapa;
		this.navio = navio;
	}
	
	public void run() {
    	Thread t = Thread.currentThread();
    	System.out.println(t.getName());
      for(int i = 15; i > 3; i--) {
    	  mapa.movimentarBarco(navio.getl(), navio.getc(), navio.getl(), navio.getc() - 1);
    	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
      }
    }
}
