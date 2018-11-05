package br.com.ernanilima.jpdv.View.Enum;

/**
 * Enumeradores de CardLayout utilizado no PDV
 *
 * @author Ernani Lima
 */
public enum CardLayoutPDV {

    /** Seleciona "tela de login" */
    CARD_PDV("cardPDV"),

    /** Seleciona "tela de vendas" */
    CARD_LOGIN("cardLogin"),

    /** Seleciona "tela de venda" */
    CARD_VENDA("cardPDVVenda"),

    /** Seleciona "tela de troco" */
    CARD_TROCO("cardPDVTroco"),

    /** Seleciona "tela de itens vendidos" */
    CARD_ITENS("cardPDVItens"),

    /** Seleciona "tela de busca" */
    CARD_BUSCAR("cardPDVBuscar"),

    /** Seleciona "painel de valores dos produtos" */
    CARD_VALOR_PRODUTO("cardValProduto"),

    /** Seleciona "painel de valores do cupom" */
    CARD_VALOR_CUPOM("cardValCupom"),

    /** Seleciona "painel de logo" */
    CARD_LOGO("cardLogo"),

    /** Seleciona "painel para aplicar desconto" */
    CARD_DESCONTO("cardDesconto"),

    /** Seleciona "painel de botons touch" */
    CARD_BOTONS_TOUCH("cardBtnTouch");

    private String nameCardLayout;

    /**
     * @param nameCardLayout String - CardLayout selecionado
     */
    private CardLayoutPDV(String nameCardLayout) {
        this.nameCardLayout = nameCardLayout;
    }

    /**
     * @return String - Nome do CardLayout selecionado
     */
    public String getNameCardLayout() {
        return nameCardLayout;
    }
}