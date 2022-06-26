package invasaoAoRio.View.Janela;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

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
    private JButton bStart;
    private JTextField textoStart;
    private JTextField textoEnd;
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
        navios = new ArrayList<>();
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
        this.bStart = new JButton();
        this.textoStart = new JTextField();
        this.textoEnd = new JTextField();
        contentPane.add(bTanque1);
        contentPane.add(bTanque2);
        contentPane.add(bTanque3);
        contentPane.add(bStart);
        contentPane.add(textoStart);
        contentPane.add(textoEnd);
        textoStart.setText("APERTE PARA INICIAR");
        textoEnd.setText("VOCE PERDEU");
        textoStart.setBounds(1255, 60, 135, 25);
        textoEnd.setBounds(730,355, 100, 25);
        textoEnd.setVisible(false);
        bTanque1.setBounds(5, 5, 120,70);
        bTanque2.setBounds(130, 5, 120,70);
        bTanque3.setBounds(255, 5, 120,70);
        bStart.setBounds(1300, 5, 48, 48);
        bTanque1.setIcon(new ImageIcon(DIRETORIO + "tanqueverde.png"));
        bTanque2.setIcon(new ImageIcon(DIRETORIO + "tanqueazul.png"));
        bTanque3.setIcon(new ImageIcon(DIRETORIO + "tanquecinza.png"));
        bStart.setIcon(new ImageIcon(DIRETORIO + "botao_start.png"));
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
        
        bStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              teste();
            }
        });

        Imagem mapa = new Imagem(DIRETORIO + "mapa_.png");
        this.add(mapa);
        mapa.setBounds(0, 85, 1408, 640);

        this.setVisible(true);
    }

    public void teste() {
    	gamestart.start();
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
    		tanqueGerado.setBounds(botao.getX(), botao.getY(), 92, 69);
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
    	tanqueGerado.setLocation(e.getX() - 44/2, e.getY() - 69);
        if(e.getX() < 296 && e.getX() > 32 && e.getY() > 85 && e.getY() < 727) {
            tanqueGerado.transformaParaLC(tanqueGerado.getX(), tanqueGerado.getY());
            tanqueGerado.setLocation(32 + tanqueGerado.getC()*88, 110 + tanqueGerado.getL()*107);
        }
    }
	@Override
	public void mouseClicked(MouseEvent e) {
        if(e.getX() < 296 && e.getX() > 32 && e.getY() > 85 && e.getY() < 727){
        	if(gamestart.addTanque(tanqueGerado.getX(), tanqueGerado.getY())) {
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
		Imagem barco1 = null;
		for(Imagem iBarco: navios){
            if(iBarco.getId() == barco.getId()){
            	barco1 = iBarco;
            	if (barco1.getX() - 120 > 260)
            		barco1.setLocation(barco1.getX() - 120, barco1.getY());
            	break;
            }
        }
	}
	@Override
	public void addBarco(Imagem barcoGerado) {
		contentPane.add(barcoGerado);
		barcoGerado.setBounds(1408-120, barcoGerado.getL()*100 + 112, 113, 65);
        navios.add(barcoGerado);
        contentPane.setComponentZOrder(barcoGerado, 1);
        SwingUtilities.updateComponentTreeUI(this);
	}
	@Override
	public void removerBarco(Barco barco) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void acabarJogo(Imagem mensagem) {
		contentPane.add(mensagem);
		gamestart.acabarJogo();
	}


}
