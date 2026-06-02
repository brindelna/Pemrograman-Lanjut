package Praktikum_Pemrograman_Lanjut.BAB2_AULYASHABRINAAHMADEWI_255150207111065;

class Rasional {
    private int pembilang, penyebut;

    public Rasional() {
        pembilang = 0;
        penyebut = 0;
    }

    public Rasional(int pbl, int pyb) {
        pembilang = pbl;
        penyebut = pyb;
    }

    // mengecek suatu bilangan adalah rasional atau bukan
    public boolean isRasional() {
        return (penyebut != 0);
    }

    // menyederhanakan bilangan rasional
    public void Sederhana() {
        int temp, A, B;
        if (penyebut == 0) {
            return;
        }
        A = (pembilang < penyebut) ? penyebut : pembilang;
        B = (pembilang < penyebut) ? pembilang : penyebut;

        while (B != 0) {
        //for (; B>0;) {
            temp = A % B;
            A = B;
            B = temp;
        }

        pembilang /= A;
        penyebut /= A;
    }

    public double Cast() {
        return (penyebut == 0.0) ? 0.0 : (double) pembilang / (double) penyebut;
    }

    // operator >
    public boolean moreThan(Rasional A) {
        return (pembilang * A.penyebut > penyebut * A.pembilang);
    }

    // public boolean lessThan(Rasional A) {
    //     return (pembilang * A.penyebut < penyebut * A.pembilang);    
    // }

    // public boolean lessThanOrEqualTo(Rasional A) {
    //     return (pembilang * A.penyebut <= penyebut * A.pembilang);    
    // }   

    // public boolean moreThanOrEqualTo(Rasional A) {
    //     return (pembilang * A.penyebut >= penyebut * A.pembilang);
    // }

    // operator Unary- ---> A = -A
    public void negasi() {
        pembilang = -pembilang;
    }

    // operator unary +=
    public void unaryPlus(Rasional A) {
        pembilang = pembilang * A.penyebut + penyebut * A.pembilang;
        penyebut *= A.penyebut;
    }

    public void minus(Rasional A) {
        pembilang = pembilang * A.penyebut - penyebut * A.pembilang;
        penyebut *= A.penyebut;
    }

    public void times(Rasional A) {
        pembilang *= A.pembilang;
        penyebut *= A.penyebut;
    }

    public void divide(Rasional A) {
        pembilang *= A.penyebut;
        penyebut *= A.pembilang;
    }

    public void cetak() {
        System.out.println(pembilang + "/" + penyebut);
    }
}

public class RasionalDemo {
    public static void main(String[] args) {
        Rasional R1 = new Rasional(1, 2);
        Rasional R2 = new Rasional(1, 3);

        System.out.println("R1.isRasional: " + R1.isRasional());
        System.out.println("R2.isRasional: " + R2.isRasional());
        System.out.println();

        System.out.println("R1 > R2 : " + R1.moreThan(R2));
        // System.out.println("R1 < R2 : " + R1.lessThan(R2));
        // System.out.println("R1 <= R2 : " + R1.lessThanOrEqualTo(R2));
        // System.out.println("R1 >= R2 : " + R1.moreThanOrEqualTo(R2));
        System.out.println();

        System.out.print("R1 : ");
        R1.cetak();
        System.out.print("R2 : ");
        R2.cetak();
        System.out.println();

        R1.Sederhana();
        R2.Sederhana();

        System.out.print("R1 : ");
        R1.cetak();
        System.out.print("R2 : ");
        R2.cetak();
        System.out.println();

        System.out.println("Setelah dilakukan Cast ke double menjadi : ");
        System.out.println("R1 : " + R1.Cast());
        System.out.println("R2 : " + R2.Cast());
        System.out.println();

        R1.minus(R2);
        System.out.print("Nilai dari 'R1 -= R2' : ");
        R1.cetak();
        System.out.println();
        R1.times(R2);
        System.out.print("Nilai dari 'R1 *= R2' : ");
        R1.cetak();
        System.out.println();
        R1.divide(R2);
        System.out.print("Nilai dari 'R1 /= R2' : ");
        R1.cetak();
        System.out.println();
        
        R1.negasi();
        System.out.print("Unary- dari R1 : ");
        R1.cetak();
        System.out.println();

        R1.unaryPlus(R2);
        System.out.print("Nilai dari 'R1 += R2' : ");
        R1.cetak();
        System.out.println();
    }
}