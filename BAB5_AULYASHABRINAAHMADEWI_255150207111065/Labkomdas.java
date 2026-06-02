package Praktikum_Pemrograman_Lanjut.BAB5_AULYASHABRINAAHMADEWI_255150207111065;

public class Labkomdas {
    private final int A = 100000;
    private final int B = 125000;
    private final int C = 175000;

    public void total(String tipe, int jumlah) {
        int hargaSatuan;
        int totalHarga;

        switch (tipe.toUpperCase()) {
            case "A":
                if (jumlah > 100) {
                    hargaSatuan = 95000;
                } else {
                    hargaSatuan = A;
                }
                break;

            case "B":
                if (jumlah > 100) {
                    hargaSatuan = 120000;
                } else {
                    hargaSatuan = B;
                }
                break;

            case "C":
                if (jumlah > 100) {
                    hargaSatuan = 160000;
                } else {
                    hargaSatuan = C;
                }
                break;

            default:
                System.out.println("Tipe jaket tidak tersedia.");
                return;
        }

        totalHarga = hargaSatuan * jumlah;
        System.out.println("Total harga untuk " + jumlah + " jaket tipe " + tipe + " adalah: " + totalHarga);
    }
}
