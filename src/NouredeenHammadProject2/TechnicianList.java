/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public abstract class TechnicianList {

    static ObjArr allTechniciansList = new ObjArr();

    static void addToList(Technician technician) {
        allTechniciansList.add(technician);
    }

    ObjArr getAllTechniciansList() {
        return allTechniciansList;
    }

    static private Technician nameSearch(String name) {
        Technician target = null;
        for (int i = 0; i < allTechniciansList.length(); i++) {
            if (name.equals(((Technician) allTechniciansList.getObj(i)).getName())) {
                target = (Technician) allTechniciansList.getObj(i);
                break;
            }
        }
        if (target == null) {
            System.out.println("Error! Name not found");
            return null;
        } else {
            return target;
        }
    }

    static void listActiveBreakdowns(String name) {
        if (allTechniciansList.length() == 0) {
            System.out.println("Technician database is empty");
            return;
        }

        Technician tech = nameSearch(name);
        if (tech != null) {
            tech.listActiveBreakdowns();
        }
    }

    static void printHighestEarning() {
        if (allTechniciansList.length() == 0) {
            System.out.println("Technician database is empty");
            return;
        }
        int max = 0;
        Technician currentT = null;
        Technician maxT = null;
        for (int i = 0; i < allTechniciansList.length(); i++) {
            currentT = (Technician) allTechniciansList.getObj(i);
            if (currentT.getBalance() > max) {
                max = currentT.getBalance();
                maxT = currentT;
            }
        }
        System.out.println("The highest earning technician is:");
        System.out.println(maxT.getName() + " ,earnings:" + maxT.getBalance());
    }

    static void deleteTechnician(Technician technician) {
        ObjArr target = new ObjArr();
        for (int i = 0; i < technician.getAssignedBreakdowns().length(); i++) {
            if (((Breakdown) technician.getAssignedBreakdowns().getObj(i)).getIsActive()) {
                target.add((Breakdown) technician.getAssignedBreakdowns().getObj(i));
            }
        }
        if (target.length() == 0) {
            for (int i = 0; i < technician.getAssignedBreakdowns().length(); i++) {
                ((Breakdown) technician.getAssignedBreakdowns().getObj(i)).setTechnician(null);
            }
            allTechniciansList.delete(technician);
            System.out.println("Technician deleted successfully.");

        } else if (target.length() > 0 && allTechniciansList.length() == 1) {

            System.out.println("Technician cannot be deleted, he has active breakdowns assigned and there are no technicians to take over");

        } else {
            Breakdown currentB;
            for (int i = 0; i < target.length(); i++) {
                ((Technician) allTechniciansList.getObj((int) (Math.random() * (target.length() * 1.0)))).assignBreakdown((Breakdown) target.getObj(i));
            }
            for (int i = 0; i < technician.getAssignedBreakdowns().length(); i++) {
                if (!((Breakdown) technician.getAssignedBreakdowns().getObj(i)).getIsActive()) {
                    BreakdownList.getOldBreakdowns().add((Breakdown) technician.getAssignedBreakdowns().getObj(i));
                }
            }
            allTechniciansList.delete(technician);
            System.out.println("Technician deleted successfully, his active Breakdowns were randomly assigned to other technicians, and his old Breakdowns were archived.");
        }
    }

}
