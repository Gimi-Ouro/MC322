package pt.c40task.l05wumpus;

public class Controle {
	private Caverna caverna;
	
	public boolean movimentoValido(char mov, int l, int c) {
		if (mov == 's' && c-1 <= 0) {
			return true;
		}else if (mov == 's' && c+1 <= 3) {
			return true;
		}else if (mov == 'a' && l-1 <= 0) {
			return true;
		}else if (mov == 'd' && l+1 <= 3) {
			return true;
		}else {
			return false;
		}
	}
	
	public void conecta(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public void movimentar(char mov, int l, int c) {
		if (movimentoValido(mov, l, c)) { 
			caverna.movimentar(mov, l, c); 
		}
	}
}
