import java.util.UUID;

public class Tablet extends Prodotto {

    public Tablet(TipoDispositivo tipoDispositivo, String produttore, String modello, Double dimensioneDisplay, TipoMemoriaArchiviazione tipoMemoria, SpazioDiArchiviazione dimensioneArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        super(tipoDispositivo, produttore, modello, dimensioneDisplay, tipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }
}