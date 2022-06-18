package invasaoAoRio.Model.Mapa;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Canhao;
import invasaoAoRio.Model.ICelula;

public interface IMapa {
	public void addCanhao(int x, int y, Canhao canhao);
	public ICelula[][] getMapa();
	public void addBarco(int x, int y, Barco barco);
	public void removerElemento(int l, int c);
	public void movimentarBarco(int origemL, int origemC, int destinoL, int destinoC);
}
