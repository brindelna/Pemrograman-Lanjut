package Praktikum_Pemrograman_Lanjut.BAB3_AULYASHABRINAAHMADEWI_255150207111065;

import java.util.Arrays;
import java.io.*;
import java.nio.file.*;

class Buku {
    public String kategori; 
    public String namaBuku;
    public String[] namaPenulis;
    public String sinopsis;

    public Buku(String kategori, String namaBuku, String[] namaPenulis, String sinopsis) {
        this.kategori = kategori;
        this.namaBuku = namaBuku;
        this.namaPenulis = namaPenulis;
        this.sinopsis = sinopsis;
    }

    public void cetakData() {
        System.out.println("Kategori: " + this.kategori);
        System.out.println("Judul   : " + this.namaBuku);
        System.out.print("Penulis : ");
        for (String penulis : this.namaPenulis) System.out.print(penulis + " ");
        System.out.println("\nSinopsis: " + this.sinopsis);
    }

    public int hitungJumlahKata() {
        if (sinopsis == null || sinopsis.isEmpty()) return 0;
        String[] kata = sinopsis.trim().split("\\s+");
        return kata.length;
    }

    public double cekKesamaan(Buku other) {
        int sama = 0;
        if (this.kategori.equalsIgnoreCase(other.kategori)) sama++;
        if (this.namaBuku.equalsIgnoreCase(other.namaBuku)) sama++;
        if (Arrays.equals(this.namaPenulis, other.namaPenulis)) sama++;
        if (this.sinopsis.equalsIgnoreCase(other.sinopsis)) sama++;
        return (sama * 100.0) / 4;
    }

    public Buku copy() {
        return new Buku(this.kategori, this.namaBuku, Arrays.copyOf(this.namaPenulis, this.namaPenulis.length), this.sinopsis);
    }

