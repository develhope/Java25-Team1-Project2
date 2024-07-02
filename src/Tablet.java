import java.math.BigDecimal;
import java.util.UUID;

public class Tablet extends Prodotto implements Dispositivo {
    private ProdottoEnum tipoDispositivo;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private ProdottoEnum tipoMemoria;
    private String dimensioneArchiviazione;
    private Double prezzoAcquisto;
    private boolean acceso;

    public Tablet(UUID id, ProdottoEnum tipologiaProdotto, ProdottoEnum tipoDispositivo, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita,
                  String produttore, String modello, Double dimensioneDisplay, ProdottoEnum tipoMemoria,
                  String dimensioneArchiviazione, Double prezzoAcquisto) {
        super(id, tipologiaProdotto, nomeProdotto, descrizioneProdotto, prezzoVendita);
        this.tipoDispositivo = tipoDispositivo;
        this.produttore = produttore;
        this.modello = modello;
        this.dimensioneDisplay = dimensioneDisplay;
        this.tipoMemoria = tipoMemoria;
        this.dimensioneArchiviazione = dimensioneArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
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

    public Double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(Double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
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
        if (isAcceso()) {
            System.out.println("Applicazione " + nomeApp + " avviata");
        } else {
            System.out.println("Il dispositivo è spento. Impossibile avviare l'applicazione.");
        }
    }

    @Override
    public void spegniApplicazione(String nomeApp) {
        if (isAcceso()) {
            System.out.println("Applicazione " + nomeApp + " spenta");
        } else {
            System.out.println("Il dispositivo è spento. Impossibile spegnere l'applicazione.");
        }
    }

    public void accendi() {
        System.out.println("Tablet acceso");
    }

    public void spegni() {
        System.out.println("Tablet spento");
    }

    @Override
    public void stampaDettagliProdotto() {
        super.stampaDettagliProdotto();
        System.out.println("Tipo Dispositivo: " + tipoDispositivo + ", Produttore: " + produttore +
                ", Modello: " + modello + ", Dimensione display: " + dimensioneDisplay + "\", Tipo di memoria: "
                + tipoMemoria + ", Dimensione: " + dimensioneArchiviazione +
                ", Prezzo acquisto: " + prezzoAcquisto);
    }
}
