package pt.c40task.l05wumpus;

public class Sala {
    private Componente conteudoSala[];
    /* vetor de 4 posições, componentes inseridos em ordem de visibilidade.
               posição zero: Wumpus, Buraco ou Ouro.
               posicão dois: Herói.
               posição três: Fedor.
               posição quatro: Brisa.
       Quando não tem nada na posição é declarado um null.
     */
    private boolean vazia;

    Sala(boolean vazia) {
        this.vazia = vazia;
        for (int i = 0; i < 4; i++)
            conteudoSala[i] = null;
    }

    public void criar(char caracterCriacao) {
        if (caracterCriacao == 'P') {
            conteudoSala[1] = new Heroi();
        }else if (caracterCriacao == 'W') {
            conteudoSala[0] = new Wumpus();
        }else if (caracterCriacao == 'O') {
            conteudoSala[0] = new Ouro();
        }else if (caracterCriacao == 'B') {
            conteudoSala[0] = new Buraco();
        }else if (caracterCriacao == 'b') {
            conteudoSala[3] = new Brisa();
        }else if (caracterCriacao == 'f') {
            conteudoSala[2] = new Fedor();
        }
    }

    public char componenteDoTopo() {
        for (int i = 0; i < 4; i++) {
            if (conteudoSala[i] != null) {
                return conteudoSala[i].getCaracter();
            }
        }
        return '#';
    }

    public int getTamanho() {
        return conteudoSala.length;
    }
}