package com.boardgames.piece;

import com.boardgames.FileUtil;
import com.boardgames.Tile;
import javafx.scene.image.Image;

/**
 * Abstract class to be used in iteration during game time
 *
 * @author Cole Glass
 */
public abstract class Piece {
    private int XCoordinate;

    private int YCoordinate;
    private int numValue;
    private String color;
    private Image image;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImage(String path) {
        this.image = FileUtil.loadImageFromAFile(path);
    }

    public Image getImage() {
        return this.image;
    }

    @Override
    public abstract String toString();

    public int getXCoordinate() {
        return XCoordinate;
    }

    public void setXCoordinate(int XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public int getYCoordinate() {
        return YCoordinate;
    }

    public void setYCoordinate(int YCoordinate) {
        this.YCoordinate = YCoordinate;
    }

    public void setNumValue(int numValue) {
        this.numValue = numValue;
    }

    public int getNumValue() {
        return numValue;
    }

    /**
     * Moves the piece within the game board
     *
     * @return
     */
    public abstract boolean move(Tile[][] board, int xPos, int yPos);
}
