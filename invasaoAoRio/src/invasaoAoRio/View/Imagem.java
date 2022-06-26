package invasaoAoRio.View;

import javax.swing.*;
import java.awt.*;

public class Imagem extends JLabel {

    
    private static final long serialVersionUID = -5038526701167212347L;
    private int l;
    private int c;
    private int id;

	public Imagem(String arquivoImagem){
        super(new ImageIcon(arquivoImagem));
    }

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
        l = (y-69) /106;
        c = x/88;
    }
}
