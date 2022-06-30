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
import invasaoAoRio.Model.Tiro;
import invasaoAoRio.View.Imagem;

public class JanelaPadrao extends JFrame implements IJanelaPadrao {
    private static final long serialVersionUID = -3425706929777799523L;
    
	//public static String getClass().getClassLoader().getResource = System.getProperty("user.dir") + "/invasaoAoRio/src/invasaoAoRio/assets/";
    private Container contentPane;
    private JButton bTanque1;
    private JButton bTanque2;
    private JButton bTanque3;
    private JButton bStart;
    private JTextField textoStart;
    private JTextField textoEnd;
    private IGameStart gamestart;
    private Imagem tanqueGerado;
    private Imagem explosao;
    private Imagem[] ondas;
    private ArrayList<Imagem> tanques;
    private ArrayList<Imagem> navios;

    private ArrayList<Imagem> tiros;
    private Imagem[][] bordasVerdes;
    private Imagem[][] bordasVermelhas;
    private Imagem creditos;
    private JTextField textoCreditos;
    private Imagem voceganhou;
    private Imagem voceperdeu;

    private IMapa mapa;
    
    public JanelaPadrao(){
        super();
        setSize(1408, 760);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tanqueGerado = null;
        tanques = new ArrayList<>();
        navios = new ArrayList<>();
        tiros = new ArrayList<>();
    }
    @Override
    public void conectaGame(IGameStart gamestart) {
    	this.gamestart = gamestart;
    }

    @Override
    public void conecta(IMapa mapa) { this.mapa = mapa; }
    //public String getgetClass().getClassLoader().getResource(){ return getClass().getClassLoader().getResource; }
    
