/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import io.airbrake.javabrake.Notifier;

/**
 *
 * @author Acer
 */
public class Test
{

    public int date, month, year;
    static Scanner sc = new Scanner(System.in);
        int projectId = 123;
        String projectKey = "abcdefgh12345678";
        Notifier notifier = new Notifier(projectId, projectKey);

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int checkInputDate() {
        //loop until user input correct
        while (true) {
            try {
                int date = Integer.parseInt(sc.nextLine().trim());
                return date;
            } catch (NumberFormatException e) {
                System.err.println("Input data for day is incorrect format. and in range [1,31]");
                System.out.print("Enter again: ");
                notifier.report(e);
            }
        }
    }

    public int checkInputMonth() {
        //loop until user input correct
        while (true) {
            try {
                int month = Integer.parseInt(sc.nextLine().trim());
                return month;
            } catch (NumberFormatException e) {
                System.err.println("Input data for month is incorrect format. and in range [1,12]");
                System.out.print("Enter again: ");
            }
        }
    }

    public int checkInputYear() {
        //loop until user input correct
        while (true) {
            try {
                int year = Integer.parseInt(sc.nextLine().trim());
                return year;
            } catch (NumberFormatException e) {
                System.err.println("Input data for year is incorrect format.");
                System.out.print("Enter again: ");
            }
        }
    }

    public int checkDateInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            if (year % 400 == 0) {
                return 29;
            } else if (year % 100 == 0) {
                return 28;
            } else if (year % 4 == 0) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return 0;
        }

    }

    public boolean checkDate(int date, int month, int year) {
        if (month < 1 || month > 12) {
            System.out.println(date + "//" +month + "//" +year + " is NOT correct date time.");
            return false;
        }
        if (date < 1) {
            System.out.println(date + "//" +month + "//" +year + " is NOT correct date time.");
            return false;
        }
        if (date <= checkDateInMonth(month, year)) {
            System.out.println(date + "//" +month + "//" +year + " is correct date time.");
            return true;
        } else {
            System.out.println(date + "//" +month + "//" +year + " is NOT correct date time.");
            return false;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("Enter Day: ");
        int date=sc.nextInt();
        //int date = test.checkInputDate();
         System.out.println("Enter Month: ");
        int month = test.checkInputMonth();
        System.out.println("Enter Year: ");
        int year = test.checkInputYear();
        boolean check = test.checkDate(date, month, year);
        
    }

}
