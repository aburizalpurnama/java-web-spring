import org.junit.jupiter.api.Test;
import training.internet.banking.entity.Nasabah;
import training.internet.banking.helper.NasabahFileImporter;

import java.io.IOException;
import java.util.List;

class NasabahTest {

    @Test
    void testProses() {
        NasabahFileImporter nfi = new NasabahFileImporter("src/main/resources/sample/file_input.txt");
        try {
            List<Nasabah> nasabahList = nfi.proses();
            System.out.println(nasabahList);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}