    public void simpanFile(String namaFile) {
        try {
            String konten = kategori + "; " + namaBuku + "; " + String.join(",", namaPenulis) + "; " + sinopsis;
            Files.writeString(Path.of(namaFile), konten);
            System.out.println("Data berhasil disimpan ke file: " + namaFile);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }

    public void bacaFile(String pathFile) {
        try {
            String content = Files.readString(Path.of(pathFile));
            String[] lines = content.trim().split(";");
            this.kategori = lines[0].trim();
            this.namaBuku = lines[1].trim();
            this.namaPenulis = lines[2].trim().split(",");
            this.sinopsis = lines.length > 3 ? lines[3].trim() : "";
            System.out.println("Data berhasil dibaca dari file: " + pathFile);
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }

    public double hitungRoyalti(double hargaBuku) { return hargaBuku * 0.1; }
    public double hitungRoyalti(double hargaBuku, double persen) { return hargaBuku * (persen / 100); }
}

public class MainBuku {
    public static void main(String[] args) {

        System.out.println("\n=== Data Buku Teknologi ===");
        Buku t1 = new Buku("Teknologi", "Teknologi 1", new String[]{"Penulis 1", "Penulis 2"}, "Buku ini membahas perkembangan teknologi modern yang memengaruhi kehidupan manusia dalam berbagai aspek sehari-hari.");
        Buku t2 = new Buku("Teknologi", "Teknologi 2", new String[]{"Penulis 1", "Penulis 2"}, "Sinopsis ini menjelaskan dampak teknologi terhadap dunia pendidikan, industri, serta perubahan sosial masyarakat modern.");
        t1.cetakData();
        System.out.println("Jumlah kata sinopsis: " + t1.hitungJumlahKata() + "\n");
        t2.cetakData();
        System.out.println("Jumlah kata sinopsis: " + t2.hitungJumlahKata() + "\n");
        System.out.println("Kesamaan t1 dan t2: " + t1.cekKesamaan(t2) + "%");
        Buku t3 = t1.copy();
        System.out.println("\nCopy dari t1");
        t3.cetakData();
        System.out.println();
        t1.simpanFile("Teknologi1.txt");
        Buku tBaru = new Buku("", "", new String[]{""}, "");
        tBaru.bacaFile("Teknologi1.txt");
        tBaru.cetakData();
        System.out.println("\nRoyalti (10%): " + t1.hitungRoyalti(50000));
        System.out.println("Royalti : " + t1.hitungRoyalti(50000, 20));

        System.out.println("\n=== Data Buku Filsafat ===");
        Buku fl1 = new Buku("Filsafat", "Filsafat 1", new String[]{"Penulis 1"}, "Buku ini membahas berbagai konsep dan teori dalam filsafat.");
        Buku fl2 = new Buku("Filsafat", "Filsafat 2", new String[]{"Penulis 2", "Penulis 3"}, "Sinopsis ini menjelaskan berbagai pandangan filsafat terhadap masalah-masalah etika dan moral.");
        fl1.cetakData();
        System.out.println("Jumlah kata sinopsis: " + fl1.hitungJumlahKata() + "\n");
        fl2.cetakData();
        System.out.println("Jumlah kata sinopsis: " + fl2.hitungJumlahKata() + "\n");
        System.out.println("Kesamaan fl1 dan fl2: " + fl1.cekKesamaan(fl2) + "%");
        Buku fl3 = fl1.copy();
        System.out.println("\nCopy dari fl1");
        fl3.cetakData();
        System.out.println();
        fl1.simpanFile("Filsafat1.txt");
        Buku flBaru = new Buku("", "", new String[]{""}, "");
        flBaru.bacaFile("Filsafat1.txt");
        flBaru.cetakData();
        System.out.println("\nRoyalti (10%): " + fl1.hitungRoyalti(50000));
        System.out.println("Royalti : " + fl1.hitungRoyalti(50000, 20));

        System.out.println("\n=== Data Buku Sejarah ===");
        Buku s1 = new Buku("Sejarah", "Sejarah 1", new String[]{"Penulis 1"}, "Buku ini mengulas perjalanan sejarah peradaban manusia dari masa prasejarah hingga era modern.");
        Buku s2 = new Buku("Sejarah", "Sejarah 2", new String[]{"Penulis 2", "Penulis 3"}, "Buku ini membahas sejarah kemerdekaan bangsa-bangsa Asia dan pengaruhnya terhadap dunia.");
        s1.cetakData();
        System.out.println("Jumlah kata sinopsis: " + s1.hitungJumlahKata() + "\n");
        s2.cetakData();
        System.out.println("Jumlah kata sinopsis: " + s2.hitungJumlahKata() + "\n");
        System.out.println("Kesamaan s1 dan s2: " + s1.cekKesamaan(s2) + "%");
        Buku s3 = s1.copy();
        System.out.println("\nCopy dari s1");
        s3.cetakData();
        System.out.println();
        s1.simpanFile("Sejarah1.txt");
        Buku sBaru = new Buku("", "", new String[]{""}, "");
        sBaru.bacaFile("Sejarah1.txt");
        sBaru.cetakData();
        System.out.println("\nRoyalti (10%): " + s1.hitungRoyalti(50000));
        System.out.println("Royalti : " + s1.hitungRoyalti(50000, 20));

        System.out.println("\n=== Data Buku Agama ===");
        Buku a1 = new Buku("Agama", "Agama 1", new String[]{"Penulis 1"}, "Buku ini membahas nilai-nilai spiritual dan ajaran agama dalam kehidupan bermasyarakat.");
        Buku a2 = new Buku("Agama", "Agama 2", new String[]{"Penulis 2", "Penulis 3"}, "Buku ini menguraikan perbandingan ajaran berbagai agama besar di dunia secara objektif.");
        a1.cetakData();
        System.out.println("Jumlah kata sinopsis: " + a1.hitungJumlahKata() + "\n");
        a2.cetakData();
        System.out.println("Jumlah kata sinopsis: " + a2.hitungJumlahKata() + "\n");
        System.out.println("Kesamaan a1 dan a2: " + a1.cekKesamaan(a2) + "%");
        Buku a3 = a1.copy();
        System.out.println("\nCopy dari a1");
        a3.cetakData();
        System.out.println();
        a1.simpanFile("Agama1.txt");
        Buku aBaru = new Buku("", "", new String[]{""}, "");
        aBaru.bacaFile("Agama1.txt");
        aBaru.cetakData();
        System.out.println("\nRoyalti (10%): " + a1.hitungRoyalti(50000));
        System.out.println("Royalti : " + a1.hitungRoyalti(50000, 20));

        System.out.println("\n=== Data Buku Psikolog ===");
        Buku ps1 = new Buku("Psikolog", "Psikolog 1", new String[]{"Penulis 1"}, "Buku ini membahas dasar-dasar ilmu psikologi dan penerapannya dalam kehidupan sehari-hari.");
        Buku ps2 = new Buku("Psikolog", "Psikolog 2", new String[]{"Penulis 2", "Penulis 3"}, "Buku ini mengupas gangguan psikologis umum dan cara penanganannya secara klinis.");
        ps1.cetakData();
        System.out.println("Jumlah kata sinopsis: " + ps1.hitungJumlahKata() + "\n");
        ps2.cetakData();
        System.out.println("Jumlah kata sinopsis: " + ps2.hitungJumlahKata() + "\n");
        System.out.println("Kesamaan ps1 dan ps2: " + ps1.cekKesamaan(ps2) + "%");
        Buku ps3 = ps1.copy();
        System.out.println("\nCopy dari ps1");
        ps3.cetakData();
        System.out.println();
        ps1.simpanFile("Psikolog1.txt");
        Buku psBaru = new Buku("", "", new String[]{""}, "");
        psBaru.bacaFile("Psikolog1.txt");
        psBaru.cetakData();
        System.out.println("\nRoyalti (10%): " + ps1.hitungRoyalti(50000));
        System.out.println("Royalti : " + ps1.hitungRoyalti(50000, 20));

        System.out.println("\n=== Data Buku Politik ===");
        Buku pl1 = new Buku("Politik", "Politik 1", new String[]{"Penulis 1"}, "Buku ini membahas sistem pemerintahan dan dinamika politik di berbagai negara dunia.");
        Buku pl2 = new Buku("Politik", "Politik 2", new String[]{"Penulis 2", "Penulis 3"}, "Buku ini menganalisis pengaruh kekuatan politik global terhadap stabilitas ekonomi dan sosial.");
        pl1.cetakData();
        System.out.println("Jumlah kata sinopsis: " + pl1.hitungJumlahKata() + "\n");
        pl2.cetakData();
        System.out.println("Jumlah kata sinopsis: " + pl2.hitungJumlahKata() + "\n");
        System.out.println("Kesamaan pl1 dan pl2: " + pl1.cekKesamaan(pl2) + "%");
        Buku pl3 = pl1.copy();
        System.out.println("\nCopy dari pl1");
        pl3.cetakData();
        System.out.println();
        pl1.simpanFile("Politik1.txt");
        Buku plBaru = new Buku("", "", new String[]{""}, "");
        plBaru.bacaFile("Politik1.txt");
        plBaru.cetakData();
        System.out.println("\nRoyalti (10%): " + pl1.hitungRoyalti(50000));
        System.out.println("Royalti : " + pl1.hitungRoyalti(50000, 20));

        System.out.println("\n=== Data Buku Fiksi ===");
        Buku fk1 = new Buku("Fiksi", "Fiksi 1", new String[]{"Penulis 1"}, "Buku ini mengisahkan petualangan seorang pahlawan muda dalam dunia fantasi penuh misteri dan bahaya.");
        Buku fk2 = new Buku("Fiksi", "Fiksi 2", new String[]{"Penulis 2", "Penulis 3"}, "Buku ini menceritakan kisah cinta yang terjalin di tengah konflik antargalaksi di masa depan.");
        fk1.cetakData();
        System.out.println("Jumlah kata sinopsis: " + fk1.hitungJumlahKata() + "\n");
        fk2.cetakData();
        System.out.println("Jumlah kata sinopsis: " + fk2.hitungJumlahKata() + "\n");
        System.out.println("Kesamaan fk1 dan fk2: " + fk1.cekKesamaan(fk2) + "%");
        Buku fk3 = fk1.copy();
        System.out.println("\nCopy dari fk1");
        fk3.cetakData();
        System.out.println();
        fk1.simpanFile("Fiksi1.txt");
        Buku fkBaru = new Buku("", "", new String[]{""}, "");
        fkBaru.bacaFile("Fiksi1.txt");
        fkBaru.cetakData();
        System.out.println("\nRoyalti (10%): " + fk1.hitungRoyalti(50000));
        System.out.println("Royalti : " + fk1.hitungRoyalti(50000, 20));
    }
}