import java.util.UUID;

public class Notebook extends Prodotti{

    public Notebook(TipoDispositivo setTipoDispositivo, String produttore, String modello, String descrizione, Double dimensioneDisplay,
                    TipoMemoriaArchiviazione setTipoMemoria, Integer dimensioneArchiviazione, Double prezzoAcquisto, Double prezzoVendita, UUID id) {
        super(setTipoDispositivo, produttore, modello, descrizione, dimensioneDisplay, setTipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
    }
}
