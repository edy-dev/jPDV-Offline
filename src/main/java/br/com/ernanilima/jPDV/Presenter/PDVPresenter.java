package br.com.ernanilima.jPDV.Presenter;

import br.com.ernanilima.jPDV.Dao.UserDao;
import br.com.ernanilima.jPDV.Model.Support;
import br.com.ernanilima.jPDV.Model.User;
import br.com.ernanilima.jPDV.Presenter.Listener.ViewPDVActionListener;
import br.com.ernanilima.jPDV.Presenter.Listener.ViewPDVKeyListener;
import br.com.ernanilima.jPDV.Util.Encrypt;
import br.com.ernanilima.jPDV.View.Enum.CardLayoutPDV;
import br.com.ernanilima.jPDV.View.IViewPDV;
import br.com.ernanilima.jPDV.View.ViewPDV;

/**
 *
 * @author Ernani Lima
 */
public class PDVPresenter {

    // Interface do ViewPDV
    private final IViewPDV viewPDV;

    // Presenter do pop-up de alertas e ok
    private final PopUPDialogPresenter popUPPresenter;

    // Model de usuario
    private final User user;

    // Model do Suporte
    private final Support support;

    // Dao do usuario
    private final UserDao userDao;

    private String id;
    private String password;

    // Construtor
    public PDVPresenter() {
        this.viewPDV = new ViewPDV();
        this.popUPPresenter = new PopUPDialogPresenter();
        this.user = new User();
        this.support = new Support();
        this.userDao = new UserDao();
        this.myListiners();
        this.viewPDV.packAndShow();
    }

    // Listiner de "Botons", "Campos" e outros.
    private void myListiners() {
        this.viewPDV.setLoginActionPerformed(new ViewPDVActionListener.LoginUserActionListener(this));
        this.viewPDV.setExitActionPerformed(new ViewPDVActionListener.ExitActionListener(this));
        this.viewPDV.setFieldIDKeyPressed(new ViewPDVKeyListener.FieldIDKeyListener(viewPDV));
        this.viewPDV.setFieldPasswordKeyPressed(new ViewPDVKeyListener.FieldPassqordKeyListener(this));
    }

    /**
     * Metodo que realiza a validacao de login do usuario ou do suporte tecnico
     */
    public void userLogin() {
        this.id = viewPDV.getIdUser();
        this.password = Encrypt.sha256(viewPDV.getPassword());

        if (id.equals("")) {
            System.out.println("INFORME O CODIGO DO OPERADOR!");
            this.viewPDV.setFocusFieldID();
        } else if (password.equals("")) {
            System.out.println("INFORME A SENHA DO OPERADOR!");
            this.viewPDV.setFocusFieldPassword();
        } else if (Integer.parseInt(id) == (support.getId()) & password.equals(support.getPwd())) {
            System.out.println("LOGIN DO SUPORTE TECNICO!");
            this.popUPPresenter.showAlert("ALERTA", "Login do Suporte Técnico que está trabalhando dia de feriado!");
        } else {
            this.user.setId(Integer.parseInt(id));
            this.user.setPwd(password);

            if (userDao.userLogin(user)) {
                System.out.println("LOGIN REALIZADO!");
                this.viewPDV.setCardPDV(CardLayoutPDV.CARD_PDV.getNameCardLayout());
                this.viewPDV.setFocusFieldBarCode();
            } else {
                this.viewPDV.setFocusFieldID();
                System.out.println("Login invalido!");
            }
        }
    }

    /**
     * Metodo que fecha o sistema do PDV
     */
    public void exitPDV() {
        System.exit(0);
    }
}
