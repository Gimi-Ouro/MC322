package invasaoAoRio.Controller.Controle;

import invasaoAoRio.Controller.GeradorDeOndas.ThreadMovimentoNavio;
import invasaoAoRio.Model.Mapa.IMapa;
import invasaoAoRio.Model.Tiro;

public class ThreadMovimentoTiro extends Thread{

    private Tiro tiro;
    private IMapa mapa;

    public ThreadMovimentoTiro(Tiro tiro, IMapa mapa){
        super();
        this.tiro = tiro;
        this.mapa = mapa;
    }

    @Override
    public void run(){
        int colunaInicial = tiro.getc();
        Thread t = Thread.currentThread();
        for(int i = 15; i > colunaInicial; i--) {
            mapa.moverTiro(tiro);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
