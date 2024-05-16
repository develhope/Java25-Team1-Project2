import java.util.UUID;

public class Notebook extends Prodotto {

    public Notebook(TipoDispositivo tipoDispositivo, String produttore, String modello, Double dimensioneDisplay,
                    TipoMemoriaArchiviazione tipoMemoria, SpazioDiArchiviazione spazioArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        super(tipoDispositivo, produttore, modello, dimensioneDisplay, tipoMemoria, spazioArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }
}

