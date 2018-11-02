package br.com.ernanilima.jPDV;

import br.com.ernanilima.jPDV.Connetion.CreateDatabaseSQLite;
import br.com.ernanilima.jPDV.Presenter.PDVPresenter;

public class jPDV {
    public static void main(String[] args) {
        new CreateDatabaseSQLite().createDB();
        PDVPresenter presenter = new PDVPresenter();
    }
}