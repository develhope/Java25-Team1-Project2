import java.util.UUID;

public class Smartphone extends Prodotti {


    public Smartphone(TipoDispositivo tipoDispositivo, String produttore, String modello, String descrizione, double dimensioneDisplay, TipoMemoriaArchiviazione tipoMemoria, double dimensioneArchiviazione, double prezzoAcquisto, double prezzoVendita, UUID id) {
        super(tipoDispositivo, produttore, modello, descrizione, dimensioneDisplay, tipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }
}
