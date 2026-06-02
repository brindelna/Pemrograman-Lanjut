package Praktikum_Pemrograman_Lanjut.BAB9_AULYASHABRINAAHMADEWI_255150207111065;

// Rumus ASD: Tugas 30% + Kuis 10% + UTS 30% + UAS 30%
public class asd extends mataKuliah {
    public asd() {
        super("ASD");
    }

    @Override
    public double hitungNilaiAkhir() {
        nilaiAkhir = (tugas * 0.30) + (kuis * 0.10) + (uts * 0.30) + (uas * 0.30);
        nilaiAkhir = Math.round(nilaiAkhir * 10.0) / 10.0;
        return nilaiAkhir;
    }
}