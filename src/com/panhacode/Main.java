package com.panhacode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Query query = new Query();
        Validation validation = new Validation();
        Controller controller = new Controller();

        System.out.println("=============== SET UP LIBRARY ===============");
        System.out.print("Enter Library's Name: ");
        String libraryName = scanner.nextLine().toUpperCase();
        System.out.print("Enter Library's Address: ");
        String libraryAddress = scanner.nextLine();


        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        String formattedDate = dateFormat.format(new Date());
        System.out.println("\"" + libraryName + "\" Library is already created in \"" +
                libraryAddress + "\" address" + " " + "successfully on " + formattedDate);


           int option = 0;
        do {
            System.out.println("======== "+ libraryName + ", " + libraryAddress + " ========");
            System.out.println("1- Add Book");
            System.out.println("2- Show All Books");
            System.out.println("3- Show Available Books");
            System.out.println("4- Borrow Book");
            System.out.println("5- Return Book");
            System.out.println("6- Exit");
            System.out.print("Choose Option(1-6): ");
            option = scanner.nextInt();



            switch (option) {
                case 1 :
                    controller.writeBook();
                    break;

                case 2 :
                    controller.printAllBook();
                    break;
                case 3 :
                    controller.displayBookWithCustomPageSize();
                    break;

                    case 6 : System.out.println("-^- Good Bye -^-");
                    System.exit(0);



                default : System.out.println("Wrong option");
            }
        } while (option != 6);

    }
}