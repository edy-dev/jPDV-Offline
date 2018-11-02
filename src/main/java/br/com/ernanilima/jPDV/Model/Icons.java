package br.com.ernanilima.jPDV.Model;

import javax.swing.ImageIcon;

/**
 * Classe com os getters de icones do sistema
 * @author Ernani Lima
 */
public class Icons {

    private final ImageIcon error = new ImageIcon(getClass().getResource("/icons/error_icon.png"));
    private final ImageIcon alert = new ImageIcon(getClass().getResource("/icons/alert_icon.png"));
    private final ImageIcon okay = new ImageIcon(getClass().getResource("/icons/okay_icon.png"));
    private final ImageIcon question = new ImageIcon(getClass().getResource("/icons/question_icon.png"));

    public Icons() {}

    /**
     * @return icone de erro
     */
    public ImageIcon getIconError() {
        return error;
    }

    /**
     * @return icone de alerta
     */
    public ImageIcon getIconAlert() {
        return alert;
    }

    /**
     * @return icone de ok
     */
    public ImageIcon getIconOkay() {
        return okay;
    }

    /**
     * @return icone de questionamento (?)
     */
    public ImageIcon getIconQuestion() {
        return question;
    }
}