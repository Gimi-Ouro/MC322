package invasaoAoRio.View.AlterarEstado;

import invasaoAoRio.Model.Tanque;
import invasaoAoRio.View.Janela.IJanelaPadrao;

public class AtualizaTela {
	private IJanelaPadrao janela;
	
	public void connect(IJanelaPadrao janela) {
		this.janela = janela;
	}
	
	public void removerTanque(Tanque tanque) {
		janela.removerTanque(tanque);
	}
}
