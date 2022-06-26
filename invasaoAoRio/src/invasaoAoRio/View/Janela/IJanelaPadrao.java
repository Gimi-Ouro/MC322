package invasaoAoRio.View.Janela;

import javax.swing.event.MouseInputListener;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Tiro;
import invasaoAoRio.View.IRGameStart;
import invasaoAoRio.View.Imagem;

public interface IJanelaPadrao extends IRGameStart, MouseInputListener, IRMapa{
    public void removerTanque(Tanque tanque);
    public String getDIRETORIO();
	public void moverBarco(Barco barco, int destinoL, int destinoC);
	public void addBarco(Imagem barcoGerado);
	public void removerBarco(Barco barco);
	public void acabarJogo(Imagem mensagem);
	public void addTiro(Imagem itiro);
	public void moverTiro(Tiro tiro);
	public void removerTiro(Tiro tiro);
}
