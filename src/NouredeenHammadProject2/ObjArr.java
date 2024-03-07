/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public class ObjArr {

    private Object[] content;

    ObjArr() {
        this.content = new Object[0];
    }

    void add(Object obj) {

        if (this.content.length == 0) {
            Object[] newArray = new Object[this.content.length + 1];
            newArray[0] = obj;
            this.content = newArray;
        } else if (isSameType(obj)) {
            Object[] newArray = new Object[this.content.length + 1];
            for (int i = 0; i < this.content.length; i++) {
                newArray[i] = this.content[i];
            }
            newArray[this.content.length] = obj;
            this.content = newArray;
        } else {
            System.out.println("Error! Cannot add different object types in the same ObjArr.");
        }

    }

    private boolean isSameType(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == content[0].getClass()) {
            return true;
        } else {
            return false;
        }
    }

    void delete(Object target) {
        boolean isTargetFound = false;
        Object[] newArray = new Object[this.content.length - 1];
        if (this.content.length == 0) {
            System.out.println("Error! Can not delete from an empty Object Array");
        } else {
            int targetIndex = -1;
            for (int i = 0; i < this.content.length; i++) {
                if (this.content[i] == target) {
                    targetIndex = i;
                    isTargetFound = true;
                }
            }
            if (isTargetFound) {
                if (targetIndex == this.content.length - 1) {
                    for (int i = 0; i < this.content.length - 1; i++) {
                        newArray[i] = this.content[i];
                    }
                } else {
                    for (int i = 0, j = 0; i < this.content.length; i++, j++) {
                        if (i == targetIndex) {
                            i++;
                        }
                        newArray[j] = this.content[i];
                    }
                }

            } else {
                System.out.println("Object not found in Object Array");
            }
        }
        this.content = newArray;
    }

    void deleteAll() {
        this.content = null;
    }

    Object getObj(int index) {
        return content[index];
    }

    int length() {
        return this.content.length;
    }

    void printInfo() {
        for (int i = 0; i < this.content.length; i++) {
            System.out.println(this.content[i].toString());
        }
    }
}
