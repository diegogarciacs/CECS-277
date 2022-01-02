import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
class Main {
    public static void main(String[] args) {
        // create tree map
        TreeMap<String, Integer> m = readFile("Lab 10/words.txt");
        boolean play = true;
        while (play) {
            int choice = menu();
            if (choice == 1) {
                search(m);
            } else if (choice == 2) {
                display(m);
            }
            if (choice == 3) {
                play = false;
            }
        }
    }

    /**
     * Takes in filename, constructs a treemap of words and # of times they appear from the file. Returns the treemap.
     * @param f filename to be opened.
     * @return text the treemap to be returned with names and # of times they appear in file.
     */
    public static TreeMap<String,Integer> readFile(String f)
    {
        //create tree map to return
        TreeMap<String, Integer> text = new TreeMap<String,Integer>();
        try
        {
            //create scanner to read file
            Scanner in = new Scanner(new File(f));

            while(in.hasNextLine())
            {
                String line = in.nextLine();
                // check to see if the string is already a key
                if(text.containsKey(line))
                {
                    // retrieves the integer associated with the key
                    int count = text.get(line);
                    //increments the integer
                    count++;
                    // puts the updated count and word back into the tree map
                    text.put(line,count);
                }
                // simply place the word and key into the treemap
                else
                    text.put(line,1);

            }
        } catch(FileNotFoundException e)
        {
            System.out.println("FNF");
        }
        return text;
    }

    /**
     * Uses the map to search for a specific word and how many times it has appeared in the file.
     * @param text the treemap to search for a key.
     */
    public static void search(TreeMap<String, Integer> text){
        System.out.print("Enter word: ");
        String key = CheckInput.getString();
        // check if the word is in the treemap
        if(text.containsKey(key))
            System.out.println(key + " -> " + text.get(key));
        else
            // just print a 0
            System.out.println(key + " -> " + 0);
    }

    /**
     * Uses the treemap to display all the entries and their appearance count.
     * @param m the treemap to iterate through and display.
     */
    public static void display(TreeMap<String,Integer> m)
    {
        // we use map.Entry and entrySet to efficiently iterate
        for(Map.Entry<String,Integer> entry : m.entrySet())
        {
            String key = entry.getKey();
            int val = entry.getValue();
            System.out.println(key + " " + val);
        }
    }

    /**
     * The menu to display choices to the user.
     * @return choice returns the choice the user choose.
     */
    public static int menu(){
        System.out.println("1. Search");
        System.out.println("2. Display");
        System.out.println("3. Quit");
        int choice = CheckInput.getIntRange(1,3);
        return choice;
    }

}