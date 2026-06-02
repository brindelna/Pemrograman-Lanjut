package Praktikum_Pemrograman_Lanjut.BAB8_AULYASHABRINAAHMADEWI_255150207111065;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manusia m = new Manusia("Aulya Shabrina A", 18);
        m.tampilkanNama();
        m.tampilkanUmur();
        m.makan();
        m.berjalan();
        m.bersuara();

        System.out.println(); 

        Hewan h = new Hewan("Kucing", 2);
        h.tampilkanNama();
        h.tampilkanUmur();
        h.makan();
        h.berjalan();
        h.bersuara();  

        System.out.println(); 

        Tumbuhan t = new Tumbuhan("Pohon Mangga", 5);
        t.tampilkanNama();
        t.tampilkanUmur();
        t.makan();
        t.berjalan();
        t.bersuara();
    }
}