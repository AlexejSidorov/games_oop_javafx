package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {

    @Test
    public void BishopPositionF8() {
        Figure bishop = new BishopBlack(Cell.F8);
        Assert.assertEquals(bishop.position(), Cell.F8);
    }

    @Test
    public void BishopCopyE7() {
        Figure bishopBefore = new BishopBlack(Cell.F8).copy(Cell.E7);
        Assert.assertEquals(Cell.E7, bishopBefore.position());
    }

    @Test
    public void BishopIfDiagonalTrue(){
        BishopBlack bishop = new BishopBlack(Cell.B1);
        boolean actual = bishop.isDiagonal(Cell.B2, Cell.E5);
        Assert.assertTrue(actual);
    }

    @Test
    public void BishopIfDiagonalFalse(){
        BishopBlack bishop = new BishopBlack(Cell.B3);
        boolean actual = bishop.isDiagonal(Cell.B3, Cell.E5);
        Assert.assertFalse(actual);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void BishopIfWayDiagonalExcept() throws ImpossibleMoveException{
        BishopBlack bishop = new BishopBlack(Cell.B3);
        bishop.way(Cell.E5);
    }

    @Test
    public void BishopIfCorrectWayB5E8() throws ImpossibleMoveException{
        BishopBlack bishop = new BishopBlack(Cell.B5);
        Cell[] expected = {Cell.C6, Cell.D7, Cell.E8};
        Cell[] actual = bishop.way(Cell.E8);
        Assert.assertArrayEquals(expected, actual);
    }
}