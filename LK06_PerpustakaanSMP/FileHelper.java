package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    public static final String FILE_PEGAWAI = "Praktikum_Pemrograman_Lanjut\\LK06_PerpustakaanSMP\\pegawai.txt";
    public static final String FILE_SISWA = "Praktikum_Pemrograman_Lanjut\\LK06_PerpustakaanSMP\\siswa.txt";
    public static final String FILE_BUKU = "Praktikum_Pemrograman_Lanjut\\LK06_PerpustakaanSMP\\buku.txt";
    public static final String FILE_TRANSAKSI = "Praktikum_Pemrograman_Lanjut\\LK06_PerpustakaanSMP\\transaksi.txt";

    public static void inisialisasiFile() {
        try {
            File folder = new File("Praktikum_Pemrograman_Lanjut\\LK06_PerpustakaanSMP");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            if (new File(FILE_PEGAWAI).createNewFile()) {
                System.out.println("[INFO] Sistem baru dijalankan. Silakan buat akun pegawai terlebih dahulu.");
            }
            new File(FILE_SISWA).createNewFile();
            new File(FILE_BUKU).createNewFile();
            new File(FILE_TRANSAKSI).createNewFile();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat inisialisasi file: " + e.getMessage());
        }
    }

    public static List<String> bacaFile(String namaFile) {
        List<String> barisList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                barisList.add(baris);
            }
        } catch (IOException e) {
        }
        return barisList;
    }

    public static void tulisKeFile(String namaFile, String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile, true))) {
            bw.write(data);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis ke " + namaFile + ": " + e.getMessage());
        }
    }

    public static void simpanSemua(String namaFile, List<String> dataList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            for (String data : dataList) {
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat memperbarui file " + namaFile + ": " + e.getMessage());
        }
    }

    public static void cetakTabel(String namaFile, String judulLaporan, String[] headers, int[] widths) {
        System.out.println("\n--- " + judulLaporan + " ---");
        int totalWidth = 1;
        for (int w : widths) {
            totalWidth += w + 3;
        }

        StringBuilder border = new StringBuilder();
        for (int i = 0; i < totalWidth; i++) border.append("-");

        System.out.println(border);
        System.out.print("|");
        for (int i = 0; i < headers.length; i++) {
            System.out.printf(" %-" + widths[i] + "s |", headers[i]);
        }
        System.out.println("\n" + border);

        List<String> barisList = bacaFile(namaFile);
        if (barisList.isEmpty()) {
            System.out.printf("| %-" + (totalWidth - 4) + "s |\n", "(Data Kosong) Silakan tambah data terlebih dahulu.");
        } else {
            for (String baris : barisList) {
                String[] data = baris.split(",");
                System.out.print("|");
                for (int i = 0; i < widths.length; i++) {
                    String value = (i < data.length) ? data[i] : "-";
                    System.out.printf(" %-" + widths[i] + "s |", value);
                }
                System.out.println();
            }
        }
        System.out.println(border);
    }
}