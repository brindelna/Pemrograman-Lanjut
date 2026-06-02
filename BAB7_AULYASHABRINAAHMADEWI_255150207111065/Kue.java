package Praktikum_Pemrograman_Lanjut.BAB7_AULYASHABRINAAHMADEWI_255150207111065;

public abstract class Kue {
    private String nama;
    private double harga;

    public Kue(String nama, double harga) {
        this.nama  = nama;
        this.harga = harga;
    }

    public String getNama()  { return nama;  }
    public double getHarga() { return harga; }

    public abstract double hitungHarga();

    @Override
    public String toString() {
        return String.format("Nama: %-22s | Harga Akhir: Rp %,12.0f", nama, hitungHarga());
    }
}