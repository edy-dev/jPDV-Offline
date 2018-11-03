package br.com.ernanilima.jPDV.Model;

import java.io.InputStream;

/**
 * Classe com os getters de imagens de background do sistema
 * @author Ernani Lima
 */
public class Backgrounds {

    private final InputStream bgDialog = getClass().getResourceAsStream("/backgrounds/bg_dialog.png");
    private final InputStream bgPDVLogin = getClass().getResourceAsStream("/backgrounds/bg_login_jpdv.png");

    public Backgrounds() {}

    /**
     * @return InputStream da imagem de Background do Dialog
     */
    public InputStream getBgDialog() {
        return bgDialog;
    }

    /**
     * @return InputStream da imagem de Background da tela de login do PDV
     */
    public InputStream getBgPDVLogin() {
        return bgPDVLogin;
    }
}
