package invasaoAoRio.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPadrao extends JFrame{
    private static final long serialVersionUID = -3425706929777799523L;
	public static String DIRETORIO = System.getProperty("user.dir") + "/invasaoAoRio/src/invasaoAoRio/assets/";
    private Container contentPane;
    private JButton bCanhao1;
    private JButton bCanhao2;
    private JButton bCanhao3;
    public JanelaPadrao(){
        super();
        setSize(1408, 760);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void configuraJanela(){
        this.contentPane = this.getContentPane();
        contentPane.setLayout(null);
        this.bCanhao1 = new JButton();
        this.bCanhao2 = new JButton();
        this.bCanhao3 = new JButton();
        contentPane.add(bCanhao1);
        contentPane.add(bCanhao2);
        contentPane.add(bCanhao3);
        bCanhao1.setBounds(5, 5, 120,70);
        bCanhao2.setBounds(130, 5, 120,70);
        bCanhao3.setBounds(255, 5, 120,70);
        bCanhao1.setIcon(new ImageIcon(DIRETORIO + "tanqueverde.png"));
        bCanhao2.setIcon(new ImageIcon(DIRETORIO + "tanqueazul.png"));
        bCanhao3.setIcon(new ImageIcon(DIRETORIO + "tanquecinza.png"));
        bCanhao1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                apertouBotao(1);
            }
        });
        bCanhao2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                apertouBotao(2);
            }
        });
        bCanhao3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                apertouBotao(3);
            }
        });

        Imagem mapa = new Imagem(DIRETORIO + "mapa_final3.png");
        contentPane.add(mapa);
        mapa.setBounds(0, 85, 1408, 640);

        this.setVisible(true);
    }

    public void apertouBotao(int numeroBotao){
        Imagem tanque = null;
        if(numeroBotao == 1) tanque = new Imagem(DIRETORIO + "tanqueverde.png");
        else if(numeroBotao == 2) tanque = new Imagem(DIRETORIO + "tanqueazul.png");
        else if(numeroBotao == 3) tanque = new Imagem(DIRETORIO + "tanquecinza.png");

        contentPane.add(tanque);
        if(tanque != null) tanque.setBounds(500, 5, 113, 66);
        SwingUtilities.updateComponentTreeUI(this);
    }
}
