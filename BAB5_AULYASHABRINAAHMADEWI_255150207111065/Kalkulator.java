package Praktikum_Pemrograman_Lanjut.BAB5_AULYASHABRINAAHMADEWI_255150207111065;

public class Kalkulator {
    public static void penjumlahan(int a, int b) {
        int nilai = a + b;
        System.out.println("nilai penjumlahan adalah : " + nilai);
    }

    public static void pengurangan(int a, int b) {
        int nilai = a - b;
        System.out.println("nilai pengurangan adalah : " + nilai);
    }

    public void perkalian(int a, int b) {
        int nilai = a * b;
        System.out.println("nilai perkalian adalah : " + nilai);
    }

    public void pembagian(double a, double b) {
        if (b != 0) {
            System.out.println("nilai pembagian adalah : " + a / b);
        } else {
            System.out.println("Error: Pembagi tidak boleh nol");
        }
    }

    private int FPB (int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return FPB(b, a % b);
        }
    }

    public void Sederhana (int pembilang, int penyebut) {
        int fpb = FPB(pembilang, penyebut);
        System.out.println("Hasil penyederhanaan: " + (pembilang / fpb) + "/" + (penyebut / fpb));
    }
}
