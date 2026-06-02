package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

public class Pegawai extends Pengguna {
    private String password;
    private String tanggalLahir;

    public Pegawai(String nip, String nama, String password, String tanggalLahir) {
        super(nip, nama);
        this.password = password;
        this.tanggalLahir = tanggalLahir;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(String tanggalLahir) { this.tanggalLahir = tanggalLahir; }

    @Override
    public String toCSV() {
        return id + "," + nama + "," + password + "," + tanggalLahir;
    }
}