package Blocks;

import java.util.*;
import  Game.GameArea;

public class BlocksGenerator {

    public static LinkedList<Block> createBoardOfBlocks(int numberOfRows, int numberOfColumns , int minDurability, int maxDurability, int level) {
        Random rand = new Random();
        LinkedList<Block> board = new LinkedList<>();
        double width = (GameArea.getMaxX()-GameArea.getMinX()-100) / (numberOfColumns + (level-1) );
        double height = 30;
        double layoutX, layoutY;
        int durability;

        for (int row = 0; row < numberOfRows+level; row++) {
            for (int col = 0; col < numberOfColumns+(level-1); col++) {
                durability = rand.nextInt(maxDurability-minDurability+1) + minDurability;
                layoutX = GameArea.getMinX() + 50 + width*col;
                layoutY = GameArea.getMinY() + 50 + height*row;
                board.add(new Block(layoutX, layoutY, width-5, height-5, durability));
            }
        }
        return board;
    }
}

