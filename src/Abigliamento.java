import java.math.BigDecimal;
import java.util.UUID;

public class Abigliamento implements Abito {
    private UUID id;
    private String nome;
    private String descrizione;
    private BigDecimal prezzoVendita;
    private ProdottoEnum tipologiaProdotto;
    private String taglia;
    private String colore;
    private String materiale;
    private boolean lavaggioSecco;

    public Abigliamento(UUID id, String nome, String descrizione, BigDecimal prezzoVendita, ProdottoEnum tipologiaProdotto,
                        String taglia, String colore, String materiale, boolean lavaggioSecco) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzoVendita = prezzoVendita;
        this.tipologiaProdotto = tipologiaProdotto;
        this.taglia = taglia;
        this.colore = colore;
        this.materiale = materiale;
        this.lavaggioSecco = lavaggioSecco;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public BigDecimal getPrezzoVendita() {
        return prezzoVendita;
    }

    public ProdottoEnum getTipologiaProdotto() {
        return tipologiaProdotto;
    }

    public String getTaglia() {
        return taglia;
    }

    public String getColore() {
        return colore;
    }

    public String getMateriale() {
        return materiale;
    }

    public boolean isLavaggioSecco() {
        return lavaggioSecco;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setPrezzoVendita(BigDecimal prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public void setTipologiaProdotto(ProdottoEnum tipologiaProdotto) {
        this.tipologiaProdotto = tipologiaProdotto;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public void setLavaggioSecco(boolean lavaggioSecco) {
        this.lavaggioSecco = lavaggioSecco;
    }


    public void stampaDettagliProdotto(){
        System.out.println("nome prodotto: " + this.nome + "descrizione prodotto: " + this.descrizione + "prezzo: "
        + this.prezzoVendita + "tipologia: " + this.tipologiaProdotto + "taglia :" + getTaglia() + "colore: "
        + getColore() + "materiale: " + getMateriale()+ "lavaggio a secco? " + this.isLavaggioSecco());
    }
}

