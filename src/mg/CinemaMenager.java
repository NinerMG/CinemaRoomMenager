package mg;

import java.util.Scanner;

public class CinemaMenager {

    public static void main(String[] args) {
	// write your code here

                //rysowanie zarysu dowolnej sali kinowej
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter the number of rows: ");
                int row = scanner.nextInt();

                System.out.println("Enter the number of seats in each row: ");
                int col = scanner.nextInt();

                System.out.println("1. Show the seats");
                System.out.println("2. Buy a ticket");
                System.out.println("0. Exit");

                switch (choice) {
                    case 1:

                }

                String[][] cinema = new String[row][col];
                int totalSeats = row * col;

                String letter = "S";
                int rowNum = 1;
                int colNum = 1;

                System.out.println("Cinema: ");
                for (int i = 0; i < col; i++) {
                    System.out.printf("  %d", colNum);
                    colNum++;
                }

                System.out.println();

                for(int i =0; i < cinema.length; i++) {
                    System.out.printf("%d ", rowNum);
                    rowNum++;
                    for (int j = 0; j < cinema[i].length; j++) {
                        cinema[i][j] = letter;
                        System.out.print(cinema[i][j] + "  ");
                    }
                    System.out.println();
                }
                //wybór miejsca na sali i oznaczenie go

                System.out.println("Enter a row number: ");
                int rowUser = scanner.nextInt();

                System.out.println("Enter a seat number in that row: ");
                int colUser = scanner.nextInt();

                int rowNumUser = 1;
                int colNumUser = 1;

                System.out.println("Cinema: ");
                for (int i = 0; i < col; i++) {
                    System.out.printf("  %d", colNumUser);
                    colNumUser++;
                }

                System.out.println();

                for(int i =0; i < cinema.length; i++) {
                    System.out.printf("%d ", rowNumUser);
                    rowNumUser++;
                    for (int j = 0; j < cinema[i].length; j++) {
                        cinema[i][j] = letter;

                        cinema[rowUser-1][colUser-1] = "B";
                        System.out.print(cinema[i][j] + "  ");
                    }
                    System.out.println();
                }

                //obliczenie ceny biletu
                int ticketCost;
                if (totalSeats < 60) {
                    ticketCost = 10;
                    System.out.println("Ticket price: $" + ticketCost);
                }
                else{
                    if(rowUser <= row/2) {
                        ticketCost = 10;
                        System.out.println("Ticket price: $" + ticketCost);
                    }
                    else{
                        ticketCost = 8;
                        System.out.println("Ticket price: $" + ticketCost);
                    }
                }
            }
        }

