import java.util.UUID;

public class Prodotti {
    private TipoDispositivo tipoDispositivo;
    private String produttore;
    private String modello;
    private String descrizione;
    private Double dimensioneDisplay;
    private TipoMemoriaArchiviazione tipoMemoria;
    private Integer dimensioneArchiviazione;
    private Double prezzoAcquisto;
    private Double prezzoVendita;
    private UUID id;

    public Prodotti(TipoDispositivo tipoDispositivo, String produttore, String modello, String descrizione, Double dimensioneDisplay, TipoMemoriaArchiviazione tipoMemoria, Integer dimensioneArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        this.tipoDispositivo = tipoDispositivo;
        this.produttore = produttore;
        this.modello = modello;
        this.descrizione = descrizione;
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
                ", descrizione = " + descrizione  +
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

    public String getDescrizione() {
        return descrizione;
    }

    public Double getDimensioneDisplay() {
        return dimensioneDisplay;
    }

    public TipoMemoriaArchiviazione getTipoMemoria() {
        return tipoMemoria;
    }

    public Integer getDimensioneArchiviazione() {
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
}