/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public class Technician extends Person {

    private ObjArr assignedBreakdowns;

    Technician(String name) {
        super(name, 0);
        assignedBreakdowns = new ObjArr();
        TechnicianList.addToList(this);
    }

    void assignBreakdown(Breakdown breakdown) {
        assignedBreakdowns.add(breakdown);
        breakdown.setTechnician(this);
    }

    private boolean checkIfAssigned(Breakdown breakdown) {
        boolean isAssignedtoHim = false;
        Breakdown currentB;
        for (int i = 0; i < assignedBreakdowns.length(); i++) {
            currentB = (Breakdown) assignedBreakdowns.getObj(i);
            if (currentB == breakdown) {
                isAssignedtoHim = true;
                break;
            }
        }
        return isAssignedtoHim;
    }

    void resolveBreakdown(Breakdown breakdown, int hour, int minutes, int seconds) {
        if (checkIfAssigned(breakdown)) {
            if (breakdown.getIsActive()) {
                breakdown.setIsActive(false);
                breakdown.setIsResolved(true);
                breakdown.setResolutionDuration(hour, minutes, seconds);
                this.setBalance(this.getBalance() + breakdown.getPrice());
                breakdown.getVehicle().getCustomer().pay(breakdown.getPrice());
            } else {
                System.out.println("Error! Cannot resolve an inactive breakdown.");
            }
        } else {
            System.out.println("Given breakdown is not assigned to this technician.");
        }

    }

    ObjArr getAssignedBreakdowns() {
        return assignedBreakdowns;
    }

    private boolean hasAssignedBreakdowns() {
        return assignedBreakdowns.length() != 0;
    }

    void listActiveBreakdowns() {
        if (this.hasAssignedBreakdowns()) {
            ObjArr activeBreakdowns = new ObjArr();
            Breakdown currentB;
            for (int i = 0; i < this.assignedBreakdowns.length(); i++) {
                currentB = (Breakdown) this.assignedBreakdowns.getObj(i);
                if (currentB.getIsActive() == true) {
                    activeBreakdowns.add(currentB);
                }
            }
            if (activeBreakdowns.length() == 0) {
                System.out.println("No active breakdowns found");
            } else {
                activeBreakdowns.printInfo();
            }
        } else {
            System.out.println("No breakdowns assigned to this Technician");
        }
    }
}
