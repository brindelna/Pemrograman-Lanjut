package Praktikum_Pemrograman_Lanjut.BAB7_AULYASHABRINAAHMADEWI_255150207111065;

public class KuePesanan extends Kue {
    private double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    public double getBerat() { return berat; }

    @Override
    public double hitungHarga() {
        return getHarga() * berat;
    }

    @Override
    public String toString() {
        return String.format(
            "[KuePesanan] Nama: %-22s | Harga/gram: Rp %,8.0f | Berat : %4.0f gr   | Harga Akhir: Rp %,13.0f",
            getNama(), getHarga(), berat, hitungHarga()
        );
    }
}