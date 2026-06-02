package Praktikum_Pemrograman_Lanjut.BAB11_AULYASHABRINAAHMADEWI_255150207111065;

// Program Sort1.java
// Collections method sort.
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Sort1 {
    public static void main(String[] args) {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        // Create and display a list containing the suits array elements
        List<String> list = Arrays.asList(suits); // create List
        System.out.printf("Unsorted array elements: %s\n", list);
        Collections.sort(list); // sort ArrayList
        // output list
        System.out.printf("Sorted array elements: %s\n", list);
    } // end main
} // end class Sort1