package pt.c40task.l05wumpus;

public class Sala {
	private Componente conteudoSala[];
	/* vetor de 4 posições, componentes inseridos em ordem de visibilidade.
	   		posição zero: Wumpus, Buraco ou Ouro.
	   		posicão um: Herói.
	   		posição dois: Fedor.
	   		posição três: Brisa.
	   Quando não tem nada na posição é declarado um null.
	 */	
	private boolean vazia, visitada = false;
	
	Sala(boolean vazia) {
		this.vazia = vazia;
		this.conteudoSala = new Componente[4];
 		for (int i = 0; i < 4; i++)
			conteudoSala[i] = null;
	}
	
	public Componente getHeroi() { return conteudoSala[1]; }
	
	public void addHeroi(Componente heroi) { 
		if (this.conteudoSala[0] != null && this.conteudoSala[0].getCaracter() != 'O') {
			heroi.setVida(false);
		}
		this.conteudoSala[1] = heroi; 
		
	}
	
	public void removerHeroi() { this.addHeroi(null); }
	
	public boolean temHeroi() {
		if (this.conteudoSala[1] != null && this.conteudoSala[1].getVida()) {
			return true;
		}
		return false;
	}
	
	public boolean temFedor() {
		if (this.conteudoSala[2] != null) {
			return true;
		}
		return false;
	}
	
	public boolean temBrisa() {
		if (this.conteudoSala[3] != null) {
			return true;
		}
		return false;
	}
	
	public boolean estaVazia() {
		return vazia;
	}
	
	public void visitar() {
		this.visitada = true;
	}
	
	public boolean getVisitada() {
		return this.visitada;
	}
	
	public void add(Componente componente) {
		if (componente.getCaracter() == 'P')
			conteudoSala[1] = componente;
	}
	
	public char componenteDoTopo() {
		for (int i = 0; i < 4; i++) {
			if (conteudoSala[i] != null && this.visitada) {
				return conteudoSala[i].getCaracter();
			}else if (this.visitada) {
				return '#';
			}	
		}
		return '_';
	}
	
	public int getTamanho() {
		return conteudoSala.length;
	}
}
