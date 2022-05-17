package pt.c40task.l05wumpus;

public class Wumpus extends Componente{
	Wumpus (int l, int c) {
		super('W', l, c);
	}
	
	public void instanciarSecundarios() {
		if(caverna.salaExiste(l - 1, c)) 
	    	this.caverna.addComponente(new Fedor(l - 1, c));
	    if(caverna.salaExiste(l + 1, c)) 
	    	caverna.addComponente(new Fedor(l+1, c));
	    if(caverna.salaExiste(l, c - 1)) 
	    	caverna.addComponente(new Fedor(l, c-1));
	    if(caverna.salaExiste(l, c + 1)) 
	    	caverna.addComponente(new Fedor(l, c+1));
	}
}
