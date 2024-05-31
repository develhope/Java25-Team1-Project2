import java.util.UUID;

public class Tablet extends Prodotto{

    private TipoDispositivoEnum tipoDispositivo;
    private String produttore;
    private String modello;
    private Double dimensioneDisplay;
    private TipoMemoriaArchiviazioneEnum tipoMemoria;
    private SpazioDiArchiviazioneEnum dimensioneArchiviazione;
    private Double prezzoAcquisto;
    private Double prezzoVendita;
    private UUID id;

    public Tablet(TipoDispositivoEnum tipoDispositivo, String produttore, String modello, Double dimensioneDisplay, TipoMemoriaArchiviazioneEnum tipoMemoria, SpazioDiArchiviazioneEnum dimensioneArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        super(tipoDispositivo, produttore, modello, dimensioneDisplay, tipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
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

    public Prodotto tabletBiuld(){
        return new Prodotto(tipoDispositivo,produttore,modello,dimensioneDisplay,tipoMemoria,dimensioneArchiviazione,prezzoAcquisto,prezzoVendita,id);
    }
}