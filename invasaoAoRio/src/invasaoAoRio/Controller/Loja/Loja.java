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
            return new Tanque(10, 50, 20,1);
        }
        else if (produto == 2 && creditos >= 75) {
            creditos -= 75;
            return new Tanque(15, 75, 30,1);
        }
        else if (produto == 3 && creditos >= 125){
            creditos -= 125;
            return new Tanque(25, 125, 40,1);
        }
        return null;
    }
    public int getCreditos(){return this.creditos;}

    public void navioAbatido(int tipo){
        if(tipo == 0) creditos += 20;
        else if(tipo == 1) creditos += 35;
        else if(tipo == 2) creditos += 50;
    }
}
