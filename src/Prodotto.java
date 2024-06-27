import java.math.BigDecimal;
import java.util.UUID;

public class Prodotto implements Dispositivo {
    private UUID id;
    private ProdottoEnum tipologiaProdotto;
    private String nomeProdotto;
    private String descrizioneProdotto;
    private BigDecimal prezzoVendita;
    private boolean acceso;
    private boolean spento;

    public Prodotto(UUID id, ProdottoEnum tipologiaProdotto, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita) {
        this.id = id;
        this.tipologiaProdotto = tipologiaProdotto;
        this.nomeProdotto = nomeProdotto;
        this.descrizioneProdotto = descrizioneProdotto;
        this.prezzoVendita = prezzoVendita;
        this.acceso = false; // di default il dispositivo è spento
        this.spento = true;
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

    public boolean isAcceso() {
        return acceso;
    }

    public boolean isSpento() {
        return spento;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
        this.spento = !acceso;
    }

    public void setSpento(boolean spento) {
        this.spento = spento;
        this.acceso = !spento;
    }


    public String Chiamare() {
        return "";
    }

    public String SMS() {
        return "";
    }

    public void inviaChiamata(String chiamare, String numero) {
        if (acceso) {
            System.out.println("Chiamata a " + numero + " - Info: " + chiamare);
        } else {
            System.out.println("Il dispositivo è spento. Impossibile chiamare.");
        }
    }

    public void inviaSMS(String SMS, String numero) {
        if (acceso) {
            System.out.println("SMS a " + numero + " - Testo: " + SMS);
        } else {
            System.out.println("Il dispositivo è spento. Impossibile inviare SMS.");
        }
    }


    public void stampaDettagliProdotto() {
        System.out.println("ID prodotto: " + getId() + ", Tipologia prodotto: " + getTipologiaProdotto() + ", Nome: "
                + getNomeProdotto() + ", Descrizione prodotto: " + getDescrizioneProdotto() + ", Prezzo vendita: "
                + getPrezzoVendita());
    }

}
