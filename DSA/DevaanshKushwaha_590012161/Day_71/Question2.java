public class GridEncryption {
    public static String encrypt(String input) {
        String s = input.replace(" ", "");
        int L = s.length();
        if (L == 0) return "";

        int cols = (int) Math.ceil(Math.sqrt(L));
        int rows = (int) Math.ceil((double) L / cols);

        char[][] grid = new char[rows][cols];
        int idx = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = (idx < L) ? s.charAt(idx++) : '\0'; // '\0' marks padding
            }
        }

        StringBuilder result = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            StringBuilder col = new StringBuilder();
            for (int r = 0; r < rows; r++) {
                if (grid[r][c] != '\0') {
                    col.append(grid[r][c]);
                }
            }
            if (c > 0) result.append(' ');
            result.append(col);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("haveaniceday")); // hae and via ecy
    }
}
