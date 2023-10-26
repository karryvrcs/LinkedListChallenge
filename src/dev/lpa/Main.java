package dev.lpa;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Initialization
        LinkedList<Places> linkedList = new LinkedList<>();
        linkedList.add(new Places("Sydney", 0));
        linkedList.add(new Places("Adelaide", 1374));
        linkedList.add(new Places("Alice Springs", 2771));
        linkedList.add(new Places("Brisbane", 917));
        linkedList.add(new Places("Darwin", 3972));
        linkedList.add(new Places("Melbourne", 877));
        linkedList.add(new Places("Perth", 3923));
        linkedList.sort(Comparator.comparing((Places::getDistance)));// 相当于((Places p) -> p.getDistance())

        ListIterator<Places> listIterator = linkedList.listIterator(1);
        Places previousPlaces = linkedList.getFirst();

        boolean flag = true;
        while(flag){
            System.out.println("""
                    Available actions (select word or letter):
                    (F)orward
                    (B)ackward
                    (L)ist Places
                    (M)enu
                    (Q)uit""");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            switch (s){
                case "F","f":
                    if (listIterator.hasNext()){
                        var places = listIterator.next();
                        System.out.println("--> From " + previousPlaces.getTown() + " to " + places.getTown());
                        System.out.println("Distance from " + places.getTown() +" to Sydney: " + places.getDistance() + " km");
                        previousPlaces = places;
                    } else {
                        System.out.println("This is the last place. No places left!");
                    }
                    break;
                case "B","b":
                    if (listIterator.hasPrevious()){
                        var places = listIterator.previous();
                        if (listIterator.hasPrevious()){
                            previousPlaces = listIterator.previous();
                            System.out.println("<-- From " + places.getTown() + " to " + previousPlaces.getTown());
                            System.out.println("Distance from " + previousPlaces.getTown() + " to Sydney: " + previousPlaces.getDistance() + " km");
                            listIterator.next();
                        } else {
                            System.out.println("First place.");
                        }
                    } else {
                        System.out.println("First place.");
                    }
                    break;
                case "L","l":
                    ListIterator<Places> newIterator = linkedList.listIterator(0);
                    // %-10s is used to print a String, left-justified, with a minimum width of 10 characters.
                    System.out.println("-".repeat(30));
                    System.out.printf("%-14s %-14s", "Town", "Distance(in km)\n");
                    while (newIterator.hasNext()){
                        Places place = newIterator.next();

                        System.out.printf("%-14s %-14d\n", place.getTown(), place.getDistance());
                    }
                    System.out.println("-".repeat(30));
                    break;
                case "Q","q":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }

        }
    }

    public static void Forward(ListIterator<Places> listIterator){

    }




}

