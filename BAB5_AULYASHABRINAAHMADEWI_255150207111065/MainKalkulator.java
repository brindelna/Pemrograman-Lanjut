package Praktikum_Pemrograman_Lanjut.BAB5_AULYASHABRINAAHMADEWI_255150207111065;
import java.util.Scanner;

public class MainKalkulator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("masukkan nilai 1 : ");
        int ajumlah = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        int bjumlah = in.nextInt();

        Kalkulator.penjumlahan(ajumlah, bjumlah);

        System.out.print("masukkan nilai 1 : ");
        int akurang = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        int bkurang = in.nextInt();

        Kalkulator.pengurangan(akurang, bkurang);

        System.out.print("masukkan nilai 1 : ");
        int akali = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        int bkali = in.nextInt();

        Kalkulator kkali = new Kalkulator();
        kkali.perkalian(akali, bkali);

        System.out.print("masukkan nilai 1 : ");
        int abagi = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        int bbagi = in.nextInt();

        Kalkulator kbagi = new Kalkulator();
        kbagi.pembagian(abagi, bbagi);

        System.out.print("masukkan pembilang : ");
        int pembilang = in.nextInt();   
        System.out.print("masukkan penyebut : ");
        int penyebut = in.nextInt();

        Kalkulator ksederhana = new Kalkulator();
        ksederhana.Sederhana(pembilang, penyebut);
    }
}
