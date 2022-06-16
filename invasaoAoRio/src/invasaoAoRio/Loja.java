package invasaoAoRio;

public class Loja {
    private int creditos;

    public Loja(int creditos){
        this.creditos = creditos;
    }

    public Canhao compraCanhao(int produto){
        if(produto == 1 && creditos >= 50) {
            creditos -= 50;
            return new Canhao(10, 50, 90,1);
        }
        else if (produto == 2 && creditos >= 75) {
            creditos -= 75;
            return new Canhao(15, 75, 90,1);
        }
        else if (produto == 3 && creditos >= 125){
            creditos -= 125;
            return new Canhao(25, 125, 90,1);
        }
        return null;
    }
}
