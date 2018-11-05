package br.com.ernanilima.jpdv.Model;

import java.io.InputStream;

/**
 * Classe de getters com o caminho de cada imagen de background do sistema
 *
 * @author Ernani Lima
 */
public class Backgrounds {
    /**
     * InputStream com o caminho interno da aplicacao contendo cada imagem de background
     */
    private final InputStream imgBgDialog = getClass().getResourceAsStream("/backgrounds/bg_dialog.png");
    private final InputStream imgBgPDVLogin = getClass().getResourceAsStream("/backgrounds/bg_login_jpdv.png");

    // Construtor vazio
    public Backgrounds() {}

    /**
     * @return InputStream - Caminho interno da imagem de Background do Dialog
     */
    public InputStream getPathBgDialog() {
        return imgBgDialog;
    }

    /**
     * @return InputStream - Caminho interno da imagem de Background da tela de login do PDV
     */
    public InputStream getPathBgPDVLogin() {
        return imgBgPDVLogin;
    }
}
