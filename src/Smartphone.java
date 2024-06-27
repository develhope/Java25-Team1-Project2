import java.math.BigDecimal;
import java.util.UUID;

public class Smartphone extends Prodotto implements Dispositivo {
    private UUID id;
    private ProdottoEnum tipoDispositivo;
    private String nomeProdotto;
    private String descrizioneProdotto;
    private BigDecimal prezzoVendita;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private ProdottoEnum tipoMemoria;
    private String dimensioneArchiviazione;
    private Double prezzoAcquisto;
    private boolean acceso;
    private boolean spento;

    public Smartphone(UUID id, ProdottoEnum tipologiaProdotto, ProdottoEnum tipoDispositivo, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita,
                      String produttore, String modello, Double dimensioneDisplay, ProdottoEnum tipoMemoria,
                      String dimensioneArchiviazione, Double prezzoAcquisto) {
        super(id, tipologiaProdotto, nomeProdotto, descrizioneProdotto, prezzoVendita);
        this.id = id;
        this.tipoDispositivo = tipoDispositivo;
        this.nomeProdotto = nomeProdotto;
        this.descrizioneProdotto = descrizioneProdotto;
        this.prezzoVendita = prezzoVendita;
        this.produttore = produttore;
        this.modello = modello;
        this.dimensioneDisplay = dimensioneDisplay;
        this.tipoMemoria = tipoMemoria;
        this.dimensioneArchiviazione = dimensioneArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.acceso = false;
        this.spento = true;
        this.setDescrizioneProdotto(descrizioneProdotto + ", Display: " + dimensioneDisplay +
                "\", Memoria: " + tipoMemoria + ", Spazio: " + dimensioneArchiviazione);
    }

    public ProdottoEnum getTipoDispositivo() {
        return tipoDispositivo;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nomeProdotto;
    }

    public String getDescrizione() {
        return descrizioneProdotto;
    }

    public BigDecimal getPrezzoVendita() {
        return prezzoVendita;
    }

    public boolean isAcceso() {
        return acceso;
    }

    public boolean isSpento() {
        return spento;
    }

    public void setTipoDispositivo(ProdottoEnum tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Double getDimensioneDisplay() {
        return dimensioneDisplay;
    }

    public void setDimensioneDisplay(Double dimensioneDisplay) {
        this.dimensioneDisplay = dimensioneDisplay;
    }

    public ProdottoEnum getTipoMemoria() {
        return tipoMemoria;
    }

    public void setTipoMemoria(ProdottoEnum tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public String getDimensioneArchiviazione() {
        return dimensioneArchiviazione;
    }

    public void setDimensioneArchiviazione(String dimensioneArchiviazione) {
        this.dimensioneArchiviazione = dimensioneArchiviazione;
    }

    public Double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(Double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
        this.spento = !acceso;
        if (acceso) {
            accendi();
        } else {
            spegni();
        }
    }

    public void chiamare(String numero) {
        System.out.println("Chiamata al numero: " + numero);
    }

    public void inviareSMS(String numero, String messaggio) {
        System.out.println("SMS inviato al numero: " + numero + " con il messaggio: " + messaggio);
    }

    public void inviaChiamata(String chiamare, String numero) {
        if (isAcceso()) {
            chiamare(numero);
        } else {
            System.out.println("Il dispositivo è spento. Impossibile chiamare.");
        }
    }

    public void inviaSMS(String SMS, String numero) {
        if (isAcceso()) {
            inviareSMS(numero, SMS);
        } else {
            System.out.println("Il dispositivo è spento. Impossibile inviare SMS.");
        }
    }

    public void accendi() {
        System.out.println("Smartphone acceso");
    }

    public void spegni() {
        System.out.println("Smartphone spento");
    }

    @Override
    public void stampaDettagliProdotto() {
        super.stampaDettagliProdotto();
        System.out.println("Tipo Dispositivo: " + tipoDispositivo + ", Produttore: " + produttore +
                ", Modello: " + modello + ", Dimensione display: " + dimensioneDisplay + "\", Tipo di memoria: "
                + tipoMemoria + ", Dimensione: " + dimensioneArchiviazione +
                ", Prezzo acquisto: " + prezzoAcquisto);
    }


    public void checkSmartphone() {
        setAcceso(true);
        inviaChiamata("Chiamata di test", "3895382595");
        inviaSMS("Messaggio di test", "3895382595");
        setSpento(true);
        inviaChiamata("Chiamata di test", "3895382595");
        inviaSMS("Messaggio di test", "3895382595");
    }
}
