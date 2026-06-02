package Praktikum_Pemrograman_Lanjut.BAB1_AULYASHABRINAAHMADEWI_255150207111065;

class Teknologi {
    public String namaBuku;
    public String[] namaPenulis;

    public Teknologi(String namaBuku, String[] namaPenulis) {
        this.namaBuku = namaBuku;
        this.namaPenulis = namaPenulis;
    }

    public void cetakData() {
        System.out.println("Judul   : " + this.namaBuku);
        System.out.print("Penulis : ");
        for (String penulis : this.namaPenulis) {
            System.out.print(penulis + " ");
        }
        System.out.println("\n");
    }
}

class Filsafat {
    public String namaBuku;
    public String[] namaPenulis;

    public Filsafat(String namaBuku, String[] namaPenulis) {
        this.namaBuku = namaBuku;
        this.namaPenulis = namaPenulis;
    }

    public void cetakData() {
        System.out.println("Judul   : " + this.namaBuku);
        System.out.print("Penulis : ");
        for (String penulis : this.namaPenulis) {
            System.out.print(penulis + " ");
        }
        System.out.println("\n");
    }
}

class Sejarah {
    public String namaBuku;
    public String[] namaPenulis;

    public Sejarah(String namaBuku, String[] namaPenulis) {
        this.namaBuku = namaBuku;
        this.namaPenulis = namaPenulis;
    }

    public void cetakData() {
        System.out.println("Judul   : " + this.namaBuku);
        System.out.print("Penulis : ");
        for (String penulis : this.namaPenulis) {
            System.out.print(penulis + " ");
        }
        System.out.println("\n");
    }
}

class Agama {
    public String namaBuku;
    public String[] namaPenulis;

    public Agama(String namaBuku, String[] namaPenulis) {
        this.namaBuku = namaBuku;
        this.namaPenulis = namaPenulis;
    }

    public void cetakData() {
        System.out.println("Judul   : " + this.namaBuku);
        System.out.print("Penulis : ");
        for (String penulis : this.namaPenulis) {
            System.out.print(penulis + " ");
        }
        System.out.println("\n");
    }
}

class Psikolog {
    public String namaBuku;
    public String[] namaPenulis;

    public Psikolog(String namaBuku, String[] namaPenulis) {
        this.namaBuku = namaBuku;
        this.namaPenulis = namaPenulis;
    }

    public void cetakData() {
        System.out.println("Judul   : " + this.namaBuku);
        System.out.print("Penulis : ");
        for (String penulis : this.namaPenulis) {
            System.out.print(penulis + " ");
        }
        System.out.println("\n");
    }
}

class Politik {
    public String namaBuku;
    public String[] namaPenulis;

    public Politik(String namaBuku, String[] namaPenulis) {
        this.namaBuku = namaBuku;
        this.namaPenulis = namaPenulis;
    }

    public void cetakData() {
        System.out.println("Judul   : " + this.namaBuku);
        System.out.print("Penulis : ");
        for (String penulis : this.namaPenulis) {
            System.out.print(penulis + " ");
        }
        System.out.println("\n");
    }
}

class Fiksi {
    public String namaBuku;
    public String[] namaPenulis;

    public Fiksi(String namaBuku, String[] namaPenulis) {
        this.namaBuku = namaBuku;
        this.namaPenulis = namaPenulis;
    }

    public void cetakData() {
        System.out.println("Judul   : " + this.namaBuku);
        System.out.print("Penulis : ");
        for (String penulis : this.namaPenulis) {
            System.out.print(penulis + " ");
        }
        System.out.println("\n");
    }
}

public class pBuku {
    public static void main(String[] args) {
        System.out.println("=== Data Buku Teknologi ===");
        Teknologi t1 = new Teknologi("Teknologi 1", new String[]{"Penulis 1", "Penulis 2"});
        Teknologi t2 = new Teknologi("Teknologi 2", new String[]{"Penulis 1"});
        t1.cetakData();
        t2.cetakData();

        System.out.println("=== Data Buku Filsafat ===");
        Filsafat fl1 = new Filsafat("Filsafat 1", new String[]{"Penulis 1"});
        Filsafat fl2 = new Filsafat("Filsafat 2", new String[]{"Penulis 2", "Penulis 3"});
        fl1.cetakData();
        fl2.cetakData();

        System.out.println("=== Data Buku Sejarah ===");
        Sejarah s1 = new Sejarah("Sejarah 1", new String[]{"Penulis 1"});
        Sejarah s2 = new Sejarah("Sejarah 2", new String[]{"Penulis 2", "Penulis 3"});
        s1.cetakData();
        s2.cetakData();

        System.out.println("=== Data Buku Agama ===");
        Agama a1 = new Agama("Agama 1", new String[]{"Penulis 1"});
        Agama a2 = new Agama("Agama 2", new String[]{"Penulis 2", "Penulis 3"});
        a1.cetakData();
        a2.cetakData();

        System.out.println("=== Data Buku Psikolog ===");
        Psikolog ps1 = new Psikolog("Psikolog 1", new String[]{"Penulis 1"});
        Psikolog ps2 = new Psikolog("Psikolog 2", new String[]{"Penulis 2", "Penulis 3"});
        ps1.cetakData();
        ps2.cetakData();

        System.out.println("=== Data Buku Politik ===");
        Politik pl1 = new Politik("Politik 1", new String[]{"Penulis 1"});
        Politik pl2 = new Politik("Politik 2", new String[]{"Penulis 2", "Penulis 3"});
        pl1.cetakData();
        pl2.cetakData();

        System.out.println("=== Data Buku Fiksi ===");
        Fiksi fk1 = new Fiksi("Fiksi 1", new String[]{"Penulis 1"});
        Fiksi fk2 = new Fiksi("Fiksi 2", new String[]{"Penulis 2", "Penulis 3"});
        fk1.cetakData();
        fk2.cetakData();
    }
}