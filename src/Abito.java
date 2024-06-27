import java.math.BigDecimal;
import java.util.UUID;

public interface Abito {

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

