package br.com.ernanilima.jpdv.View;

import com.towel.swing.img.JImagePanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * Interface da View PopUPConfirmDialog
 *
 * @author Ernani Lima
 */
public interface IPopUPConfirmDialog {

    // Exibe o Dialog
    public void setShowPopUP(String title, String message, ImageIcon icon);

    // Fecha o Dialog
    public void setClosePopUP();

    // Seta escutas em componentes do Dialog
    public void setYesKeyPressed(KeyAdapter adapter);
    public void setYesActionPerformed(ActionListener listener);
    public void setNoKeyPressed(KeyAdapter adapter);
    public void setNoActionPerformed(ActionListener listener);
    public void setTopBarMousePressed(MouseAdapter adapter);
    public void setTopBarMouseDragged(MouseAdapter adapter);

    // Definir foco em determinado componente
    public void setFocusBtnYes();
    public void setFocusBtnNo();

    // Seta a movimentacao do Dialog na barra superior
    public void setMouseMotion(int x, int y);

    // Seta a Imagem de background usando o projeto towel
    public void setBackground(JImagePanel imagePanel);
}