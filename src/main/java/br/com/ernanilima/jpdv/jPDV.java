package br.com.ernanilima.jpdv;

import br.com.ernanilima.jpdv.Connection.CreateDatabaseSQLite;
import br.com.ernanilima.jpdv.Presenter.PDVPresenter;

public class jPDV {
    public static void main(String[] args) {
        new CreateDatabaseSQLite().createDB();
        PDVPresenter presenter = new PDVPresenter();
    }
}