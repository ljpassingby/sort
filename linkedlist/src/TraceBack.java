import org.junit.Test;

public class TraceBack {
    boolean[][] result = new boolean[8][8];
    public void cal8queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int col = 0; col < 8; ++col) {
            if (isOk(row, col)) {
                result[row][col] = true;
                cal8queens(row + 1);
                result[row][col] = false;
            }
        }
    }

    private boolean isOk(int row, int col) {
        int left = col - 1;
        int right = col + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (result[i][col] == true)
                return false;
            if (left >= 0)
                if (result[i][left] == true)
                    return false;
            if (right < 8)
                if (result[i][right] == true)
                    return false;
            --left;
            ++right;
        }
        return true;
    }

    private void printQueens(boolean[][] result) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (result[i][j] == true)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void test() {
        cal8queens(0);
    }
}
