package training.internet.banking.app;

import training.internet.banking.entity.Nasabah;
import training.internet.banking.helper.NasabahFileImporter;

import java.io.IOException;
import java.util.List;

public class NasabahApp {
    public static void main(String[] args) {
        NasabahFileImporter nfi = new NasabahFileImporter("src/main/resources/sample/file_input.txt");
        try {
            List<Nasabah> nasabahList = nfi.proses();
            System.out.println("\n \t Data hasil import sebanyak " + nasabahList.size());
            nasabahList.forEach(nasabah -> {
                System.out.println(
                        "nomor : " + nasabah.getNomor() +
                        ", nama : " + nasabah.getName() +
                        ", email : " + nasabah.getEmail());
            });
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
