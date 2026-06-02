package Praktikum_Pemrograman_Lanjut.BAB7_AULYASHABRINAAHMADEWI_255150207111065;

public class Main {
    public static void main(String[] args) {
        
        SalariedEmployee salariedEmployee =
            new SalariedEmployee("Daniel", "135", 800.00);

        HourlyEmployee hourlyEmployee =
            new HourlyEmployee("Karina", "234", 16.75, 40);

        CommissionEmployee commissionEmployee =
            new CommissionEmployee("Keanu", "145", 10000, .06);

        BasePlusCommissionEmployee basePlusCommissionEmployee =
            new BasePlusCommissionEmployee("Bondan", "234", 5000, .04, 300);

        PieceWorkerEmployee pieceWorkerEmployee1 = 
            new PieceWorkerEmployee("Siti", "456", 2.50, 200);

        PieceWorkerEmployee pieceWorkerEmployee2 =
            new PieceWorkerEmployee("Budi", "567", 3.00, 150);
            
        PieceWorkerEmployee pieceWorkerEmployee3 =
            new PieceWorkerEmployee("Andi", "789", 2.00, 300);
            
        PieceWorkerEmployee pieceWorkerEmployee4 =
            new PieceWorkerEmployee("Dewi", "901", 4.50, 100);

        System.out.println("Employees diproses secara terpisah:\n");

        // System.out.printf("%s\n%s: $%,.2f\n\n",
        //     salariedEmployee, "pendapatan: ", salariedEmployee.earnings());

        // System.out.printf("%s\n%s: $%,.2f\n\n",
        //     hourlyEmployee, "pendapatan: ", hourlyEmployee.earnings());

        // System.out.printf("%s\n%s: $%,.2f\n\n",
        //     commissionEmployee, "pendapatan: ", commissionEmployee.earnings());

        // System.out.printf("%s\n%s: $%,.2f\n\n",
        //     basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());

        System.out.printf("%s\n%s: $%,.2f\n\n",
            pieceWorkerEmployee1, "pendapatan", pieceWorkerEmployee1.earnings());

        System.out.printf("%s\n%s: $%,.2f\n\n",
            pieceWorkerEmployee2, "pendapatan", pieceWorkerEmployee2.earnings());

        System.out.printf("%s\n%s: $%,.2f\n\n",
            pieceWorkerEmployee3, "pendapatan", pieceWorkerEmployee3.earnings());

        System.out.printf("%s\n%s: $%,.2f\n\n",
            pieceWorkerEmployee4, "pendapatan", pieceWorkerEmployee4.earnings());
            
        Employee[] employees = new Employee[4];
        // employees[0] = salariedEmployee;
        // employees[1] = hourlyEmployee;
        // employees[2] = commissionEmployee;
        // employees[3] = basePlusCommissionEmployee;
        employees[0] = pieceWorkerEmployee1;
        employees[1] = pieceWorkerEmployee2;    
        employees[2] = pieceWorkerEmployee3;
        employees[3] = pieceWorkerEmployee4;

        System.out.println("Employees diproses secara polimorfisme:\n");

        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);

            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee =
                    (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf("Gaji pokok setelah dinaikkan 10%% : $%,.2f\n",
                    employee.getBaseSalary());
            }

            System.out.printf("pendapatan: $%,.2f\n\n", currentEmployee.earnings());
        }

        for (int j = 0; j < employees.length; j++) {
            System.out.printf("Employee %d = %s\n", j,
                employees[j].getClass().getName());
        }
    }
}
