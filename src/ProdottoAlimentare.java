public interface ProdottoAlimentare {

    boolean isDaFrigo();

    String getDataScadenza();

    String getMarca();

    void setDaFrigo(boolean daFrigo);

    void setDataScadenza(String dataScadenza);

    void setMarca(String marca);
}
