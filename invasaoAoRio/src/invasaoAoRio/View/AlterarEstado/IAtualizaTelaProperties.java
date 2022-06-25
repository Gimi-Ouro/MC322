package invasaoAoRio.View.AlterarEstado;

import invasaoAoRio.Model.Barco;
import invasaoAoRio.Model.Tanque;

public interface IAtualizaTelaProperties {
	public void removerTanque(Tanque tanque);
	public void adicionarBarco(Barco barco);
	public void moverBarco(Barco barco, int l, int c);
}
