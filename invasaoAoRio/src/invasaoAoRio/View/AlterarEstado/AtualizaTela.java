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
		barcoGerado.setId(barco.getId());
		//deve adicionar a imagem gerada do barco no contentPane
		janela.addBarco(barcoGerado);
	}
	
	
	public void moverBarco(Barco barco, int destinoL, int destinoC) {
		//deve achar a imagem do barco de deslocar ela até o destino
		janela.moverBarco(barco, destinoL, destinoC);
	}
	
	public void removerBarco(Barco barco) throws InterruptedException {
		janela.removerBarco(barco);
	}

	@Override
	public void addTiro(Tiro tiro) {
		Imagem itiro = new Imagem(janela.getDIRETORIO() + "tank_bullet4.png");
		itiro.setL(tiro.getl());
		itiro.setC(tiro.getc());
		itiro.setId(tiro.getid());
		janela.addTiro(itiro);
	}

	@Override
	public void removerTiro(Tiro tiro) {
		janela.removerTiro(tiro);
	}

	@Override
	public void moverTiro(Tiro tiro) {
		janela.moverTiro(tiro);
	}

	@Override
	public void acabarJogo(int flag) {
		janela.acabarJogo(flag);
	}

	public void trocaImagemOnda(int ondaAnterior, int novaOnda){
		janela.trocaImagemOnda(ondaAnterior, novaOnda);
	}

	public void atualizaCreditos(int nCreditos){
		janela.atualizaCreditos(nCreditos);
	}
	
}
