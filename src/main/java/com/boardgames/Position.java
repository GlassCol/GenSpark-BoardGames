package com.boardgames;

public class Position {

    private int x, y;

    //Constructors
    public Position(char file, int rank) {
        x = fileToInt(file);
        y = rankToInt(rank);
    }

    public Position(int arrayX, int arrayY) {
        x = arrayX;
        y = arrayY;
    }


    @Override public boolean equals(Object other) {
        return other instanceof Position && ((Position)other).getX() == getX() && ((Position)other).getY() == getY();
    }



    /*Translate the file of the algebraic chess move to its array 	equivalent [ex the ‘A’ in A1 would become 0].
     */
    private static int fileToInt(char file) {
        if (!Character.isAlphabetic(file)) {
            return -1;
        }
        //if rank is an ascii capital letter
        if (file >= 97){
            return file - 97;
        }else{
            return file - 65;
        }
    }

    /*Translate the rank of the algebraic chess move to its 	array equivalent.
     */
    private static int rankToInt(int rank) {
        return rank -1;
    }


    //getters and setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
