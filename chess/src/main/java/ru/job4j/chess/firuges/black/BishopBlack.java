package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws ImpossibleMoveException{
        if(!isDiagonal(position(), dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - position().getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - position().getX())/size;
        int deltaY = (dest.getY() - position().getY())/size;
        for (int index = 1; index <= size; index++) {
            steps[index - 1] = Cell.findBy((position.getX() + deltaX*index), (position.getY() + deltaY*index));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (source.equals(dest)) {
            return false;
        }
        int dX = Math.abs(source.getX() - dest.getX());
        int dY = Math.abs(source.getY() - dest.getY());
        return dX == dY;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
