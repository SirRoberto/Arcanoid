package Score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PointCounter {
    private static int currentScore;
    private static int level;
    private static int theHighestScore;

    static {
        try {
            theHighestScore = setTheHighestScore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        currentScore = 0;
        level = 1;
    }

    public static void addPoints() {
        currentScore += level;
    }

    private static int setTheHighestScore() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/main/java/Score/highscore.txt"));
        return Integer.parseInt(scan.nextLine());
    }

    public static void writeTheHighestScore() throws FileNotFoundException {
        if(currentScore > theHighestScore) {
            PrintWriter write = new PrintWriter("src/main/java/Score/highscore.txt");
            write.println(currentScore);
            write.close();
        }
    }

    public static int getScore() {
        return currentScore;
    }

    public static void setScore(int score) {
        PointCounter.currentScore = score;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        PointCounter.level = level;
    }

    public static int getTheHighestScore() {
        return theHighestScore;
    }
    public static void setTheHighestScore(int score) {
        theHighestScore = score;
    }
}