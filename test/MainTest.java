import org.junit.Test;
import java.util.UUID;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testAggiungiProdotto() {

        Magazzino magazzino = new Magazzino();
        Notebook notebook = new Notebook(TipoDispositivo.NOTEBOOK, "Intel", "Chuwi", "Ciao2", 15.4, TipoMemoriaArchiviazione.HDD, 512, 269.99, 599.99, UUID.randomUUID());

        assertTrue(magazzino.aggiungiProdotto(notebook));
    }
}