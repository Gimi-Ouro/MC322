package invasaoAoRio.Controller.GeradorDeOndas;

import java.util.Random;
//import java.util.Timer;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Navio;
import invasaoAoRio.Model.Mapa.IMapa;

public class GeradorOnda implements IgeradorDeOndas{
    //private Timer tempoInterno;
    private IMapa mapa;

    //public GeradorOnda(){
        //tempoInterno = new Timer();
    //}

    public void connect(IMapa mapa){
        this.mapa = mapa;
    }
    
    private void partidaNoNavio(Barco navio) {
    	new Thread() {
    	    @Override
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
    	  }.start();
    }
    
    public void gerarOnda(int quantidadeNavios, long duracao, int dificuldade) throws InterruptedException {
        if(mapa != null) {
            long intervaloGeracao = duracao / quantidadeNavios;
            int posicionamento, tipo;
            Random rand = new Random();
            Navio navio = null;
            for (int i = 0; i < quantidadeNavios; i++){
	            posicionamento = rand.nextInt(mapa.getMapa().length);
	            tipo = rand.nextInt(dificuldade); //tipo de navio que será gerado. A dificuldade pode ir de 1 a 3, dependendo de qual onda estamos
	            if(tipo == 0){
	            	navio = new Navio(50, 1, true, 0, i);
	            } else if(tipo == 1){
	            	navio = new Navio(50, 2, true, 1, i);
	            } else if(tipo == 2){
	            	navio = new Navio(100, 1, true, 2, i);
	            }
	            navio.setPosicao(posicionamento, 15);
	            mapa.addBarco(navio);
	            partidaNoNavio(navio);
	            Thread.sleep(intervaloGeracao);
            }
        }
    }
}
