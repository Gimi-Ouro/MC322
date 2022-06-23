package invasaoAoRio;

public class Tela implements IConector{
	private Mapa mapa;
	private Loja loja;
	private int creditos;
	
	public Tela() {
		this.creditos = 0;
	}
	
	public void conectaMapa(Mapa mapa) {
		this.mapa = mapa;
	}
}
