package invasaoAoRio;

import java.util.Random;
import java.util.Timer;

public class GeradorOnda {
    private Timer tempoInterno;
    private Mapa mapa;

    public GeradorOnda(){
        tempoInterno = new Timer();
    }

    public void conectaMapa(Mapa mapa){
        this.mapa = mapa;
    }

    public void gerarOnda(int quantidadeNavios, long duracao, int dificuldade) throws InterruptedException {
        if(mapa != null) {
            long intervaloGeracao = duracao / quantidadeNavios;
            int posicionamento, tipo;
            Random rand = new Random();
            for (int i = 0; i < quantidadeNavios; i++){
            posicionamento = rand.nextInt(0, mapa.getMapa().length);
            tipo = rand.nextInt(1, dificuldade+1); //tipo de navio que será gerado. A dificuldade pode ir de 1 a 3, dependendo de qual onda estamos
            if(tipo == 1){
                mapa.getMapa()[posicionamento][16].addBarco(new Navio(50, 1, true));
            }
            else if(tipo == 2){
                mapa.getMapa()[posicionamento][16].addBarco(new Navio(50, 2, true));
            }
            else if(tipo == 3){
                mapa.getMapa()[posicionamento][16].addBarco(new Navio(100, 1, true));
            }
            //não sei se essa função sozinha espera o tempo. Quando coloquei ela, o IntelliJ pediu pra colocar aquele throws InterruptedException ali em cima
            wait(intervaloGeracao);
            }
        }
    }
}
