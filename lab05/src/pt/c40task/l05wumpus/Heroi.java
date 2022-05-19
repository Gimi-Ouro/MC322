package pt.c40task.l05wumpus;

public class Heroi extends Componente{
	Heroi (int l, int c, Caverna caverna) {
		super('P', l, c, caverna);
		this.artefato = true;
	}
	
	private Caverna caverna;
	
	private int qtdFlexas = 1;
	
	public int getQtdFlexas() { return this.qtdFlexas; };
	
	public void mover(char mov, int l, int c) {
		caverna.movimentar(mov, l, c);
	}
}
