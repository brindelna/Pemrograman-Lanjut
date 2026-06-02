package Praktikum_Pemrograman_Lanjut.BAB2_AULYASHABRINAAHMADEWI_255150207111065;
import java.util.Arrays;

class Teknologi {
    public String namaBuku;
    public String[] namaPenulis;
    public String sinopsis;

    public Teknologi(String namaBuku, String[] namaPenulis, String sinopsis) {
        this.namaBuku = namaBuku;
        this.namaPenulis = namaPenulis;
        this.sinopsis = sinopsis;
    }

    public void cetakData() {
        System.out.println("Judul   : " + this.namaBuku);
        System.out.print("Penulis : ");
        for (String penulis : this.namaPenulis) {
            System.out.print(penulis + " ");
        }
        System.out.println("\nSinopsis: " + this.sinopsis);
    }

    public int hitungJumlahKata() {
        return sinopsis.trim().split("\\s+").length;
    }

    public double cekKesamaan(Teknologi other) {
        int atribut = 3;
        int sama = 0;
        if (this.namaBuku.equalsIgnoreCase(other.namaBuku)) sama++;
        if (Arrays.equals(this.namaPenulis, other.namaPenulis)) sama++;
        if (this.sinopsis.equalsIgnoreCase(other.sinopsis)) sama++;
        return (sama * 100.0) / atribut;
    }

    public Teknologi copy() {
        return new Teknologi(this.namaBuku, Arrays.copyOf(this.namaPenulis, this.namaPenulis.length), this.sinopsis);
    }
}

class Filsafat {
    public String namaBuku;
    public String[] namaPenulis;
        public String sinopsis;

        public Filsafat(String namaBuku, String[] namaPenulis, String sinopsis) {
            this.namaBuku = namaBuku;
            this.namaPenulis = namaPenulis;
            this.sinopsis = sinopsis;
        }

        public void cetakData() {
            System.out.println("Judul   : " + this.namaBuku);
            System.out.print("Penulis : ");
            for (String penulis : this.namaPenulis) {
                System.out.print(penulis + " ");
            }
            System.out.println("Sinopsis: " + this.sinopsis);
        }
        
    public int hitungJumlahKata() {
        return sinopsis.trim().split("\\s+").length;
    }

    public double cekKesamaan(Filsafat other) {
        int atribut = 3;
        int sama = 0;
        if (this.namaBuku.equalsIgnoreCase(other.namaBuku)) sama++;
        if (Arrays.equals(this.namaPenulis, other.namaPenulis)) sama++;
        if (this.sinopsis.equalsIgnoreCase(other.sinopsis)) sama++;
        return (sama * 100.0) / atribut;
    }

    public Filsafat copy() {
        return new Filsafat(this.namaBuku, Arrays.copyOf(this.namaPenulis, this.namaPenulis.length), this.sinopsis);
    }
}

public class MainBuku {
    public static void main(String[] args) {
        System.out.println("\n=== Data Buku Teknologi ===");
        Teknologi t1 = new Teknologi("Teknologi 1", new String[]{"Penulis 1", "Penulis 2"}, "Buku ini membahas perkembangan teknologi modern yang memengaruhi kehidupan manusia dalam berbagai aspek sehari-hari.");
        Teknologi t2 = new Teknologi("Teknologi 2", new String[]{"Penulis 1", "Penulis 2"}, "Sinopsis ini menjelaskan dampak teknologi terhadap dunia pendidikan, industri, serta perubahan sosial masyarakat modern.");
        t1.cetakData();
        System.out.println("Jumlah kata sinopsis: " + t1.hitungJumlahKata() + "\n");
        t2.cetakData();
        System.out.println("Jumlah kata sinopsis: " + t2.hitungJumlahKata() + "\n");
        System.out.println("Kesamaan t1 dan t2: " + t1.cekKesamaan(t2) + "%");
        Teknologi t3 = t1.copy();
        System.out.println("\nCopy dari t1");
        t3.cetakData();

        System.out.println("\n=== Data Buku Filsafat ===");
        Filsafat fl1 = new Filsafat("Filsafat 1", new String[]{"Penulis 1"}, "Buku ini membahas berbagai konsep dan teori dalam filsafat.");
        Filsafat fl2 = new Filsafat("Filsafat 2", new String[]{"Penulis 2", "Penulis 3"}, "Sinopsis ini menjelaskan berbagai pandangan filsafat terhadap masalah-masalah etika dan moral.");
        fl1.cetakData();
        System.out.println("Jumlah kata sinopsis: " + fl1.hitungJumlahKata() + "\n");
        fl2.cetakData();
        System.out.println("Jumlah kata sinopsis: " + fl2.hitungJumlahKata() + "\n");
        System.out.println("Kesamaan fl dan fl2: " + fl1.cekKesamaan(fl2) + "%");
        Filsafat fl3 = fl1.copy();
        System.out.println("\nCopy dari fl1");
        fl3.cetakData();
    }
}