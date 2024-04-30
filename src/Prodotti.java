public class Prodotti {
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
}