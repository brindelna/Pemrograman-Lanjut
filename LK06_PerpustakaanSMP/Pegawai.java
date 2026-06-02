package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

public class Pegawai {
    private String nip;
    private String nama;
    private String password;
    private String tglLahir;

    public Pegawai(String nip, String nama, String password, String tglLahir) {
        this.nip = nip;
        this.nama = nama;
        this.password = password;
        this.tglLahir = tglLahir;
    }

    public String getNama() {
        return nama;
    }

    public String toCSV() {
        return nip + "," + nama + "," + password + "," + tglLahir;
    }
}