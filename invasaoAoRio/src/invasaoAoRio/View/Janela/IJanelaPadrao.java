package invasaoAoRio.View.Janela;

import javax.swing.event.MouseInputListener;

import invasaoAoRio.Model.Tanque;
import invasaoAoRio.View.IRGameStart;

public interface IJanelaPadrao extends IRGameStart, MouseInputListener{
    public void removerTanque(Tanque tanque);
    public String getDIRETORIO();
}
