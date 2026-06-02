package Praktikum_Pemrograman_Lanjut.BAB10_AULYASHABRINAAHMADEWI_255150207111065;

import java.io.File;

public class Bab10No4 {
    public static void main(String[] args) {
        var dir = new File("D:\\OneDrive\\Documents\\Coding\\Praktikum_Pemrograman_Lanjut\\BAB10_AULYASHABRINAAHMADEWI_255150207111065\\tes.java");

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        var isDeleted = file.delete();
                        System.out.println((isDeleted ? "Berhasil" : "Gagal")
                                + " menghapus file: " + file.getName());
                    }
                }
            }

            var isDirDeleted = dir.delete();
            System.out.println("\n" + (isDirDeleted ? "Berhasil" : "Gagal")
                    + " menghapus direktori: " + dir.getName());
        } else {
            System.out.println("Direktori tidak ditemukan atau target bukanlah sebuah direktori..");
        }
    }
}