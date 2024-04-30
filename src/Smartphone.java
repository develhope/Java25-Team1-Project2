public class Smartphone implements  Attributi {
    private String produttore;
    private String modello;
    private double display;
    private int spazioArchiviazione;
    private TipoMemoriaArchiviazione tipoMemoriaArchiviazione;
    private double prezzoAcquisto;
    private double prezzoVendita;
    private TipoDispositivo dispositivo;
    private int id;

    public Smartphone(
            TipoDispositivo dispositivo, int id,  String produttore,
            String modello, double display, int spazioArchiviazione, TipoMemoriaArchiviazione tipoMemoriaArchiviazione,
            double prezzoAcquisto, double prezzoVendita) {

        this.dispositivo = dispositivo;
        this.produttore = produttore;
        this.modello = modello;
        this.display = display;
        this.spazioArchiviazione = spazioArchiviazione;
        this.tipoMemoriaArchiviazione = tipoMemoriaArchiviazione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.id = id;
    }


    @Override
    public String leggiProduttore() {
        return produttore;
    }

    @Override
    public String leggiModello() {
        return modello;
    }

    @Override
    public String leggiDescrizioneProdotto() {
        return '\n' + "Un dispositivo di ottima fattura, parliamo dello " + TipoDispositivo.smartphone + "  " + produttore +
                " " + modello + ", dotato di uno spazio di archiviazione di tipo " + TipoMemoriaArchiviazione.NVMe + " da " + spazioArchiviazione +
                " GB, con un display di " + display + " pollici. Il costo del prodotto è di " +
                prezzoVendita + " €" + '\n';
    }

    @Override
    public int leggiSpazioArchiviazione() {
        return spazioArchiviazione;
    }

    @Override
    public double leggiDisplay() {
        return display;
    }

    @Override
    public double leggiPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    @Override
    public double leggiPrezzoVendita() {
        return prezzoVendita;
    }

    @Override
    public int leggiId() {
        return id;
    }

    @Override
    public TipoDispositivo leggiTipoDispositivo() {
        return dispositivo;
    }

    @Override
    public TipoMemoriaArchiviazione leggiTipoMemoriaArchiviazione() {
        return tipoMemoriaArchiviazione;
    }

    @Override
    public String toString() {
        return "Smartphone : " +
                "produttore = " + produttore;
    }
}
