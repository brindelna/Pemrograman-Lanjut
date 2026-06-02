package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

public class Siswa extends Orang {
    private String alamat;

    public Siswa(String nis, String nama, String alamat) {
        super(nis, nama);
        this.alamat = alamat;
    }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    @Override
    public String toCSV() {
        return id + "," + nama + "," + alamat;
    }
}
