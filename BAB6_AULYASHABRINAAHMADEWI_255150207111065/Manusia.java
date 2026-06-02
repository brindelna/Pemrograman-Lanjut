package Praktikum_Pemrograman_Lanjut.BAB6_AULYASHABRINAAHMADEWI_255150207111065;

public class Manusia {
    private String nama;
    private boolean jenisKelamin;
    private String nik;
    private boolean menikah;

    public Manusia(String nama, boolean jenisKelamin, String nik, boolean menikah) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
        this.menikah = menikah;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public boolean getJenisKelamin() {
        return jenisKelamin;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setMenikah(boolean menikah) {
        this.menikah = menikah;
    }

    public boolean getMenikah() {
        return menikah;
    }

    public double getTunjangan() {
        if(menikah && jenisKelamin) {
            return 25;
        }
        else if(menikah && !jenisKelamin) {
            return 20;
        }
        else {
            return 15;
        }
    }

    public double getPendapatan() {
        return getTunjangan();
    }

    @Override  
    public String toString() {
        String jenisKelamin = (getJenisKelamin()) ? "Laki-Laki" : "Perempuan";
        return String.format("%-20s: %s\n%-20s: %s\n%-20s: %s\n%-20s: $%.2f", "Nama", nama, "Jenis Kelamin", jenisKelamin, "NIK", nik, "Pendapatan", getPendapatan());
    }
}
