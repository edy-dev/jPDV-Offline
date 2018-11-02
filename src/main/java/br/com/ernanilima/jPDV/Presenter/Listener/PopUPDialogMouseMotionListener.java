package br.com.ernanilima.jPDV.Presenter.Listener;

import br.com.ernanilima.jPDV.Presenter.PopUPDialogPresenter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ernani Lima
 */
public class PopUPDialogMouseMotionListener {

    private static int xMouse, yMouse;

    /**
     * Define movimentacao do Dialog de acordo com o tamanho da tela e local onde clicou na barra superior
     */
    public static class TopBarMouseMotionListener extends MouseAdapter {
        private final PopUPDialogPresenter presenter;
        private int x, y;

        public TopBarMouseMotionListener(PopUPDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            this.x = e.getXOnScreen(); this.y = e.getYOnScreen();
            this.presenter.mouseMotionPopUP(this.x - xMouse, this.y - yMouse);
        }
    }

    /**
     * Captura local exato onde clicou na barra superior do Dialog
     */
    public static class TopBarMouseListener extends MouseAdapter {
        private final PopUPDialogPresenter presenter;

        public TopBarMouseListener(PopUPDialogPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            xMouse = e.getX(); yMouse = e.getY();
        }
    }
}