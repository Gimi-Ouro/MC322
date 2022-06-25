package invasaoAoRio.View.Janela;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import invasaoAoRio.GameStart.IGameStart;
import invasaoAoRio.Model.Mapa.IMapa;
import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.View.Imagem;

public class JanelaPadrao extends JFrame implements IJanelaPadrao {
    private static final long serialVersionUID = -3425706929777799523L;
    
	public static String DIRETORIO = System.getProperty("user.dir") + "/invasaoAoRio/src/invasaoAoRio/assets/";
    private Container contentPane;
    private JButton bTanque1;
    private JButton bTanque2;
    private JButton bTanque3;
    private IGameStart gamestart;
    private Imagem tanqueGerado;
    private ArrayList<Imagem> tanquesPosicionados;
    private ArrayList<Imagem> navios;
    private Imagem[][] bordasVerdes;
    private Imagem[][] bordasVermelhas;

    private IMapa mapa;
    
    public JanelaPadrao(){
        super();
        setSize(1408, 760);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tanqueGerado = null;
        tanquesPosicionados = new ArrayList<>();
    }
    @Override
    public void conectaGame(IGameStart gamestart) {
    	this.gamestart = gamestart;
    }

    @Override
    public void conecta(IMapa mapa) { this.mapa = mapa; }
    @Override
    public String getDIRETORIO(){ return DIRETORIO; }

    public void configuraJanela(){
        this.contentPane = this.getContentPane();
        contentPane.setLayout(null);
        this.bTanque1 = new JButton();
        this.bTanque2 = new JButton();
        this.bTanque3 = new JButton();
        contentPane.add(bTanque1);
        contentPane.add(bTanque2);
        contentPane.add(bTanque3);
        bTanque1.setBounds(5, 5, 120,70);
        bTanque2.setBounds(130, 5, 120,70);
        bTanque3.setBounds(255, 5, 120,70);
        bTanque1.setIcon(new ImageIcon(DIRETORIO + "tanqueverde.png"));
        bTanque2.setIcon(new ImageIcon(DIRETORIO + "tanqueazul.png"));
        bTanque3.setIcon(new ImageIcon(DIRETORIO + "tanquecinza.png"));
        this.bordasVerdes = new Imagem[6][3];
        this.bordasVermelhas = new Imagem[6][3];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                bordasVerdes[i][j] = new Imagem(DIRETORIO + "bordaverde.png");
                bordasVermelhas[i][j] = new Imagem(DIRETORIO + "bordavermelha.png");
                bordasVerdes[i][j].setBounds(j*88 + 32, i*107 + 85, 88, 107);
                bordasVermelhas[i][j].setBounds(j*88 + 32, i*107 + 85, 88, 107);
                contentPane.add(bordasVerdes[i][j]);
                contentPane.add(bordasVermelhas[i][j]);
                contentPane.setComponentZOrder(bordasVermelhas[i][j], 1);
                contentPane.setComponentZOrder(bordasVerdes[i][j], 1);
                bordasVerdes[i][j].setVisible(false);
                bordasVermelhas[i][j].setVisible(false);
            }
        }
        
        bTanque1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                apertouBotao(1, (JButton) e.getSource());
            }
        });
        bTanque2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	apertouBotao(2, (JButton) e.getSource());
            }
        });
        bTanque3.addActionListener(new ActionListener(){
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
            tanquesPosicionados.add(tanqueGerado);
    		this.contentPane.setComponentZOrder(tanqueGerado, 1);
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    if(!posicaoVazia(i, j)) bordasVermelhas[i][j].setVisible(true);
                    else bordasVerdes[i][j].setVisible(true);
                }
            }
    		SwingUtilities.updateComponentTreeUI(this);
    	}else {
    		//falar que não tem créditos suficientes para fazer a compra
    	}
    }
    public void removerTanque(Tanque tanque){
        for(Imagem itanque: tanquesPosicionados){
            if(itanque.getL() == tanque.getL() && itanque.getC() == tanque.getC()){
                contentPane.remove(itanque);
                tanquesPosicionados.remove(itanque);
            }
        }
    }
    public boolean posicaoVazia(int l, int c){
        return mapa.getMapa()[l][c].isVazia();
    }

    public void alteraVisibilidadeBordas(boolean estado){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                bordasVermelhas[i][j].setVisible(estado);
                bordasVerdes[i][j].setVisible(estado);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    	this.contentPane.setComponentZOrder(tanqueGerado, 1);
    	tanqueGerado.setLocation(e.getX()-50, e.getY()-63);
        if(e.getX() < 270 && e.getX() > 40 && e.getY() > 145 && e.getY() < 720) {
            tanqueGerado.transformaParaLC(tanqueGerado.getX(), tanqueGerado.getY());
        }
    }
	@Override
	public void mouseClicked(MouseEvent e) {
        if(e.getX() < 270 && e.getX() > 40 && e.getY() > 145 && e.getY() < 720){
        	if(gamestart.addTanque(e.getX(), e.getY())) {        		
        		removeMouseMotionListener(this);
        		removeMouseListener(this);
                alteraVisibilidadeBordas(false);
        	}
        }
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
	public void moverBarco(Barco barco, int destinoL, int destinoC) {
		
	}
	@Override
	public void addBarco(Imagem barcoGerado) {
		contentPane.add(barcoGerado);
		barcoGerado.setBounds(barcoGerado.getL() + 500, barcoGerado.getC() + 500, 60, 30);
        navios.add(barcoGerado);
		this.contentPane.setComponentZOrder(barcoGerado, 5);
		contentPane.add(tanqueGerado);
		tanqueGerado.setBounds(barcoGerado.getL(), barcoGerado.getC(), 25, 16);
        navios.add(tanqueGerado);
		this.contentPane.setComponentZOrder(tanqueGerado, 1);
	}
	@Override
	public void removerBarco(Barco barco) {
		// TODO Auto-generated method stub
		
	}


}
