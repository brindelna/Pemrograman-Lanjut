package Praktikum_Pemrograman_Lanjut.BAB5_AULYASHABRINAAHMADEWI_255150207111065;

import java.util.Scanner;

public class MainAritmatika {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("masukkan nilai 1 : ");
        int nil1 = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        int nil2 = in.nextInt();

        // memanggil method static
        Aritmatika.hitungPengurangan(nil1, nil2);

        System.out.print("masukkan nilai 1 : ");
        nil1 = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        nil2 = in.nextInt();

        // memanggil method static
        Aritmatika.hitungPerkalian(nil1, nil2);

        System.out.print("masukkan nilai 1 : ");
        int value1 = in.nextInt();
        System.out.print("masukkan nilai 2 : ");
        int value2 = in.nextInt();

        // memanggil method NON-static harus melalui objek
        Aritmatika a = new Aritmatika();
        a.hitungPenjumlahan(value1, value2);

        System.out.print("masukkan nilai 1 : ");
        String val = in.next();    
        System.out.print("masukkan nilai 2: ");
        String val2 = in.next();
        
        Aritmatika a2 = new Aritmatika();
        a2.hitungPembagian(val, val2);
    }
}