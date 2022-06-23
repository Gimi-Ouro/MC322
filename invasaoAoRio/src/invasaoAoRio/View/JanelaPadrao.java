package invasaoAoRio.View;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.MouseInputListener;

import invasaoAoRio.GameStart.GameStart;

public class JanelaPadrao extends JFrame implements IJanelaPadrao, MouseInputListener {
    private static final long serialVersionUID = -3425706929777799523L;
    
	public static String DIRETORIO = System.getProperty("user.dir") + "/invasaoAoRio/src/invasaoAoRio/assets/";
    private Container contentPane;
    private JButton bCanhao1;
    private JButton bCanhao2;
    private JButton bCanhao3;
    private GameStart gamestart;
    private Imagem tanqueGerado;
    
    public JanelaPadrao(){
        super();
        setSize(1408, 760);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tanqueGerado = null;
    }
    public void conectaGame(GameStart gamestart) {
    	this.gamestart = gamestart;
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
        this.contentPane.setComponentZOrder(mapa, 0);
        mapa.setBounds(0, 85, 1408, 640);

        this.setVisible(true);
    }

    public void apertouBotao(int numeroBotao){
        addMouseMotionListener(this);
        addMouseListener(this);
        if(numeroBotao == 1) { 
        	tanqueGerado = new Imagem(DIRETORIO + "tanqueverde.png");
        	contentPane.add(tanqueGerado);
        	tanqueGerado.setBounds(5, 5, 113, 66);
        }
        else if(numeroBotao == 2) { 
        	tanqueGerado = new Imagem(DIRETORIO + "tanqueazul.png");
        	contentPane.add(tanqueGerado);
        }
        else if(numeroBotao == 3) { 
        	tanqueGerado = new Imagem(DIRETORIO + "tanquecinza.png");
        	contentPane.add(tanqueGerado);
        }

        
        this.contentPane.setComponentZOrder(tanqueGerado, 1);
        if(tanqueGerado != null) 
        	
        SwingUtilities.updateComponentTreeUI(this);
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click: " + e.getX() + ", " + e.getY());
		removeMouseMotionListener(this);
	}
	@Override
	public void mousePressed(MouseEvent e) {
			
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		this.contentPane.setComponentZOrder(tanqueGerado, 1);
		tanqueGerado.setLocation(e.getX()-56, e.getY()-33);
		
	}
}
