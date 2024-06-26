public interface ProdottoAlimentare {

   // TODO boolean piccolo
    boolean isDaFrigo();

    String getDataScadenza();

    String getMarca();

    void setDaFrigo(Boolean daFrigo);

    void setDataScadenza(String dataScadenza);

    void setMarca(String marca);
}
