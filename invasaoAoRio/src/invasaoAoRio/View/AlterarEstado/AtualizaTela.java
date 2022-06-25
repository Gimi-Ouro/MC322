package invasaoAoRio.View.AlterarEstado;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.View.Imagem;
import invasaoAoRio.View.Janela.IJanelaPadrao;

public class AtualizaTela implements IAtualizaTela{
	private IJanelaPadrao janela;
	
	public void connect(IJanelaPadrao janela) {
		this.janela = janela;
	}
	
	public void removerTanque(Tanque tanque) {
		janela.removerTanque(tanque);
	}

	@Override
	public void adicionarBarco(Barco barco) {
		Imagem barcoGerado = null;
		if (barco.getTipo() == 0) {
			barcoGerado = new Imagem(janela. + "navioverde.png");
		}
	}
	
	
	
}
