/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public abstract class Person {

    private String name;
    private int balance;

    Person(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    Person(String name) {
        this.name = name;
        this.balance = 0;
    }

    String getName() {
        return name;
    }

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Name:" + name + " ,Balance:" + balance;
    }
}
