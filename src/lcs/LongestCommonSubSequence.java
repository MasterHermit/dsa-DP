package lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubSequence {
    static String solve(String s1, String s2, int n, int m, int[][] mat, String op) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    mat[i][j] = 1 + mat[i - 1][j - 1];
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        int i = n, j = m;
        StringBuilder opBuilder = new StringBuilder(op);
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                opBuilder.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (mat[i - 1][j] > mat[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        op = opBuilder.toString();


        return op;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String inputString = br.readLine();
        String[] iarr = inputString.split(" ");
        String s1 = iarr[0];
        String s2 = iarr[1];

        int n = s1.length();
        int m = s2.length();

        int[][] mat = new int[n + 1][m + 1];

        System.out.println(solve(s1, s2, n, m, mat, ""));

    }
}
