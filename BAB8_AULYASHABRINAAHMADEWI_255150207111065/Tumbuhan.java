package Praktikum_Pemrograman_Lanjut.BAB8_AULYASHABRINAAHMADEWI_255150207111065;

public class Tumbuhan implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    public Tumbuhan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    @Override
    public void makan() {
        System.out.println("Makan dengan fotosintesis");  // beda dari Manusia
    }

    @Override
    public void berjalan() {
        System.out.println("Tidak bisa berjalan, hanya tumbuh");  // beda
    }

    @Override
    public void bersuara() {
        System.out.println("Tidak bersuara");  // beda
    }

    @Override
    public void tampilkanNama() {
        System.out.println("Nama tumbuhan: " + this.nama);
    }

    @Override
    public void tampilkanUmur() {
        System.out.println("Umur tumbuhan: " + this.umur + " tahun");
    }
}