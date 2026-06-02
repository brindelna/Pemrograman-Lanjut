package Praktikum_Pemrograman_Lanjut.BAB11_AULYASHABRINAAHMADEWI_255150207111065;

import java.util.*;

class Player {
    String team;
    int no;
    int tinggiBadan;
    int beratBadan;

    public Player(String team, int no, int tinggiBadan, int beratBadan) {
        this.team = team;
        this.no = no;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    public String toString() {
        return "Tim " + team + " | No: " + no +
               " | Tinggi: " + tinggiBadan + " cm" +
               " | Berat: " + beratBadan + " kg";
    }
}

class SortByTinggiAsc implements Comparator<Player> {
    public int compare(Player a, Player b) {
        return a.tinggiBadan - b.tinggiBadan;
    }
}

class SortByTinggiDesc implements Comparator<Player> {
    public int compare(Player a, Player b) {
        return b.tinggiBadan - a.tinggiBadan;
    }
}

class SortByBeratAsc implements Comparator<Player> {
    public int compare(Player a, Player b) {
        return a.beratBadan - b.beratBadan;
    }
}

class SortByBeratDesc implements Comparator<Player> {
    public int compare(Player a, Player b) {
        return b.beratBadan - a.beratBadan;
    }
}

public class Bab11No1 {

    public static void main(String[] args) {

        ArrayList<Player> timA = new ArrayList<>();
        timA.add(new Player("A", 1, 168, 50));
        timA.add(new Player("A", 2, 170, 60));
        timA.add(new Player("A", 3, 165, 56));
        timA.add(new Player("A", 4, 168, 55));
        timA.add(new Player("A", 5, 172, 60));
        timA.add(new Player("A", 6, 170, 70));
        timA.add(new Player("A", 7, 169, 66));
        timA.add(new Player("A", 8, 165, 56));
        timA.add(new Player("A", 9, 171, 72));
        timA.add(new Player("A", 10, 166, 56));

        ArrayList<Player> timB = new ArrayList<>();
        timB.add(new Player("B", 1, 170, 66));
        timB.add(new Player("B", 2, 167, 60));
        timB.add(new Player("B", 3, 165, 59));
        timB.add(new Player("B", 4, 166, 58));
        timB.add(new Player("B", 5, 168, 58));
        timB.add(new Player("B", 6, 175, 71));
        timB.add(new Player("B", 7, 172, 68));
        timB.add(new Player("B", 8, 171, 68));
        timB.add(new Player("B", 9, 168, 65));
        timB.add(new Player("B", 10, 169, 60));

        ArrayList<Player> semuaPemain = new ArrayList<>();
        semuaPemain.addAll(timA);
        semuaPemain.addAll(timB);

        System.out.println("=== a. SORT BERDASARKAN TINGGI BADAN ===");

        Collections.sort(semuaPemain, new SortByTinggiAsc());
        System.out.println("\n-- Ascending (Menaik) --");
        for (Player p : semuaPemain) System.out.println(p);

        Collections.sort(semuaPemain, new SortByTinggiDesc());
        System.out.println("\n-- Descending (Menurun) --");
        for (Player p : semuaPemain) System.out.println(p);

        System.out.println("\n=== b. SORT BERDASARKAN BERAT BADAN ===");

        Collections.sort(semuaPemain, new SortByBeratAsc());
        System.out.println("\n-- Ascending (Menaik) --");
        for (Player p : semuaPemain) System.out.println(p);

        Collections.sort(semuaPemain, new SortByBeratDesc());
        System.out.println("\n-- Descending (Menurun) --");
        for (Player p : semuaPemain) System.out.println(p);

        System.out.println("\n=== c. NILAI MAKSIMUM DAN MINIMUM ===");

        Player maxTinggiA = Collections.max(timA, new SortByTinggiAsc());
        Player minTinggiA = Collections.min(timA, new SortByTinggiAsc());
        Player maxBeratA  = Collections.max(timA, new SortByBeratAsc());
        Player minBeratA  = Collections.min(timA, new SortByBeratAsc());

        System.out.println("\n-- Tim A --");
        System.out.println("Tinggi Max : " + maxTinggiA.tinggiBadan + " cm (Pemain No " + maxTinggiA.no + ")");
        System.out.println("Tinggi Min : " + minTinggiA.tinggiBadan + " cm (Pemain No " + minTinggiA.no + ")");
        System.out.println("Berat Max  : " + maxBeratA.beratBadan  + " kg (Pemain No " + maxBeratA.no  + ")");
        System.out.println("Berat Min  : " + minBeratA.beratBadan  + " kg (Pemain No " + minBeratA.no  + ")");

        Player maxTinggiB = Collections.max(timB, new SortByTinggiAsc());
        Player minTinggiB = Collections.min(timB, new SortByTinggiAsc());
        Player maxBeratB  = Collections.max(timB, new SortByBeratAsc());
        Player minBeratB  = Collections.min(timB, new SortByBeratAsc());

        System.out.println("\n-- Tim B --");
        System.out.println("Tinggi Max : " + maxTinggiB.tinggiBadan + " cm (Pemain No " + maxTinggiB.no + ")");
        System.out.println("Tinggi Min : " + minTinggiB.tinggiBadan + " cm (Pemain No " + minTinggiB.no + ")");
        System.out.println("Berat Max  : " + maxBeratB.beratBadan  + " kg (Pemain No " + maxBeratB.no  + ")");
        System.out.println("Berat Min  : " + minBeratB.beratBadan  + " kg (Pemain No " + minBeratB.no  + ")");

        System.out.println("\n=== d. COPY TIM B KE TIM C ===");
        ArrayList<Player> timC = new ArrayList<>();
        Collections.copy(new ArrayList<>(Collections.nCopies(timB.size(), (Player)null)), timB);
        timC.addAll(timB);

        for (Player p : timC) p.team = "C";

        System.out.println("\n-- Anggota Tim C (copy dari Tim B) --");
        for (Player p : timC) System.out.println(p);
    }
}