// package Praktikum_Pemrograman_Lanjut.BAB6_AULYASHABRINAAHMADEWI_255150207111065;

// import java.util.*;
// public class MainEmployee {
//     public static void main(String[] args) {
//         Manager boss = new Manager("Steven", 80000, 1987, 12, 15);
//         boss.setBonus(5000);
//         Employee staff = new Employee("Donni", 50000, 1989, 10,1);
//         System.out.println("nama boss : " + boss.getName()+", salary = "+boss.getSalary());
//         System.out.println("nama staff : " + staff.getName()+", salary = "+staff.getSalary());
//     }
// }

// class Employee {
//     private String name;
//     private double salary;
//     private Date hireday;

//     public Employee(String name, double salary, int year,int month, int day){
//         this.name = name;
//         this.salary = salary;
//         GregorianCalendar calendar = new
//         GregorianCalendar(year,month-1,day);
//         this.hireday = calendar.getTime();
//     }

//     public String getName(){
//         return name;
//     }

//     public double getSalary(){
//          return salary;
//     }

//     public void raiseSalary(double byPercent){
//         double raise = salary * byPercent/100;
//         salary+=raise;
//     }
// }

// class Manager extends Employee {
//     private double bonus;
//     public Manager(String name, double salary, int year, int month, int day){
//         super(name, salary, year, month, day);
//         bonus = 0;
//     }

//     public void setBonus(double bonus){
//         this.bonus = bonus;
//     }

//     public double getSalary(){
//         double baseSalary = super.getSalary();
//         return baseSalary+bonus;
//     }
// }