/*
 * @file Nouredeen Hammad Project2
 * @description Breakdown management system
 * @assignment Project 2
 * @date 31/12/2021 -> 23/1/2022
 * @author Nouredeen Ahmed Mahmoud Ali Hammad / nouredeen.ahmed@stu.fsm.edu.tr
 * @studentId 2121221362
 */
package project2;

public class Rendezvous {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;
    private long secondsFrom0;
    private Breakdown breakdown;
    static Rendezvous now;

    Rendezvous(int day, int month, int year, int hour, int minute, int second) {
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        if (year / 1000 > 0) {
            this.year = year;
        } else {
            this.year = year + 2000;
        }
        this.setSecondsPassed();
    }

    private void setSecondsPassed() { //20.11.2020,12:30
        long sum = 0;
        sum += ((long) this.getYear() - 1) * 12 * 30 * 24 * 60 * 60;
        sum += ((long) this.getMonth() - 1) * 30 * 24 * 60 * 60;
        sum += ((long) this.getDay() - 1) * 24 * 60 * 60;
        sum += ((long) this.getHour() - 1) * 60 * 60;
        sum += ((long) this.getMinute() - 1) * 60;
        sum += (long) this.getSecond() - 1;
        this.secondsFrom0 = sum;
    }

    static void setTodayDate(Rendezvous date) {
        now = date;
    }

    Rendezvous getTodayDate() {
        return this.now;
    }

    void setBreakdown(Breakdown breakdown) {
        this.breakdown = breakdown;
    }

    Breakdown getBreakdown() {
        return breakdown;
    }

    int getDay() {
        return day;
    }

    int getMonth() {
        return month;
    }

    int getYear() {
        return year;
    }

    int getHour() {
        return hour;
    }

    int getMinute() {
        return minute;
    }

    int getSecond() {
        return second;
    }

    long getSecondsFrom0() {
        return secondsFrom0;
    }

    boolean isInTheFuture() {
        if (this.secondsFrom0 - now.secondsFrom0 > 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkMoreThan24Hr() {
        if (now.secondsFrom0 - this.secondsFrom0 > 86400) {
            return true;
        } else {
            return false;
        }
    }

    private String timeToString() {
        String returnString = "";
        if (hour / 10 < 1) {
            returnString += "0" + hour;
        } else {
            returnString += hour;
        }
        if (minute / 10 < 1) {
            returnString += ":0" + minute;
        } else {
            returnString += ":" + minute;
        }
        if (second / 10 < 1) {
            returnString += ":0" + second;
        } else {
            returnString += ":" + second;
        }
        return returnString;
    }

    private String dateToString() {
        String returnString = "";
        if (this.day / 10 < 1) {
            returnString += "0" + day;
        } else {
            returnString += day;
        }
        if (month / 10 < 1) {
            returnString += ".0" + month;
        } else {
            returnString += "." + month;
        }
        return returnString + "." + year;
    }

    @Override
    public String toString() {
        return (this.dateToString() + "," + this.timeToString());
    }
}
