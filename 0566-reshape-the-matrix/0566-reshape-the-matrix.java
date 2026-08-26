class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Cannot reshape if number of elements changes
        if (rows * cols != r * c) {
            return mat;
        }

        int[][] ans = new int[r][c];

        for (int i = 0; i < rows * cols; i++) {
            // Original matrix position
            int oldRow = i / cols;
            int oldCol = i % cols;

            // New matrix position
            int newRow = i / c;
            int newCol = i % c;

            ans[newRow][newCol] = mat[oldRow][oldCol];
        }

        return ans;
    }
}