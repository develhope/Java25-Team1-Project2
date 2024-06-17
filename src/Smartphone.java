import java.math.BigDecimal;
import java.util.UUID;

public class Smartphone extends Prodotto implements Dispositivo {
    private TipoDispositivoEnum tipoDispositivo;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private TipoMemoriaArchiviazioneEnum tipoMemoria;
    private SpazioDiArchiviazioneEnum dimensioneArchiviazione;
    private Double prezzoAcquisto;

    public Smartphone(UUID id, TipologiaProdottoEnum tipologiaProdotto, TipoDispositivoEnum tipoDispositivo, String nomeProdotto, String descrizioneProdotto, BigDecimal prezzoVendita,
                      String produttore, String modello, Double dimensioneDisplay, TipoMemoriaArchiviazioneEnum tipoMemoria,
                      SpazioDiArchiviazioneEnum dimensioneArchiviazione, Double prezzoAcquisto) {
        super(id, tipologiaProdotto, nomeProdotto, descrizioneProdotto, prezzoVendita);
        this.tipoDispositivo = tipoDispositivo;
        this.produttore = produttore;
        this.modello = modello;
        this.dimensioneDisplay = dimensioneDisplay;
        this.tipoMemoria = tipoMemoria;
        this.dimensioneArchiviazione = dimensioneArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.setDescrizioneProdotto(descrizioneProdotto + ", Display: " + dimensioneDisplay +
                "\", Memoria: " + tipoMemoria + ", Spazio: " + dimensioneArchiviazione);
    }

    @Override
    public TipoDispositivoEnum getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivoEnum tipoDispositivo) {
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

    public TipoMemoriaArchiviazioneEnum getTipoMemoria() {
        return tipoMemoria;
    }

    public void setTipoMemoria(TipoMemoriaArchiviazioneEnum tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public SpazioDiArchiviazioneEnum getDimensioneArchiviazione() {
        return dimensioneArchiviazione;
    }

    public void setDimensioneArchiviazione(SpazioDiArchiviazioneEnum dimensioneArchiviazione) {
        this.dimensioneArchiviazione = dimensioneArchiviazione;
    }

    public Double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(Double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    @Override
    public void stampaDettagliProdotto() {
        super.stampaDettagliProdotto();
        System.out.println("Tipo Dispositivo: " + tipoDispositivo + ", Produttore: " + produttore +
                ", Modello: " + modello + ", Dimensione display: " + dimensioneDisplay + "\", Tipo di memoria: "
                + tipoMemoria + ", Dimensione: " + dimensioneArchiviazione +
                ", Prezzo acquisto: " + prezzoAcquisto);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + getId() +
                ", tipologiaProdotto=" + getTipologiaProdotto() +
                ", nomeProdotto='" + getNomeProdotto() + '\'' +
                ", descrizioneProdotto='" + getDescrizioneProdotto() + '\'' +
                ", prezzoVendita=" + getPrezzoVendita() +
                ", tipoDispositivo=" + tipoDispositivo +
                ", produttore='" + produttore + '\'' +
                ", modello='" + modello + '\'' +
                ", dimensioneDisplay=" + dimensioneDisplay +
                ", tipoMemoria=" + tipoMemoria +
                ", dimensioneArchiviazione=" + dimensioneArchiviazione +
                ", prezzoAcquisto=" + prezzoAcquisto +
                '}';
    }
}