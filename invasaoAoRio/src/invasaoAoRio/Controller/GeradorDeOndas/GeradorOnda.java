package invasaoAoRio.Controller.GeradorDeOndas;

import java.util.ArrayList;
import java.util.Random;
//import java.util.Timer;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Navio;
import invasaoAoRio.Model.Mapa.IMapa;

public class GeradorOnda implements IgeradorDeOndas{
    //private Timer tempoInterno;
    private IMapa mapa;
    private ArrayList<ThreadMovimentoNavio> threads;

    //public GeradorOnda(){
        //tempoInterno = new Timer();
    //}

    public void connect(IMapa mapa){
        this.mapa = mapa;
    }
    
    private void partidaNoNavio(Barco navio) {
    	ThreadMovimentoNavio t = new ThreadMovimentoNavio(mapa, navio);
    	threads.add(t);
    	t.start();
    }
    
    @SuppressWarnings("deprecation")
	public void pararOnda() {
    	for (Thread t: threads) {
    		t.stop();
    	}
    }
    
    public void gerarOnda(int quantidadeNavios, long duracao, int dificuldade) throws InterruptedException {
        if(mapa != null) {
        	threads = new ArrayList<>();
            long intervaloGeracao = duracao / quantidadeNavios;
            int posicionamento, tipo;
            Random rand = new Random();
            Navio navio = null;
            for (int i = 0; i < quantidadeNavios; i++){
	            posicionamento = rand.nextInt(mapa.getMapa().length);
	            tipo = rand.nextInt(dificuldade); //tipo de navio que será gerado. A dificuldade pode ir de 1 a 3, dependendo de qual onda estamos
	            if(tipo == 0){
	            	navio = new Navio(20, 1, true, 0, i);
	            } else if(tipo == 1){
	            	navio = new Navio(50, 1, true, 1, i);
	            } else if(tipo == 2){
	            	navio = new Navio(70, 1, true, 2, i);
	            }
	            navio.setPosicao(posicionamento, 15);
	            mapa.addBarco(navio);
	            partidaNoNavio(navio);
	            Thread.sleep(intervaloGeracao);
            }
        }
    }
}
