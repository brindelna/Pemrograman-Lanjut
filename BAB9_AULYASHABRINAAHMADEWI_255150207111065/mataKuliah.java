package Praktikum_Pemrograman_Lanjut.BAB9_AULYASHABRINAAHMADEWI_255150207111065;

public abstract class mataKuliah {
    protected String nama;
    protected double tugas, kuis, uts, uas;
    protected double nilaiAkhir;
 
    public mataKuliah(String nama) {
        this.nama = nama;
    }
 
    public void setNilai(double tugas, double kuis, double uts, double uas) {
        this.tugas  = tugas;
        this.kuis   = kuis;
        this.uts    = uts;
        this.uas    = uas;
    }
 
    public abstract double hitungNilaiAkhir();
 
    public String getNama() { return nama; }
 
    public double getNilaiAkhir() { return nilaiAkhir; }
}