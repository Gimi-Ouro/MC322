package invasaoAoRio.View;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Imagem extends JLabel {

    
    private static final long serialVersionUID = -5038526701167212347L;
    private int l;
    private int c;
    private int id;

	public Imagem(URL url){
        super(new ImageIcon(url));
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
        l = (y-107/2)/107;
        c = x/88;
    }
}
