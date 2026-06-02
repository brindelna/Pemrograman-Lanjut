package Praktikum_Pemrograman_Lanjut.BAB9_AULYASHABRINAAHMADEWI_255150207111065;

public class pemlan extends mataKuliah {
    public pemlan() {
        super("Pemlan");
    }

    @Override
    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.20) + (kuis * 0.20) + (uts * 0.25) + (uas * 0.35);
        nilaiAkhir = Math.round(nilaiAkhir * 10.0) / 10.0;
        return nilaiAkhir;
    }
}