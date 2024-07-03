import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Prodotto {

    private ProdottoEnum tipologiaProdotto;
    private String nomeProdotto;
    private String descrizioneProdotto;
    private BigDecimal prezzoVendita;
    private Integer quantita;

    public Prodotto( ProdottoEnum tipologiaProdotto, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita, Integer quantita) {
        this.tipologiaProdotto = tipologiaProdotto;
        this.nomeProdotto = nomeProdotto;
        this.descrizioneProdotto = descrizioneProdotto;
        this.prezzoVendita = prezzoVendita;
        this.quantita = quantita;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public ProdottoEnum getTipologiaProdotto() {
        return tipologiaProdotto;
    }

    public void setTipologiaProdotto(ProdottoEnum tipologiaProdotto) {
        this.tipologiaProdotto = tipologiaProdotto;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public String getDescrizioneProdotto() {
        return descrizioneProdotto;
    }

    public void setDescrizioneProdotto(String descrizioneProdotto) {
        this.descrizioneProdotto = descrizioneProdotto;
    }

    public BigDecimal getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(BigDecimal prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public String stampaDettagliProdotto() {
        System.out.println( "Tipologia prodotto: " + getTipologiaProdotto() + ", Nome: "
                + getNomeProdotto() + ", Prezzo vendita: "
                + getPrezzoVendita() + ", quantita: " + quantita);

        return null;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return prezzoVendita.compareTo(prodotto.prezzoVendita) == 0 &&
                nomeProdotto.equals(prodotto.nomeProdotto) &&
                tipologiaProdotto.equals(prodotto.tipologiaProdotto);
    }

    public int hashCode() {
        return Objects.hash(nomeProdotto, tipologiaProdotto, prezzoVendita);
    }
}
