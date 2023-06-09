import java.util.Arrays;

/**
 * The Bord class represents a board configuration for "Sliding Puzzle" game.
 * It contains a 2D array of Tile objects, representing the tiles on the board.
 */
public class Board {
    private final Tile[][] tiles;
    private static Tile[][] goalTiles;

    /**
     * Constructs a Board object based on a string representation of the board.
     * Constructs the goal tiles, representing the target board configuration.
     *
     * @param strBoard The string representation of the board.
     */
    public Board(String strBoard) {
        /* Constructs a Board object based on a string representation of the board. */
        String[] strBoardSplit = strBoard.split("\\|");
        int numOfCol = strBoardSplit[0].split(" ").length;
        int numOfRow = strBoardSplit.length;
        this.tiles = new Tile[numOfRow][numOfCol];
        for(int i = 0; i < numOfRow; i++) {
            String[] strBoardSecondSplit = strBoardSplit[i].split(" ");
            for(int j = 0; j < strBoardSecondSplit.length; j++) {
                String titleValue = strBoardSecondSplit[j];
                if(titleValue.equals("_")) {
                    tiles[i][j] = new Tile(0);
                } else {
                    tiles[i][j] = new Tile(Integer.parseInt(titleValue));
                }
            }
        }

        /* Constructs the goal tiles, representing the target board configuration. */
        int numRows = tiles.length;
        int numCols = tiles[0].length;
        goalTiles = new Tile[numRows][numCols];
        int value = 1;
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                goalTiles[i][j] = new Tile(value);
                value++;
            }
        }
        goalTiles[numRows - 1][numCols - 1] = new Tile(0);
    }

    public Board(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile[][] getGoalTiles() {
        return goalTiles;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tiles);
    }
}
