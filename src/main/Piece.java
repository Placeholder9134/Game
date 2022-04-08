package main;

public class Piece {

    public enum Tetromino {
        NoShape, ZShape, SShape, IShape, TShape, JShape, LShape, OShape
    }

    private int[][] coords;
    private Tetromino tetromino;


    public Piece() {
        coords = new int[4][2];
        setShape(Tetromino.NoShape);
    }

    public Piece(Tetromino i) {
        coords = new int[4][2];
        setShape(i);
    }

    public void setShape(Tetromino shape) {

        int[][][] coordsTable = new int[][][]{
            {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
            {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
            {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
            {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
            {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
        };

        for(int i = 0; i < 4;i++) {
            System.arraycopy(coordsTable[shape.ordinal()], 0, coords, 0, 4);
        }

    }

    private void setX(int index, int x) {
        coords[index][0] = x;
    }

    private void setY(int index, int y) {
        coords[index][1] = y;
    }

    public int getX(int index) {
        return coords[index][0];
    }

    public int getY(int index) {
        return coords[index][0];
    }

    public Tetromino getShape() {
        return tetromino;
    }

    public void setRandomType() {
        int random = (int) (Math.random() * 7) + 1;
        Tetromino[] shapeOptions = Tetromino.values();
        setShape(shapeOptions[random]);
    }

    public Piece rotateRight() {
        if(tetromino == Tetromino.OShape) {
            return this;
        }
        Piece piece = new Piece(tetromino);

        for(int i=0;i<4;i++) {
            piece.setX(i,-getY(i));
            piece.setY(i,getX(i));
        }
        return piece;
    }

    public Piece rotateLeft() {
        if(tetromino == Tetromino.OShape) {
            return this;
        }
        Piece piece = new Piece(tetromino);
        for(int i=0;i<4;i++) {
            piece.setX(i,getY(i));
            piece.setY(i,-getX(i));
        }
        return piece;
    }

}
