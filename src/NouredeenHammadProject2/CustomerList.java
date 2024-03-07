/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public abstract class CustomerList {

    static ObjArr allCustomersList = new ObjArr();

    static void addToList(Customer customer) {
        allCustomersList.add(customer);
    }

    static ObjArr getAllCustomersList() {
        return allCustomersList;
    }

    static void printHighestSpending() {
        int max = 0;
        Customer maxC = null;
        Customer currentC = null;
        for (int i = 0; i < allCustomersList.length(); i++) {
            currentC = (Customer) allCustomersList.getObj(i);
            if (currentC.getSpending() > max) {
                max = currentC.getSpending();
                maxC = currentC;
            }
        }
        System.out.println("The highest spending customer is:");
        System.out.println(maxC.getName() + " ,spendings:" + maxC.getSpending());
        maxC.printRendezvous();
    }

    static void printInfoMostRendezvous() {
        if (allCustomersList.length() != 0) {
            int max = 0;
            Customer currentC = null;
            Customer target = null;
            for (int i = 0; i < allCustomersList.length(); i++) {
                currentC = (Customer) allCustomersList.getObj(i);
                if (currentC.getAssignedBreakdowns().length() > max) {
                    max = currentC.getAssignedBreakdowns().length();
                    target = currentC;
                }
            }
            System.out.println("The customer with the most rendezvous is:");
            System.out.println(target.toString());
            System.out.println("Their vehicles list:");
            target.getVehicleList().printInfo();
            System.out.println("Their breakdowns list:");
            target.getAssignedBreakdowns().printInfo();
            System.out.println("Their rendezvous list:");
            for (int i = 0; i < target.getAssignedBreakdowns().length(); i++) {
                System.out.println(((Breakdown) target.getAssignedBreakdowns().getObj(i)).getRendezvous().toString());
            }
        } else {
            System.out.println("No Customers have been added to the system.");
        }
    }

    static void printRendezvous(String name) {
        Customer customer = nameSearch(name);
        if (customer != null) {
            System.out.println("The customer with the most rendezvous is:" + customer.getName());
            customer.printRendezvous();
        }
    }

    static private void printSearchResults(ObjArr target) {
        if (target.length() != 0) {
            System.out.println("Customers matching search criteria:");
            for (int i = 0; i < target.length(); i++) {
                System.out.println(((Customer) target.getObj(i)).toString());
                ((Customer) target.getObj(i)).printRendezvous();
            }
        } else {
            System.out.println("No results found");
        }
    }

    static private Customer nameSearch(String name) {
        Customer target = null;
        for (int i = 0; i < allCustomersList.length(); i++) {
            if (name.equals(((Customer) allCustomersList.getObj(i)).getName())) {
                target = (Customer) allCustomersList.getObj(i);
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

    static void searchStartsWith(char start) {
        if (allCustomersList.length() == 0) {
            System.out.println("Customer database is empty.");
            return;
        }

        ObjArr target = new ObjArr();
        Customer currentC;
        for (int i = 0; i < allCustomersList.length(); i++) {
            currentC = (Customer) allCustomersList.getObj(i);
            if (currentC.getName().charAt(0) == start
                    || currentC.getName().charAt(0) == start + 32
                    || currentC.getName().charAt(0) == start - 32) {
                target.add(currentC);
            }
        }
        printSearchResults(target);
    }

    static void searchEndsWith(char end) {
        if (allCustomersList.length() == 0) {
            System.out.println("Customer database is empty.");
            return;
        }

        ObjArr target = new ObjArr();
        Customer currentC;
        for (int i = 0; i < allCustomersList.length(); i++) {
            currentC = (Customer) allCustomersList.getObj(i);
            if (currentC.getName().charAt(currentC.getName().length() - 1) == end
                    || currentC.getName().charAt(currentC.getName().length() - 1) == end + 32
                    || currentC.getName().charAt(currentC.getName().length() - 1) == end - 32) {
                target.add(currentC);
            }
        }
        printSearchResults(target);
    }

    static void searchMixed(char start, char mid, char end) {
        if (allCustomersList.length() == 0) {
            System.out.println("Customer database is empty.");
            return;
        }

        ObjArr target = new ObjArr();
        Customer currentC;
        for (int i = 0; i < allCustomersList.length(); i++) {
            currentC = (Customer) allCustomersList.getObj(i);
            boolean doesStart = false;
            if (currentC.getName().charAt(0) == start
                    || currentC.getName().charAt(0) == start + 32
                    || currentC.getName().charAt(0) == start - 32) {
                doesStart = true;
            }
            boolean doesEnd = false;
            if (currentC.getName().charAt(currentC.getName().length() - 1) == end
                    || currentC.getName().charAt(currentC.getName().length() - 1) == end + 32
                    || currentC.getName().charAt(currentC.getName().length() - 1) == end - 32) {
                doesEnd = true;
            }
            boolean doesContain = false;
            for (int j = 1; j < currentC.getName().length() - 2; j++) {
                if (currentC.getName().charAt(j) == mid
                        || currentC.getName().charAt(j) == mid + 32
                        || currentC.getName().charAt(j) == mid - 32) {
                    doesContain = true;
                }
            }
            if (doesStart && doesEnd && doesContain) {
                target.add(currentC);
            }
        }
        printSearchResults(target);
    }

    static void complexAsteriskSearch(String asterisk) {
        if (allCustomersList.length() == 0) {
            System.out.println("Customer database is empty.");
            return;
        }

        ObjArr target = new ObjArr();
        Customer currentC;
        for (int i = 0; i < allCustomersList.length(); i++) {
            currentC = (Customer) allCustomersList.getObj(i);
            if (doesNameMatchAsterisk(asterisk, currentC.getName())) {
                target.add(currentC);
            }
        }
        printSearchResults(target);

    }

    //  TwoMad
    //  *w*m*d
    static private boolean doesNameMatchAsterisk(String asterisk, String name) {
        if (asterisk.length() != name.length()) {
            return false;
        }

        boolean isMatching = true;
        for (int i = 0; i < asterisk.length(); i++) {
            if (asterisk.charAt(i) != '*') {
                if (asterisk.charAt(i) == name.charAt(i)
                        || asterisk.charAt(i) == name.charAt(i) - 32
                        || asterisk.charAt(i) == name.charAt(i) + 32) {

                } else {
                    return false;
                }
            }

        }

        return isMatching;
    }

    static void deleteCustomer(Customer customer) {
        boolean hasActiveBreakdowns = false;
        for (int i = 0; i < customer.getAssignedBreakdowns().length(); i++) {
            if (((Breakdown) customer.getAssignedBreakdowns().getObj(i)).getIsActive()) {
                hasActiveBreakdowns = true;
                break;
            }
        }
        if (hasActiveBreakdowns) {
            System.out.println("This customer has active Breakdowns, delete unsuccessful");
        } else {
            for (int i = 0; i < customer.getAssignedBreakdowns().length(); i++) {
                BreakdownList.deleteBreakdown((Breakdown) customer.getAssignedBreakdowns().getObj(i));
            }
            customer.getAssignedBreakdowns().deleteAll();
            allCustomersList.delete(customer);
            System.out.println("Customer deleted successfully.");
        }
    }

}
