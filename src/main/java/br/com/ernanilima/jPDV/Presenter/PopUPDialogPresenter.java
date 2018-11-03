package br.com.ernanilima.jPDV.Presenter;

import br.com.ernanilima.jPDV.Model.Backgrounds;
import br.com.ernanilima.jPDV.Model.Icons;
import br.com.ernanilima.jPDV.Presenter.Listener.PopUPDialogActionListener;
import br.com.ernanilima.jPDV.Presenter.Listener.PopUPDialogKeyListener;
import br.com.ernanilima.jPDV.Presenter.Listener.PopUPDialogMouseMotionListener;
import br.com.ernanilima.jPDV.View.IPopUPDialog;
import br.com.ernanilima.jPDV.View.PopUPDialog;
import com.towel.swing.img.JImagePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author Ernani Lima
 */
public class PopUPDialogPresenter {

    // Interface do PopUPDialog
    private final IPopUPDialog popUP;

    // Model de Icones do sistema
    private final Icons icons;

    // Model de Backgrounds do sistema
    private final Backgrounds bg;

    // Construtor
    public PopUPDialogPresenter() {
        this.icons = new Icons();
        this.bg = new Backgrounds();
        this.popUP = new PopUPDialog(null, true);
        this.myListiners();
        this.popUP.setBackground(popUPBackground());
    }

    // Listiner de "Botons", "Campos" e outros.
    private void myListiners() {
        this.popUP.setOKActionPerformed(new PopUPDialogActionListener.OkActionListener(this));
        this.popUP.setTopBarMousePressed(new PopUPDialogMouseMotionListener.TopBarMouseListener(this));
        this.popUP.setTopBarMouseDragged(new PopUPDialogMouseMotionListener.TopBarMouseMotionListener(this));
        this.popUP.setOKKeyPressed(new PopUPDialogKeyListener.OkKeyListener(this));
    }

    // Define o background do Dialog usando o projeto towel
    private JImagePanel popUPBackground() {
        try {
            BufferedImage imgBuffer = ImageIO.read(bg.getBgDialog());
            JImagePanel background = new JImagePanel(imgBuffer);
            Rectangle rect = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
            background.setSize((int) rect.getWidth(), (int) rect.getHeight());
            background.setFillType(JImagePanel.FillType.SIDE_BY_SIDE);
            return background;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Exibe o Dialog de "ALERTA" com um titulo e mensagem personalizada
     * @param title
     * @param message
     */
    public void showAlert(String title, String message) {
        this.popUP.setShowPopUP(title, message, icons.getIconAlert());
    }

    /**
     * Exibe o Dialog de "OK" com um titulo e mensagem personalizada
     * @param title
     * @param message
     */
    public void showOkay(String title, String message) {
        this.popUP.setShowPopUP(title, message, icons.getIconOkay());
    }

    /**
     * Fecha o Dialog com setVisible(false)
     */
    public void closePopUP() {
        this.popUP.setClosePopUP();
    }

    /**
     * Movimenta o Dialog ao clicar e arrastar na barra superior
     * @param x
     * @param y
     */
    public void mouseMotionPopUP(int x, int y) {
        this.popUP.setMouseMotion(x, y);
    }
}