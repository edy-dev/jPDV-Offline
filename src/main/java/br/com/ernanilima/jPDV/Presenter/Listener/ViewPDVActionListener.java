package br.com.ernanilima.jPDV.Presenter.Listener;

import br.com.ernanilima.jPDV.Presenter.PDVPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ernani Lima
 */
public class ViewPDVActionListener {

    /**
     * Executa o metodo "userLogin" que realiza a validacao de login do usuario
     */
    public static class LoginUserActionListener implements ActionListener {
        private final PDVPresenter presenter;

        public LoginUserActionListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.presenter.userLogin();
        }
    }

    /**
     * Executa o metodo "exitPDV" que fecha a tela do PDV
     */
    public static class ExitActionListener implements ActionListener {
        private final PDVPresenter presenter;

        public ExitActionListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.presenter.exitPDV();
        }
    }
}
