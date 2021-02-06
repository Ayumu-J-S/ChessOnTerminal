package util;

import java.util.Scanner;

/**
 * This class contains some methods that are frequently used.
 *
 * @author Ayumu Saito 
 */
public class Utilities {

    /**
     * Display header for assignments.
     *
     * @param name name of the author
     * @param info description of the program
     */
    public static void displayInfo(String name, String info) {
        System.out.println(name);
        System.out.println(info);
    }

    /**
     * Pause with message.
     *
     * @param message message that is printed out before enter
     */
    public static void pause(String message) {
        Scanner kbd = new Scanner(System.in);
        System.out.print(message);
        kbd.nextLine();
    }

    /**
     * Pause with a default message.
     */
    public static void pause() {
        Scanner kbd = new Scanner(System.in);
        System.out.print("Press enter to continue...");
        kbd.nextLine();
    }
}
