package Praktikum_Pemrograman_Lanjut.BAB7_AULYASHABRINAAHMADEWI_255150207111065;

public class KueJadi extends Kue {
    private double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double getJumlah() { return jumlah; }

    @Override
    public double hitungHarga() {
        return getHarga() * jumlah * 2;
    }

    @Override
    public String toString() {
        //  Semua lebar kolom identik dengan KuePesanan:
        //  "Harga/biji" = 10 char ✓   "Jumlah: " = 8 char ✓   "biji " = 5 char ✓
        return String.format(
            "[KueJadi   ] Nama: %-22s | Harga/biji: Rp %,8.0f | Jumlah: %4.0f biji | Harga Akhir: Rp %,13.0f",
            getNama(), getHarga(), jumlah, hitungHarga()
        );
    }
}