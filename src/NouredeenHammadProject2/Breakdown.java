/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public class Breakdown {

    private String type;
    private int price;
    private Rendezvous rendezvous;
    private Vehicle vehicle;
    private Technician technician;
    private boolean isActive;
    private boolean isResolved;
    private int resolutionDuration;

    Breakdown(String type, int price, Rendezvous rendezvous, Vehicle vehicle, Technician technician) {
        this.type = type;
        BreakdownList.processType(type);
        this.price = price;
        this.vehicle = vehicle;
        vehicle.getCustomer().assignBreakdown(this);

        this.technician = technician;
        technician.assignBreakdown(this);

        this.rendezvous = rendezvous;
        rendezvous.setBreakdown(this);
        if (rendezvous.isInTheFuture()) {
            this.isActive = true;
        } else {
            this.isActive = false;
        }
        this.isResolved = false;
        this.resolutionDuration = -1;
        BreakdownList.addToList(this);
    }

    Breakdown(String type, int price, Rendezvous rendezvous, Vehicle vehicle) {
        this.type = type;
        BreakdownList.processType(type);
        this.price = price;
        this.vehicle = vehicle;
        vehicle.getCustomer().assignBreakdown(this);

        this.rendezvous = rendezvous;
        rendezvous.setBreakdown(this);
        if (rendezvous.isInTheFuture()) {
            this.isActive = true;
        } else {
            this.isActive = false;
        }
        this.isResolved = false;
        this.resolutionDuration = -1;
        BreakdownList.addToList(this);
    }

    void setResolutionDuration(int hour, int minute, int second) {
        resolutionDuration = (hour * 60 * 60) + (minute * 60) + second;
    }

    int getResolutionDurationSec() {
        return resolutionDuration;
    }

    void setIsResolved(boolean bool) {
        isResolved = bool;
    }

    boolean getIsResolved() {
        return isResolved;
    }

    void setIsActive(boolean bool) {
        isActive = bool;
    }

    boolean getIsActive() {
        return isActive;
    }

    int getPrice() {
        return price;
    }

    void setTechnician(Technician technician) {
        this.technician = technician;
    }

    void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    void setRendezvous(Rendezvous rendezvous) {
        this.rendezvous = rendezvous;
    }

    Technician getTechnician() {
        return technician;
    }

    Vehicle getVehicle() {
        return vehicle;
    }

    Rendezvous getRendezvous() {
        return rendezvous;
    }

    @Override
    public String toString() {

        if (technician == null) {
            return ("Breakdown type:" + type + ", customer:" + vehicle.getCustomer().getName()
                    + ", date and time:" + rendezvous.toString());
        } else {
            return ("Breakdown type:" + type + ", technician:" + technician.getName()
                    + ", customer:" + vehicle.getCustomer().getName() + ", date and time:"
                    + rendezvous.toString());
        }

    }

}
