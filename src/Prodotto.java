import java.util.UUID;
//TODO AGGIUNGERE DASCRIZIONE
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


    @Override
    public String toString() {
        return "Prodotto{ " +
                "tipoDispositivo=" + tipoDispositivo +
                ", produttore='" + produttore + '\'' +
                ", modello='" + modello + '\'' +
                ", dimensioneDisplay=" + dimensioneDisplay +
                ", tipoMemoria=" + tipoMemoria +
                ", dimensioneArchiviazione=" + dimensioneArchiviazione +
                ", prezzoAcquisto=" + prezzoAcquisto +
                ", prezzoVendita=" + prezzoVendita +
                ", id=" + id +
                '}';
    }
}