package Praktikum_Pemrograman_Lanjut.BAB6_AULYASHABRINAAHMADEWI_255150207111065;

import java.time.LocalDate;
import java.time.Period;

public class Manager extends Pekerja {
    private String departemen;

    public Manager(String nama, boolean jenisKelamin, String nik, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak, String departemen) {
        super(nama, jenisKelamin, nik, menikah, gaji, tahunMasuk, jumlahAnak);
        this.departemen = departemen;
    }  
    
    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + (0.10 * getGaji());
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +String.format("%-20s: %s", "Departemen", getDepartemen());
    }
}
