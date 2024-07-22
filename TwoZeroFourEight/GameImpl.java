package TwoZeroFourEight;

import java.util.ArrayList;
import java.util.List;

/*

GameImpl
    -> GameBoard
    -> NumberGenerator
    ---------------------
    void M run;




 */

public class GameImpl implements Game {

    private final GameBoard gameBoard;
    private final NumberGenerator numberGenerator;
    private final List<GameBoard> gameBoardList;

    public GameImpl(NumberGenerator numberGenerator1) {
        numberGenerator = numberGenerator1;
        gameBoard = gameBoard.getInstance();
        gameBoardList = new ArrayList<>();
    }

    @Override
    public void run(GameCommand move) {
        move.runThisCommand(gameBoard);

    }

    @Override
    void createHistory(){
        gameBoardList.add(copyArray());
    }

     public List<List<Integer, Integer>> copyArray() {
        return List.copyOf(gameBoard);
    }


}
