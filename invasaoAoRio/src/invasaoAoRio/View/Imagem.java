package invasaoAoRio.View;

import javax.swing.*;
import java.awt.*;

public class Imagem extends JLabel {

    public Imagem(String arquivoImagem){
        super(new ImageIcon(arquivoImagem));
    }
}
