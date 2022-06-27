package invasaoAoRio.Model.Mapa;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Tiro;
import invasaoAoRio.Model.ICelula;

public interface IMapa extends IRLoja, IRAtualizaTela{
	public boolean addTanque(Tanque tanque);
	public ICelula[][] getMapa();
	public void addBarco(Barco barco);
	public void removerElemento(int l, int c);
	public void movimentarBarco(int origemL, int origemC, int destinoL, int destinoC) throws InterruptedException;
	public boolean moverTiro(Tiro tiro) throws InterruptedException;
	public void addTiro(Tiro tiro, boolean addNaTela);
	public void removerTanque(Tanque tanque);
	public void removerBarco(Barco barco) throws InterruptedException;
}
