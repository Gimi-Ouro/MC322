package invasaoAoRio.GameStart;

import invasaoAoRio.Model.Mapa.IMapa;
import invasaoAoRio.View.AlterarEstado.IAtualizaTela;

public interface IGameStartProperties {
	public void iniciarJogo(IMapa mapa, IAtualizaTela atualizaTela);
	public boolean addTanque(int x, int y);
	public boolean comprarTanque(int i);
	public void acabarJogo();
	public void start();
}
