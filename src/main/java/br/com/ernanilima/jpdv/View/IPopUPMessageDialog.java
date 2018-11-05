package br.com.ernanilima.jpdv.View;

import com.towel.swing.img.JImagePanel;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;

/**
 * Interface da View PopUPMessageDialog
 *
 * @author Ernani Lima
 */
public interface IPopUPMessageDialog {

    // Exibe o Dialog
    public void setShowPopUP(String title, String message, ImageIcon icon);

    // Fecha o Dialog
    public void setClosePopUP();

    // Seta escutas em componentes do Dialog
    public void setOKKeyPressed(KeyAdapter adapter);
    public void setOKActionPerformed(ActionListener listener);
    public void setTopBarMousePressed(MouseAdapter adapter);
    public void setTopBarMouseDragged(MouseAdapter adapter);

    // Seta a movimentacao do Dialog na barra superior
    public void setMouseMotion(int x, int y);

    // Seta a Imagem de background usando o projeto towel
    public void setBackground(JImagePanel imagePanel);
}
