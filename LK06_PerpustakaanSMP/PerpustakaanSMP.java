package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerpustakaanSMP {
    private static Scanner scanner = new Scanner(System.in);
    private static String loggedInPegawai = null;

    public static void main(String[] args) {
        FileHelper.inisialisasiFile();

        System.out.println("=== SELAMAT DATANG DI SISTEM PERPUSTAKAAN SMP ===");
        while (loggedInPegawai == null) {
            System.out.println("\n=== MENU AUTENTIKASI ===");
            System.out.println("1. Login Pegawai");
            System.out.println("2. Buat Akun Pegawai (Maks 2 Pegawai)");
            System.out.print("Pilih menu (1/2): ");
            String authPilihan = scanner.nextLine().trim();

            if (authPilihan.equals("1")) {
                if (FileHelper.bacaFile(FileHelper.FILE_PEGAWAI).isEmpty()) {
                    System.out.println("\n[INFO] Belum terdapat data pegawai untuk login. Silakan pilih menu 2 untuk buat akun terlebih dahulu!");
                } else {
                    loginPegawai();
                }
            } else if (authPilihan.equals("2")) {
                buatAkunPegawai();
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }

        boolean jalan = true;
        while (jalan) {
            System.out.println("\n=== MENU UTAMA PERPUSTAKAAN ===");
            System.out.println("Petugas Aktif: " + loggedInPegawai);
            System.out.println("1. Kelola Data Buku");
            System.out.println("2. Kelola Data Siswa");
            System.out.println("3. Transaksi Peminjaman");
            System.out.println("4. Transaksi Pengembalian");
            System.out.println("5. Laporan (Buku Belum Kembali & Jatuh Tempo)");
            System.out.println("0. Keluar / Logout");
            System.out.print("Pilih menu (0-5): ");
            
            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1": menuBuku(); break;
                case "2": menuSiswa(); break;
                case "3": transaksiPinjam(); break;
                case "4": transaksiKembali(); break;
                case "5": lihatLaporan(); break;
                case "0":
                    jalan = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini, " + loggedInPegawai + "!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void buatAkunPegawai() {
        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_PEGAWAI);
        if (lines.size() >= 2) {
            System.out.println("GAGAL: Kuota pegawai sudah penuh! Sistem hanya mengizinkan maksimal 2 pegawai.");
            return;
        }

        System.out.print("Masukkan NIP Baru: ");
        String nip = scanner.nextLine().trim();

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 1 && data[0].equals(nip)) {
                System.out.println("GAGAL: NIP tersebut sudah terdaftar! Silakan gunakan NIP lain atau Login.");
                return;
            }
        }

        System.out.print("Masukkan Nama Anda: ");
        String nama = scanner.nextLine().trim();
        System.out.print("Masukkan Tanggal Lahir (dd-MM-yyyy): ");
        String tglLahir = scanner.nextLine().trim();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine().trim();

        Pegawai pegawaiBaru = new Pegawai(nip, nama, password, tglLahir);
        FileHelper.tulisKeFile(FileHelper.FILE_PEGAWAI, pegawaiBaru.toCSV());
        System.out.println("BERHASIL: Akun pegawai atas nama " + nama + " berhasil dibuat! Silakan Login.");
    }

    private static void loginPegawai() {
        System.out.print("\nMasukkan NIP Anda: ");
        String inputNip = scanner.nextLine().trim();
        System.out.print("Masukkan Password: ");
        String inputPassword = scanner.nextLine().trim();

        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_PEGAWAI);
        boolean ditemukan = false;

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 3) {
                String tglLahir = data.length > 3 ? data[3] : "-";
                Pegawai p = new Pegawai(data[0], data[1], data[2], tglLahir);
                if (p.getId().equals(inputNip) && p.getPassword().equals(inputPassword)) {
                    loggedInPegawai = p.getNama();
                    ditemukan = true;
                    System.out.println("Login Berhasil! Selamat bekerja " + loggedInPegawai + " !");
                    break;
                }
            }
        }
        if (!ditemukan) {
            System.out.println("LOGIN GAGAL: NIP atau Password salah.");
        }
    }

    private static void menuBuku() {
        System.out.println("\n--- KELOLA BUKU ---");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Lihat Daftar Buku");
        System.out.println("3. Update Data Buku");
        System.out.println("4. Hapus Data Buku");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.print("Pilih (0-4): ");
        String pil = scanner.nextLine().trim();

        switch (pil) {
            case "1":
                System.out.print("Masukkan Kode Buku: ");
                String kode = scanner.nextLine().trim();
                System.out.print("Masukkan Judul Buku: ");
                String judul = scanner.nextLine().trim();
                System.out.print("Masukkan Jenis Buku: ");
                String jenis = scanner.nextLine().trim();
                Buku bukuBaru = new Buku(kode, judul, jenis);
                FileHelper.tulisKeFile(FileHelper.FILE_BUKU, bukuBaru.toCSV());
                System.out.println("Buku berhasil ditambahkan!");
                break;
            case "2":
                FileHelper.cetakTabel(FileHelper.FILE_BUKU, "DAFTAR BUKU PERPUSTAKAAN", 
                                   new String[]{"Kode Buku", "Judul Buku", "Jenis Buku"}, 
                                   new int[]{12, 30, 20});
                break;
            case "3": updateBuku(); break;
            case "4": hapusBuku(); break;
            default: return;
        }
    }

    private static void updateBuku() {
        System.out.print("Masukkan Kode Buku yang akan diubah: ");
        String targetKode = scanner.nextLine().trim();
        
        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_BUKU);
        List<Buku> daftarBuku = new ArrayList<>();
        Buku targetBuku = null;

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 3) {
                Buku b = new Buku(data[0], data[1], data[2]);
                daftarBuku.add(b);
                if (b.getKodeBuku().equalsIgnoreCase(targetKode)) {
                    targetBuku = b;
                }
            }
        }

        if (targetBuku == null) {
            System.out.println("Buku dengan Kode " + targetKode + " tidak ditemukan.");
            return;
        }

        boolean lanjutUpdate = true;
        while ( lanjutUpdate ) {
            System.out.println("\n--- DATA BUKU SAAT INI ---");
            String border = "-------------------------------------------------------------------------";
            System.out.println(border);
            System.out.printf("| %-12s | %-30s | %-20s |\n", "Kode Buku", "Judul Buku", "Jenis Buku");
            System.out.println(border);
            System.out.printf("| %-12s | %-30s | %-20s |\n", targetBuku.getKodeBuku(), targetBuku.getJudul(), targetBuku.getJenis());
            System.out.println(border);

            System.out.println("\nPilih bagian yang ingin diubah:");
            System.out.println("1. Kode Buku");
            System.out.println("2. Judul Buku");
            System.out.println("3. Jenis Buku");
            System.out.println("0. Selesai & Simpan");
            System.out.print("Pilih (0-3): ");
            String pilUbah = scanner.nextLine().trim();

            switch (pilUbah) {
                case "1": System.out.print("Masukkan Kode Buku Baru: "); targetBuku.setKodeBuku(scanner.nextLine().trim()); break;
                case "2": System.out.print("Masukkan Judul Buku Baru: "); targetBuku.setJudul(scanner.nextLine().trim()); break;
                case "3": System.out.print("Masukkan Jenis Buku Baru: "); targetBuku.setJenis(scanner.nextLine().trim()); break;
                default: lanjutUpdate = false; break;
            }
        }

        List<String> updatedLines = new ArrayList<>();
        for (Buku b : daftarBuku) updatedLines.add(b.toCSV());
        FileHelper.simpanSemua(FileHelper.FILE_BUKU, updatedLines);
        System.out.println("Data buku berhasil diperbarui dan disimpan!");
    }

    private static void hapusBuku() {
        System.out.print("Masukkan Kode Buku yang akan dihapus: ");
        String targetKode = scanner.nextLine().trim();
        
        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_BUKU);
        List<String> updatedLines = new ArrayList<>();
        boolean ditemukan = false;

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 1 && data[0].equalsIgnoreCase(targetKode)) {
                ditemukan = true;
                continue;
            }
            updatedLines.add(line);
        }

        if (ditemukan) {
            FileHelper.simpanSemua(FileHelper.FILE_BUKU, updatedLines);
            System.out.println("Buku berhasil dihapus dari sistem!");
        } else {
            System.out.println("Buku dengan Kode " + targetKode + " tidak ditemukan.");
        }
    }

    private static void menuSiswa() {
        System.out.println("\n--- KELOLA SISWA ---");
        System.out.println("1. Tambah Siswa");
        System.out.println("2. Lihat Daftar Siswa");
        System.out.println("3. Update Data Siswa");
        System.out.println("4. Hapus Data Siswa");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.print("Pilih (0-4): ");
        String pil = scanner.nextLine().trim();

        switch (pil) {
            case "1":
                System.out.print("Masukkan NIS: "); String nis = scanner.nextLine().trim();
                System.out.print("Masukkan Nama: "); String nama = scanner.nextLine().trim();
                System.out.print("Masukkan Alamat: "); String alamat = scanner.nextLine().trim();
                Siswa siswaBaru = new Siswa(nis, nama, alamat);
                FileHelper.tulisKeFile(FileHelper.FILE_SISWA, siswaBaru.toCSV());
                System.out.println("Siswa berhasil ditambahkan!");
                break;
            case "2":
                FileHelper.cetakTabel(FileHelper.FILE_SISWA, "DAFTAR SISWA TERDAFTAR", 
                                   new String[]{"NIS", "Nama Siswa", "Alamat"}, 
                                   new int[]{12, 25, 30});
                break;
            case "3": updateSiswa(); break;
            case "4": hapusSiswa(); break;
            default: return;
        }
    }

    private static void updateSiswa() {
        System.out.print("Masukkan NIS Siswa yang akan diubah: ");
        String targetNis = scanner.nextLine().trim();
        
        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_SISWA);
        List<Siswa> daftarSiswa = new ArrayList<>();
        Siswa targetSiswa = null;

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 3) {
                Siswa s = new Siswa(data[0], data[1], data[2]);
                daftarSiswa.add(s);
                if (s.getId().equalsIgnoreCase(targetNis)) {
                    targetSiswa = s;
                }
            }
        }

        if (targetSiswa == null) {
            System.out.println("Siswa dengan NIS " + targetNis + " tidak ditemukan.");
            return;
        }

        boolean lanjutUpdate = true;
        while (lanjutUpdate) {
            System.out.println("\n--- DATA SISWA SAAT INI ---");
            String border = "------------------------------------------------------------------------------";
            System.out.println(border);
            System.out.printf("| %-12s | %-25s | %-30s |\n", "NIS", "Nama Siswa", "Alamat");
            System.out.println(border);
            System.out.printf("| %-12s | %-25s | %-30s |\n", targetSiswa.getId(), targetSiswa.getNama(), targetSiswa.getAlamat());
            System.out.println(border);

            System.out.println("\nPilih bagian yang ingin diubah:");
            System.out.println("1. NIS");
            System.out.println("2. Nama Siswa");
            System.out.println("3. Alamat");
            System.out.println("0. Selesai & Simpan");
            System.out.print("Pilih (0-3): ");
            String pilUbah = scanner.nextLine().trim();

            switch (pilUbah) {
                case "1": System.out.print("Masukkan NIS Baru: "); targetSiswa.setId(scanner.nextLine().trim()); break;
                case "2": System.out.print("Masukkan Nama Baru: "); targetSiswa.setNama(scanner.nextLine().trim()); break;
                case "3": System.out.print("Masukkan Alamat Baru: "); targetSiswa.setAlamat(scanner.nextLine().trim()); break;
                default: lanjutUpdate = false; break;
            }
        }

        List<String> updatedLines = new ArrayList<>();
        for (Siswa s : daftarSiswa) updatedLines.add(s.toCSV());
        FileHelper.simpanSemua(FileHelper.FILE_SISWA, updatedLines);
        System.out.println("Data Siswa berhasil diperbarui dan disimpan!");
    }

    private static void hapusSiswa() {
        System.out.print("Masukkan NIS Siswa yang akan dihapus: ");
        String targetNis = scanner.nextLine().trim();
        
        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_SISWA);
        List<String> updatedLines = new ArrayList<>();
        boolean ditemukan = false;

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 1 && data[0].equalsIgnoreCase(targetNis)) {
                ditemukan = true;
                continue;
            }
            updatedLines.add(line);
        }

        if (ditemukan) {
            FileHelper.simpanSemua(FileHelper.FILE_SISWA, updatedLines);
            System.out.println("Siswa berhasil dihapus dari sistem!");
        } else {
            System.out.println("Siswa dengan NIS " + targetNis + " tidak ditemukan.");
        }
    }

    private static void transaksiPinjam() {
        System.out.println("\n--- PEMINJAMAN BUKU ---");
        System.out.print("Masukkan NIS Siswa: ");
        String nis = scanner.nextLine().trim();

        int jumlahPinjam = 0;
        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_TRANSAKSI);
        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 6 && data[1].equals(nis) && data[5].equals("0")) {
                jumlahPinjam++;
            }
        }

        if (jumlahPinjam >= 2) {
            System.out.println("DITOLAK: Siswa sudah meminjam 2 buku!");
            return;
        }

        System.out.print("Masukkan Kode Buku: ");
        String kodeBuku = scanner.nextLine().trim();
        System.out.print("Lama Pinjam (hari): ");
        int lamaPinjam = Integer.parseInt(scanner.nextLine().trim());

        String kodeTransaksi = String.format("TRX-%02d", lines.size() + 1);
        LocalDate tglPinjam = LocalDate.now();
        LocalDate tglKembali = tglPinjam.plusDays(lamaPinjam);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Transaksi trxBaru = new Transaksi(kodeTransaksi, nis, kodeBuku, tglPinjam.format(fmt), tglKembali.format(fmt), "0");
        FileHelper.tulisKeFile(FileHelper.FILE_TRANSAKSI, trxBaru.toCSV());

        System.out.println("Peminjaman berhasil!");
        System.out.println("Kode Transaksi : " + kodeTransaksi);
        System.out.println("Tanggal Pinjam : " + tglPinjam.format(fmt));
        System.out.println("Batas Kembali  : " + tglKembali.format(fmt));
    }

    private static void transaksiKembali() {
        System.out.println("\n--- PENGEMBALIAN BUKU ---");
        System.out.print("Masukkan Kode Transaksi: ");
        String kodeTrx = scanner.nextLine().trim();

        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_TRANSAKSI);
        List<String> updatedLines = new ArrayList<>();
        boolean ditemukan = false;

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 6) {
                Transaksi trx = new Transaksi(data[0], data[1], data[2], data[3], data[4], data[5]);
                if (trx.getKodeTrx().equalsIgnoreCase(kodeTrx) && trx.getStatus().equals("0")) {
                    trx.setStatus("1"); // Diubah menggunakan setter OOP
                    ditemukan = true;
                }
                updatedLines.add(trx.toCSV());
            } else {
                updatedLines.add(line);
            }
        }

        if (ditemukan) {
            FileHelper.simpanSemua(FileHelper.FILE_TRANSAKSI, updatedLines);
            System.out.println("Buku berhasil dikembalikan!");
        } else {
            System.out.println("Kode transaksi tidak ditemukan atau buku sudah dikembalikan sebelumnya.");
        }
    }

    private static void lihatLaporan() {
        System.out.println("\n--- LAPORAN BUKU BELUM DIKEMBALIKAN & JATUH TEMPO ---");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate hariIni = LocalDate.now();
        boolean adaData = false;

        String border = "------------------------------------------------------------------------------------------------------------";
        System.out.println(border);
        System.out.printf("| %-10s | %-12s | %-20s | %-12s | %-15s | %-15s |\n", "Kode Trx", "NIS", "Nama Siswa", "Kode Buku", "Batas Kembali", "Status");
        System.out.println(border);

        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_TRANSAKSI);
        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 6 && data[5].equals("0")) {
                adaData = true;
                String nis = data[1];
                String nama = cariNamaSiswa(nis);
                LocalDate tglKembali = LocalDate.parse(data[4], fmt);
                String status = hariIni.isAfter(tglKembali) ? "Ya" : "Tidak";

                System.out.printf("| %-10s | %-12s | %-20s | %-12s | %-15s | %-15s |\n", data[0], nis, nama, data[2], data[4], status);
            }
        }

        if (!adaData) {
            System.out.printf("| %-106s |\n", "Semua buku telah dikembalikan.");
        }
        System.out.println(border);
    }

    private static String cariNamaSiswa(String nisCari) {
        List<String> lines = FileHelper.bacaFile(FileHelper.FILE_SISWA);
        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 2 && data[0].equals(nisCari)) {
                return data[1];
            }
        }
        return "Tidak Ditemukan";
    }
}