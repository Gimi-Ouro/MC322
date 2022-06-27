package invasaoAoRio.Controller.Loja;

import invasaoAoRio.Model.Mapa.IMapa;
import invasaoAoRio.Model.Tanque;

public interface Iloja {
	public Tanque compraCanhao(int produto);
	public int getCreditos();
	public void navioAbatido(int tipo);

}
