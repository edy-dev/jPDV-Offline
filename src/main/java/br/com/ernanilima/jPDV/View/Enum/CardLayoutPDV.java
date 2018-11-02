package br.com.ernanilima.jPDV.View.Enum;

/**
 *
 * @author Ernani Lima
 */
public enum CardLayoutPDV {

    /**
     * Seleciona entre "tela de login" e "tela de vendas"
     */
    CARD_PDV("cardPDV"),
    CARD_LOGIN("cardLogin"),

    /**
     * Seleciona entre "tela de venda", "tela de troco", "tela de itens vendidos" e "tela de busca"
     */
    CARD_VENDA("cardPDVVenda"),
    CARD_TROCO("cardPDVTroco"),
    CARD_ITENS("cardPDVItens"),
    CARD_BUSCAR("cardPDVBuscar"),

    /**
     * Seleciona entre "painel de valores dos produtos" e "painel de valores do cupom"
     */
    CARD_VALOR_PRODUTO("cardValProduto"),
    CARD_VALOR_CUPOM("cardValCupom"),

    /**
     * Seleciona entre "painel de logo", "painel para aplicar desconto" e "painel de botons touch"
     */
    CARD_LOGO("cardLogo"),
    CARD_DESCONTO("cardDesconto"),
    CARD_BOTONS_TOUCH("cardBtnTouch");

    private String nameCardLayout;

    private CardLayoutPDV(String nameCardLayout) {
        this.nameCardLayout = nameCardLayout;
    }

    public String getNameCardLayout() {
        return nameCardLayout;
    }
}