package Praktikum_Pemrograman_Lanjut.BAB9_AULYASHABRINAAHMADEWI_255150207111065;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MainBab9No2 extends JFrame {

    JTextField txNama, txTglLahir, txNoPendaftaran, txNoTelp, txEmail;
    JTextArea  txAlamat;
    JButton    btnSubmit;

    static final Color BIRU_HEADER = new Color(70,  130, 200);
    static final Color BIRU_MUDA   = new Color(230, 240, 255);
    static final Color BIRU_BORDER = new Color(180, 210, 240);
    static final Color PUTIH       = Color.WHITE;
    static final Color ABU_LABEL   = new Color(60,  60,  60);
    static final Color ABU_BORDER  = new Color(200, 200, 200);
    static final Font  FONT_LABEL  = new Font("SansSerif", Font.PLAIN, 13);
    static final Font  FONT_INPUT  = new Font("SansSerif", Font.PLAIN, 13);
    static final Font  FONT_JUDUL  = new Font("SansSerif", Font.BOLD,  14);
    static final Font  FONT_BTN    = new Font("SansSerif", Font.PLAIN, 12);

    public MainBab9No2() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(PUTIH);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(PUTIH);
        root.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel pForm = buatPanelForm();

        root.add(pForm, BorderLayout.CENTER);
        setContentPane(root);
        pack();
        setSize(440, 370);
        setLocationRelativeTo(null);
    }

    JPanel buatPanelForm() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(BIRU_MUDA);
        p.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(BIRU_BORDER, 1, true),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints g = new GridBagConstraints();
        g.insets  = new Insets(7, 5, 7, 5);
        g.anchor  = GridBagConstraints.WEST;
        g.fill    = GridBagConstraints.HORIZONTAL;

        txNama = buatTextField();
        g.gridx=0; g.gridy=0; g.weightx=0.35;
        p.add(buatLabel("Nama Lengkap"), g);
        g.gridx=1; g.weightx=0.65;
        p.add(txNama, g);

        txTglLahir = buatTextField();
        g.gridx=0; g.gridy=1; g.weightx=0.35;
        p.add(buatLabel("Tanggal Lahir"), g);
        g.gridx=1; g.weightx=0.65;
        p.add(txTglLahir, g);

        txNoPendaftaran = buatTextField();
        g.gridx=0; g.gridy=2; g.weightx=0.35;
        p.add(buatLabel("Nomor Pendaftaran"), g);
        g.gridx=1; g.weightx=0.65;
        p.add(txNoPendaftaran, g);

        txNoTelp = buatTextField();
        g.gridx=0; g.gridy=3; g.weightx=0.35;
        p.add(buatLabel("No. Telp"), g);
        g.gridx=1; g.weightx=0.65;
        p.add(txNoTelp, g);

        txAlamat = new JTextArea(3, 20);
        txAlamat.setFont(FONT_INPUT);
        txAlamat.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(ABU_BORDER, 1),
            BorderFactory.createEmptyBorder(3, 5, 3, 5)
        ));
        txAlamat.setLineWrap(true);
        txAlamat.setWrapStyleWord(true);

        g.gridx=0; g.gridy=4; g.weightx=0.35; g.anchor=GridBagConstraints.NORTHWEST;
        p.add(buatLabel("Alamat"), g);
        g.gridx=1; g.weightx=0.65; g.fill=GridBagConstraints.BOTH; g.anchor=GridBagConstraints.WEST;
        p.add(txAlamat, g);
        g.fill = GridBagConstraints.HORIZONTAL; 

        txEmail = buatTextField();
        g.gridx=0; g.gridy=5; g.weightx=0.35; g.anchor=GridBagConstraints.WEST;
        p.add(buatLabel("E-mail"), g);
        g.gridx=1; g.weightx=0.65;
        p.add(txEmail, g);

        btnSubmit = new JButton("submit");
        btnSubmit.setFont(FONT_BTN);
        btnSubmit.setPreferredSize(new Dimension(80, 26));
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(e -> prosesSubmit());

        JPanel pBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        pBtn.setOpaque(false);
        pBtn.add(btnSubmit);

        g.gridx=0; g.gridy=6; g.gridwidth=2; g.weightx=1.0;
        g.insets = new Insets(12, 5, 0, 5);
        p.add(pBtn, g);

        return p;
    }

    void prosesSubmit() {
        StringBuilder err = new StringBuilder();
        if (txNama.getText().trim().isEmpty())
            err.append("• Nama Lengkap belum diisi\n");
        if (txTglLahir.getText().trim().isEmpty())
            err.append("• Tanggal Lahir belum diisi\n");
        if (txNoPendaftaran.getText().trim().isEmpty())
            err.append("• Nomor Pendaftaran belum diisi\n");
        if (txNoTelp.getText().trim().isEmpty())
            err.append("• No. Telp belum diisi\n");
        if (txAlamat.getText().trim().isEmpty())
            err.append("• Alamat belum diisi\n");
        if (txEmail.getText().trim().isEmpty())
            err.append("• E-mail belum diisi\n");

        if (err.length() > 0) {
            JOptionPane.showMessageDialog(this,
                "Harap lengkapi kolom berikut:\n\n" + err.toString(),
                "Peringatan",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        int pilih = JOptionPane.showConfirmDialog(this,
            "Apakah anda yakin data yang Anda isi sudah benar?",
            "Konfirmasi",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (pilih == JOptionPane.OK_OPTION) {
            tampilkanHasil();
        }
    }

    void tampilkanHasil() {
        JFrame jHasil = new JFrame("Data Mahasiswa");
        jHasil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jHasil.setResizable(false);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(PUTIH);
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblJudul = new JLabel("Data Mahasiswa", SwingConstants.CENTER);
        lblJudul.setFont(FONT_JUDUL);
        lblJudul.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 0));

        JTextArea taHasil = new JTextArea();
        taHasil.setFont(new Font("Monospaced", Font.PLAIN, 12));
        taHasil.setEditable(false);
        taHasil.setBackground(PUTIH);
        taHasil.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(ABU_BORDER, 1),
            BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        String isi =
            String.format("%-16s: %s%n", "Nama",           txNama.getText().trim())         +
            String.format("%-16s: %s%n", "Tanggal Lahir",  txTglLahir.getText().trim())      +
            String.format("%-16s: %s%n", "No.Pendaftaran", txNoPendaftaran.getText().trim()) +
            String.format("%-16s: %s%n", "No.Telp",        txNoTelp.getText().trim())        +
            String.format("%-16s: %s%n", "Alamat",         txAlamat.getText().trim())        +
            String.format("%-16s: %s%n", "E-mail",         txEmail.getText().trim());

        taHasil.setText(isi);

        root.add(lblJudul, BorderLayout.NORTH);
        root.add(taHasil,  BorderLayout.CENTER);

        jHasil.setContentPane(root);
        jHasil.setSize(360, 220);
        jHasil.setLocationRelativeTo(this);
        jHasil.setVisible(true);
    }

    JTextField buatTextField() {
        JTextField tf = new JTextField(20);
        tf.setFont(FONT_INPUT);
        tf.setPreferredSize(new Dimension(220, 26));
        tf.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(ABU_BORDER, 1),
            BorderFactory.createEmptyBorder(3, 5, 3, 5)
        ));
        return tf;
    }

    JLabel buatLabel(String teks) {
        JLabel lbl = new JLabel(teks);
        lbl.setFont(FONT_LABEL);
        lbl.setForeground(ABU_LABEL);
        return lbl;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            MainBab9No2 f = new MainBab9No2();
            f.setVisible(true);
        });
    }
}