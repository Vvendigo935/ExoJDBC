package org.example.Exo_JDBC2.utility;

import java.util.Scanner;

public class IhmExo2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Create customer and bank account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Show customers");
            System.out.println("5. Exit");
            System.out.print("Choices : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ;
                    break;
                case 2:
                    ;
                    break;
                case 3:
                    ;
                    break;
                case 4:
                    ;
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Impossible choice !");
            }
        }
        System.out.println("GoodBye !");
    }



































}
