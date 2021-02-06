package Driver;

import chess.Board;
import chess.ChessException;
import chess.InvalidMoveException;
import java.util.Scanner;
import util.Menu;
import static util.Utilities.displayInfo;
import static util.Utilities.pause;

/**
 * This is a driver program for the simple chess program. 
 *
 * @author Ayummu Saito 
 */
public class ChessFileDriver {

    public static void main(String[] args) {

        //display information header
        displayInfo("=========================================================="
                + "\nAyumu.S", "This program is a simple chess game."
                + " The coordinates of the pieces are set as (x,y) "
                + "\nwith x indicating the column number and y indicating the"
                + " row number."
                + "\nWhen you input the coordinates, it has to "
                + "be the coordinate of x followed by a space "
                + "\nfollowed"
                + " by the coordinate of y. \n"
                + "The white pieces are represented in uppercase letters "
                + "and black pieces are represented in"
                + "\nlowercase letters.\n"
                + "============================================================"
        );
        pause();

        //create menu
        Menu m = createMenu();

        //create board
        Board b = new Board();
        int choice;

        //repeat the menu until the user quits
        do {
            m.display();
            choice = m.getChoice();
            switch (choice) {
                case 1:
                    b.display();
                    pause();
                    break;
                case 2:
                    moveOption(b);

                    b.display();
                    pause();
                    break;
                case 3:
                    b = new Board();
                    System.out.println("\nBoard has been reset");
                    pause();
                    break;
                case 4:
                    System.out.println("\nQuiting");
                    pause("Press enter to end...");
                    break;
                case -1:
                    System.out.println("\nInvalid Choice");
                    pause();
                    break;
            }
        } while (choice != 4);
    }

    /**
     * This method creates the Menu for the program and adds each of the options
     *
     * @return the created Menu
     */
    private static Menu createMenu() {
        Menu m = new Menu("Chess Menu", 30, 120);
        m.addOption("Display Board");
        m.addOption("Move Piece");
        m.addOption("Reset Board");
        m.addOption("Quit");
        return m;
    }

    /**
     * This method handles the move option in the menu. Displays the board then
     * gets the move from the user and passes it to the board. Finally it
     * displays the updated board.
     *
     * @param b The board that the move will take place on.
     */
    private static void moveOption(Board b) {
        Scanner kbd = new Scanner(System.in);

        b.display();

        //print out which turn it is currently
        System.out.println((b.getIsWhiteTurn())
                ? "It is white's turn."
                : "It is black's turn.");

        //get piece location
        System.out.print("Enter the coordinates of the piece"
                + " you want to move: ");
        int x1 = kbd.nextInt();
        int y1 = kbd.nextInt();
        kbd.nextLine();

        //get move location
        System.out.print("Enter the coordinates of the "
                + "location you want to move to: ");
        int x2 = kbd.nextInt();
        int y2 = kbd.nextInt();
        kbd.nextLine();

        //try and catch fot the InValidMoveException 
        try {
            b.move(x1, y1, x2, y2);

        } catch (InvalidMoveException ex1) {
            System.out.println(ex1);
            System.out.print("Select a valid location to move to: ");
            x2 = kbd.nextInt();
            y2 = kbd.nextInt();

            try {

                b.move(x1, y1, x2, y2);

            } catch (ChessException ex2) {

                System.out.println(ex2);

            }
        } catch (ChessException ex3) {

            System.out.println(ex3);

        }
    }
}