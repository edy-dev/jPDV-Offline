package br.com.ernanilima.jPDV.Presenter.Listener;

import br.com.ernanilima.jPDV.Presenter.PopUPDialogPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ernani Lima
 */
public class PopUPDialogActionListener {
    /**
     * Executa o metodo "closePopUP" que fecha o Dialog
     */
    public static class OkActionListener implements ActionListener {
        private final PopUPDialogPresenter presenter;

        public OkActionListener(PopUPDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.presenter.closePopUP();
        }
    }
}