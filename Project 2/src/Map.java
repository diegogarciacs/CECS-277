import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Map is a representation of a Map.
 * It uses the Singleton design pattern.
 *
 * @author Diego Garcia, Daniel Jo 2021
 */
public class Map {
    /**
     * The map of characters
     */
    private char[][] map;

    /**
     * The map of booleans of whether the character is revealed
     */
    private boolean[][] revealed;

    /**
     * The instance of Map
     */
    private static Map instance = null;

    /**
     * Constructs a Map object that initializes a 2D char map and a 2D boolean array
     */
    private Map() {
        try {
            this.loadMap(1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        this.revealed = new boolean[this.map.length][this.map[0].length];
    }

    /**
     * Creates a new instance of Map if it does not exist.
     * Otherwise, it returns the existing instance of Map.
     *
     * @return instance of Map
     */
    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }

        return instance;
    }

    /**
     * Loads a new map by populating 2D char array from provided Area#.txt files.
     * Resets the revealed 2D boolean array.
     *
     * @param mapNum number of txt file to be loaded (1-3).
     * @throws FileNotFoundException Throws an exception if no file is found.
     */
    public void loadMap(int mapNum) throws FileNotFoundException {
        File areaTxtFile = new File("Area" + mapNum + ".txt");
        Scanner scanner = new Scanner(areaTxtFile);
        this.map = new char[5][5];

        for (int r = 0; r < this.map.length; r++) {
            for (int c = 0; c < this.map[0].length; c++) {
                if (scanner.hasNext()) {
                    char letter = scanner.next().charAt(0);
                    this.map[r][c] = letter;
                }
            }
        }

        scanner.close();

        this.revealed = new boolean[this.map.length][this.map[0].length];
    }

    /**
     * Returns the character at the given point coordinate in the 2D array.
     *
     * @param p The point coordinates to check for a character in the 2D array.
     * @return the character at the provided point coordinate.
     * @throws ArrayIndexOutOfBoundsException Throws exception if the point is out of bounds of the array.
     */
    public char getCharAtLoc(Point p) throws ArrayIndexOutOfBoundsException {
        return this.map[p.x][p.y];
    }

    /**
     * Prints out the map with revealed characters and the location of the trainer.
     *
     * @param p Passes in the point coordinate of the trainer.
     * @return Returns string of the 2D map to print.
     */
    public String mapToString(Point p) {
        String s = "";

        for (int r = 0; r < this.map.length; r++) {
            for (int c = 0; c < this.map[0].length; c++) {
                if (r == p.x && c == p.y) {
                    s += "* ";
                } else if (revealed[r][c]) {
                    s += this.map[r][c] + " ";
                } else {
                    s += "x ";
                }
            }
            s += "\n";
        }

        return s;
    }

    /**
     * Returns the point position of the start of the map, which is where the char 's' is at.
     *
     * @return a point with the array coordinates of 's' character.
     */
    public Point findStart() {
        for (int r = 0; r < this.map.length; r++) {
            for (int c = 0; c < this.map.length; c++) {
                if (this.map[r][c] == 's') {
                    return new Point(r, c);
                }
            }
        }

        return null;
    }

    /**
     * Uses the point coordinate to switch the corresponding location in the revealed index to true.
     *
     * @param p the point to use to switch the revealed array to true.
     */
    public void reveal(Point p) {
        this.revealed[p.x][p.y] = true;
    }

    /**
     * Accepts a point coordinate to remove from the char array.
     *
     * @param p point to use to remove from the char array.
     */
    public void removeCharAtLoc(Point p) {
        this.map[p.x][p.y] = 'n';
    }
}
