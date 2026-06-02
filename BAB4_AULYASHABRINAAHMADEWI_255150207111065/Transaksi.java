package Praktikum_Pemrograman_Lanjut.BAB4_AULYASHABRINAAHMADEWI_255150207111065;

import java.util.Scanner;

public class Transaksi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Pelanggan p1 = new Pelanggan("3812345678", "Fifi", "3800", 2000000);
        Pelanggan p2 = new Pelanggan("5612345678", "Clara", "5600", 2000000);
        Pelanggan p3 = new Pelanggan("7412345678", "Rina", "7400", 2000000);

        Pelanggan[] daftarPelanggan = {p1, p2, p3};

        int pilihan = 0;
        do {
            System.out.println("==========MENU===========");
            System.out.println("1. Bayar");
            System.out.println("2. Top Up");
            System.out.print("Pilih transaksi: ");
            pilihan = in.nextInt();

            boolean loginBerhasil = false;
            int percobaan = 0;

            System.out.print("Masukkan nomor pelanggan: ");
            String nomor = in.next();

            Pelanggan current = null;
            for (Pelanggan p : daftarPelanggan) {
                if (p.getNomor().equals(nomor)) {
                    current = p;
                    break;
                }
            }

            if (current == null) {
                System.out.println("Nomor pelanggan tidak ditemukan!");
                return;
            }

            while (!loginBerhasil && percobaan < 3) {
                System.out.print("Masukkan pin            : ");
                String pin = in.next();

                if (current.autentikasi(nomor, pin)) {
                    loginBerhasil = true;
                    switch (pilihan) {
                        case 1:
                            System.out.print("Masukkan jumlah pembelian: ");
                            int jumlahPembelian = in.nextInt();
                            if (current.beli(jumlahPembelian)) {
                                System.out.println("Transaksi berhasil.");
                                System.out.println("Nama : " + current.getNama() + " , No. Pelanggan : " + current.getNomor());
                                System.out.println("Jumlah Pembelian: " + jumlahPembelian);
                                int cashback = current.cashback(jumlahPembelian);
                                System.out.println("Cashback        : " + cashback);
                                System.out.println("Saldo           : " + current.getSaldo());
                            }
                            break;
                        case 2:
                            System.out.print("Masukkan jumlah top up: ");
                            int jumlahTopUp = in.nextInt();
                            if (current.topUp(jumlahTopUp)) {
                                System.out.println("Transaksi berhasil.");
                                System.out.println("Nama : " + current.getNama() + " | No. Pelanggan : " + current.getNomor());
                                System.out.println("Jumlah Top Up   : " + jumlahTopUp);
                                System.out.println("Saldo           : " + current.getSaldo());
                            }
                            break;
                        default:
                            System.out.println("Pilihan tidak valid");
                    }
                } else {
                    percobaan++;
                    if (percobaan >= 3) {
                        System.out.println("Akun diblokir. Tidak bisa lanjut transaksi.");
                    } else {
                        System.out.println("Silakan coba lagi.");
                    }
                }
            }
        } while (pilihan != 0 && (pilihan == 1 || pilihan == 2));
    }
}