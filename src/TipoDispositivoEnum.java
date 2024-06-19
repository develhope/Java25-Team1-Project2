public enum TipoDispositivoEnum {
    // TODO spostare le info degli altri enum qui e unirli
    SMARTPHONE("Smartphone"),
    NOTEBOOK("Notebook"),
    TABLET("Tablet");

    private String descrizione;

    TipoDispositivoEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}

