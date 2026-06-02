package Praktikum_Pemrograman_Lanjut.BAB4_AULYASHABRINAAHMADEWI_255150207111065;

import java.util.Scanner;

public class Pelanggan {
    private String nomor;
    private String nama;
    private String pin;
    private int saldo;
    private int salahPin = 0;
    private boolean cekPin = false;

    public Pelanggan(String nomor, String nama, String pin, int saldo) {
        this.nomor = nomor;
        this.nama = nama;
        this.pin = pin;
        this.saldo = saldo;
    }

    public String getNomor() { return nomor; }
    public String getNama() { return nama; }
    public String getPin() { return pin; }
    public int getSaldo() { return saldo; }

    public boolean autentikasi(String nomor, String pin) {
        if (this.pin.equals(pin) && this.nomor.equals(nomor)) {
            salahPin = 0;
            System.out.println("Pin Benar");
            return true;
        } else {
            salahPin++;
            System.out.println("Pin Salah " + salahPin + "x");
            if (salahPin >= 3) {
                cekPin = false;
                System.out.println("Akun diblokir");
            }
            return false;
        }
    }

    public int cashback(int jumlahPembelian) {
        String kode = nomor.substring(0, 2);
        int persen = 0;
        switch (kode) {
            case "38":
                if (jumlahPembelian >= 1000000) {
                    persen = 5;
                }
                break;
            case "56":
                if (jumlahPembelian >= 1000000) {
                    persen = 7;
                } else {
                    persen = 2;
                }
                break;
            case "74":
                if (jumlahPembelian >= 1000000) {
                    persen = 10;
                } else {
                    persen = 5;
                }
                break;
        }
        return jumlahPembelian * persen / 100;
    }

    public boolean beli(int jumlahPembelian) {
        int cashback = cashback(jumlahPembelian);
        int total = jumlahPembelian - cashback;
        if (saldo - total < 10000) {
            System.out.println("Sisa saldo minimal Rp 10.000");
            return false;
        } else {
            saldo -= total;
            return true;
        }
    }

    public boolean topUp(int jumlahTopUp) {
        saldo += jumlahTopUp;
        return true;
    }
}