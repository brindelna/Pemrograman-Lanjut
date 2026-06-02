package Praktikum_Pemrograman_Lanjut.BAB9_AULYASHABRINAAHMADEWI_255150207111065;

public class matkomlan extends mataKuliah {
    public matkomlan() {
        super("Matkomlan");
    }

    @Override
    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.15) + (kuis * 0.15) + (uts * 0.30) + (uas * 0.40);
        nilaiAkhir = Math.round(nilaiAkhir * 10.0) / 10.0;
        return nilaiAkhir;
    }
}