import java.util.UUID;

public class Prodotto {
    private UUID id;
    private TipologiaProdottoEnum tipologiaProdotto;
    private String nomeProdotto;
    private String descrizioneProdotto;
    private Double prezzoVendita;

    public Prodotto(UUID id, TipologiaProdottoEnum tipologiaProdotto, String nomeProdotto, String descrizioneProdotto, Double prezzoVendita) {
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

    public TipologiaProdottoEnum getTipologiaProdotto() {
        return tipologiaProdotto;
    }

    public void setTipologiaProdotto(TipologiaProdottoEnum tipologiaProdotto) {
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

    public Double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(Double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    // Metodo per stampare i dettagli del prodotto
    public void stampaDettagliProdotto() {
        System.out.println("ID prodotto: " + id + ", Tipologia prodotto: " + tipologiaProdotto + ", Nome: " + nomeProdotto + ", Descrizione prodotto: " + descrizioneProdotto + ", Prezzo vendita: " + prezzoVendita);
    }

    @Override
    public String toString() {
        return "Prodotto: " +
                "nome=" + nomeProdotto +
        ", prezzoVendita= " + prezzoVendita + "€";
    }
}