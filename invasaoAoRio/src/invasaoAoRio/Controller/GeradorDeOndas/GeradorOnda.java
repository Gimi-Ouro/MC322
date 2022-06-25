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
    	      for(int i = navio.getc(); i > 4; i--) {
    	    	  mapa.movimentarBarco(navio.getl(), i, navio.getl(), i-1);
    	    	  try {
					Thread.sleep(500);
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
	            posicionamento = rand.nextInt(mapa.getMapa().length - 1);
	            tipo = rand.nextInt(dificuldade); //tipo de navio que será gerado. A dificuldade pode ir de 1 a 3, dependendo de qual onda estamos
	            if(tipo == 0){
	            	navio = new Navio(50, 1, true, 0);
	            } else if(tipo == 1){
	            	navio = new Navio(50, 2, true, 1);
	            } else if(tipo == 2){
	            	navio = new Navio(100, 1, true, 2);
	            }
	            navio.setPosicao(posicionamento, 15);
	            mapa.addBarco(navio);
	            partidaNoNavio(navio);
	            /*não sei se essa função sozinha espera o tempo. Quando coloquei ela, 
	            o IntelliJ pediu pra colocar aquele throws InterruptedException ali em cima*/
	            wait(intervaloGeracao);
            }
        }
    }
}
