package Praktikum_Pemrograman_Lanjut.BAB7_AULYASHABRINAAHMADEWI_255150207111065;

public class MainBab7 {
    public static void main(String[] args) {

        Kue[] kue = new Kue[20];

        kue[0]  = new KuePesanan("Lapis Legit",        15_000, 500);
        kue[1]  = new KuePesanan("Bolu Gulung",         8_000,  400);
        kue[2]  = new KuePesanan("Brownies Coklat",    12_000, 350);
        kue[3]  = new KuePesanan("Cheese Cake",        18_000, 600);
        kue[4]  = new KuePesanan("Red Velvet",         20_000, 450);
        kue[5]  = new KuePesanan("Kue Pelangi",        14_000, 500);
        kue[6]  = new KuePesanan("Tart Buah",          16_000, 550);
        kue[7]  = new KuePesanan("Opera Cake",         22_000, 400);
        kue[8]  = new KuePesanan("Chiffon Pandan",     10_000, 480);
        kue[9]  = new KuePesanan("Tiramisu",           25_000, 300);

        kue[10] = new KueJadi("Nastar",              5_000,  12);
        kue[11] = new KueJadi("Putri Salju",         4_500,  15);
        kue[12] = new KueJadi("Kastengel",           6_000,  10);
        kue[13] = new KueJadi("Kue Semprit",         3_500,  20);
        kue[14] = new KueJadi("Lidah Kucing",        4_000,  18);
        kue[15] = new KueJadi("Kue Kacang",          3_000,  25);
        kue[16] = new KueJadi("Sagu Keju",           5_500,  14);
        kue[17] = new KueJadi("Kue Madu",            4_800,  16);
        kue[18] = new KueJadi("Corn Flakes Cookies", 6_500,   8);
        kue[19] = new KueJadi("Chocolate Chip",      5_200,  11);

        System.out.println("=".repeat(125));
        System.out.printf("%n%60s%n", "DAFTAR SEMUA KUE");
        System.out.println("=".repeat(125));
        for (int i = 0; i < kue.length; i++) {
            System.out.printf("%2d. %s%n", i + 1, kue[i]);
        }

        double totalSemua = 0;
        for (Kue k : kue) totalSemua += k.hitungHarga();

        System.out.println("\n" + "=".repeat(125));
        System.out.printf("  TOTAL HARGA SEMUA KUE          : Rp %,.0f%n", totalSemua);

        double totalHargaPesanan = 0, totalBerat = 0;
        for (Kue k : kue) {
            if (k instanceof KuePesanan p) {          
                totalHargaPesanan += p.hitungHarga();
                totalBerat        += p.getBerat();
            }
        }
        System.out.println("-".repeat(125));
        System.out.printf("  [KuePesanan] Total Harga       : Rp %,.0f%n", totalHargaPesanan);
        System.out.printf("  [KuePesanan] Total Berat       : %.0f gram%n",  totalBerat);

        double totalHargaJadi = 0, totalJumlah = 0;
        for (Kue k : kue) {
            if (k instanceof KueJadi j) {
                totalHargaJadi += j.hitungHarga();
                totalJumlah    += j.getJumlah();
            }
        }
        System.out.println("-".repeat(125));
        System.out.printf("  [KueJadi   ] Total Harga       : Rp %,.0f%n", totalHargaJadi);
        System.out.printf("  [KueJadi   ] Total Jumlah      : %.0f biji%n",  totalJumlah);

        Kue kueMahal = kue[0];
        for (Kue k : kue) {
            if (k.hitungHarga() > kueMahal.hitungHarga()) kueMahal = k;
        }
        System.out.println("-".repeat(125));
        System.out.println("  KUE DENGAN HARGA TERBESAR      :");
        System.out.println("  " + kueMahal);
        System.out.println("=".repeat(125));
    }
}