package invasaoAoRio.View.AlterarEstado;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Tiro;
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
			barcoGerado = new Imagem(janela.getDIRETORIO() + "navioverde.png");
		}else if (barco.getTipo() == 1) {
			barcoGerado = new Imagem(janela.getDIRETORIO() + "naviovermelho.png");
		}else if (barco.getTipo() == 2) {
			barcoGerado = new Imagem(janela.getDIRETORIO() + "naviopreto.png");
		}
		barcoGerado.setL(barco.getl());
		barcoGerado.setC(barco.getc());
		//deve adicionar a imagem gerada do barco no contentPane
		janela.addBarco(barcoGerado);
	}
	
	
	public void moverBarco(Barco barco, int destinoL, int destinoC) {
		//deve achar a imagem do barco de deslocar ela até o destino
		janela.moverBarco(barco, destinoL, destinoC);
	}
	
	public void removerBarco(Barco barco) {
		janela.removerBarco(barco);
	}

	@Override
	public void addTiro(Tiro tiro) {
		Imagem tiro = new Imagem(janela.getDIRETORIO() + "ntiro.png");
		tiro.setL(tiro.getL());
		tiro.setC(tiro.getC());
		janela.addTiro(tiro);
	}

	@Override
	public void removerTiro(Tiro tiro) {
		janela.removerTiro(tiro);
	}

	@Override
	public void moverTiro(Tiro tiro, int l, int c) {
		janela.moverTiro(tiro, l, c);
	}
	
}
