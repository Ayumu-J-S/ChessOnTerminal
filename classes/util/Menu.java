package util;

import java.util.Scanner;

/**
 * This is menu object class, which helps to make a menu driven program.
 *
 * @author Ayumu Saito 
 */
public class Menu {

    //declare and initialize the max number of options
    public static final int NUM_OPTIONS = 10;

    //declare variables to hold information for menu and menuOption array
    private String[] menuOptions = new String[NUM_OPTIONS];
    private String menuTitle;
    private int optionsAdded;

    //declare height and the width of menu
    public final int HEIGHT_MENU;
    public final int WIDTH_MENU;

    /**
     * Constructor for the menu Object.
     *
     * @param menuTitle title of the menu
     * @param height height of the menu
     * @param width width of the menu
     */
    public Menu(String menuTitle, int height, int width) {
        this.menuTitle = menuTitle;
        HEIGHT_MENU = height;
        WIDTH_MENU = width;
    }

    /**
     * Method for displaying the menu centered in the window according to height
     * and width passed to the constructor.
     */
    public void display() {
        int widthOptions = 0; //width of the options

        //determines the width of the options 
        for (int i = 0; i < optionsAdded; i++) {
            if (menuOptions[i].length() > widthOptions) {
                widthOptions = menuOptions[i].length();
            }
        }

        //print out the vertical spaces before printing each option in the menu
        if (optionsAdded == 0) {
            //println half of the height and -2, which is height of menuTitle
            for (int i = 0; i <= HEIGHT_MENU / 2 - 2; i++) {
                System.out.println("");
            }
        } else if (optionsAdded == 1) {
            //1 is space between menuTitle and menuOptions
            for (int i = 0; i <= (HEIGHT_MENU / 2) - (optionsAdded + 1); i++) {
                System.out.println("");
            }
        } else {
            //+2 is tile and the space between menuTitle and menuOptions and
            for (int i = 0; i <= (HEIGHT_MENU / 2) - ((optionsAdded) / 2 + 2);
                    i++) {
                System.out.println("");
            }
        }

        //print out the menu title centered in the window
        if (menuTitle.length() % 2 == 0) {
            //print out centered title
            for (int i = 0; i < (WIDTH_MENU / 2) - (menuTitle.length() / 2);
                    i++) {
                System.out.print(" ");
            }
            System.out.println(menuTitle);
            System.out.println("");
        } else {
            //pritn out centered - 1 title
            for (int i = 0; i < (WIDTH_MENU / 2) - (menuTitle.length() / 2) - 1;
                    i++) {
                System.out.print(" ");
            }
            System.out.println(menuTitle);
            System.out.println("");
        }

        //print out each option in the menu centered in the window
        for (int i = 0; i < optionsAdded; i++) {
            for (int j = 0; j <= (WIDTH_MENU / 2) - (widthOptions / 2) - 4;
                    j++) {
                System.out.print(" ");
            }
            System.out.printf("%2d", (i + 1));
            System.out.print(". " + menuOptions[i]);
            System.out.println("");
        }

        //print out vetical spaces after printing each option in the menu 
        if (optionsAdded % 2 == 0) {
            //+2 is menuTitle and the space between menuTitle and menuOptions
            for (int i = 0; i <= (HEIGHT_MENU / 2) - ((optionsAdded) / 2 + 2);
                    i++) {
                System.out.println("");
            }
        } else {
            //+3 is 2+1 and 1 is just for making one less vertical space
            for (int i = 0; i <= (HEIGHT_MENU / 2) - ((optionsAdded) / 2 + 3);
                    i++) {
                System.out.println("");
            }
        }
    }

    /**
     * Setter method for title.
     *
     * @param newTitle title that you want to set for the menu
     */
    public void setTitle(String newTitle) {
        menuTitle = newTitle;
    }

    /**
     * Print out the error message if the array is full, if not add a option to
     * the menuOption array.
     *
     * @param optionName name of the option to be added
     */
    public void addOption(String optionName) {
        if (optionsAdded < NUM_OPTIONS) {
            menuOptions[optionsAdded] = optionName;
            optionsAdded++;
        } else {
            System.out.println("\nERROR cannot add option: " + optionName + "."
                    + "\nThe menu is full.\n");
        }
    }

    /**
     * Prompt the user to enter their choice and if the choice is valid return
     * the number of the choice, if not return -1.
     *
     * @return if valid the number of the choice, if not -1
     */
    public int getChoice() {
        //prompt the user to enter the choice
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter your choice here: ");
        String choice = kbd.nextLine();

        //validates if the input is integer
        boolean valid = true;
        if (choice.length() != 0) {
            for (int i = 0; i < choice.length(); i++) {
                if (!Character.isDigit(choice.charAt(i))) {
                    valid = false;
                    break;
                }
            }
        } else {
            valid = false;
        }

        //if the input is valid return the choice, if not -1
        if (valid == true) {
            int choiceNum = Integer.parseInt(choice);
            if (choiceNum <= optionsAdded && choiceNum != 0) {
                return choiceNum;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}
