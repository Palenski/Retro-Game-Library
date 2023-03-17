package ConnectFour;


public class Cell {

    private char cellPosition;
    private int rowPosition;
    private int cellState;

    public Cell() {
        cellPosition = ' ';
        rowPosition = 0;
        cellState = 0;
    }

    public Cell(char newCellPosition, int newRowPosition) {
        cellPosition = newCellPosition;
        rowPosition = newRowPosition;
    }

    public void setCellPosition(char newCellPosition) {
        cellPosition = newCellPosition;
    }

    public void setRowPosition(int newRowPosition) {
        rowPosition = newRowPosition;
    }

    public void setAllPosition(char newCellPosition, int newRowPosition) {
        cellPosition = newCellPosition;
        rowPosition = newRowPosition;
    }

    public void setCellState(int newCellState) {
        cellState = newCellState;
    }

    public int getCellState() {
        return cellState;
    }

    public char getCellPosition() {
        return cellPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }
}
