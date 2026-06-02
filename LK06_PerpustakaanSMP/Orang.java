package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

public abstract class Orang {
    protected String id; // Bisa berupa NIP atau NIS
    protected String nama;

    public Orang(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public abstract String toCSV();
}
