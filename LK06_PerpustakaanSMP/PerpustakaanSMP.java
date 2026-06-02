package Praktikum_Pemrograman_Lanjut.LK06_PerpustakaanSMP;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PerpustakaanSMP {
    private static final String FOLDER_PATH = "Praktikum_Pemrograman_Lanjut\\LK06_PerpustakaanSMP";
    private static final String FILE_PEGAWAI = FOLDER_PATH + "\\pegawai.txt";
    private static final String FILE_SISWA = FOLDER_PATH + "\\siswa.txt";
    private static final String FILE_BUKU = FOLDER_PATH + "\\buku.txt";
    private static final String FILE_TRANSAKSI = FOLDER_PATH + "\\transaksi.txt";

    private static Scanner scanner = new Scanner(System.in);
    private static Pegawai loggedInPegawai = null; // Menerapkan Object Pegawai

    public static void main(String[] args) {
        FileHelper.inisialisasiFile(FOLDER_PATH, new String[]{FILE_PEGAWAI, FILE_SISWA, FILE_BUKU, FILE_TRANSAKSI});

        System.out.println("=== SELAMAT DATANG DI SISTEM PERPUSTAKAAN SMP ===");
        while (loggedInPegawai == null) {
            System.out.println("\n=== MENU AUTENTIKASI ===");
            System.out.println("1. Login Pegawai");
            System.out.println("2. Buat Akun Pegawai (Maks 2 Pegawai)");
            System.out.print("Pilih menu (1/2): ");
            String authPilihan = scanner.nextLine().trim();

            if (authPilihan.equals("1")) {
                if (hitungJumlahPegawai() == 0) {
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
            System.out.println("Petugas Aktif: " + loggedInPegawai.getNama());
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
                    System.out.println("Terima kasih telah menggunakan sistem ini, " + loggedInPegawai.getNama() + "!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    // 1. SISTEM LOGIN & REGISTRASI

    private static int hitungJumlahPegawai() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PEGAWAI))) {
            while (br.readLine() != null) count++;
        } catch (IOException e) { }
        return count;
    }

    private static void buatAkunPegawai() {
        if (hitungJumlahPegawai() >= 2) {
            System.out.println("GAGAL: Kuota pegawai sudah penuh! Maksimal 2 pegawai.");
            return;
        }

        System.out.print("Masukkan NIP Baru: ");
        String nip = scanner.nextLine().trim();

        if (cekNipTerdaftar(nip)) {
            System.out.println("GAGAL: NIP tersebut sudah terdaftar! Silakan Login.");
            return;
        }

        System.out.print("Masukkan Nama Anda: ");
        String nama = scanner.nextLine().trim();
        System.out.print("Masukkan Tanggal Lahir (dd-MM-yyyy): ");
        String tglLahir = scanner.nextLine().trim();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine().trim();

        Pegawai pegawaiBaru = new Pegawai(nip, nama, password, tglLahir);
        FileHelper.tulisKeFile(FILE_PEGAWAI, pegawaiBaru.toCSV());
        System.out.println("BERHASIL: Akun pegawai atas nama " + nama + " berhasil dibuat!");
    }

    private static boolean cekNipTerdaftar(String nip) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PEGAWAI))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                if (baris.split(",")[0].equals(nip)) return true;
            }
        } catch (IOException e) {}
        return false;
    }

    private static void loginPegawai() {
        System.out.print("\nMasukkan NIP Anda: ");
        String inputNip = scanner.nextLine().trim();
        System.out.print("Masukkan Password: ");
        String inputPassword = scanner.nextLine().trim();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PEGAWAI))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(","); 
                if (data.length >= 3 && data[0].equals(inputNip) && data[2].equals(inputPassword)) {
                    loggedInPegawai = new Pegawai(data[0], data[1], data[2], data[3]);
                    System.out.println("Login Berhasil! Selamat bekerja " + loggedInPegawai.getNama() + "!");
                    return;
                }
            }
            System.out.println("LOGIN GAGAL: NIP atau Password salah.");
        } catch (IOException e) {
            System.out.println("Error membaca file pegawai: " + e.getMessage());
        }
    }

    // 2. KELOLA DATA BUKU

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
                FileHelper.tulisKeFile(FILE_BUKU, bukuBaru.toCSV());
                System.out.println("Buku berhasil ditambahkan!");
                break;
            case "2":
                FileHelper.cetakTabel(FILE_BUKU, "DAFTAR BUKU PERPUSTAKAAN", 
                                      new String[]{"Kode Buku", "Judul Buku", "Jenis Buku"}, 
                                      new int[]{12, 30, 20});
                break;
            case "3": updateBuku(); break;
            case "4": hapusBuku(); break;
            case "0": return;
            default: System.out.println("Pilihan tidak valid!");
        }
    }

    private static void updateBuku() {
        System.out.print("Masukkan Kode Buku yang akan diubah: ");
        String targetKode = scanner.nextLine().trim();
        
        File fileAsli = new File(FILE_BUKU);
        File fileTemp = new File(fileAsli.getParent(), "temp_buku.txt");
        boolean ditemukan = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileAsli));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp))) {
            
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(",");
                if (data.length >= 3 && data[0].equalsIgnoreCase(targetKode)) {
                    ditemukan = true;
                    // Buat object Buku berdasarkan data lama
                    Buku bukuEdit = new Buku(data[0], data[1], data[2]);

                    boolean lanjutUpdate = true;
                    while (lanjutUpdate) {
                        System.out.println("\n--- DATA BUKU SAAT INI ---");
                        System.out.printf("| %-12s | %-30s | %-20s |\n", bukuEdit.getKodeBuku(), bukuEdit.getJudul(), bukuEdit.getJenis());
                        System.out.println("\n1. Ubah Kode\n2. Ubah Judul\n3. Ubah Jenis\n0. Selesai");
                        System.out.print("Pilih (0-3): ");
                        String pilUbah = scanner.nextLine().trim();

                        switch (pilUbah) {
                            case "1": System.out.print("Kode Baru: "); bukuEdit.setKodeBuku(scanner.nextLine().trim()); break;
                            case "2": System.out.print("Judul Baru: "); bukuEdit.setJudul(scanner.nextLine().trim()); break;
                            case "3": System.out.print("Jenis Baru: "); bukuEdit.setJenis(scanner.nextLine().trim()); break;
                            case "0": lanjutUpdate = false; break;
                            default: System.out.println("Pilihan tidak valid!");
                        }
                    }
                    baris = bukuEdit.toCSV();
                }
                bw.write(baris);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saat update: " + e.getMessage());
        }

        if (ditemukan) {
            fileAsli.delete();
            fileTemp.renameTo(fileAsli);
            System.out.println("Data buku berhasil diperbarui!");
        } else {
            fileTemp.delete();
            System.out.println("Buku dengan Kode " + targetKode + " tidak ditemukan.");
        }
    }

    private static void hapusBuku() {
        System.out.print("Masukkan Kode Buku yang akan dihapus: ");
        String targetKode = scanner.nextLine().trim();
        
        File fileAsli = new File(FILE_BUKU);
        File fileTemp = new File(fileAsli.getParent(), "temp_buku.txt");
        boolean ditemukan = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileAsli));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp))) {
            
            String baris;
            while ((baris = br.readLine()) != null) {
                if (baris.split(",")[0].equalsIgnoreCase(targetKode)) {
                    ditemukan = true;
                    continue; 
                }
                bw.write(baris);
                bw.newLine();
            }
        } catch (IOException e) {}

        if (ditemukan) {
            fileAsli.delete();
            fileTemp.renameTo(fileAsli);
            System.out.println("Buku berhasil dihapus dari sistem!");
        } else {
            fileTemp.delete();
        }
    }

    // 3. KELOLA DATA SISWA

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
                System.out.print("Masukkan NIS: ");
                String nis = scanner.nextLine().trim();
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine().trim();
                System.out.print("Masukkan Alamat: ");
                String alamat = scanner.nextLine().trim();
                
                Siswa s = new Siswa(nis, nama, alamat);
                FileHelper.tulisKeFile(FILE_SISWA, s.toCSV());
                System.out.println("Siswa berhasil ditambahkan!");
                break;
            case "2":
                FileHelper.cetakTabel(FILE_SISWA, "DAFTAR SISWA TERDAFTAR", 
                                      new String[]{"NIS", "Nama Siswa", "Alamat"}, 
                                      new int[]{12, 25, 30});
                break;
            case "3": updateSiswa(); break;
            case "4": hapusSiswa(); break;
            case "0": return;
            default: System.out.println("Pilihan tidak valid!");
        }
    }

    private static void updateSiswa() {
        System.out.print("Masukkan NIS Siswa yang akan diubah: ");
        String targetNis = scanner.nextLine().trim();
        
        File fileAsli = new File(FILE_SISWA);
        File fileTemp = new File(fileAsli.getParent(), "temp_siswa.txt");
        boolean ditemukan = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileAsli));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp))) {
            
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(",");
                if (data.length >= 3 && data[0].equalsIgnoreCase(targetNis)) {
                    ditemukan = true;
                    Siswa siswaEdit = new Siswa(data[0], data[1], data[2]);

                    boolean lanjutUpdate = true;
                    while (lanjutUpdate) {
                        System.out.println("\n--- DATA SISWA SAAT INI ---");
                        System.out.printf("| %-12s | %-25s | %-30s |\n", siswaEdit.getNis(), siswaEdit.getNama(), siswaEdit.getAlamat());
                        System.out.println("\n1. Ubah NIS\n2. Ubah Nama\n3. Ubah Alamat\n0. Selesai");
                        System.out.print("Pilih (0-3): ");
                        String pilUbah = scanner.nextLine().trim();

                        switch (pilUbah) {
                            case "1": System.out.print("NIS Baru: "); siswaEdit.setNis(scanner.nextLine().trim()); break;
                            case "2": System.out.print("Nama Baru: "); siswaEdit.setNama(scanner.nextLine().trim()); break;
                            case "3": System.out.print("Alamat Baru: "); siswaEdit.setAlamat(scanner.nextLine().trim()); break;
                            case "0": lanjutUpdate = false; break;
                            default: System.out.println("Pilihan tidak valid!");
                        }
                    }
                    baris = siswaEdit.toCSV();
                }
                bw.write(baris);
                bw.newLine();
            }
        } catch (IOException e) {}

        if (ditemukan) {
            fileAsli.delete();
            fileTemp.renameTo(fileAsli);
            System.out.println("Data Siswa berhasil diperbarui!");
        } else {
            fileTemp.delete();
            System.out.println("Siswa tidak ditemukan.");
        }
    }

    private static void hapusSiswa() {
        System.out.print("Masukkan NIS Siswa yang akan dihapus: ");
        String targetNis = scanner.nextLine().trim();
        
        File fileAsli = new File(FILE_SISWA);
        File fileTemp = new File(fileAsli.getParent(), "temp_siswa.txt");
        boolean ditemukan = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileAsli));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp))) {
            
            String baris;
            while ((baris = br.readLine()) != null) {
                if (baris.split(",")[0].equalsIgnoreCase(targetNis)) {
                    ditemukan = true;
                    continue; 
                }
                bw.write(baris);
                bw.newLine();
            }
        } catch (IOException e) {}

        if (ditemukan) {
            fileAsli.delete();
            fileTemp.renameTo(fileAsli);
            System.out.println("Siswa berhasil dihapus dari sistem!");
        } else {
            fileTemp.delete();
        }
    }

    // 4. TRANSAKSI (PINJAM & KEMBALI)

    private static void transaksiPinjam() {
        System.out.println("\n--- PEMINJAMAN BUKU ---");
        System.out.print("Masukkan NIS Siswa: ");
        String nis = scanner.nextLine().trim();

        int jumlahPinjam = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_TRANSAKSI))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(",");
                if (data.length >= 6 && data[1].equals(nis) && data[5].equals("0")) {
                    jumlahPinjam++;
                }
            }
        } catch (IOException e) {}

        if (jumlahPinjam >= 2) {
            System.out.println("DITOLAK: Siswa sudah meminjam 2 buku!");
            return;
        }

        System.out.print("Masukkan Kode Buku: ");
        String kodeBuku = scanner.nextLine().trim();
        System.out.print("Lama Pinjam (hari): ");
        int lamaPinjam = Integer.parseInt(scanner.nextLine().trim());

        String kodeTransaksi = generateKodeTransaksi();
        LocalDate tglPinjam = LocalDate.now();
        LocalDate tglKembali = tglPinjam.plusDays(lamaPinjam);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Transaksi trxBaru = new Transaksi(
            kodeTransaksi, nis, kodeBuku, 
            tglPinjam.format(fmt), tglKembali.format(fmt), "0"
        );

        FileHelper.tulisKeFile(FILE_TRANSAKSI, trxBaru.toCSV());
        System.out.println("Peminjaman berhasil! Kode Transaksi : " + kodeTransaksi);
    }

    private static String generateKodeTransaksi() {
        int nomor = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_TRANSAKSI))) {
            while (br.readLine() != null) nomor++;
        } catch (IOException e) {}
        return String.format("TRX-%02d", nomor);
    }

    private static void transaksiKembali() {
        System.out.println("\n--- PENGEMBALIAN BUKU ---");
        System.out.print("Masukkan Kode Transaksi: ");
        String kodeTrx = scanner.nextLine().trim();

        File fileAsli = new File(FILE_TRANSAKSI);
        File fileTemp = new File(fileAsli.getParent(), "temp_transaksi.txt");
        boolean ditemukan = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileAsli));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp))) {
            
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(",");
                if (data.length >= 6 && data[0].equalsIgnoreCase(kodeTrx) && data[5].equals("0")) {
                    Transaksi trxKembali = new Transaksi(data[0], data[1], data[2], data[3], data[4], "1");
                    baris = trxKembali.toCSV(); // Manfaatkan object model untuk update
                    ditemukan = true;
                }
                bw.write(baris);
                bw.newLine();
            }
        } catch (IOException e) {}

        if (ditemukan) {
            fileAsli.delete();
            fileTemp.renameTo(fileAsli);
            System.out.println("Buku berhasil dikembalikan!");
        } else {
            fileTemp.delete();
            System.out.println("Kode transaksi tidak ditemukan atau buku sudah dikembalikan sebelumnya.");
        }
    }

    // 5. LAPORAN

    private static void lihatLaporan() {
        System.out.println("\n--- LAPORAN BUKU BELUM DIKEMBALIKAN & JATUH TEMPO ---");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate hariIni = LocalDate.now();
        boolean adaData = false;

        String border = "------------------------------------------------------------------------------------------------------------";
        System.out.println(border);
        System.out.printf("| %-10s | %-12s | %-20s | %-12s | %-15s | %-15s |\n",
                "Kode Trx", "NIS", "Nama Siswa", "Kode Buku", "Batas Kembali", "Jatuh Tempo");
        System.out.println(border);

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_TRANSAKSI))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(",");
                if (data.length >= 6 && data[5].equals("0")) {
                    adaData = true;
                    String namaSiswa = cariNamaSiswa(data[1]);
                    LocalDate tglKembali = LocalDate.parse(data[4], fmt);
                    String status = hariIni.isAfter(tglKembali) ? "Ya" : "Tidak";

                    System.out.printf("| %-10s | %-12s | %-20s | %-12s | %-15s | %-15s |\n",
                            data[0], data[1], namaSiswa, data[2], data[4], status);
                }
            }
            if (!adaData) System.out.printf("| %-106s |\n", "Semua buku telah dikembalikan.");
        } catch (Exception e) {}
        System.out.println(border);
    }

    private static String cariNamaSiswa(String nisCari) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_SISWA))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(",");
                if (data.length >= 2 && data[0].equals(nisCari)) return data[1];
            }
        } catch (IOException e) {}
        return "Tidak Ditemukan";
    }
}