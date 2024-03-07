/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public abstract class BreakdownList {

    static ObjArr allBreakdownsList = new ObjArr();
    static ObjArr oldBreakdowns = new ObjArr();
    private static ObjArr uniqueTypes = new ObjArr();

    static void addToList(Breakdown breakdown) {
        allBreakdownsList.add(breakdown);
    }

    static void printAvgRevenueAndResolutionTime() {
        int totalRevenue = 0;
        int totalSeconds = 0;
        int noOfResolved = 0;
        Breakdown currentB;
        for (int i = 0; i < allBreakdownsList.length(); i++) {
            currentB = (Breakdown) allBreakdownsList.getObj(i);
            if (currentB.getIsResolved()) {
                noOfResolved++;
                totalSeconds += currentB.getResolutionDurationSec();
                totalRevenue += currentB.getPrice();
            }
        }
        System.out.println("The average revenue of resolved breakdowns is: " + totalRevenue * 1.0 / noOfResolved);
        System.out.println("The average resolution time is: " + (totalSeconds * 1.0 / noOfResolved) / 60 + " minutes");
    }

    static void printResolvedBreakdownsBetween(Rendezvous r1, Rendezvous r2) {
        ObjArr target = new ObjArr();
        Breakdown currentB;
        for (int i = 0; i < allBreakdownsList.length(); i++) {
            currentB = (Breakdown) allBreakdownsList.getObj(i);
            if (r1.getSecondsFrom0() < currentB.getRendezvous().getSecondsFrom0()
                    && currentB.getRendezvous().getSecondsFrom0() < r2.getSecondsFrom0()
                    && currentB.getIsResolved()) {
                target.add(currentB);
            }
        }
        if (target.length() == 0) {
            System.out.println("No resolved breakdowns found between the given dates.");
        } else {
            for (int i = 0; i < target.length(); i++) {
                System.out.println(((Breakdown) target.getObj(i)).toString());
            }
        }
    }

    static void printUnresolvedBreakdownsBetween(Rendezvous r1, Rendezvous r2) {
        ObjArr target = new ObjArr();
        Breakdown currentB;
        for (int i = 0; i < allBreakdownsList.length(); i++) {
            currentB = (Breakdown) allBreakdownsList.getObj(i);
            if (r1.getSecondsFrom0() < currentB.getRendezvous().getSecondsFrom0()
                    && currentB.getRendezvous().getSecondsFrom0() < r2.getSecondsFrom0()
                    && currentB.getIsResolved() == false) {
                target.add(currentB);
            }
        }
        if (target.length() == 0) {
            System.out.println("No un-resolved breakdowns found between the given dates.");
        } else {
            System.out.println("Un-resolved breakdowns between " + r1.toString() + " and " + r2.toString());
            for (int i = 0; i < target.length(); i++) {
                currentB = (Breakdown) target.getObj(i);
                System.out.println(currentB.toString());
                System.out.println(currentB.getVehicle().getCustomer().toString());
                System.out.println(currentB.getVehicle().toString());
                System.out.println("");
            }
        }
    }

    static void processType(String newType) {
        if (uniqueTypes.length() == 0) {
            uniqueTypes.add(newType);
        } else {
            boolean isUnique = true;
            for (int i = 0; i < uniqueTypes.length(); i++) {
                if (uniqueTypes.getObj(i) == newType) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueTypes.add(newType);
            }
        }
    }

    static void printUniqueTypes() {
        System.out.println("List of Unique Breakdown types in the system:");
        uniqueTypes.printInfo();
    }

    static ObjArr getOldBreakdowns() {
        return oldBreakdowns;
    }

    static ObjArr getAllBreakdownsList() {
        return allBreakdownsList;
    }

    static void deleteBreakdown(Breakdown target) {
        allBreakdownsList.delete(target);
    }

}
