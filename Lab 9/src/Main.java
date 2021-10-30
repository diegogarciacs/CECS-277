import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;

/**
 * Lab 9 - LinkedList + ListIterator
 * Diego O. Garcia, Eduardo Martinez
 */
class Main {
    public static void main(String[] args) {
        readFile();
    }

    /**
     * Constructs a linkedList and a listIterator, then reads a file and adds each word read into the file based on the
     * location of the iterator.
     */
    public static void readFile() {
        ListIterator<String> iter;
        LinkedList<String> list = new LinkedList<String>();
        iter = list.listIterator();
        try {
            Scanner reader = new Scanner(new File("words.txt"));
            while (reader.hasNext()) {
                String word = reader.nextLine();
                iter = list.listIterator();
                moveIter(word, iter);
                iter.add(word);
            }
            reader.close();
            printList(list);

        } catch (FileNotFoundException fnf) {
            System.out.println("File was not found");
        }
    }

    /**
     * Takes in the word read in from readfile, accepts the iterator, and will move the iterator based on whether the if
     * the word is lexicographically less than or greater than the next/previous word.
     *
     * @param word The current word read in from readfile.
     * @param iter The iterator to be adjusted based on the word and comparisons to words surrounding it.
     */
    public static void moveIter(String word, ListIterator<String> iter) {
        // check if there's words in front of the iterator
        while (iter.hasNext()) {
            // compare next word with passed in word to see if it's lexicographically greater. If it is, move the
            // iterator right back to place behind greater word.
            if (iter.next().compareToIgnoreCase(word) > 0) {
                iter.previous();
                break;
            }
        }
        //check if there's words behind the iterator
        while (iter.hasPrevious()) {
            // compare previous word with passed in word to see if it's lexicographically less than. If it is than
            // move the iterator right back (forward?) to place word in front of the less than word.
            if (iter.previous().compareToIgnoreCase(word) < 0) {
                iter.next();
                break;
            }
        }


    }

    /**
     * Method to print out the linked list after all elements have been added.
     * @param list list of words.
     */
    public static void printList(LinkedList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}