package pt.c40task.l05wumpus;

public class Caverna {
    private Sala[][] vSalas;

    public Caverna(){
        this.vSalas = new Sala[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                this.vSalas[i][j] = new Sala(true);
            }
        }
    }

    public void addComponente(int l, int c, char caracterCriacao){
        this.vSalas[l][c].criar(caracterCriacao);
    }

    public boolean salaExiste(int l, int c){
        // Considerando que as salas vao de 0 a 3, e não de 1 a 4.
        if(l < 4 && c < 4)
            return true;
        return false;
    }

    public char[][] toMatriz(){
        char[][] mChar = new char[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                mChar[i][j] = vSalas[i][j].componenteDoTopo();
            }
        }
        return mChar;
    }

    public void imprime(){
        for (int l = 0; l < vSalas.length; l++) {
            for (int c = 0; c < vSalas[l].length; c++)
                System.out.print(vSalas[l][c].componenteDoTopo() + ((c < vSalas[l].length-1) ? ", " : ""));
            System.out.println();
        }
    }
}
