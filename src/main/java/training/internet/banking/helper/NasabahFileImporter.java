package training.internet.banking.helper;

import training.internet.banking.entity.Nasabah;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NasabahFileImporter {
	private File fileInput;
	private BufferedReader fileReader;

    public NasabahFileImporter(String namaFile) {
        this.fileInput = new File(namaFile);
    }

    public List<Nasabah> proses() throws IOException {

        openFile();
        String data = fileReader.readLine();
        System.out.println("Header : " +data);

        List<Nasabah> nasabahList = new ArrayList<Nasabah>();

        data = fileReader.readLine();

        while (data != null){
            String[] splitNasabah = data.split(",");
            if (splitNasabah.length != 3){
                throw new IllegalStateException("Format data salah, harusnya ada 3 data.");
            }
            nasabahList.add( new Nasabah(splitNasabah[0], splitNasabah[1], splitNasabah[2]));

            System.out.println("data : " + data);
            data = fileReader.readLine();

        }

        closeFile();
        return nasabahList;
    }

    public boolean openFile() throws FileNotFoundException {
        if (!fileInput.exists()){
            throw new FileNotFoundException("File tidak ditemukan");
        }else {
            fileReader = new BufferedReader(new FileReader(fileInput));
            return true;
        }
    }

    public boolean closeFile() throws IOException {
        if (fileReader != null){
            fileReader.close();
            return true;
        } else return false;
    }

}
