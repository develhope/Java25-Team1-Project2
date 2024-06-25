import java.math.BigDecimal;
import java.util.UUID;

public class Vestito implements Abito.ProdottoAbbigliamento, Abito.LavaggioSecco {
    private UUID id;
    private String nome;
    private String descrizione;
    private BigDecimal prezzoVendita;
    private ProdottoEnum tipologiaProdotto;
    private String taglia;
    private String colore;
    private String materiale;
    private boolean lavaggioSecco;

    public Vestito(UUID id, String nome, String descrizione, BigDecimal prezzoVendita, ProdottoEnum tipologiaProdotto,
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

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public BigDecimal getPrezzoVendita() {
        return prezzoVendita;
    }

    @Override
    public ProdottoEnum getTipologiaProdotto() {
        return tipologiaProdotto;
    }

    @Override
    public String getTaglia() {
        return taglia;
    }

    @Override
    public String getColore() {
        return colore;
    }

    @Override
    public String getMateriale() {
        return materiale;
    }

    @Override
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

    @Override
    public String toString() {
        return "Vestito{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzoVendita=" + prezzoVendita +
                ", tipologiaProdotto=" + tipologiaProdotto +
                ", taglia='" + taglia + '\'' +
                ", colore='" + colore + '\'' +
                ", materiale='" + materiale + '\'' +
                ", lavaggioSecco=" + lavaggioSecco +
                '}';
    }
}
