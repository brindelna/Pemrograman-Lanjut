package Praktikum_Pemrograman_Lanjut.BAB10_AULYASHABRINAAHMADEWI_255150207111065;

import java.io.File;

public class Bab10No3 {
    public static void main(String[] args) {
        var dir = new File("D:\\OneDrive\\Documents\\Coding");

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null && files.length > 0) {
                System.out.println("Daftar file dalam direktori: " + dir.getAbsolutePath());
                System.out.println("=".repeat(50));

                int count = 0;
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("[FILE] " + file.getName());
                        count++;
                    } else if (file.isDirectory()) {
                        System.out.println("[DIR]  " + file.getName());
                    }
                }

                System.out.println("=".repeat(50));
                System.out.println("Total file ditemukan: " + count);
            } else {
                System.out.println("Direktori kosong.");
            }
        } else {
            System.out.println("Direktori tidak ditemukan.");
        }
    }
}