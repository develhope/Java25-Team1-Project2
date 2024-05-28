import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class MainTest {
    private Magazzino magazzino;

    @BeforeEach
    public void setUp() {
        magazzino = new Magazzino();
    }

    @Test
    public void testCercaDispositiviPerTipoValidInput() throws Exception {
        String input = "SMARTPHONE\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            System.setIn(in);
            System.setOut(new PrintStream(out));

            Metodi.cercaDispositiviPerTipo(magazzino);

            String output = out.toString();
            assertTrue(output.contains("Prodotto{ tipoDispositivo=SMARTPHONE"));
            assertFalse(output.contains("Dispositivo non trovato."));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testCercaDispositiviPerTipoInvalidInput() throws Exception {
        String input = "INVALID\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            System.setIn(in);
            System.setOut(new PrintStream(out));

            Metodi.cercaDispositiviPerTipo(magazzino);

            String output = out.toString();
            assertTrue(output.contains("Tipo di dispositivo non valido."));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testCercaDispositiviPerTipoNoDispositiviTrovati() throws Exception {
        String input = "NOTEBOOK\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Magazzino emptyMagazzino = new Magazzino();
        emptyMagazzino.setInventario(new ArrayList<>()); // Assicurarsi che l'inventario sia vuoto

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            System.setIn(in);
            System.setOut(new PrintStream(out));

            Metodi.cercaDispositiviPerTipo(emptyMagazzino);

            String output = out.toString();
            assertTrue(output.contains("Dispositivo non trovato."));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testCercaDispositiviPerProduttoreInvalidInput() throws Exception {
        String input = "NonEsistente\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            System.setIn(in);
            System.setOut(new PrintStream(out));

            Metodi.cercaDispositiviPerProduttore(magazzino);

            String output = out.toString();
            assertTrue(output.contains("Produttore non trovato."));
            assertTrue(output.contains("Produttori già presenti nel magazzino:"));
            assertTrue(output.contains("Asus"));
            assertTrue(output.contains("Apple"));
            assertTrue(output.contains("Samsung"));
            assertTrue(output.contains("Acer"));
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}