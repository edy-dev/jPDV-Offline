package br.com.ernanilima.jpdv.Presenter.Listener;

import br.com.ernanilima.jpdv.Presenter.PDVPresenter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Classe que escuta teclas precionadas na ViewPDV
 *
 * @author Ernani Lima
 */
public class ViewPDVKeyListener {

    /**
     * Ao precionar "ENTER", define foco no campo de senha do usuario.
     */
    public static class FieldIDKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
         */
        public FieldIDKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                this.presenter.focusFieldPassword();
            }
        }
    }

    /**
     * Ao precionar "ENTER", executa o metodo "{@link PDVPresenter#userLogin()}".
     * que realiza a validacao de login do usuario ou do suporte tecnico.
     */
    public static class FieldPassqordKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

        /**
         * Metodo construtor
         * @param presenter {@link PDVPresenter} - Classe presenter da ViewPDV.
         */
        public FieldPassqordKeyListener(PDVPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                this.presenter.userLogin();
            }
        }
    }
}
