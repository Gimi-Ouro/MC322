package invasaoAoRio.View;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class Imagem extends JLabel {

    @Serial
    private static final long serialVersionUID = -5038526701167212347L;

	public Imagem(String arquivoImagem){
        super(new ImageIcon(arquivoImagem));
    }
}
