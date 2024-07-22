package TwoZeroFourEight;

/*

Here's a brief explanation of the game:

Game Rules:
Game Board:

The game is played on a 4x4 grid.

Tiles with numbers (powers of 2) are randomly placed on the grid.

Tile Movement:

Tiles can be moved in four directions: up, down, left, and right.

When a player makes a move, all tiles on the board slide as
far as possible in the chosen direction.

Tile Merging:

When two tiles with the same number collide while moving,
they merge into a tile with the sum of their values.

For example, if two tiles with the number 2 collide, they merge into a single tile with the number 4.

Scoring:

The player earns points for every merged tile.

The goal is to reach the highest possible tile value, ideally reaching the tile with the number 2048.

Game Over:

The game ends when there are no more valid moves (i.e., the grid is full, and no tiles can be merged).
Features Required:
Game Board:

A 4x4 grid representing the game board.

Tiles with values, initially two tiles with a value of 2 or 4.

Game Logic:

Merging tiles with the same value when they collide.

Scoring based on the merged tiles.

User Input:

Accepting user input for movement (left, right, up, down).
Score Calculation:

Calculating and updating the score based on merged tiles.


 */

public class Client {

    public static void main (String[] arg){

        // User will create a board [Singleton design pattern]
        GameBoard gameBoard;

        //User will be able to swipeRight
        // When he swipe right, you should do two things
        // i update the state and second we randomly place a powr of 2 somwhere there is empty box
        //

        NumberGenerator numberGenerator = new BasicNumberGenerator();
        Game game = new GameImpl(numberGenerator);
        GameCommand move= new LeftMove();
        game.run(move);





        /*

            Since we are doing the same thing for each step
            im the game,
                1. Merge the current state
                2. generate a number after you swipe
                3. Find the empty box and place the value there

        */






    }
}
