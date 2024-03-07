/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public class Vehicle {

    private String brand;
    private String color;
    private Customer customer;
    static ObjArr allVehiclesList = new ObjArr();

    Vehicle(String brand, String color, Customer customer) {
        this.brand = brand;
        this.color = color;
        this.customer = customer;
        customer.addToVehicleList(this);
        allVehiclesList.add(this);
    }

    Customer getCustomer() {
        return customer;
    }

    String getColor() {
        return color;
    }

    String getBrand() {
        return brand;
    }

    void setBrand(String brand) {
        this.brand = brand;
    }

    void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return ("Brand: " + brand + ", Color: " + color + ", Customer: " + customer.getName());
    }
}
