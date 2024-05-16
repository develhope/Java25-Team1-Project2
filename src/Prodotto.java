import java.util.UUID;

public class Prodotto {
    private TipoDispositivo tipoDispositivo;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private TipoMemoriaArchiviazione tipoMemoria;
    private SpazioDiArchiviazione dimensioneArchiviazione;
    private Double prezzoAcquisto;
    private Double prezzoVendita;
    private UUID id;

    public Prodotto(TipoDispositivo tipoDispositivo, String produttore, String modello, Double dimensioneDisplay, TipoMemoriaArchiviazione tipoMemoria, SpazioDiArchiviazione dimensioneArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        this.tipoDispositivo = tipoDispositivo;
        this.produttore = produttore;
        this.modello = modello;
        this.dimensioneDisplay = dimensioneDisplay;
        this.tipoMemoria = tipoMemoria;
        this.dimensioneArchiviazione = dimensioneArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prodotto { " +
                "id = " + id +
                "  TipoDispositivo = " + tipoDispositivo +
                ", produttore = " + produttore +
                ", modello = " + modello +
                ", dimensioneDisplay = " + dimensioneDisplay +
                ", TipoMemoria = " + tipoMemoria +
                ", dimensioneArchiviazione = " + dimensioneArchiviazione +
                ", prezzoAcquisto = " + prezzoAcquisto +
                ", prezzoVendita = " + prezzoVendita +
                "}";
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public String getProduttore() {
        return produttore;
    }

    public String getModello() {
        return modello;
    }

    public Double getDimensioneDisplay() {
        return dimensioneDisplay;
    }

    public TipoMemoriaArchiviazione getTipoMemoria() {
        return tipoMemoria;
    }

    public SpazioDiArchiviazione getDimensioneArchiviazione() {
        return dimensioneArchiviazione;
    }

    public Double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public Double getPrezzoVendita() {
        return prezzoVendita;
    }

    public UUID getId() {
        return id;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setDimensioneDisplay(Double dimensioneDisplay) {
        this.dimensioneDisplay = dimensioneDisplay;
    }

    public void setTipoMemoria(TipoMemoriaArchiviazione tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public void setDimensioneArchiviazione(SpazioDiArchiviazione dimensioneArchiviazione) {
        this.dimensioneArchiviazione = dimensioneArchiviazione;
    }

    public void setPrezzoAcquisto(Double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public void setPrezzoVendita(Double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
