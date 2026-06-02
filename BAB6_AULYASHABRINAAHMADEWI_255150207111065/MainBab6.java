package Praktikum_Pemrograman_Lanjut.BAB6_AULYASHABRINAAHMADEWI_255150207111065;

import java.time.LocalDate;

public class MainBab6 {
    public static void main(String[] args) {
        System.out.println("=== TEST CASE: MANUSIA ===");
        Manusia m1 = new Manusia("Laki Menikah", true, "351111", true);
        System.out.println(m1 + "\n");
        
        Manusia m2 = new Manusia("Perempuan Menikah", false, "351112", true);
        System.out.println(m2 + "\n");
        
        Manusia m3 = new Manusia("Belum Menikah", true, "351113", false);
        System.out.println(m3 + "\n");


        System.out.println("=== TEST CASE: MAHASISWA FILKOM ===");
        MahasiswaFILKOM mhs1 = new MahasiswaFILKOM("Mhs Rendah", true, "351114", false, "255150207111065", 2.8);
        System.out.println(mhs1 + "\n");
        
        MahasiswaFILKOM mhs2 = new MahasiswaFILKOM("Mhs Sedang", false, "351115", false, "255150307111065", 3.2);
        System.out.println(mhs2 + "\n");
        
        MahasiswaFILKOM mhs3 = new MahasiswaFILKOM("Mhs Tinggi", true, "351116", false, "255150707111065", 3.9);
        System.out.println(mhs3 + "\n");

        System.out.println("=== TEST CASE: PEKERJA ===");
        Pekerja p1 = new Pekerja("Pekerja Baru", true, "351117", true, 1000, LocalDate.now().minusYears(2), 2);
        System.out.println(p1 + "\n");
        
        Pekerja p2 = new Pekerja("Pekerja Senior", true, "351118", true, 1000, LocalDate.now().minusYears(9), 0);
        System.out.println(p2 + "\n");
        
        Pekerja p3 = new Pekerja("Pekerja Veteran", true, "351119", true, 1000, LocalDate.now().minusYears(20), 10);
        System.out.println(p3 + "\n");

        System.out.println("=== TEST CASE: MANAGER ===");
        Manager mgr = new Manager("Steven", true, "351120", true, 2000, LocalDate.now().minusYears(15), 2, "IT");
        System.out.println(mgr + "\n");
    }
}