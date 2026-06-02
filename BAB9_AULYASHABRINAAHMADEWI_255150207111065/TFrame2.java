package Praktikum_Pemrograman_Lanjut.BAB9_AULYASHABRINAAHMADEWI_255150207111065;

import java.awt.*;
import java.awt.event.*;

public class TFrame2 extends Frame {
    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;
    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;
    CheckboxGroup cbg;
    Checkbox cbNilaiAngka, cbNilaiHuruf;

    public TFrame2() {
        setLayout(null);

        lbJudul = new Label("Hitung Nilai Akhir");
        lbJudul.setFont(new Font("Arial", Font.BOLD, 14));
        add(lbJudul);
        lbJudul.setBounds(100, 30, 170, 20);

        lbTugas = new Label("Tugas : ");
        add(lbTugas);
        lbTugas.setBounds(100, 60, 62, 20);

        lbKuis = new Label("Kuis : ");
        add(lbKuis);
        lbKuis.setBounds(100, 90, 70, 20);

        lbUTS = new Label("UTS : ");
        add(lbUTS);
        lbUTS.setBounds(100, 120, 70, 20);

        lbUAS = new Label("UAS : ");
        add(lbUAS);
        lbUAS.setBounds(100, 150, 70, 20);

        lbHasil = new Label("Hasil : ");
        add(lbHasil);
        lbHasil.setBounds(100, 180, 70, 20);

        txtTugas = new TextField("0");
        add(txtTugas);
        txtTugas.setBounds(200, 60, 60, 20);

        txtKuis = new TextField("0");
        add(txtKuis);
        txtKuis.setBounds(200, 90, 60, 20);

        txtUTS = new TextField("0");
        add(txtUTS);
        txtUTS.setBounds(200, 120, 60, 20);

        txtUAS = new TextField("0");
        add(txtUAS);
        txtUAS.setBounds(200, 150, 60, 20);

        txtHasil = new TextField("0");
        add(txtHasil);
        txtHasil.setBounds(200, 180, 60, 20);

        cbg = new CheckboxGroup();
        cbNilaiHuruf = new Checkbox("Nilai Huruf", cbg, false);
        this.add(cbNilaiHuruf).setBounds(100, 220, 90, 20);

        cbNilaiAngka = new Checkbox("Nilai Angka", cbg, false);
        this.add(cbNilaiAngka).setBounds(200, 220, 90, 20);

        cbNilaiHuruf.addItemListener(new mainAction());
        cbNilaiAngka.addItemListener(new mainAction());
    }

    String konversiNilaiHuruf(int nilai) {
        if (nilai >= 80 && nilai <= 100) {
            return "A";
        } else if (nilai >= 75 && nilai <= 79)  {
            return "B+";
        } else if (nilai >= 65 && nilai <= 74) {
            return "B";
        } else if (nilai >= 60 && nilai <= 64) {
            return "C+";
        } else if (nilai >= 50 && nilai <= 59) {
            return "C";
        } else if (nilai >= 45 && nilai <= 49) {
            return "D+";
        } else if (nilai >= 35 && nilai <= 44) {
            return "D";
        } else if (nilai >= 0 && nilai <= 34) {
            return "E";
        } else {
            return "Nilai tidak valid";
        }
    }

    class mainAction implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int tugas = Integer.parseInt(txtTugas.getText().trim());
            int kuis = Integer.parseInt(txtKuis.getText().trim());
            int UTS = Integer.parseInt(txtUTS.getText().trim());
            int UAS = Integer.parseInt(txtUAS.getText().trim());

            int hasil = tugas / 4 + kuis / 4 + UTS / 4 + UAS / 4;
            String hasilAkhir = String.valueOf(hasil);
            Object source = e.getItemSelectable();

            if (source == cbNilaiAngka) {
                txtHasil.setText(hasilAkhir);
            } else if (source == cbNilaiHuruf) {
                txtHasil.setText(konversiNilaiHuruf(hasil));
            }
        }
    }
}