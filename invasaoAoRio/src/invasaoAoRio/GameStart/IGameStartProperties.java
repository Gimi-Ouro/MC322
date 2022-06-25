package invasaoAoRio.GameStart;

import invasaoAoRio.Model.Mapa.IMapa;

public interface IGameStartProperties {
	public void iniciarJogo(IMapa mapa);
	public boolean addTanque(int x, int y);
	public boolean comprarTanque(int i);
}
