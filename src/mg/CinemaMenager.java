package mg;

import java.util.Scanner;

public class CinemaMenager {


    public static void main(String[] args) {
	// write your code here
        cinemaStart client = new cinemaStart();
        client.cinemaStarts();
        client.showMenu();
            }
        }

class cinemaStart {
    int row;
    int col;
    int rowUser;
    int colUser;
    Scanner scanner = new Scanner(System.in);
    String[][] cinema = new String[row][col];
    int soldTickets = 0;
    float percent = 0;
    int totalSeats = 0;
    int ticketCost = 0;
    int currentIncome = 0;

    void cinemaStarts() {


        System.out.println("Enter the number of rows: ");
        row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        col = scanner.nextInt();

        cinema = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cinema[i][j] = "S";
            }
        }
    }

    void cinemaDrawUser() {
        System.out.println("Cinema:");
        for (int i = 1; i <= col; i++) {
            System.out.printf(i == 1 ? "  1 " : "%d ", i);
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < col; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void cinemaBookingDraw() {
        System.out.println("Enter a row number: ");
        rowUser = scanner.nextInt();
        System.out.println("Enter a seat number in that row: ");
        colUser = scanner.nextInt();

        if (rowUser > row || rowUser < 0 || colUser > col || colUser < 0) {
            System.out.println("Wrong input");
            cinemaBookingDraw();
        }
        else
            cinemaBooking();
    }

    void cinemaBooking() {
        if ("B".equals(cinema[rowUser-1][colUser-1])){
            System.out.println("That ticket has already been purchased!");
            cinemaBookingDraw();
        }
        else{
            cinema[rowUser - 1][colUser - 1] = "B";
            ticketPrice();
            currentIncome();
            soldTickets++;
        }
    }

    void ticketPrice(){
        //obliczenie ceny biletu
        totalSeats = row * col;

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

    void totalIncomes() {
        int totalIncome = 0;
        totalSeats = row*col;
        if (totalSeats < 60) {
            totalIncome = 10 * totalSeats;
        }
        else {
            if (row % 2 == 0) {
                totalIncome = col * (row/2) * 10 + col * (row/2) * 8;
            }
            else
                totalIncome = (col * (row - (row/2)) * 8) + (col * (row/2) * 10);
        }
        System.out.println("Total income: $" + totalIncome);
    }

    void currentIncome() {

        totalSeats = row * col;

        if (totalSeats < 60) {
            ticketCost = 10;
        }
        else{
            if(rowUser <= row/2) {
                ticketCost = 10;
            }
            else{
                ticketCost = 8;
            }
        }
        currentIncome = currentIncome + ticketCost;
    }

    void statistics(){
        if (soldTickets ==0){
            percent = 0;
        }
        else{
            percent = (float) (soldTickets *  100.0/totalSeats);
        }

        String percenteges = String.format("Percentage: %.2f", percent);


        System.out.println("Number of purchased tickets: " + soldTickets);
        System.out.println(percenteges + "%");
        System.out.println("Current income: $" + currentIncome);
        totalIncomes();

    }

    void showMenu(){

        int option;

        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    cinemaDrawUser();
                    break;
                case 2:
                    cinemaBookingDraw();
                    break;
                case 3:
                    statistics();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Enter a valid number!");
                    break;
            }
        }
        while(option != 0);


    }
}
