/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public class Test {

    public static void main(String[] args) {

        Rendezvous.setTodayDate(new Rendezvous(24, 1, 2022, 12, 0, 0));

        Customer c1 = new Customer("CustOne", 420000);
        Customer c2 = new Customer("CustTwo", 69);
        Customer c3 = new Customer("CustThree", 100000);
        Customer c4 = new Customer("CustFour", 100000);

        Vehicle v1 = new Vehicle("BMW", "White", c1);
        Vehicle v2 = new Vehicle("Kia", "Black", c2);
        Vehicle v3 = new Vehicle("Kia", "Yellow", c3);
        Vehicle v4 = new Vehicle("Porche", "Red", c3);

        Technician t1 = new Technician("TechOne");
        Technician t2 = new Technician("TechTwo");
        Technician t3 = new Technician("TechThree");
        Technician t4 = new Technician("TechFour");

        Rendezvous r1 = new Rendezvous(24, 3, 2023, 10, 40, 3); //3 1 2 2 3
        Rendezvous r2 = new Rendezvous(24, 1, 2021, 8, 20, 34);
        Rendezvous r3 = new Rendezvous(24, 1, 2022, 8, 50, 21);
        Rendezvous r4 = new Rendezvous(23, 1, 2022, 8, 50, 0);
        Rendezvous r5 = new Rendezvous(3, 5, 2023, 12, 3, 0);

        Breakdown b1 = new Breakdown("Oil Change", 350, r1, v1, t1);
        Breakdown b2 = new Breakdown("Engine Failure", 1200, r2, v2, t2);
        Breakdown b3 = new Breakdown("Suspension", 700, r3, v3, t3);
        Breakdown b4 = new Breakdown("Oil Change", 350, r4, v4, t3);

        System.out.println("///////////////////////1///////////////////////");
        TechnicianList.listActiveBreakdowns("Ahmet");
        System.out.println("");
        TechnicianList.listActiveBreakdowns("TechOne");
        System.out.println("");
        TechnicianList.listActiveBreakdowns("TechThree");
        System.out.println("");
        TechnicianList.listActiveBreakdowns("TechFour");
        System.out.println("");

        System.out.println("///////////////////////2///////////////////////");
        BreakdownList.printUniqueTypes();
        System.out.println("");

        System.out.println("///////////////////////3///////////////////////");
        CustomerList.printInfoMostRendezvous();
        System.out.println("");

        System.out.println("///////////////////////4///////////////////////");
        CustomerList.printRendezvous("CustOne");
        System.out.println("");

        System.out.println("///////////////////////5///////////////////////");
        c1.printRendezvous();
        c1.cancelRendezvous(r1);
        c1.printRendezvous();
        System.out.println("");
        c2.printRendezvous();
        c2.cancelRendezvous(r2);
        c2.printRendezvous();
        System.out.println("");
        c1.editRendezvous(r3, new Rendezvous(14, 3, 2022, 7, 23, 0));

        System.out.println("///////////////////////6///////////////////////");
        CustomerList.complexAsteriskSearch("C*ST***");
        System.out.println("");
        CustomerList.searchStartsWith('b');
        System.out.println("");
        CustomerList.searchEndsWith('o');
        System.out.println("");
        CustomerList.searchMixed('c', 's', 'e');
        System.out.println("");

        System.out.println("///////////////////////7///////////////////////");

        Rendezvous r6 = new Rendezvous(12, 6, 2020, 14, 50, 0);
        Vehicle v5 = new Vehicle("Fiat", "Red", c2);
        Breakdown b5 = new Breakdown("Crash", 3000, r6, v5, t2);

        BreakdownList.getAllBreakdownsList().printInfo();
        System.out.println("");
        CustomerList.deleteCustomer(c2);
        BreakdownList.getAllBreakdownsList().printInfo();
        System.out.println("");
        CustomerList.deleteCustomer(c1);

        System.out.println("///////////////////////8///////////////////////");
        TechnicianList.deleteTechnician(t4);
        System.out.println("");

        System.out.println("///////////////////////9///////////////////////");
        t1.resolveBreakdown(b1, 2, 23, 12);
        t2.resolveBreakdown(b2, 4, 54, 24);
        t3.resolveBreakdown(b3, 1, 31, 5);
        TechnicianList.printHighestEarning();
        System.out.println("");

        System.out.println("///////////////////////10///////////////////////");
        CustomerList.printHighestSpending();
        System.out.println("");

        System.out.println("///////////////////////11///////////////////////");
        BreakdownList.printAvgRevenueAndResolutionTime();
        System.out.println("");

        System.out.println("///////////////////////12///////////////////////");
        BreakdownList.printResolvedBreakdownsBetween(new Rendezvous(2, 4, 2020, 12, 20, 0), new Rendezvous(2, 4, 2026, 12, 20, 0));
        System.out.println("");

        System.out.println("///////////////////////13///////////////////////");
        BreakdownList.printUnresolvedBreakdownsBetween(r2, r3);

    }

}
