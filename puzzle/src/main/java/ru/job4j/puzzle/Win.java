package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for(int i = 0; i < board.length; i++){
            if(board[i][i] == 1){
                return checkRow(board, i) || checkColumn(board, i);
            }
        }
        return false;
    }

    private static boolean checkRow(int[][] board, int rowIndex) {
        for (int i = 1; i < board.length; i++) {
            if (board[i][rowIndex] != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumn(int[][] board, int columnIndex) {
        for (int i = 1; i < board.length; i++) {
            if (board[columnIndex][i] != 1) {
                return false;
            }
        }
        return true;
    }
}
