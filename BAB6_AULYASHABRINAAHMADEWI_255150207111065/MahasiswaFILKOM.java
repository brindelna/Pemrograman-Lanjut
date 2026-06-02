package Praktikum_Pemrograman_Lanjut.BAB6_AULYASHABRINAAHMADEWI_255150207111065;

public class MahasiswaFILKOM extends Manusia {
    private String nim;
    private double ipk;

    public MahasiswaFILKOM(String nama, boolean jenisKelamin, String nik, boolean menikah, String nim, double ipk) {
        super(nama, jenisKelamin, nik, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public double getIpk() {
        return ipk;
    }   

    public String getStatus() {
        String angkatan = nim.substring(0, 2); 
        String prodi = nim.substring(6, 7);
        if (prodi.equals("2")) {
            prodi = "Teknik Informatika";
        }
        else if (prodi.equals("3")) {
            prodi = "Teknik Komputer";
        }
        else if (prodi.equals("4")) {
            prodi = "Sistem Informasi";
        }
        else if (prodi.equals("6")) {
            prodi = "Pendidikan Teknologi Informasi";
        }
        else if (prodi.equals("7")) {
            prodi = "Teknologi Informasi";
        }
        else {
        }

        return prodi + ", 20" + angkatan; 
    }

    public double getBeasiswa() {
        if (ipk >= 3.0 && ipk < 3.5) {
            return 50.0;
        } else if (ipk >= 3.5 && ipk <= 4) {
            return 75.0;
        } else {
            return 0;
        }
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getBeasiswa();
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n" + String.format("%-20s: %s\n%-20s: %.2f\n%-20s: %s", "NIM", nim, "IPK", ipk, "Status", getStatus());
    }
}
