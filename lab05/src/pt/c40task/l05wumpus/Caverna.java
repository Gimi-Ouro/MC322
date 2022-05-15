package pt.c40task.l05wumpus;

public class Caverna {
    private Sala[][] vSalas;

    public Caverna(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                vSalas[i][j] = new Sala(true);
            }
        }
    }

    public void addComponente(int l, int c, char caracterCriacao){
        this.vSalas[l][c].criar(caracterCriacao);
    }

    public boolean salaExiste(int l, int c){
        // Considerando que as salas vao de 0 a 3, e nao de 1 a 4
        if(l < 4 && c < 4)
            return true;
        return false;
    }
}
