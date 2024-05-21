public enum SpazioDiArchiviazione {
    DUE(2),
    QUATTRO(4),
    OTTO(8),
    SEDICI(16),
    TRENTADUE(32),
    SESSANTAQUATTRO(64),
    CENTOVENTOTTO(128),
    DUECENTOCINQUANTASEI(256),
    CINQUECENTODODICI(512),
    MILLEVENTIQUATTRO(1024),
    DUEMILAQUARANTADUE(2042),
    TREMILA(3000),
    QUATROMILA(4000),
    CINQUEMILA(5000);



private final Integer valore;
SpazioDiArchiviazione(Integer valore){
    this.valore = valore;
}
    public int getValue() {
        return valore;
    }

    public static SpazioDiArchiviazione fromInt(Integer valore) {
        for (SpazioDiArchiviazione numero : values()) {
            if (numero.getValue() == valore) {
                return numero;
            }
        }
        throw new IllegalArgumentException("Nessun enum con questo valore: " + valore);
    }
}
