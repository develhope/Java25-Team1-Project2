import java.math.BigDecimal;
import java.util.UUID;

public class Prodotto {
    private UUID id;
    private ProdottoEnum tipologiaProdotto;
    private String nomeProdotto;
    private String descrizioneProdotto;
    private BigDecimal prezzoVendita;

    public Prodotto(UUID id, ProdottoEnum tipologiaProdotto, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita) {
        this.id = id;
        this.tipologiaProdotto = tipologiaProdotto;
        this.nomeProdotto = nomeProdotto;
        this.descrizioneProdotto = descrizioneProdotto;
        this.prezzoVendita = prezzoVendita;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    // Metodo per stampare i dettagli del prodotto
    public void stampaDettagliProdotto() {
        System.out.println("ID prodotto: " + getId() + ", Tipologia prodotto: " + getTipologiaProdotto() + ", Nome: " + getNomeProdotto() + ", Descrizione prodotto: " + getDescrizioneProdotto() + ", Prezzo vendita: " + getPrezzoVendita());
    }
}