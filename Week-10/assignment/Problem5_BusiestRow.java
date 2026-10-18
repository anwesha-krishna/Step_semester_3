// Problem 10: Busiest Bus Row
// busiestRow(grid) returns the index of the row with the largest total and that total.
// On a tie the row with the smaller index wins, because the best row only changes when a total
// is strictly larger.
//
// Complexity
//   Time O(r * c): every seat in the grid is added exactly once.
//   Additional space O(1): only a few variables are used (the 2-element result is a fixed size).

public class Problem10_BusiestRow {
    // Returns {rowIndex, total}
    static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1; // totals are never negative, so the first row always becomes the best so far

        for (int row = 0; row < grid.length; row++) {
            int total = 0;
            for (int col = 0; col < grid[row].length; col++) {
                total += grid[row][col];
            }

            if (total > bestTotal) { // strictly larger, so ties keep the smaller index
                bestTotal = total;
                bestRow = row;
            }
        }

        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
