package br.com.ernanilima.jPDV.Presenter.Listener;

import br.com.ernanilima.jPDV.Presenter.PDVPresenter;
import br.com.ernanilima.jPDV.View.IViewPDV;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Ernani Lima
 */
public class ViewPDVKeyListener {

    /**
     * Ao precionar "ENTER", seta o foco no campo de senha do usuario
     */
    public static class FieldIDKeyListener extends KeyAdapter {
        private final IViewPDV viewPDV;

        public FieldIDKeyListener(IViewPDV viewPDV) {
            this.viewPDV = viewPDV;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                this.viewPDV.setFocusFieldPassword();
            }
        }
    }

    /**
     * Ao precionar "ENTER", executa o metodo "userLogin".
     * Metodo "userLogin" realiza a validacao de login do usuario
     */
    public static class FieldPassqordKeyListener extends KeyAdapter {
        private final PDVPresenter presenter;

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
