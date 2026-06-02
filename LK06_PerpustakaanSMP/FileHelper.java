package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

import java.io.*;

public class FileHelper {
    
    public static void inisialisasiFile(String folderPath, String[] files) {
        try {
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs(); 
            }
            for (String file : files) {
                File f = new File(file);
                if (f.createNewFile() && file.contains("pegawai")) {
                    System.out.println("[INFO] Sistem baru dijalankan. Silakan buat akun pegawai terlebih dahulu.");
                }
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat inisialisasi file: " + e.getMessage());
        }
    }

    public static void tulisKeFile(String namaFile, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis ke " + namaFile + ": " + e.getMessage());
        }
    }

    public static void cetakTabel(String namaFile, String judulLaporan, String[] headers, int[] widths) {
        System.out.println("\n--- " + judulLaporan + " ---");
        int totalWidth = 1; 
        for (int w : widths) {
            totalWidth += w + 3; 
        }

        StringBuilder border = new StringBuilder();
        for(int i = 0; i < totalWidth; i++) border.append("-");

        System.out.println(border);
        System.out.print("|");
        for (int i = 0; i < headers.length; i++) {
            System.out.printf(" %-" + widths[i] + "s |", headers[i]);
        }
        System.out.println("\n" + border);

        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            boolean kosong = true;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(",");
                System.out.print("|");
                for (int i = 0; i < widths.length; i++) {
                    String value = (i < data.length) ? data[i] : "-";
                    System.out.printf(" %-" + widths[i] + "s |", value);
                }
                System.out.println();
                kosong = false;
            }
            if (kosong) {
                System.out.printf("| %-" + (totalWidth - 4) + "s |\n", "(Data Kosong) Silakan tambah data terlebih dahulu.");
            }
        } catch (IOException e) {
            System.out.printf("| %-" + (totalWidth - 4) + "s |\n", "Terjadi kesalahan saat membaca file.");
        }
        System.out.println(border);
    }
}