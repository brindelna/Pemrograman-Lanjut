package Praktikum_Pemrograman_Lanjut.BAB9_AULYASHABRINAAHMADEWI_255150207111065;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.*;
import java.util.*;
import javax.swing.*;

public class gui extends JFrame {
    JMenuBar mb = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    JMenuItem open = new JMenuItem("Open");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem quit = new JMenuItem("Quit");
    JMenuItem about = new JMenuItem("About");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem cut = new JMenuItem("Cut");
    JLabel lblnama = new JLabel("Nama");
    JTextField txnama = new JTextField(30);
    JLabel lblnim = new JLabel("NIM");
    JTextField txnim = new JTextField(7);
    JLabel lblkelamin = new JLabel("Jenis Kelamin");

    JComboBox<String> cmbKelamin = new JComboBox<>(new String[]{"-- Pilih --", "Pria", "Wanita"});

    ButtonGroup kelompok = new ButtonGroup();
    JLabel lblhobi = new JLabel("Hobi");
    JRadioButton rbShoping = new JRadioButton("Shoping");
    JRadioButton rbFutsal  = new JRadioButton("Futsal");
    JRadioButton rbMusik   = new JRadioButton("Musik");
    
    JLabel label1 = new JLabel("Nilai UTS");
    JTextField tx1 = new JTextField(20);
    JLabel label2 = new JLabel("Nilai UAS");
    JTextField tx2 = new JTextField(20);

    JLabel labelRata = new JLabel("Nilai Rata-Rata");
    JTextField txRata = new JTextField(20);
    
    JButton cetak = new JButton("Cetak");
    JTextArea hasil = new JTextArea();

