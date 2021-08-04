package training.internet.banking.entity;

public class Nasabah {

    public static Integer jumlahNasabah = 0;
    private String nomor;
    private String name;
    private String email;

    public Nasabah() {
        jumlahNasabah++;
    }

    public Nasabah(String nomor, String name, String email) {
        this.nomor = nomor;
        this.name = name;
        this.email = email;
        jumlahNasabah++;
    }

    public static void tampilkanJumlahNasabah(){
        System.out.println("Jumlah nasabah saat ini adalah : " + jumlahNasabah);
    }

    @Override
    public String toString() {
        return "Nasabah{" +
                "nomor='" + nomor + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName(){
        return this.name;
    }

    public static Integer getJumlahNasabah() {
        return jumlahNasabah;
    }

    public static void setJumlahNasabah(Integer jumlahNasabah) {
        Nasabah.jumlahNasabah = jumlahNasabah;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
