package gameState;

import main.Keys;
import main.Piece;

import java.awt.*;
import java.util.Arrays;

import main.Piece.Tetromino;

public class PlayState extends GameState {

    private Color[][] grid = new Color[40][10];
    private Tetromino[] board;
    private Piece currentPiece;
    private int currentX;
    private int currentY;
    private boolean isFallingFinished;

    public PlayState(GameStateManager g) {
        super(g);
        board = new Tetromino[400];
        currentPiece = new Piece();
        clearBoard();
        newPiece();
        System.out.println("2");
    }

    private void clearBoard() {
        Arrays.fill(board, Tetromino.NoShape);

        // DOES THE SAME THING AS:
//        for (int i = 0; i < board.length; i++) {
//            board[i] = Tetromino.NoShape;
//        }
    }

    private void newPiece() {
        currentPiece.setRandomType();
        currentX = 5;
        currentY = 19;
        if(!tryMove(currentPiece, currentX, currentY)) {
            System.out.println("Game Over");
            System.exit(0);
        }
    }

    private boolean tryMove(Piece thePiece, int newX, int newY) {
        for(int i=0;i<4;i++) {
            System.out.println("1");
            int x = newX+thePiece.getX(i);
            int y = newY-thePiece.getY(i);
            if (x<0 || x>=10 || y<0 || y>=40) {
                return false;
            }
//            if (shapeAt(x, y) != Tetromino.NoShape) {
//                return false;
//            }
        }
        currentPiece = thePiece;
        currentX = newX;
        currentY = newY;



        return true;
    }

    private Tetromino shapeAt(int x, int y) {
        return board[(y * 10) + x];
    }

    @Override
    public void update() {
        int whatever = (int) (Math.random()*6);
        int r = (int) (Math.random()*20)+20;
        int c = (int) (Math.random()*10);

        Color color = Color.red;

        switch (whatever) {
            case 0:
                color = Color.red;
                break;
            case 1:
                color = Color.orange;
                break;
            case 2:
                color = Color.yellow;
                break;
            case 3:
                color = Color.green;
                break;
            case 4:
                color = Color.blue;
                break;
            case 5:
                color = Color.magenta;
                break;
        }
        grid[r][c] = color;
    }

    @Override
    public void draw(Graphics2D g) {
        Color colors[] = {new Color(0, 0, 0), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };



        for(int r = 20; r < 40; r++) {
            for(int c = 0; c < 10; c++) {
                Tetromino shape = shapeAt(c, r);
                if(shape != Tetromino.NoShape) {
                    g.setColor(colors[shape.ordinal()]);
                    int x = 25*c+25;
                    int y = 25*r-450;
                    g.fillRect(x, y, 25, 25);
                }
//                if(grid[r][c] != null) {
//                    g.setColor(grid[r][c]);
//                    int x = 25*c+25;
//                    int y = 25*r-450;
//                    g.fillRect(x, y, 25, 25);
//                }
            }
        }


        g.setColor(Color.RED);

        for(int i = 0; i < 21; i++) {
            g.drawLine(25, 50+(i*25), 275, 50+(i*25));
        }
        for(int i = 0; i < 11; i++) {
            g.drawLine(25+(i*25), 50, 25+(i*25), 550);
        }
    }

    @Override
    public void handleKeyInput() {
        if (Keys.isPressed(Keys.ESCAPE)) {
            gsm.setState(GameStateManager.MENU_STATE);
        }
    }

    @Override
    public void init () {

    }
}

