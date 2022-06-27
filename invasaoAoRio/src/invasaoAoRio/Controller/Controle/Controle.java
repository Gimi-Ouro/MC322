package invasaoAoRio.Controller.Controle;

import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Tiro;
import invasaoAoRio.Model.Mapa.IMapa;

import java.util.ArrayList;

public class Controle implements Icontrole{
	private IMapa mapa;
	private Tanque tanque;

	private ArrayList<ThreadMovimentoTiro> threads;
	private ArrayList<Tanque> tanques;

	private static int nIds = 0;

	public Controle(){
		threads = new ArrayList<>();
		tanques = new ArrayList<>();
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
	
	private void gerarTiros(Tanque tanque) throws InterruptedException {
			new Thread() {
				public void run() {
					for(int i = 0; i < tanque.getQtdTiros(); i++){
						Tiro tiro = new Tiro(tanque.getL(), tanque.getC() + 1, tanque.getDano(), nIds);
						nIds++;
						mapa.addTiro(tiro, true);
						ThreadMovimentoTiro t = new ThreadMovimentoTiro(tiro, mapa);
						threads.add(t);
						t.start();
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
						if(i == tanque.getQtdTiros() - 1){
							mapa.removerTanque(tanque);
						}
				}}
			}.start();

	}
	
	//(l, c) é a coordenada do evento do click
	@Override
	public boolean addTanque(int l, int c) throws InterruptedException {
		this.tanque.setPosicao(l, c);
		if(mapa.addTanque(this.tanque)) {
			tanques.add(this.tanque);
			gerarTiros(tanques.get(tanques.size() - 1));
			return true;}
		return false;
	}
	
}