    public void configuraJanela(){
        this.contentPane = this.getContentPane();
        contentPane.setLayout(null);
        configuraBotoes();
        configuraTexto();
        explosao = new Imagem(getClass().getClassLoader().getResource("explosion2.png"));
        contentPane.add(explosao);
        explosao.setBounds(0, 0, 60, 59);
        explosao.setVisible(false);
        configuraBordas();
        configuraHUD();
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
              eventoStart();
            }
        });

        Imagem mapa = new Imagem(getClass().getClassLoader().getResource("mapa_.png"));
        this.add(mapa);
        mapa.setBounds(0, 85, 1408, 640);

        this.setVisible(true);
    }
    
    public void configuraBotoes(){
        this.bTanque1 = new JButton();
        this.bTanque2 = new JButton();
        this.bTanque3 = new JButton();
        this.bStart = new JButton();
        contentPane.add(bTanque1);
        contentPane.add(bTanque2);
        contentPane.add(bTanque3);
        contentPane.add(bStart);
        bTanque1.setBounds(5, 5, 120,70);
        bTanque2.setBounds(130, 5, 120,70);
        bTanque3.setBounds(255, 5, 120,70);
        bStart.setBounds(1300, 5, 48, 48);
        bTanque1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("tanqueverde.png")));
        bTanque2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("tanqueazul.png")));
        bTanque3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("tanquecinza.png")));
        bStart.setIcon(new ImageIcon(getClass().getClassLoader().getResource("botao_start.png")));
    }
    
    public void configuraTexto(){
        this.textoStart = new JTextField();
        this.textoEnd = new JTextField();
        this.textoCreditos = new JTextField();
        contentPane.add(textoCreditos);
        contentPane.add(textoStart);
        contentPane.add(textoEnd);
        textoStart.setText("APERTE PARA INICIAR");
        textoEnd.setText("VOCE PERDEU");
        textoStart.setBounds(1255, 60, 135, 25);
        textoEnd.setBounds(730,355, 100, 25);
        textoCreditos.setBounds(665, 22, 60, 44);
        textoEnd.setVisible(false);
    }
    
    public void configuraBordas(){
        this.bordasVerdes = new Imagem[6][3];
        this.bordasVermelhas = new Imagem[6][3];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                bordasVerdes[i][j] = new Imagem(getClass().getClassLoader().getResource("bordaverde.png"));
                bordasVermelhas[i][j] = new Imagem(getClass().getClassLoader().getResource("bordavermelha.png"));
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
    }

    public void configuraHUD(){
        ondas = new Imagem[10];
        for(int i = 0; i < 10; i++){
            ondas[i] = new Imagem(getClass().getClassLoader().getResource("onda" + String.valueOf(i+1) + ".png"));
            ondas[i].setBounds(900, 15, 164, 44);
            contentPane.add(ondas[i]);
            ondas[i].setVisible(false);
            contentPane.setComponentZOrder(ondas[i], 1);
        }
        voceganhou = new Imagem(getClass().getClassLoader().getResource("voceganhou.png"));
        voceperdeu = new Imagem(getClass().getClassLoader().getResource("voceperdeu.png"));
        creditos = new Imagem(getClass().getClassLoader().getResource("creditos_texto.png"));
        voceganhou.setBounds(365, 338, 678, 84);
        voceperdeu.setBounds(380, 338, 678, 84);
        creditos.setBounds(500, 15, 154, 44);
        contentPane.add(creditos);
        contentPane.add(voceganhou);
        contentPane.add(voceperdeu);
        contentPane.setComponentZOrder(creditos, 1);
        contentPane.setComponentZOrder(voceperdeu, 2);
        contentPane.setComponentZOrder(voceganhou, 2);
        voceperdeu.setVisible(false);
        voceganhou.setVisible(false);
    }
    public void eventoStart() {
    	new Thread() {
    	    @Override
    	    public void run() {
    	    	gamestart.start();    	      
    	    }
    	  }.start();
    }
    
    public void apertouBotao(int numeroBotao, JButton botao){
    	if (gamestart.comprarTanque(numeroBotao)) {
    		addMouseMotionListener(this);
    		addMouseListener(this);
    		if(numeroBotao == 1) { 
    			tanqueGerado = new Imagem(getClass().getClassLoader().getResource("tanqueverde.png"));
    		}
    		else if(numeroBotao == 2) { 
    			tanqueGerado = new Imagem(getClass().getClassLoader().getResource("tanqueazul.png"));
    		}
    		else if(numeroBotao == 3) { 
    			tanqueGerado = new Imagem(getClass().getClassLoader().getResource("tanquecinza.png"));
    		}
    		contentPane.add(tanqueGerado);
    		tanqueGerado.setBounds(botao.getX(), botao.getY(), 92, 69);
            tanques.add(tanqueGerado);
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
        for(Imagem itanque: tanques){
            if(itanque.getL() == tanque.getL() && itanque.getC() == tanque.getC()){
                contentPane.remove(itanque);
                tanques.remove(itanque);
                break;
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
            try {
                if(gamestart.addTanque(tanqueGerado.getX(), tanqueGerado.getY())) {
                    removeMouseMotionListener(this);
                    removeMouseListener(this);
                    alteraVisibilidadeBordas(false);
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
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
            	if (barco1.getX() - 88 > 260)
            		barco1.setLocation(barco1.getX() - 88, barco1.getY());
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
	public void removerBarco(Barco barco) throws InterruptedException {
        if(barco != null){
            for(Imagem ibarco: navios){
                    if (ibarco.getId() == barco.getId()){
                        ibarco.setVisible(false);
                        contentPane.remove(ibarco);
                        explosao.setLocation(ibarco.getX(), ibarco.getY());
                        explosao.setVisible(true);
                        Thread.sleep(800);
                        explosao.setVisible(false);
                        navios.remove(ibarco);
                        SwingUtilities.updateComponentTreeUI(this);
                        break;
                    }
                }
        }
	}
	
	public void retirarImagens() {
		for(int i = 0; i < tiros.size(); i++) {
			contentPane.remove(tiros.get(tiros.size() - 1));
			tiros.remove(tiros.get(tiros.size() - 1));
		}
		for (int i = 0; i < tanques.size(); i++) {
			contentPane.remove(tanques.get(tanques.size() - 1));
			tanques.remove(tanques.get(tanques.size() - 1));
		}
		for (int i = 0; i < navios.size(); i++) {
			contentPane.remove(navios.get(navios.size() - 1));
			navios.remove(navios.get(navios.size() - 1));
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	
	@Override
	public void acabarJogo(int flag) {
		if(flag == 1) {
			voceganhou.setVisible(true);
		}
		else {
			voceperdeu.setVisible(true);
		}
		retirarImagens();
		gamestart.acabarJogo();

	}

    public void addTiro(Imagem itiro){
        contentPane.add(itiro);
        itiro.setBounds(32 + itiro.getC()*88, 112 + itiro.getL()*107, 38, 26);
        contentPane.setComponentZOrder(itiro, 2);
        tiros.add(itiro);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void moverTiro(Tiro tiro){
        Imagem tiro1 = null;
        for(Imagem iTiro: tiros){
            if(iTiro.getId() == tiro.getid()){
                tiro1 = iTiro;
                tiro1.setLocation(tiro1.getX() + 100, tiro1.getY());
                //SwingUtilities.updateComponentTreeUI(this);
                break;
            }
        }
    }

    public void removerTiro(Tiro tiro){
        Imagem tiro1;
        for(Imagem iTiro: tiros){
            if(iTiro.getId() == tiro.getid()) {
                tiro1 = iTiro;
                tiros.remove(tiro1);
                contentPane.remove(tiro1);
                break;
            }
        }
    }

    public void trocaImagemOnda(int ondaAnterior, int novaOnda){
        ondas[novaOnda - 1].setVisible(true);
        if(ondaAnterior > 0)
            ondas[ondaAnterior - 1].setVisible(false);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void atualizaCreditos(int nCreditos){
        textoCreditos.setText(String.valueOf(nCreditos));
        SwingUtilities.updateComponentTreeUI(this);
    }

}
