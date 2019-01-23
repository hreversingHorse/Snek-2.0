package snakegame.components;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private int originalX;
    private int getOriginalY;
    private Direction direction;
    private List<Piece> snakePieces;
    private boolean growSwitch;

    public Snake(int originalX, int getOriginalY, Direction direction) {
        this.originalX = originalX;
        this.getOriginalY = getOriginalY;
        this.direction = direction;

        this.snakePieces = new ArrayList<Piece>();
        this.snakePieces.add(new Piece(originalX, getOriginalY));
        this.growSwitch = false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSnakeLength() {
        return snakePieces.size();
    }

    public List<Piece> getSnakePieces() {
        return snakePieces;
    }

    public void move() {
        if (snakePieces.size() < 3) {
            this.grow();
        }
        Piece newPiece = new Piece(snakePieces.get(snakePieces.size() - 1).getX(),
                snakePieces.get(snakePieces.size() - 1).getY());
        //newPiece has the same x and y as the head of the snake (which is last in snakePieces)
        //now depending on the direction it will be moved into different location

        if (direction == Direction.UP) {
            newPiece.setXY(0, -1);
        }
        if (direction == Direction.DOWN) {
            newPiece.setXY(0, 1);
        }
        if (direction == Direction.LEFT) {
            newPiece.setXY(-1, 0);
        }
        if (direction == Direction.RIGHT) {
            newPiece.setXY(1, 0);
        }

        //adding newPiece with updated x and y into snakePieces
        snakePieces.add(newPiece);

        if (!growSwitch) {
            snakePieces.remove(0);
        } else {
            growSwitch = false;
        }
    }

    public boolean runsInto(Piece piece) {
        if (snakePieces.get(snakePieces.size() - 1).getX() == piece.getX()
                && snakePieces.get(snakePieces.size() - 1).getY() == piece.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean runsIntoItself (){
        for (Piece one : snakePieces){
            for (Piece two : snakePieces){
                if(one==two){
                    continue;
                }
                if(one.getX()==two.getX() && one.getY()==two.getY()){
                    return true;
                }
            }
        }
        return false;
    }

    public void grow() {
        this.growSwitch = true;
    }

}
