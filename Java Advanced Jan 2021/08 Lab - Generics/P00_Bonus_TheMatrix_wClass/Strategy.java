package _14_Generics_LAB.P00_Bonus_TheMatrix_wClass;

public interface Strategy {
    void solve(int row, int col,
               char colorToReplace, char fillColor, Matrix matrix);
}