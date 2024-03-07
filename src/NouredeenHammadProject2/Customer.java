/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public class Customer extends Person {

    private ObjArr vehicleList;
    private ObjArr assignedBreakdowns;
    private int spending;

    Customer(String name, int balance) {
        super(name, balance);
        assignedBreakdowns = new ObjArr();
        vehicleList = new ObjArr();
        spending = 0;
        CustomerList.addToList(this);
    }

    int getSpending() {
        return spending;
    }

    void pay(int cost) {
        spending = spending + cost;
        this.setBalance(this.getBalance() - cost);
    }

    void addToVehicleList(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    void printRendezvous() {
        if (assignedBreakdowns.length() == 0) {
            System.out.println("No rendezvous found.");
        } else {
            System.out.println("Their rendezvous list:");
            for (int i = 0; i < assignedBreakdowns.length(); i++) {
                System.out.println(((Breakdown) assignedBreakdowns.getObj(i)).getRendezvous().toString());
            }
        }

    }

    void assignBreakdown(Breakdown breakdown) {
        assignedBreakdowns.add(breakdown);
    }

    void editRendezvous(Rendezvous oldR, Rendezvous newR) {
        if (oldR.checkMoreThan24Hr()) {
            oldR.getBreakdown().setRendezvous(newR);
            System.out.println("Rendezvous edited successfully");
        } else {
            System.out.println("Less than 24 hours remaining on the rendezvous, editing unsuccessful");
        }
    }

    void cancelRendezvous(Rendezvous rendezvous) {
        if (rendezvous.checkMoreThan24Hr()) {
            assignedBreakdowns.delete(rendezvous.getBreakdown());
            BreakdownList.getAllBreakdownsList().delete(rendezvous.getBreakdown());
            System.out.println("Rendezvous and breakdown information deleted successfully");
        } else {
            System.out.println("Less than 24 hours remaining on the rendezvous, cancellation unsuccessful");
        }
    }

    ObjArr getVehicleList() {
        return vehicleList;
    }

    ObjArr getAssignedBreakdowns() {
        return assignedBreakdowns;
    }

}
