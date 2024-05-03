public abstract class Prodotti implements Attributi {
    protected int id;
    protected TipoDispositivo tipoDispositivo;

    public Prodotti(TipoDispositivo tipoDispositivo, int id) {
        this.tipoDispositivo = tipoDispositivo;
        this.id = id;
    }

    @Override
    public int leggiId() {
        return id;
    }

    @Override
    public TipoDispositivo leggiTipoDispositivo() {
        return tipoDispositivo;
    }
}