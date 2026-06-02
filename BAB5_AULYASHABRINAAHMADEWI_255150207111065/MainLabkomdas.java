package Praktikum_Pemrograman_Lanjut.BAB5_AULYASHABRINAAHMADEWI_255150207111065;
import java.util.Scanner;

public class MainLabkomdas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Labkomdas jaket = new Labkomdas();

        System.out.print("masukkan tipe jaket : ");
        String tipe = in.nextLine();
        System.out.print("masukkan jumlah jaket : ");
        int jumlah = in.nextInt();
        jaket.total(tipe, jumlah);
    }
}
