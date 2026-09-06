class Result {

    public static String encryption(String s) {
        s = s.replace(" ", "");

        int L = s.length();
        int rows = (int) Math.sqrt(L);
        int cols = rows;

        if (rows * cols < L) {
            cols++;
        }

        if (rows * cols < L) {
            rows++;
        }

        StringBuilder result = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            if (col > 0) {
                result.append(" ");
            }

            for (int row = 0; row < rows; row++) {
                int index = row * cols + col;

                if (index < L) {
                    result.append(s.charAt(index));
                }
            }
        }

        return result.toString();
    }
}
