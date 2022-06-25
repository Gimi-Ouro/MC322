package invasaoAoRio.Controller.Loja;

import invasaoAoRio.Model.Tanque;

public class Loja implements Iloja{
    private int creditos;

    public Loja(int creditos){
        this.creditos = creditos;
    }

    public Tanque compraCanhao(int produto){
        if(produto == 1 && creditos >= 50) {
            creditos -= 50;
            return new Tanque(10, 50, 90,1);
        }
        else if (produto == 2 && creditos >= 75) {
            creditos -= 75;
            return new Tanque(15, 75, 90,1);
        }
        else if (produto == 3 && creditos >= 125){
            creditos -= 125;
            return new Tanque(25, 125, 90,1);
        }
        return null;
    }

    public void navioAbatido(int tipo){
        if(tipo == 1) creditos += 25;
        else if(tipo == 2) creditos += 50;
        else if(tipo == 3) creditos += 100;
    }
}
