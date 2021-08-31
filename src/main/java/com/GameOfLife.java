package com;

public class GameOfLife {
    public static void main(String[] args) {
        int rows = 10, cols = 10;

        int[][] plane = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // Displaying the plane
        System.out.println("curr gen");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (plane[i][j] == 0)
                    System.out.print("-");
                else
                    System.out.print("^");
            }
            System.out.println();
        }
        System.out.println();
        nuGen(plane, rows, cols);
    }

    static void nuGen(int grid[][], int M, int N) {
        int[][] future = new int[M][N];

        // Loop through every cell
        // apply the rules at each cell
        // Time Complexity O(M * N) => O(N^2)
        for (int l = 1; l < M - 1; l++) {
            for (int m = 1; m < N - 1; m++) {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];

                aliveNeighbours -= grid[l][m];

                if ((grid[l][m] == 1) && (aliveNeighbours < 2)) {
                    future[l][m] = 0;
                } else if ((grid[l][m] == 1) && (aliveNeighbours > 3)) {
                    future[l][m] = 0;
                } else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) {
                    future[l][m] = 1;
                } else {
                    future[l][m] = grid[l][m];
                }
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (future[i][j] == 0)
                    System.out.print("-");
                else
                    System.out.print("^");
            }
            System.out.println();
        }
    }
}
