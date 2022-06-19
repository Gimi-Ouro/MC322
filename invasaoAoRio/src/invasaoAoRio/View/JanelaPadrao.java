package invasaoAoRio.View;

import javax.swing.*;
import java.awt.*;

public class JanelaPadrao extends JFrame{
    private static final long serialVersionUID = -3425706929777799523L;
	public static String DIRETORIO = System.getProperty("user.dir") + "/invasaoAoRio/src/invasaoAoRio/assets/";
    private Container contentPane;
    private JButton bCanhao1;
    private JButton bCanhao2;
    private JButton bCanhao3;
    public JanelaPadrao(){
        super();
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void configuraJanela(){
        this.contentPane = this.getContentPane();
        contentPane.setLayout(null);
        this.bCanhao1 = new JButton("Canhao 1");
        this.bCanhao2 = new JButton("Canhao 2");
        this.bCanhao3 = new JButton("Canhao 3");
        contentPane.add(bCanhao1);
        contentPane.add(bCanhao2);
        contentPane.add(bCanhao3);
        bCanhao1.setBounds(640, 5, 120,40);
        bCanhao2.setBounds(765, 5, 120,40);
        bCanhao3.setBounds(890, 5, 120,40);

        Imagem mapa = new Imagem(DIRETORIO + "map.png");
        contentPane.add(mapa);
        mapa.setBounds(0, 45, 1280, 640);

        this.setVisible(true);
    }
}
