package br.com.ernanilima.jPDV.Presenter.Listener;

import br.com.ernanilima.jPDV.Presenter.PopUPDialogPresenter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Ernani Lima
 */
public class PopUPDialogKeyListener {
    /**
     * Executa o metodo "closePopUP" que fecha o Dialog se precionado a tecla ENTER no botao OK
     */
    public static class OkKeyListener extends KeyAdapter {
        private final PopUPDialogPresenter presenter;

        public OkKeyListener(PopUPDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.presenter.closePopUP();
            }
        }
    }
}