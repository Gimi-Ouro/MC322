package pt.c40task.l05wumpus;

public class Buraco extends Componente{
	Buraco(int l, int c) {
		super('B', l, c);
	}
	
	public void instanciarSecundarios() {
		if(caverna.salaExiste(l - 1, c)) 
	    	this.caverna.addComponente(new Brisa(l - 1, c));
	    if(caverna.salaExiste(l + 1, c)) 
	    	caverna.addComponente(new Brisa(l+1, c));
	    if(caverna.salaExiste(l, c - 1)) 
	    	caverna.addComponente(new Brisa(l, c-1));
	    if(caverna.salaExiste(l, c + 1)) 
	    	caverna.addComponente(new Brisa(l, c+1));
	}
}
