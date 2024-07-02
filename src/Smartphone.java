import java.math.BigDecimal;
import java.util.UUID;

public class Smartphone extends Prodotto implements Dispositivo {
    private ProdottoEnum tipoDispositivo;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private ProdottoEnum tipoMemoria;
    private String dimensioneArchiviazione;
    private boolean acceso;

    public Smartphone(ProdottoEnum tipologiaProdotto, ProdottoEnum tipoDispositivo, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita,
                      String produttore, String modello, Double dimensioneDisplay, ProdottoEnum tipoMemoria,
                      String dimensioneArchiviazione, Integer quantita) {
        super(tipologiaProdotto, nomeProdotto, descrizioneProdotto, prezzoVendita, quantita);
        this.tipoDispositivo = tipoDispositivo;
        this.produttore = produttore;
        this.modello = modello;
        this.dimensioneDisplay = dimensioneDisplay;
        this.tipoMemoria = tipoMemoria;
        this.dimensioneArchiviazione = dimensioneArchiviazione;
        this.acceso = false;
    }

    public ProdottoEnum getTipoDispositivo() {
        return tipoDispositivo;
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

    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
        if (acceso) {
            accendi();
        } else {
            spegni();
        }
    }

    @Override
    public void avviaApplicazione(String nomeApp) {
        System.out.println("Applicazione " + nomeApp + " avviata");
    }

    @Override
    public void spegniApplicazione(String nomeApp) {
        System.out.println("Applicazione " + nomeApp + " spenta");
    }

    public void chiamare(String numero) {
        if (isAcceso()) {
            System.out.println("Chiamata al numero: " + numero);
        } else {
            System.out.println("Il dispositivo è spento. Impossibile chiamare.");
        }
    }

    public void inviareSMS(String numero, String messaggio) {
        if (isAcceso()) {
            System.out.println("SMS inviato al numero: " + numero + " con il messaggio: " + messaggio);
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
    public String stampaDettagliProdotto() {
        super.stampaDettagliProdotto();
        System.out.println("Tipo Dispositivo: " + tipoDispositivo + ", Produttore: " + produttore +
                ", Modello: " + modello + ", Dimensione display: " + dimensioneDisplay + "\", Tipo di memoria: "
                + tipoMemoria + ", Dimensione: " + dimensioneArchiviazione);
        return null;
    }

    public void checkSmartphone() {
        setAcceso(true);
        chiamare("3895382595");
        inviareSMS("3895382595", "Messaggio di test");
        setAcceso(false);
        chiamare("3895382595");
        inviareSMS("3895382595", "Messaggio di test");
    }
}
