package Praktikum_Pemrograman_Lanjut.BAB6_AULYASHABRINAAHMADEWI_255150207111065;

import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, boolean jenisKelamin, String nik, boolean menikah, double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, jenisKelamin, nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    } 

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public double getGaji() {
        return gaji;
    }

    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public double getBonus() {
        int lamaBekerja = Period.between(tahunMasuk, LocalDate.now()).getYears();
        if (lamaBekerja <=5) {
            return 0.05 * getGaji();
        } else if (lamaBekerja > 5 && lamaBekerja <= 10) {
            return 0.1 * getGaji();
        } else if (lamaBekerja >  10) {
            return 0.15 * getGaji();
        } else {
            return 0;
        }
    } 
    
    @Override
    public double getPendapatan() {
        return super.getPendapatan() + gaji + getBonus() + (jumlahAnak * 20.0);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" + String.format("%-20s: $%.2f\n%-20s: %s\n%-20s: %d", "Gaji", gaji, "Tahun Masuk", tahunMasuk, "Jumlah Anak", jumlahAnak);
    }
}
