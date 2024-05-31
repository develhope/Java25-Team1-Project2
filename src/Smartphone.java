import java.util.UUID;

public class Smartphone extends  Prodotto{
    private TipoDispositivoEnum tipoDispositivo;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private TipoMemoriaArchiviazioneEnum tipoMemoria;
    private SpazioDiArchiviazioneEnum dimensioneArchiviazione;
    private Double prezzoAcquisto;
    private Double prezzoVendita;
    private UUID id;

    public Smartphone(TipoDispositivoEnum tipoDispositivo, String produttore, String modello, Double dimensioneDisplay, TipoMemoriaArchiviazioneEnum tipoMemoria, SpazioDiArchiviazioneEnum dimensioneArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        super(tipoDispositivo, produttore, modello, dimensioneDisplay, tipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }

    @Override
    public TipoDispositivoEnum getTipoDispositivo() {
        return tipoDispositivo;
    }

    @Override
    public String getProduttore() {
        return produttore;
    }

    @Override
    public String getModello() {
        return modello;
    }

    @Override
    public Double getDimensioneDisplay() {
        return dimensioneDisplay;
    }

    @Override
    public TipoMemoriaArchiviazioneEnum getTipoMemoria() {
        return tipoMemoria;
    }

    @Override
    public SpazioDiArchiviazioneEnum getDimensioneArchiviazione() {
        return dimensioneArchiviazione;
    }

    @Override
    public Double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    @Override
    public Double getPrezzoVendita() {
        return prezzoVendita;
    }

    @Override
    public UUID getId() {
        return id;
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

    public Prodotto smartphoneBiuld(){
        return new Prodotto(tipoDispositivo,produttore,modello,dimensioneDisplay,tipoMemoria,dimensioneArchiviazione,prezzoAcquisto,prezzoVendita,id);
    }
}