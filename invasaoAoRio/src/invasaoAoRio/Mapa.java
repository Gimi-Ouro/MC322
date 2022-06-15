package invasaoAoRio;

public class Mapa {
    private ICelula[][] mapa;

    public Mapa(){
        mapa = new ICelula[6][16];
        for(int i = 0; i < mapa.length; i++){
            for(int j = 0; j < mapa[i].length; j++){
                if(j == 0) mapa[i][j] = new Terra();
                else mapa[i][j] = new Agua();
            }
        }
    }

    public void addColunaTerra(){
        int flag = 0;
        for(int i = 1; i < mapa[0].length; i++){
            if(mapa[0][i-1].isTerra() && mapa[0][i].isAgua() && flag == 0){
                for(int j = 0; j < mapa.length; j++){
                    //não sei se precisaria limpar essas posições antes de dar new Terra, porque elas já eram Agua
                    mapa[j][i] = new Terra();
                }
                flag = 1;
            }
        }
    }
    public void addEquipamento(int x, int y, Equipamento equipamento){
        if(mapa[x][y].isTerra()) mapa[x][y].addEquipamento(equipamento);
    }

    public void addBarco(int x, int y, Barco barco){
        if(mapa[x][y].isAgua()) mapa[x][y].addBarco(barco);
    }

}
