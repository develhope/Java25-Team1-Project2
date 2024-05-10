import java.util.UUID;

public class Prodotti {
    TipoDispositivo setTipoDispositivo;
    String produttore;
    String modello;
    String descrizione;
    double dimensioneDisplay;
    TipoMemoriaArchiviazione setTipoMemoria;
    double dimensioneArchiviazione;
    double prezzoAcquisto;
    double prezzoVendita;
    private UUID id;

    public Prodotti(TipoDispositivo setTipoDispositivo, String produttore, String modello, String descrizione, double dimensioneDisplay, TipoMemoriaArchiviazione setTipoMemoria, double dimensioneArchiviazione, double prezzoAcquisto, double prezzoVendita, UUID id) {
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
                ", id = " + id +
                "    TipoDispositivo = " + setTipoDispositivo +
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

    public UUID getId() {
        return id;
    }
}
