import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

/**
 * Zork is a game where the user travels through a haunted castle.
 * Each room has its own method which contain everything specific about the room, including:
 *      - what each room contains
 *      - the correct navigation out of the room
 *      - the correct name of the room which is keyed off of the room number
 *
 * Once a user is in a room, they select a direction they want to travel.  The direction will determine
 * whether they are able to go to another room and the program moves them to that room.  If they do not
 * select a correct direction, they will be asked to try again.
 */
public class ZorkExt {

    private static int roomNumber;
    private static String roomName;
    private static String direction;
    private static boolean continueGame;
    private static int choice;
    private static int personalLoot;
    private static int roomsVisited;

    public static ArrayList<String> rooms = new ArrayList<>();
    public static HashMap<String, Integer> routeChoice = new HashMap<>();   // String: direction, Integer: room number
    public static Scanner key = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);
        Random rand = new Random();
        int tryEntry;
        String rmEight;

        // to start the game the user is placed in the foyer
        roomNumber = 1;
        continueGame = true;
        rooms.add("This was not a valid choice, please try again");
        rooms.add("foyer");
        rooms.add("front room");
        rooms.add("library");
        rooms.add("kitchen");
        rooms.add("dining room");
        rooms.add("vault");
        rooms.add("parlor");
        rooms.add("secret room");
        rooms.add("outside fo the castle");

        routeChoice.put("north", 2);
        routeChoice.put("south", 9);
        routeChoice.put("east", 0);
        routeChoice.put("west", 0);

        personalLoot = 0;
        roomsVisited = 0;

        // Starting the game.
        System.out.println("Congratulations, you are playing Zork.");
        System.out.println("You are starting the game in the foyer of the castle.");
        System.out.println("You will enter a direction (\"north\", \"south\", \"east\" or \"west\"),");
        System.out.println("If this direction is a valid choice, you wiil move to another room.");

        while( continueGame ) {                                         // main loop for the game
            System.out.print("Enter the direction you want to go: ");
            direction = key.nextLine().toLowerCase();
            if (routeChoice.get(direction) == 0) {                      // 0 is an incorrect choice
                System.out.println(rooms.get(routeChoice.get(direction)) + ".");
            }
            else if (routeChoice.get(direction) == 8) {                 // 8 is is the secret room
                choice = routeChoice.get(direction);
                System.out.println("You walked " + direction + " and are trying to enter the " + rooms.get(choice) + ".");
                System.out.println("You can try, but you are not guaranteed to enter the room");
                tryEntry = rand.nextInt(100) + 1;
                if (tryEntry <=25) {
                    System.out.println("You were not allowed to enter the room.");
                    System.out.println("Do you want to try again? (Y|N)");
                    rmEight = key.nextLine().toUpperCase();
                    if (rmEight.equals("Y")) {
                        System.out.println("Trying again...");
                    }
                    else {
                        routeChoice.put("north", 0);                    // need to re-initialize these variables
                        routeChoice.put("south", 0);
                        routeChoice.put("east", 0);
                        routeChoice.put("west", 0);
                        chooseRoom(choice);
                    }
                }
            }
            else {
                choice = routeChoice.get(direction);
                System.out.println("You walked " + direction + " and are currently in the " + rooms.get(routeChoice.get(direction)) + ".");
                routeChoice.put("north", 0);                            // need to re-initialize these variables
                routeChoice.put("south", 0);
                routeChoice.put("east", 0);
                routeChoice.put("west", 0);
                chooseRoom(choice);
            }
        }
    }

    // Room #1
    private static void foyer() {
        String[] roomContains = new String[1];
        String takeMoney = "";
        roomContains[0] = "dead scorpion";
        roomNumber = 1;
        roomName = rooms.get(roomNumber);
        routeChoice.replace("north", 2);
        routeChoice.replace("south", 9);
        Boolean isMoney = true;
        int moneyAmount;

        System.out.println("You have successfully entered room number " + roomNumber + ", which is the " + rooms.get(roomNumber));

        if (isMoney) {
            System.out.println("There is money in the room, do you want to take it?");
            takeMoney = key.nextLine().toUpperCase();
            if (takeMoney.equals("Y")) {
                moneyAmount = rand.nextInt(1000);
                System.out.println("The amount of loot is : " + moneyAmount);
                personalLoot += moneyAmount;
                isMoney = false;
            }
        }
        for (int i = 0; i < roomContains.length; i++) {
            System.out.println("The " + roomName + " contains " + roomContains[i] + ".");
        }
        System.out.println();
    }

    // Room #2
    private static void frontRoom() {
        String[] roomContains = new String[1];
        String takeMoney = "";
        roomContains[0] = "a piano";
        roomNumber = 2;
        roomName = rooms.get(roomNumber);
        routeChoice.replace("south", 1);
        routeChoice.replace("east", 4);
        routeChoice.replace("west", 3);
        Boolean isMoney = true;
        int moneyAmount;

        System.out.println("You have successfully entered room number " + roomNumber + ", which is the " + rooms.get(roomNumber));

        if (isMoney) {
            System.out.println("There is money in the room, do you want to take it?");
            takeMoney = key.nextLine().toUpperCase();
            if (takeMoney.equals("Y")) {
                moneyAmount = rand.nextInt(1000);
                System.out.println("The amount of loot is : " + moneyAmount);
                personalLoot += moneyAmount;
                isMoney = false;
            }
        }
        for (int i = 0; i < roomContains.length; i++) {
            System.out.println("The " + roomName + " contains " + roomContains[i] + ".");
        }
        System.out.println();
    }

    // Room #3
    private static void library() {
        String[] roomContains = new String[1];
        String takeMoney = "";
        roomContains[0] = "spiders";
        roomNumber = 3;
        roomName = rooms.get(roomNumber);
        routeChoice.replace("north", 5);
        routeChoice.replace("east", 2);
        Boolean isMoney = true;
        int moneyAmount;

        System.out.println("You have successfully entered room number " + roomNumber + ", which is the " + rooms.get(roomNumber));

        if (isMoney) {
            System.out.println("There is money in the room, do you want to take it?");
            takeMoney = key.nextLine().toUpperCase();
            if (takeMoney.equals("Y")) {
                moneyAmount = rand.nextInt(1000);
                System.out.println("The amount of loot is : " + moneyAmount);
                personalLoot += moneyAmount;
                isMoney = false;
            }
        }
        for (int i = 0; i < roomContains.length; i++) {
            System.out.println("The " + roomName + " contains " + roomContains[i] + ".");
        }
        System.out.println();
    }

    // Room #4
    private static void kitchen() {
        String[] roomContains = new String[1];
        String takeMoney = "";
        roomContains[0] = "bats";
        roomNumber = 4;
        roomName = rooms.get(roomNumber);
        routeChoice.replace("north", 7);
        routeChoice.replace("west", 2);
        Boolean isMoney = true;
        int moneyAmount;

        System.out.println("You have successfully entered room number " + roomNumber + ", which is the " + rooms.get(roomNumber));

        if (isMoney) {
            System.out.println("There is money in the room, do you want to take it?");
            takeMoney = key.nextLine().toUpperCase();
            if (takeMoney.equals("Y")) {
                moneyAmount = rand.nextInt(1000);
                System.out.println("The amount of loot is : " + moneyAmount);
                personalLoot += moneyAmount;
                isMoney = false;
            }
        }
        for (int i = 0; i < roomContains.length; i++) {
            System.out.println("The " + roomName + " contains " + roomContains[i] + ".");
        }
        System.out.println();
    }

    // Room 5
    private static void diningRoom() {
        String[] roomContains = new String[1];
        String takeMoney = "";
        roomContains[0] = "dust";
        roomContains[1] = "an empty box";
        roomNumber = 5;
        roomName = rooms.get(roomNumber);
        routeChoice.replace("south", 3);
        Boolean isMoney = true;
        int moneyAmount;

        System.out.println("You have successfully entered room number " + roomNumber + ", which is the " + rooms.get(roomNumber));

        if (isMoney) {
            System.out.println("There is money in the room, do you want to take it?");
            takeMoney = key.nextLine().toUpperCase();
            if (takeMoney.equals("Y")) {
                moneyAmount = rand.nextInt(1000);
                System.out.println("The amount of loot is : " + moneyAmount);
                personalLoot += moneyAmount;
                isMoney = false;
            }
        }
        for (int i = 0; i < roomContains.length; i++) {
            System.out.println("The " + roomName + " contains " + roomContains[i] + ".");
        }
        System.out.println();
    }

    // Room #6
    private static void vault() {
        String[] roomContains = new String[1];
        String takeMoney = "";
        roomContains[0] = "3 walking skeketons";
        roomNumber = 6;
        roomName = rooms.get(roomNumber);
        routeChoice.replace("east", 7);
        routeChoice.replace("north", 8);
        Boolean isMoney = true;
        int moneyAmount;

        System.out.println("You have successfully entered room number " + roomNumber + ", which is the " + rooms.get(roomNumber));

        if (isMoney) {
            System.out.println("There is money in the room, do you want to take it?");
            takeMoney = key.nextLine().toUpperCase();
            if (takeMoney.equals("Y")) {
                moneyAmount = rand.nextInt(1000);
                System.out.println("The amount of loot is : " + moneyAmount);
                personalLoot += moneyAmount;
                isMoney = false;
            }
        }
        for (int i = 0; i < roomContains.length; i++) {
            System.out.println("The " + roomName + " contains " + roomContains[i] + ".");
        }
        System.out.println();
    }

    // Room #7
    private static void parlor() {
        String[] roomContains = new String[1];
        String takeMoney = "";
        roomContains[0] = "a treasure chest";
        roomNumber = 7;
        roomName = rooms.get(roomNumber);
        routeChoice.replace("south", 4);
        routeChoice.replace("west", 6);
        Boolean isMoney = true;
        int moneyAmount;

        System.out.println("You have successfully entered room number " + roomNumber + ", which is the " + rooms.get(roomNumber));

        if (isMoney) {
            System.out.println("There is money in the room, do you want to take it?");
            takeMoney = key.nextLine().toUpperCase();
            if (takeMoney.equals("Y")) {
                moneyAmount = rand.nextInt(1000);
                System.out.println("The amount of loot is : " + moneyAmount);
                personalLoot += moneyAmount;
                isMoney = false;
            }
        }
        for (int i = 0; i < roomContains.length; i++) {
            System.out.println("The " + roomName + " contains " + roomContains[i] + ".");
        }
        System.out.println();
    }

    // Room #8
    private static void secretRoom() {
        String[] roomContains = new String[1];
        String takeMoney = "";
        roomContains[0] = "piles of gold";
        roomNumber = 8;
        roomName = rooms.get(roomNumber);
        routeChoice.replace("south", 6);
        Boolean isMoney = true;
        int moneyAmount;

        System.out.println("You have successfully entered room number " + roomNumber + ", which is the " + rooms.get(roomNumber));

        if (isMoney) {
            System.out.println("There is money in the room, do you want to take it?");
            takeMoney = key.nextLine().toUpperCase();
            if (takeMoney.equals("Y")) {
                moneyAmount = rand.nextInt(1000);
                System.out.println("The amount of loot is : " + moneyAmount);
                personalLoot += moneyAmount;
                isMoney = false;
            }
        }

        for (int i = 0; i < roomContains.length; i++) {
            System.out.println("The " + roomName + " contains " + roomContains[i] + ".");
        }
        System.out.println();
    }

    // Exit Game
    private static void exitGame() {
        String[] roomContains = new String[1];
        roomContains[0] = "You are successfully exited the csstle.";
        roomName = "castle grounds";
        roomContains[0] = "ghosts";
        continueGame = false;

        for (int i = 0; i < roomContains.length; i++) {
            System.out.println("The " + roomName + " contains " + roomContains[i] + ".");
        }
    }

    public static void chooseRoom(int rm) {
        if (rm == 1) { foyer(); }
        else if (rm == 2) { frontRoom(); }
        else if (rm == 3) { library(); }
        else if (rm == 4) { kitchen(); }
        else if (rm == 5) { diningRoom(); }
        else if (rm == 6) { vault(); }
        else if (rm == 7) { parlor(); }
        else if (rm == 8) { secretRoom(); }
        else if (rm == 9) { exitGame(); }
    }
}
