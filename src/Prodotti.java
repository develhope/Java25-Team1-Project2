import com.sun.jdi.Method;

public class Prodotti implements Attributi {
    private int id;
    private TipoDispositivo tipo;
    private Attributi attributi;


    public Prodotti(TipoDispositivo tipo, Attributi attributi, int id) {
        this.id = id;
        this.tipo = tipo;
        this.attributi = attributi;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Tipo: " + tipo + "\n" +
                "Descrizione: " + attributi.leggiDescrizioneProdotto();
    }


    @Override
    public String leggiProduttore() {
        return "";
    }

    @Override
    public String leggiModello() {
        return "";
    }

    @Override
    public String leggiDescrizioneProdotto() {
        return "";
    }

    @Override
    public int leggiSpazioArchiviazione() {
        return 0;
    }

    @Override
    public double leggiDisplay() {
        return 0;
    }

    @Override
    public double leggiPrezzoAcquisto() {
        return 0;
    }

    @Override
    public double leggiPrezzoVendita() {
        return 0;
    }

    @Override
    public int leggiId() {
        return 0;
    }

    @Override
    public TipoDispositivo leggiTipoDispositivo() {
        return null;
    }

    @Override
    public TipoMemoriaArchiviazione leggiTipoMemoriaArchiviazione() {
        return null;
    }
}