package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

public class Transaksi {
    private String kodeTransaksi;
    private String nis;
    private String kodeBuku;
    private String tglPinjam;
    private String batasKembali;
    private String status; // "0" untuk dipinjam, "1" untuk dikembalikan

    public Transaksi(String kodeTransaksi, String nis, String kodeBuku, String tglPinjam, String batasKembali, String status) {
        this.kodeTransaksi = kodeTransaksi;
        this.nis = nis;
        this.kodeBuku = kodeBuku;
        this.tglPinjam = tglPinjam;
        this.batasKembali = batasKembali;
        this.status = status;
    }

    public String toCSV() {
        return kodeTransaksi + "," + nis + "," + kodeBuku + "," + tglPinjam + "," + batasKembali + "," + status;
    }
}