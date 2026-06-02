package Praktikum_Pemrograman_Lanjut.BAB5_AULYASHABRINAAHMADEWI_255150207111065;

public class Aritmatika {

    public void hitungPenjumlahan(int a, int b) {
        int nilai = a + b;
        System.out.println("nilai penjumlahan adalah : " + nilai);

        // hitungPerkalian(a, b);
    }

    public static void hitungPerkalian(int a, int b) {
        int nilai = a * b;
        System.out.println("nilai perkalian adalah : " + nilai);

        // hitungPenjumlahan(a, b);
    }

    public static void hitungPengurangan(int a, int b) {
        int nilai = a - b;
        System.out.println("nilai pengurangan adalah : " + nilai);
    }

    public double hitungPembagian(String nil, String nil2) {
        double a = Double.parseDouble(nil);
        double b = Double.parseDouble(nil2);
        if (b != 0) {
            double hasil = a / b;
            System.out.println("hasil pembagian adalah : " + hasil);
            return hasil;
        } else {
            System.out.println("Error: Pembagi tidak boleh nol");
            return 0; 
        }
    }
}