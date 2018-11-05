package br.com.ernanilima.jpdv.Presenter;

import br.com.ernanilima.jpdv.Util.Background;
import br.com.ernanilima.jpdv.Dao.UserDao;
import br.com.ernanilima.jpdv.Model.Backgrounds;
import br.com.ernanilima.jpdv.Model.Support;
import br.com.ernanilima.jpdv.Model.User;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewPDVActionListener;
import br.com.ernanilima.jpdv.Presenter.Listener.ViewPDVKeyListener;
import br.com.ernanilima.jpdv.Util.Encrypt;
import br.com.ernanilima.jpdv.View.Enum.CardLayoutPDV;
import br.com.ernanilima.jpdv.View.IViewPDV;
import br.com.ernanilima.jpdv.View.ViewPDV;

/**
 * Presenter da ViewPDV
 *
 * @author Ernani Lima
 */
public class PDVPresenter {

    // Interface da ViewPDV
    private final IViewPDV viewPDV;

    // Presenter do pop-up de alertas/ok
    private final PopUPMessageDialogPresenter pPopUPMessage;

    // Presenter do pop-up de confirmacao (sim/nao)
    private final PopUPConfirmDialogPresenter pPopUPConfirm;

    // Model do usuario
    private final User mUser;

    // Model do suporte
    private final Support mSupport;

    // Model de imagens de background do sistema
    private final Backgrounds mBg;

    // Dao do usuario
    private final UserDao dUser;

    private String id;
    private String password;

    // Construtor
    public PDVPresenter() {
        this.viewPDV = new ViewPDV();
        this.pPopUPMessage = new PopUPMessageDialogPresenter();
        this.pPopUPConfirm = new PopUPConfirmDialogPresenter();
        this.mUser = new User();
        this.mSupport = new Support();
        this.mBg = new Backgrounds();
        this.dUser = new UserDao();
        this.myListiners();
        this.viewPDV.setBackgroundLogin(Background.getBackgroundCenter(mBg.getPathBgPDVLogin()));
        this.viewPDV.packAndShow();
    }

    // Listiner de "Botons", "Campos" e outros.
    private void myListiners() {
        this.viewPDV.setLoginActionPerformed(new ViewPDVActionListener.LoginUserActionListener(this));
        this.viewPDV.setExitActionPerformed(new ViewPDVActionListener.ExitActionListener(this));
        this.viewPDV.setFieldIDKeyPressed(new ViewPDVKeyListener.FieldIDKeyListener(this));
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
            this.pPopUPMessage.showAlert("Atenção", "Informe o código do usuário!");
            this.focusFieldID();
        } else if (password.equals("")) {
            System.out.println("INFORME A SENHA DO OPERADOR!");
            this.pPopUPMessage.showAlert("Atenção", "Informe a senha do usuário!");
            this.focusFieldPassword();
        } else if (Integer.parseInt(id) == (mSupport.getId()) & password.equals(mSupport.getPwd())) {
            System.out.println("LOGIN DO SUPORTE TECNICO!");
            this.pPopUPMessage.showAlert("ALERTA", "Login do Suporte!");
        } else {
            this.mUser.setId(Integer.parseInt(id));
            this.mUser.setPwd(password);

            if (dUser.userLogin(mUser)) {
                System.out.println("LOGIN REALIZADO!");
                this.viewPDV.setCardPDV(CardLayoutPDV.CARD_PDV.getNameCardLayout());
                this.focusFieldBarCode();
            } else {
                System.out.println("Dados incorretos ou usuário não cadastrado!");
                this.pPopUPMessage.showAlert("Atenção", "Dados incorretos ou usuário não cadastrado!");
                this.focusFieldID();
            }
        }
    }

    /**
     * Metodo que fecha o sistema do PDV.
     * O metodo exibe um Dialog de confirmacao para fechar a tela do PDV.
     */
    public void exitPDV() {
        this.pPopUPConfirm.showConfirmDialog("Atenção", "Deseja sair do sistema?");
        if (this.pPopUPConfirm.questionResult()) {
            System.exit(0);
        }
    }

    /**
     * Metodo que define o foco no campo de senha do usuario
     */
    public void focusFieldPassword() {
        this.viewPDV.setFocusFieldPassword();
    }

    /**
     * Metodo que define o foco no campo de ID do usuario
     */
    public void focusFieldID() {
        this.viewPDV.setFocusFieldID();
    }

    /**
     * Metodo que define o foco no campo de codigo de barras
     */
    public void focusFieldBarCode() {
        this.viewPDV.setFocusFieldBarCode();
    }
}