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

public class Bab11No2 {

    public static int binarySearchTinggi(ArrayList<Player> list, int targetTinggi) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).tinggiBadan == targetTinggi) {
                return mid; 
            } else if (list.get(mid).tinggiBadan < targetTinggi) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; 
    }

    public static int binarySearchBerat(ArrayList<Player> list, int targetBerat) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).beratBadan == targetBerat) {
                return mid;
            } else if (list.get(mid).beratBadan < targetBerat) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int countByTinggi(ArrayList<Player> list, int target) {
        int idx = binarySearchTinggi(list, target);
        if (idx == -1) return 0;

        int count = 1;
        int i = idx - 1;
        while (i >= 0 && list.get(i).tinggiBadan == target) { count++; i--; }
        i = idx + 1;
        while (i < list.size() && list.get(i).tinggiBadan == target) { count++; i++; }
        return count;
    }

    public static int countByBerat(ArrayList<Player> list, int target) {
        int idx = binarySearchBerat(list, target);
        if (idx == -1) return 0;

        int count = 1;
        int i = idx - 1;
        while (i >= 0 && list.get(i).beratBadan == target) { count++; i--; }
        i = idx + 1;
        while (i < list.size() && list.get(i).beratBadan == target) { count++; i++; }
        return count;
    }

    public static void main(String[] args) {

        ArrayList<Player> timA = new ArrayList<>();
        timA.add(new Player("A", 1,  168, 50));
        timA.add(new Player("A", 2,  170, 60));
        timA.add(new Player("A", 3,  165, 56));
        timA.add(new Player("A", 4,  168, 55));
        timA.add(new Player("A", 5,  172, 60));
        timA.add(new Player("A", 6,  170, 70));
        timA.add(new Player("A", 7,  169, 66));
        timA.add(new Player("A", 8,  165, 56));
        timA.add(new Player("A", 9,  171, 72));
        timA.add(new Player("A", 10, 166, 56));

        ArrayList<Player> timB = new ArrayList<>();
        timB.add(new Player("B", 1,  170, 66));
        timB.add(new Player("B", 2,  167, 60));
        timB.add(new Player("B", 3,  165, 59));
        timB.add(new Player("B", 4,  166, 58));
        timB.add(new Player("B", 5,  168, 58));
        timB.add(new Player("B", 6,  175, 71));
        timB.add(new Player("B", 7,  172, 68));
        timB.add(new Player("B", 8,  171, 68));
        timB.add(new Player("B", 9,  168, 65));
        timB.add(new Player("B", 10, 169, 60));

        Collections.sort(timA, (a, b) -> a.tinggiBadan - b.tinggiBadan);
        Collections.sort(timB, (a, b) -> a.tinggiBadan - b.tinggiBadan);

        ArrayList<Player> timA_sortBerat = new ArrayList<>(timA);
        Collections.sort(timA_sortBerat, (a, b) -> a.beratBadan - b.beratBadan);

        System.out.println("=== b. PENCARIAN TINGGI BADAN TIM B ===");

        int jmlTinggi168B = countByTinggi(timB, 168);
        int idxTinggi168B = binarySearchTinggi(timB, 168);
        if (idxTinggi168B != -1) {
            System.out.println("Tinggi 168 cm -> DITEMUKAN, jumlah pemain: " + jmlTinggi168B + " orang");
        } else {
            System.out.println("Tinggi 168 cm -> TIDAK DITEMUKAN di Tim B");
        }

        int jmlTinggi160B = countByTinggi(timB, 160);
        int idxTinggi160B = binarySearchTinggi(timB, 160);
        if (idxTinggi160B != -1) {
            System.out.println("Tinggi 160 cm -> DITEMUKAN, jumlah pemain: " + jmlTinggi160B + " orang");
        } else {
            System.out.println("Tinggi 160 cm -> TIDAK DITEMUKAN di Tim B");
        }

        System.out.println("\n=== c. PENCARIAN BERAT BADAN TIM A ===");

        int jmlBerat56A = countByBerat(timA_sortBerat, 56);
        int idxBerat56A = binarySearchBerat(timA_sortBerat, 56);
        if (idxBerat56A != -1) {
            System.out.println("Berat 56 kg -> DITEMUKAN, jumlah pemain: " + jmlBerat56A + " orang");
        } else {
            System.out.println("Berat 56 kg -> TIDAK DITEMUKAN di Tim A");
        }

        int jmlBerat53A = countByBerat(timA_sortBerat, 53);
        int idxBerat53A = binarySearchBerat(timA_sortBerat, 53);
        if (idxBerat53A != -1) {
            System.out.println("Berat 53 kg -> DITEMUKAN, jumlah pemain: " + jmlBerat53A + " orang");
        } else {
            System.out.println("Berat 53 kg -> TIDAK DITEMUKAN di Tim A");
        }

        System.out.println("\n=== d. PEMAIN TIM A YANG SAMA TINGGI/BERAT DENGAN TIM B ===");

        boolean adaKesamaan = false;

        for (Player pb : timB) {
            int idxT = binarySearchTinggi(timA, pb.tinggiBadan);
            if (idxT != -1) {
                System.out.println("[TINGGI SAMA] Tim B No." + pb.no +
                    " (tinggi " + pb.tinggiBadan + " cm) == Tim A No." + timA.get(idxT).no);
                adaKesamaan = true;
            }

            int idxB = binarySearchBerat(timA_sortBerat, pb.beratBadan);
            if (idxB != -1) {
                System.out.println("[BERAT SAMA ] Tim B No." + pb.no +
                    " (berat " + pb.beratBadan + " kg) == Tim A No." + timA_sortBerat.get(idxB).no);
                adaKesamaan = true;
            }
        }

        if (!adaKesamaan) {
            System.out.println("Tidak ada pemain Tim A yang memiliki tinggi/berat sama dengan Tim B.");
        }
    }
}