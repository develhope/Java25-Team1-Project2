import java.util.UUID;

public class Prodotti {
    private TipoDispositivo setTipoDispositivo;
    private String produttore;
    private String modello;
    private String descrizione;
    private Double dimensioneDisplay;
    private TipoMemoriaArchiviazione setTipoMemoria;
    private Integer dimensioneArchiviazione;
    private Double prezzoAcquisto;
    private Double prezzoVendita;
    private UUID id;

    public Prodotti(TipoDispositivo setTipoDispositivo, String produttore, String modello, String descrizione, Double dimensioneDisplay, TipoMemoriaArchiviazione setTipoMemoria, Integer dimensioneArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        this.setTipoDispositivo = setTipoDispositivo;
        this.produttore = produttore;
        this.modello = modello;
        this.descrizione = descrizione;
        this.dimensioneDisplay = dimensioneDisplay;
        this.setTipoMemoria = setTipoMemoria;
        this.dimensioneArchiviazione = dimensioneArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prodotto { " +
                "id = " + id +
                "  TipoDispositivo = " + setTipoDispositivo +
                ", produttore = " + produttore +
                ", modello = " + modello +
                ", descrizione = " + descrizione  +
                ", dimensioneDisplay = " + dimensioneDisplay +
                ", TipoMemoria = " + setTipoMemoria +
                ", dimensioneArchiviazione = " + dimensioneArchiviazione +
                ", prezzoAcquisto = " + prezzoAcquisto +
                ", prezzoVendita = " + prezzoVendita +
                "}";
    }

    public TipoDispositivo getSetTipoDispositivo() {
        return setTipoDispositivo;
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

    public TipoMemoriaArchiviazione getSetTipoMemoria() {
        return setTipoMemoria;
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
