import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testAggiungiProdotto() {

        Magazzino magazzino = new Magazzino();
        Notebook notebook = new Notebook(2, "Apple", "Macbook Pro", 16.0, 512, 2650.00, 3099.00, TipoMemoriaArchiviazione.SSD);

        List<Prodotti> listaProdotti = magazzino.aggiungiProdotto(notebook);
        assertTrue(listaProdotti.contains(notebook));
    }
}
