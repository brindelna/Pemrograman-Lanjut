package Praktikum_Pemrograman_Lanjut.BAB9_AULYASHABRINAAHMADEWI_255150207111065;

import java.awt.*;
import java.awt.event.*;

public class MainBab9No1 extends Frame {

    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;

    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;

    CheckboxGroup cbg;
    Checkbox cbPemlan, cbASD, cbMatkomlan, cbProbstat;

    Button btnHitung, btnTampilSemua;

    TextArea taHasil;

    pemlan    matkul_Pemlan    = new pemlan();
    asd       matkul_ASD       = new asd();
    matkomlan matkul_Matkomlan = new matkomlan();
    probstat  matkul_Probstat  = new probstat();

    boolean sudahHitungPemlan    = false;
    boolean sudahHitungASD       = false;
    boolean sudahHitungMatkomlan = false;
    boolean sudahHitungProbstat  = false;

    public MainBab9No1() {
        setLayout(null);

        lbJudul = new Label("Hitung Nilai Akhir");
        lbJudul.setFont(new Font("Arial", Font.BOLD, 14));
        add(lbJudul);
        lbJudul.setBounds(100, 30, 200, 20);

        cbg         = new CheckboxGroup();
        cbASD       = new Checkbox("ASD",       cbg, false);
        cbPemlan    = new Checkbox("Pemlan",    cbg, true);  
        cbMatkomlan = new Checkbox("Matkomlan", cbg, false);
        cbProbstat  = new Checkbox("Probstat",  cbg, false);

        add(cbASD);       cbASD.setBounds(30,  60, 60,  20);
        add(cbPemlan);    cbPemlan.setBounds(100, 60, 70,  20);
        add(cbMatkomlan); cbMatkomlan.setBounds(180, 60, 90,  20);
        add(cbProbstat);  cbProbstat.setBounds(280, 60, 80,  20);

        ItemListener radioListener = new RadioAction();
        cbASD.addItemListener(radioListener);
        cbPemlan.addItemListener(radioListener);
        cbMatkomlan.addItemListener(radioListener);
        cbProbstat.addItemListener(radioListener);

        lbTugas = new Label("Tugas : ");
        add(lbTugas); lbTugas.setBounds(100, 90, 62, 20);

        lbKuis = new Label("Kuis : ");
        add(lbKuis); lbKuis.setBounds(100, 120, 70, 20);

        lbUTS = new Label("UTS : ");
        add(lbUTS); lbUTS.setBounds(100, 150, 70, 20);

        lbUAS = new Label("UAS : ");
        add(lbUAS); lbUAS.setBounds(100, 180, 70, 20);

        lbHasil = new Label("Hasil : ");
        add(lbHasil); lbHasil.setBounds(100, 210, 70, 20);

        txtTugas = new TextField(""); add(txtTugas); txtTugas.setBounds(200, 90,  100, 20);
        txtKuis  = new TextField(""); add(txtKuis);  txtKuis.setBounds(200,  120, 100, 20);
        txtUTS   = new TextField(""); add(txtUTS);   txtUTS.setBounds(200,   150, 100, 20);
        txtUAS   = new TextField(""); add(txtUAS);   txtUAS.setBounds(200,   180, 100, 20);
        txtHasil = new TextField(""); add(txtHasil); txtHasil.setBounds(200,  210, 100, 20);
        txtHasil.setEditable(false); 

        btnHitung = new Button("Hitung");
        add(btnHitung); btnHitung.setBounds(130, 245, 100, 25);
        btnHitung.addActionListener(new HitungAction());

        taHasil = new TextArea("HASIL NILAI SEMUA MATA KULIAH\n\n", 8, 35,
                               TextArea.SCROLLBARS_VERTICAL_ONLY);
        taHasil.setEditable(false);
        add(taHasil); taHasil.setBounds(30, 285, 320, 130);

        btnTampilSemua = new Button("Tampilkan nilai semua matkul");
        add(btnTampilSemua); btnTampilSemua.setBounds(60, 425, 240, 25);
        btnTampilSemua.addActionListener(new TampilSemuaAction());
    }

    class RadioAction implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                txtTugas.setText("");
                txtKuis.setText("");
                txtUTS.setText("");
                txtUAS.setText("");
                txtHasil.setText("");
            }
        }
    }

    class HitungAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double tugas = Double.parseDouble(txtTugas.getText().trim());
                double kuis  = Double.parseDouble(txtKuis.getText().trim());
                double uts   = Double.parseDouble(txtUTS.getText().trim());
                double uas   = Double.parseDouble(txtUAS.getText().trim());

                Checkbox dipilih = cbg.getSelectedCheckbox();
                double hasil = 0;

                if (dipilih == cbPemlan) {
                    matkul_Pemlan.setNilai(tugas, kuis, uts, uas);
                    hasil = matkul_Pemlan.hitungNilaiAkhir();
                    sudahHitungPemlan = true;

                } else if (dipilih == cbASD) {
                    matkul_ASD.setNilai(tugas, kuis, uts, uas);
                    hasil = matkul_ASD.hitungNilaiAkhir();
                    sudahHitungASD = true;

                } else if (dipilih == cbMatkomlan) {
                    matkul_Matkomlan.setNilai(tugas, kuis, uts, uas);
                    hasil = matkul_Matkomlan.hitungNilaiAkhir();
                    sudahHitungMatkomlan = true;

                } else if (dipilih == cbProbstat) {
                    matkul_Probstat.setNilai(tugas, kuis, uts, uas);
                    hasil = matkul_Probstat.hitungNilaiAkhir();
                    sudahHitungProbstat = true;
                }

                txtHasil.setText(String.valueOf(hasil));

            } catch (NumberFormatException ex) {
                txtHasil.setText("Input tidak valid!");
            }
        }
    }

    class TampilSemuaAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            sb.append("HASIL NILAI SEMUA MATA KULIAH\n\n");

            if (sudahHitungPemlan)
                sb.append(String.format("%-12s   : %s%n", "Pemlan", matkul_Pemlan.getNilaiAkhir()));
                
            if (sudahHitungASD)
                sb.append(String.format("%-12s     : %s%n", "ASD", matkul_ASD.getNilaiAkhir()));
                
            if (sudahHitungMatkomlan)
                sb.append(String.format("%-12s : %s%n", "Matkomlan", matkul_Matkomlan.getNilaiAkhir()));
                
            if (sudahHitungProbstat)
                sb.append(String.format("%-12s    : %s%n", "Probstat", matkul_Probstat.getNilaiAkhir()));

            if (!sudahHitungPemlan && !sudahHitungASD && !sudahHitungMatkomlan && !sudahHitungProbstat) {
                sb.append("Belum ada mata kuliah yang dihitung.");
            }

            taHasil.setText(sb.toString());
        }
    }

    public static void main(String[] args) {
        MainBab9No1 window = new MainBab9No1();
        window.setTitle("Hitung Nilai Akhir dengan GUI java.awt");
        window.setSize(380, 490);
        window.setVisible(true);
    }
}
