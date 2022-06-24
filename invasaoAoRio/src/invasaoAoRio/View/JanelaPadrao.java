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
import invasaoAoRio.GameStart.IGameStart;

public class JanelaPadrao extends JFrame implements IJanelaPadrao {
    private static final long serialVersionUID = -3425706929777799523L;
    
	public static String DIRETORIO = System.getProperty("user.dir") + "/invasaoAoRio/src/invasaoAoRio/assets/";
    private Container contentPane;
    private JButton bCanhao1;
    private JButton bCanhao2;
    private JButton bCanhao3;
    private IGameStart gamestart;
    private Imagem tanqueGerado;
    
    public JanelaPadrao(){
        super();
        setSize(1408, 760);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tanqueGerado = null;
    }
    public void conectaGame(IGameStart gamestart) {
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
                apertouBotao(1, (JButton) e.getSource());
            }
        });
        bCanhao2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	apertouBotao(2, (JButton) e.getSource());
            }
        });
        bCanhao3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	apertouBotao(3, (JButton) e.getSource());
            }
        });

        Imagem mapa = new Imagem(DIRETORIO + "mapa_.png");
        this.add(mapa);
        mapa.setBounds(0, 85, 1408, 640);

        this.setVisible(true);
    }

    public void apertouBotao(int numeroBotao, JButton botao){
    	if (gamestart.comprarTanque(numeroBotao)) {
    		addMouseMotionListener(this);
    		addMouseListener(this);
    		if(numeroBotao == 1) { 
    			tanqueGerado = new Imagem(DIRETORIO + "tanqueverde.png");
    		}
    		else if(numeroBotao == 2) { 
    			tanqueGerado = new Imagem(DIRETORIO + "tanqueazul.png");
    		}
    		else if(numeroBotao == 3) { 
    			tanqueGerado = new Imagem(DIRETORIO + "tanquecinza.png");
    		}
    		contentPane.add(tanqueGerado);
    		tanqueGerado.setBounds(botao.getX(), botao.getY(), 113, 66);
    		this.contentPane.setComponentZOrder(tanqueGerado, 1);
    		SwingUtilities.updateComponentTreeUI(this);
    	}else {
    		//falar que não tem créditos suficientes para fazer a compra
    	}
    }
	@Override
	public void mouseClicked(MouseEvent e) {
        if(e.getX() < 270 && e.getX() > 40 && e.getY() > 145 && e.getY() < 720){
			System.out.println("click: " + e.getX() + ", " + e.getY());
        	if(gamestart.addTanque(e.getX(), e.getY())) {        		
        		removeMouseMotionListener(this);
        		removeMouseListener(this);
        	}else {
        		//falar que não da para colocar o tanque em cima do outro
        		//(deixar vermelho a "celula" (área que representa a celula))
        	}
        }

	}
	@Override
	public void mouseMoved(MouseEvent e) {
		this.contentPane.setComponentZOrder(tanqueGerado, 1);
		tanqueGerado.setLocation(e.getX()-50, e.getY()-63);
		System.out.println("x: " + e.getX() + " y: " + e.getY());
		
	}
	
	//////não utilizado por enquanto
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
}
