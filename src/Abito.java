import java.math.BigDecimal;
import java.util.UUID;

public interface Abito {
    UUID getId();

    String getNome();

    String getDescrizione();

    BigDecimal getPrezzoVendita();

    ProdottoEnum getTipologiaProdotto();

    String getTaglia();

    String getColore();

    String getMateriale();

    boolean isLavaggioSecco();


    public interface ProdottoAbbigliamento extends Abito {
        String getTaglia();

        String getColore();

        String getMateriale();
    }

    public interface LavaggioSecco {
        boolean isLavaggioSecco();
    }
}

