package csvtest;

import java.time.*;
import java.util.Scanner;

public class ClashCheck {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        //fop lecture
        LocalTime compareStart = LocalTime.of(10, 00);
        LocalTime compareEnd = LocalTime.of(12, 00);

        while (true) {
            System.out.println(" >> Press X to exit");
            //module yg nak pilih
            System.out.print("Please enter a time to start (HH:MM) : ");
            String start = s.nextLine(); // 

            if (start.equalsIgnoreCase("x")) {
                System.out.println("\n********************* you wished to exit *********************");
                break;
            }
            //module yg nak pilih
            LocalTime targetStart = LocalTime.parse(start);

            System.out.println("");
            System.out.print("Please enter a time to end (HH:MM) : ");
            String end = s.nextLine();
            LocalTime targetEnd = LocalTime.parse(end);
            
            //case 1
            //s1.equals(s2)
            boolean startSame = (targetStart.equals(compareStart));
            boolean endSame = (targetEnd.equals(compareEnd));

            //case 2
            // 4 < x< 20 -> 4<x && x<20
            boolean startInBTW = (targetStart.isAfter(compareStart)
                    //isAfter = >
                    //ts > cs
                    && targetStart.isBefore(compareEnd) 
                    //isBefore = <
                    // ts < ce
                    );

            boolean endInBTW = (targetEnd.isAfter(compareStart)
                    && targetEnd.isBefore(compareEnd));

            //case 3 FOP
            boolean compareStartInBTW = (compareStart.isAfter(targetStart)
                    && compareStart.isBefore(targetEnd));

            boolean compareEndInBTW = (compareEnd.isAfter(targetStart)
                    && compareEnd.isBefore(targetEnd));

            if (startSame || endSame) { //case 1
                System.out.println("the class starts OR ends AT THE SAME TIME as fop class!!");
            } else if (startInBTW || endInBTW) {    //case 2
                System.out.println("the class starts OR ends DURING fop class!");
            } else if (compareStartInBTW || compareEndInBTW) {  //case 3
                System.out.println("fop class is held during this entered class!!!");
            } else {
                System.out.println("no clashes?");
            }

        }
    }
}
