package com.boardgames;

import com.boardgames.piece.Piece;
import com.boardgames.piece.checkerpiece.CheckerPiece;
import com.boardgames.piece.checkerpiece.King;
import com.boardgames.piece.chesspiece.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PLEASE DO NOT EDIT
 * Class to test correct implementation of all methods in the Piece class
 * @author Cole Glass
 */
class PieceTest {
    Piece pawn = new Pawn();
    Piece knight = new Knight();
    Piece rook = new Rook();
    Piece bishop = new Bishop();
    Piece queen = new Queen();
    Piece king = new com.boardgames.piece.chesspiece.King();
    Piece checkerPiece = new CheckerPiece();
    Piece checkerKing = new King();
    Tile[][] board = new Tile[8][8];
    @BeforeEach
    void setUp() {
    }

    @Test
    void testToString() {
        Piece king = new King();
        assertEquals("King", king.toString());
    }
    @Test
    void movePawnTooFarTest(){
        pawn.setXCoordinate(0);
        pawn.setYCoordinate(1);
        assertFalse(pawn.move(board, 0, 4));
    }
    @Test
    void movePawnBackwardsTest(){
        pawn.setXCoordinate(0);
        pawn.setYCoordinate(1);
        assertFalse(pawn.move(board, 0, 0));
    }
    @Test
    void movePawnToSideTest(){
        pawn.setXCoordinate(0);
        pawn.setYCoordinate(1);
        assertFalse(pawn.move(board, 1, 1));
    }
    @Test
    void pawnAttackPieceStraightTest(){
        pawn.setXCoordinate(0);
        pawn.setYCoordinate(1);
        knight.setXCoordinate(0);
        knight.setYCoordinate(2);
        assertFalse(pawn.move(board, 0, 2));
    }
    @Test
    void pawnAttackPieceVerticallyTest(){
        pawn.setXCoordinate(0);
        pawn.setYCoordinate(1);
        knight.setXCoordinate(1);
        knight.setYCoordinate(2);
        assertTrue(pawn.move(board, 0, 2));
    }
    @Test
    void knightSkipOverTest(){
        pawn.setXCoordinate(1);
        pawn.setYCoordinate(1);
        knight.setXCoordinate(1);
        knight.setYCoordinate(0);
        assertTrue(pawn.move(board, 2, 2));
    }
    @Test
    void knightNonValidMoveTest(){
        pawn.setXCoordinate(1);
        pawn.setYCoordinate(1);
        knight.setXCoordinate(1);
        knight.setYCoordinate(0);
        assertFalse(pawn.move(board, 1, 3));
    }
    @Test
    void rookSkipOverTest(){
        pawn.setXCoordinate(0);
        pawn.setYCoordinate(1);
        rook.setXCoordinate(0);
        rook.setYCoordinate(0);
        assertFalse(rook.move(board, 0, 2));
    }
    @Test
    void rookDoLongTest(){
        rook.setXCoordinate(0);
        rook.setYCoordinate(0);
        assertFalse(rook.move(board, 0, 8));
    }
    @Test
    void queenDiagonalTest(){
        queen.setXCoordinate(4);
        queen.setYCoordinate(0);
        assertTrue(queen.move(board, 6, 2));
    }
    @Test
    void kingDiagonalTest(){
        king.setXCoordinate(3);
        king.setYCoordinate(0);
        assertTrue(king.move(board, 4, 1));
    }
    @Test
    void bishopDiagonalTest(){
        bishop.setXCoordinate(2);
        bishop.setYCoordinate(0);
        assertTrue(bishop.move(board, 4, 2));
    }
    @Test
    void bishopIsBlockedTest(){
        bishop.setXCoordinate(2);
        bishop.setYCoordinate(0);
        pawn.setXCoordinate(3);
        pawn.setYCoordinate(1);
        assertFalse(bishop.move(board, 4, 2));
    }
    @Test
    void bishopVerticalTest(){
        bishop.setXCoordinate(2);
        bishop.setYCoordinate(0);
        assertFalse(bishop.move(board, 2, 1));
    }
    @Test
    void bishopHorizontalTest(){
        bishop.setXCoordinate(2);
        bishop.setYCoordinate(0);
        assertFalse(bishop.move(board, 3, 0));
    }
    @Test
    void checkerValidTest(){
        board = new Tile[8][8];
        checkerPiece.setXCoordinate(0);
        checkerPiece.setYCoordinate(1);
        assertTrue(checkerPiece.move(board, 1, 2));
    }
    @Test
    void checkerMoveBackwardsTest(){
        board = new Tile[8][8];
        checkerPiece.setXCoordinate(1);
        checkerPiece.setYCoordinate(2);
        assertFalse(checkerPiece.move(board, 1, 0));
    }
    @Test
    void checkerNotValidTest(){
        board = new Tile[8][8];
        checkerPiece.setXCoordinate(0);
        checkerPiece.setYCoordinate(1);
        assertFalse(checkerPiece.move(board, 3, 4));
    }
    @Test
    void checkerTakePieceTest(){
        board = new Tile[8][8];
        checkerPiece.setXCoordinate(1);
        checkerPiece.setYCoordinate(2);
        CheckerPiece whitePiece = new CheckerPiece();
        whitePiece.setXCoordinate(2);
        whitePiece.setYCoordinate(3);
        assertTrue(checkerPiece.move(board, 3, 4));
    }
    @Test
    void checkersKingMoveBackwardsTest(){
        board = new Tile[8][8];
        checkerKing.setXCoordinate(5);
        checkerKing.setYCoordinate(5);
        assertTrue(checkerKing.move(board, 4, 4));
    }
}