package invasaoAoRio.View;

import javax.swing.*;
import java.awt.*;

public class Imagem extends JLabel {

    
    private static final long serialVersionUID = -5038526701167212347L;
    private int tipo;
    private int l;
    private int c;

	public Imagem(String arquivoImagem){
        super(new ImageIcon(arquivoImagem));
    }

    public int getL(){
        return this.l;
    }
    public int getC(){
        return this.c;
    }
    public void setL(int l){
        this.l = l;
    }
    public void setC(int c){
        this.c = c;
    }

    public void transformaParaLC(int x, int y){
        l = (int) (y-112)/106;
        c = (int) x/88;
    }
}
