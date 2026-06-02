package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

public class Transaksi {
    private String kodeTrx;
    private String nis;
    private String kodeBuku;
    private String tglPinjam;
    private String tglKembali;
    private String status; // "0" belum kembali, "1" sudah kembali

    public Transaksi(String kodeTrx, String nis, String kodeBuku, String tglPinjam, String tglKembali, String status) {
        this.kodeTrx = kodeTrx;
        this.nis = nis;
        this.kodeBuku = kodeBuku;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.status = status;
    }

    public String getKodeTrx() { return kodeTrx; }
    public String getNis() { return nis; }
    public String getKodeBuku() { return kodeBuku; }
    public String getTglPinjam() { return tglPinjam; }
    public String getTglKembali() { return tglKembali; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String toCSV() {
        return kodeTrx + "," + nis + "," + kodeBuku + "," + tglPinjam + "," + tglKembali + "," + status;
    }
}