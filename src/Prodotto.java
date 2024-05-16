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


