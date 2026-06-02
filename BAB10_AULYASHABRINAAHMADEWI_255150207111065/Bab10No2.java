package Praktikum_Pemrograman_Lanjut.BAB10_AULYASHABRINAAHMADEWI_255150207111065;

import java.io.File;

public class Bab10No2 {
    public static void main(String[] args) {
        var file = new File("C:\\Users\\ZENBOOK\\Downloads\\Poster Extend Intriv.png");

        if (file.exists() && file.isFile()) {
            long bytes = file.length();
            long MB = 1024 * 1024;

            if (bytes < MB) {
                double kb = (double) bytes / 1024;
                System.out.printf("Ukuran file: %.2f KB%n", kb);
            } else {
                double mb = (double) bytes / MB;
                System.out.printf("Ukuran file: %.2f MB%n", mb);
            }
        } else {
            System.out.println("File tidak ditemukan.");
        }
    }
}