package com.bichel.algorithms.popularproblems.islands;

/*

Given an m x n 2D binary grid grid
which represents a map of '1's (land) and '0's (water),
return the number of islands.
An island is surrounded by water and is formed
by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are
all surrounded by water.

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

---
Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Time complexity : O(M×N) where M is the number of rows
and N is the number of columns.

Space complexity : worst case O(M×N) in case that the grid map is filled with
lands where DFS goes by M×N deep.
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            int numOfIslands = 0;

            if(grid == null || grid.length == 0) {
                return numOfIslands;
            }

            int rows = grid.length;
            int cols = grid[0].length;

            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(grid[i][j] == '1') {
                        numOfIslands++;
                        findAndMaskIsland(grid, i, j, rows, cols);
                    }
                }
            }

            return numOfIslands;
        }

        private void findAndMaskIsland(char[][] grid, int row, int col, int rows, int cols) {
            if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
                return;
            }

            grid[row][col] = '0';

            findAndMaskIsland(grid, row-1, col, rows, cols);
            findAndMaskIsland(grid, row, col-1, rows, cols);
            findAndMaskIsland(grid, row+1, col, rows, cols);
            findAndMaskIsland(grid, row, col+1, rows, cols);
        }
    }


    // using DFS
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int numIslands = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    //using BFS
    private int numIslandsUsingBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {

                if (grid[r][c] == '1') {
                    numIslands++;
                    grid[r][c] = '0'; // mark as visited

                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);

                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return numIslands;
    }
}
