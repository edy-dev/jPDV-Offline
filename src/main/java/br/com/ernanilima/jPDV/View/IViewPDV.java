package br.com.ernanilima.jPDV.View;

import com.towel.swing.img.JImagePanel;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

/**
 *
 * @author Ernani Lima
 */
public interface IViewPDV {

    public String getIdUser();
    public void setIdUser(String id);

    public String getPassword();

    /**
     * Botons
     */
    public void setLoginActionPerformed(ActionListener listener);
    public void setExitActionPerformed(ActionListener listener);
    public void setFieldIDKeyPressed(KeyAdapter adapter);
    public void setFieldPasswordKeyPressed(KeyAdapter adapter);

    /**
     * Definir foco em determinado campo
     */
    public void setFocusFieldID();
    public void setFocusFieldPassword();
    public void setFocusFieldBarCode();

    /**
     * Cards
     */
    public void setCardPDV(String cardName);
    public void setCardPDVVendas(String cardName);
    public void setCardPDVValores(String cardName);
    public void setCardPDVLogo(String cardName);

    /**
     * Backgrounds
     */
    // Seta a Imagem de background na tela de login usando o projeto towel
    public void setBackgroundLogin(JImagePanel imagePanel);

    public void packAndShow();
}