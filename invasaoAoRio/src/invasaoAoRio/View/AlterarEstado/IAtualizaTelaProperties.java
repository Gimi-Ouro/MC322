package invasaoAoRio.View.AlterarEstado;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;
import invasaoAoRio.Model.Tiro;

public interface IAtualizaTelaProperties {
	public void removerTanque(Tanque tanque);
	public void adicionarBarco(Barco barco);
	public void moverBarco(Barco barco, int l, int c);
	public void removerBarco(Barco barco);
	public void addTiro(Tiro tiro);
	public void removerTiro(Tiro tiro);
	public void moverTiro(Tiro tiro);
	public void acabarJogo();
}
