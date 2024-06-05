import java.util.UUID;
//TODO AGGIUNGERE nome, prezzo e DESCRIZIONE, pulire la classe prodotto
public class Prodotto {
    private TipoDispositivoEnum tipoDispositivo;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private TipoMemoriaArchiviazioneEnum tipoMemoria;
    private SpazioDiArchiviazioneEnum dimensioneArchiviazione;
    private Double prezzoAcquisto;
    private Double prezzoVendita;
    private UUID id;


    // TODO usare ereditarietà per prodotto base, eliminare i campi non utili
    public Prodotto(TipoDispositivoEnum tipoDispositivo, String produttore, String modello, Double dimensioneDisplay,
                    TipoMemoriaArchiviazioneEnum tipoMemoria, SpazioDiArchiviazioneEnum dimensioneArchiviazione,
                    Double prezzoAcquisto, Double prezzoVendita, UUID id) {
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

    public void setTipoDispositivo(TipoDispositivoEnum tipoDispositivo) {
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

    public void setTipoMemoria(TipoMemoriaArchiviazioneEnum tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public void setDimensioneArchiviazione(SpazioDiArchiviazioneEnum dimensioneArchiviazione) {
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

    public TipoDispositivoEnum getTipoDispositivo() {
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

    public TipoMemoriaArchiviazioneEnum getTipoMemoria() {
        return tipoMemoria;
    }

    public SpazioDiArchiviazioneEnum getDimensioneArchiviazione() {
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

    // TODO aggiungere metodo stampa dettagli

}