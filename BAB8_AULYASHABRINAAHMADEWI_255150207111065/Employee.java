package Praktikum_Pemrograman_Lanjut.BAB8_AULYASHABRINAAHMADEWI_255150207111065;

public class Employee implements Payable {
    private Integer registrationNumber;
    private String name;
    private Integer salaryPerMonth;
    private Invoice[] invoices;

    public Employee(Integer registrationNumber, String name, Integer salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public double getPayableAmount() {
        double totalHutang = 0;
        for (Invoice inv : invoices) {
            if (inv != null) {
                totalHutang += inv.getPayableAmount();
            }
        }
        return salaryPerMonth - totalHutang;
    }

    public void tampilkanDetailKaryawan() {
        System.out.println("ID Karyawan   : " + registrationNumber);
        System.out.println("Nama Karyawan : " + name);
        System.out.println("Gaji Pokok    : Rp" + salaryPerMonth);
        System.out.println("--- Detail Belanja Koperasi ---");
        for (Invoice inv : invoices) {
            if (inv != null) {
                System.out.println(inv.toString());
            }
        }
        System.out.println("-------------------------------");
        System.out.printf("Gaji Bersih   : Rp%,10.0f\n", getPayableAmount());
    }
}
