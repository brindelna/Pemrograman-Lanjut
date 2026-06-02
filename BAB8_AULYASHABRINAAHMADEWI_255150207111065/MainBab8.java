package Praktikum_Pemrograman_Lanjut.BAB8_AULYASHABRINAAHMADEWI_255150207111065;

public class MainBab8 {
    public static void main(String[] args) {
        Invoice[] belanjaan = {
            new Invoice("Beras 5kg", 2, 75000),
            new Invoice("Minyak Goreng", 3, 20000),
            new Invoice("Gula Pasir", 1, 15000)
        };

        // Membuat objek karyawan
        Employee rina = new Employee(255150, "Aulya Shabrina", 5000000, belanjaan);

        // Menampilkan informasi secara lengkap
        System.out.println("======= SISTEM PENGGAJIAN NV. MENEER =======");
        rina.tampilkanDetailKaryawan();
    }
}