    gui() {
        setTitle("DATA MAHASISWA");
        setLocation(300, 100);
        setSize(300, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void KomponenVisual() {
        setJMenuBar(mb);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        file.add(open);
        file.add(close);
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        close.setEnabled(false);
        file.add(quit);
        help.add(about);
        setVisible(true);
        getContentPane().setLayout(null);
        getContentPane().add(lblnama);
        lblnama.setBounds(10, 10, 80, 20);
        getContentPane().add(txnama);
        txnama.setBounds(105, 10, 175, 20);
        getContentPane().add(lblnim);
        lblnim.setBounds(10, 33, 80, 20);
        getContentPane().add(txnim);
        txnim.setBounds(105, 33, 70, 20);
        getContentPane().add(lblkelamin);
        lblkelamin.setBounds(10, 56, 80, 20);

        getContentPane().add(cmbKelamin);
        cmbKelamin.setBounds(105, 56, 175, 20);

        getContentPane().add(lblhobi);

        kelompok.add(rbShoping);
        kelompok.add(rbFutsal);
        kelompok.add(rbMusik);

        getContentPane().add(rbShoping);
        rbShoping.setBounds(105, 80, 80, 20);
        getContentPane().add(rbFutsal);
        rbFutsal.setBounds(105, 103, 80, 20);
        getContentPane().add(rbMusik);
        rbMusik.setBounds(105, 126, 80, 20);

        getContentPane().add(label1);
        label1.setBounds(10, 146, 80, 20);
        getContentPane().add(tx1);
        tx1.setBounds(105, 146, 175, 20);
        getContentPane().add(label2);
        label2.setBounds(10, 169, 80, 20);
        getContentPane().add(tx2);
        tx2.setBounds(105, 169, 175, 20);

        getContentPane().add(labelRata);
        labelRata.setBounds(10, 192, 80, 20);
        getContentPane().add(txRata);
        txRata.setBounds(105, 192, 175, 20);
        txRata.setEditable(false);

        getContentPane().add(cetak);
        cetak.setBounds(10, 218, 270, 20);
        getContentPane().add(hasil);
        hasil.setBounds(10, 241, 270, 140);
        setVisible(true);
    }

    void AksiReaksi() {
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // ✅ Membuat panel khusus untuk isi dialog About
                JPanel panelAbout = new JPanel();
                panelAbout.setLayout(new BoxLayout(panelAbout, BoxLayout.Y_AXIS));

                // ✅ Teks informasi yang ditampilkan di dialog About
                String pesanAbout =
                    "============================================\n" +
                    "         APLIKASI DATA MAHASISWA            \n" +
                    "============================================\n\n" +
                    "Versi      : 1.0.0\n" +
                    "Dibuat     : 2025\n\n" +
                    "Deskripsi  :\n" +
                    "Aplikasi ini digunakan untuk menginputkan\n" +
                    "data mahasiswa meliputi nama, NIM, jenis\n" +
                    "kelamin, hobi, serta nilai UTS dan UAS.\n" +
                    "Program akan menghitung nilai rata-rata\n" +
                    "dari nilai UTS dan UAS secara otomatis.\n\n" +
                    "Developer  :\n" +
                    "Nama  : Aulya Shabrina Ahmadewi\n" +
                    "NIM   : 255150207111065\n" +
                    "Kelas : Praktikum Pemrograman Lanjut\n\n" +
                    "Cara Penggunaan :\n" +
                    "1. Isi kolom Nama dan NIM\n" +
                    "2. Pilih Jenis Kelamin dari dropdown\n" +
                    "3. Pilih satu Hobi menggunakan radio button\n" +
                    "4. Masukkan Nilai UTS dan Nilai UAS\n" +
                    "5. Klik tombol Cetak untuk melihat hasil\n\n" +
                    "============================================\n" +
                    "         Universitas Brawijaya 2025         \n" +
                    "============================================";

                // ✅ Menampilkan teks ke JTextArea agar bisa discroll
                JTextArea taAbout = new JTextArea(pesanAbout);
                taAbout.setEditable(false);
                taAbout.setFont(new Font("Monospaced", Font.PLAIN, 11));
                taAbout.setBackground(new Color(240, 240, 240));

                // ✅ Membungkus JTextArea dalam JScrollPane agar bisa discroll
                JScrollPane scroll = new JScrollPane(taAbout);
                scroll.setPreferredSize(new Dimension(320, 280));

                // ✅ Menampilkan dialog About menggunakan JOptionPane
                JOptionPane.showMessageDialog(
                    gui.this,       // parent window
                    scroll,         // komponen yang ditampilkan
                    "About - Aplikasi Data Mahasiswa",  // judul dialog
                    JOptionPane.INFORMATION_MESSAGE     // tipe ikon (i)
                );
            }
        });
                
        cetak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                hasil.append(lblnama.getText() + " : " + txnama.getText() + "\n");
                hasil.append(lblnim.getText() + " : " + txnim.getText() + "\n");
                
                String pilihanKelamin = (String) cmbKelamin.getSelectedItem();
                hasil.append(lblkelamin.getText() + " : " + pilihanKelamin + "\n");
                
                String pilihanHobi = "Tidak ada hobi dipilih";
                if (rbShoping.isSelected()) {
                    pilihanHobi = rbShoping.getText();
                } else if (rbFutsal.isSelected()) {
                    pilihanHobi = rbFutsal.getText();
                } else if (rbMusik.isSelected()) {
                    pilihanHobi = rbMusik.getText();
                }
                hasil.append(lblhobi.getText() + " : " + pilihanHobi + "\n");

                hasil.append(label1.getText() + " : " + tx1.getText() + "\n");
                hasil.append(label2.getText() + " : " + tx2.getText() + "\n");
                double a = 0.0, b = 0.0, c = 0.0;
                try {
                    a = Double.parseDouble(tx1.getText());
                    b = Double.parseDouble(tx2.getText());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                JButton btn = (JButton) event.getSource();
                if (btn == cetak) {
                    c = ((a + b) / 2);
                }

                txRata.setText(String.valueOf(c));
                hasil.append(labelRata.getText() + " : " + c + "\n");
                
                hasil.append(new String().valueOf("NIlai Akhir " + c));
            }
        });
    }

    public static void main(String args[]) {
        gui e5 = new gui();
        e5.KomponenVisual();
        e5.AksiReaksi();
    }
}