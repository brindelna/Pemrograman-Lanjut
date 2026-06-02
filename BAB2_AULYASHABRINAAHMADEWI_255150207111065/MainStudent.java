package Praktikum_Pemrograman_Lanjut.BAB2_AULYASHABRINAAHMADEWI_255150207111065;
import java.util.Scanner;

class Student {
    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private double average;
    private static int counter = 0;

    public Student() {
        name = "";
        address = "";
        age = 0;
        counter++;
    }

    public Student(String n, String a, int ag) {
    // public Student(String n, String a, int ag, int math, int english, int science) {
        name = n;
        address = a;
        age = ag;
        // mathGrade = math;
        // englishGrade = english; 
        // scienceGrade = science;
        // counter++;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAddress(String a) {
        address = a;
    }

    public void setAge(int ag) {
        age = ag;
    }

    public void setMath(int math) {
        mathGrade = math;
    }

    public void setEnglish(int english) {
        englishGrade = english;
    }

    public void setScience(int science) {
        scienceGrade = science;
    }

    private double getAverage() {
        double result = 0;
        result = (mathGrade + scienceGrade + englishGrade) / 3;
        return result;
    }

    // private boolean statusAkhir() {
    //     return getAverage() >= 61;
    // }

    public void displayMessage() {
        System.out.println("Siswa dengan nama " + name);
        System.out.println("beralamat di " + address);
        System.out.println("berumur " + age);
        System.out.println("mempunyai nilai rata-rata " + getAverage());
        // System.out.print("Status akhir ");
        // if (statusAkhir()) {
        //     System.out.println("lolos");
        // } else {
        //     System.out.println("remidi");
        // }
    }

    // public static void jumlahObjek() {
    //     System.out.println("Jumlah objek yang telah dibuat " + counter);
    // }
}

public class MainStudent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Student anna = new Student();
        anna.setName("Anna");
        anna.setAddress("Malang");
        anna.setAge(20);
        anna.setMath(100);
        anna.setScience(89);
        anna.setEnglish(80);
        anna.displayMessage();

        // menggunakan constructor lain
        System.out.println("===================");
        Student chris = new Student("Chris", "Kediri", 21);
        chris.setMath(70);
        chris.setScience(60);
        chris.setEnglish(90);
        chris.displayMessage();

        // siswa dengan nama anna dirubah informasi alamat dan umurnya melalui constructor
        System.out.println("===================");
        anna = new Student("Anna", "Batu", 18);
        anna.displayMessage();

        // siswa dengan nama chris dirubah informasi alamat dan umurnya melalui method
        System.out.println("===================");
        chris.setAddress("Surabaya");
        chris.setAge(22);
        chris.displayMessage();

        // System.out.println("===================");
        // Student chris = new Student("Chris", "Kediri", 21, 70, 90, 60);
        // chris.displayMessage();

        // System.out.println("===================");
        // Student anna = new Student("Anna", "Batu", 18, 50, 60, 45);
        // anna.displayMessage();

        // System.out.print("Masukkan jumlah siswa : ");
        // int jumlahSiswa = in.nextInt();
        // in.nextLine();

        // Student[] siswa = new Student[jumlahSiswa];

        // for (int i=0; i<jumlahSiswa; i++) {
        //     System.out.println("Masukkan data siswa ke-" + (i+1));
        //     System.out.print("Nama : ");
        //     String name = in.nextLine();
        //     System.out.print("Alamat : ");
        //     String address = in.nextLine();
        //     System.out.print("Umur : ");
        //     int age = in.nextInt();
        //     System.out.print("Nilai Matematika : ");
        //     int mathGrade = in.nextInt();
        //     System.out.print("Nilai Bahasa Inggris : ");
        //     int englishGrade = in.nextInt();
        //     System.out.print("Nilai IPA : ");
        //     int scienceGrade = in.nextInt();
        //     in.nextLine();
        //     siswa[i] = new Student(name, address, age, mathGrade, englishGrade, scienceGrade);
        // }

        // System.out.println("===================");
        // for (Student s : siswa) {
        //     s.displayMessage();
        //     System.out.println("===================");
        // }

        // System.out.println("===================");
        // Student.jumlahObjek();
    }
}