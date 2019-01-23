package snakegame.components;

public class Piece {
    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY (int x, int y){
        this.x += x;
        this.y += y;
    }

    public boolean runsInto (Piece piece){
        if (x == piece.getX() && y == piece.getY()){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
