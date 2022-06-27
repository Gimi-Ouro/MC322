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
        for(int i = colunaInicial; i < 16; i++) {
            try {
                mapa.moverTiro(tiro);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
