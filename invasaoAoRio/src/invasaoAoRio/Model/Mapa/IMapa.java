package invasaoAoRio.Model.Mapa;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Tiro;
import invasaoAoRio.Model.ICelula;

public interface IMapa {
	public boolean addTanque(Tanque tanque);
	public ICelula[][] getMapa();
	public void addBarco(Barco barco);
	public void removerElemento(int l, int c);
	public void movimentarBarco(int origemL, int origemC, int destinoL, int destinoC);
	public boolean moverTiro(int origemL, int origemC, int destinoL, int destinoC);
	public void addTiro(Tiro tiro);
	public void removerTanque(Tanque tanque);
	public void removerBarco(Barco barco);
}
