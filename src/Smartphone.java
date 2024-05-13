import java.util.UUID;

public class Smartphone extends Prodotti {


    public Smartphone(TipoDispositivo tipoDispositivo, String produttore, String modello, String descrizione, Double dimensioneDisplay, TipoMemoriaArchiviazione tipoMemoria, Integer dimensioneArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        super(tipoDispositivo, produttore, modello, descrizione, dimensioneDisplay, tipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }
}
