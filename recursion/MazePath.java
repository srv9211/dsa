import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class MazePath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] arraySize = br.readLine().trim().split(" ");
        int n = Integer.parseInt(arraySize[0]);
        int m = Integer.parseInt(arraySize[1]);

        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(arr[j]);
            }
        }

        System.out.println(getMazePathsWithJumps(maze, 0, 0));
    }

    static List<String> getMazePaths(int[][] maze, int i, int j) {
        List<String> ans = new ArrayList<>();
        if (i == maze.length || j == maze[0].length) return ans;
        else if (i == maze.length - 1 && j == maze[0].length - 1) {
            ans.add("");
            return ans;
        }

        List<String> downList = getMazePaths(maze, i+1, j);
        List<String> rightList = getMazePaths(maze, i, j+1);

        for (String downPath : downList) {
            ans.add("d" + downPath);
        }
        for (String rightPath : rightList) {
            ans.add("r" + rightPath);
        }

        return ans;
    }

    static List<String> getMazePathsWithJumps(int[][] maze, int i, int j) {
        List<String> ans = new ArrayList<>();
        if (i >= maze.length || j >= maze[0].length) return ans;
        else if (i == maze.length - 1 && j == maze[0].length - 1) {
            ans.add("");
            return ans;
        }

        for (int jumps = 1; jumps <= 3; jumps++) {
            List<String> downList = getMazePathsWithJumps(maze, i+jumps, j);
            for (String downPath : downList) {
                ans.add("d" + jumps + downPath);
            }
        }

        for (int jumps = 1; jumps <= 3; jumps++) {
            List<String> rightList = getMazePathsWithJumps(maze, i, j+jumps);
            for (String rightPath : rightList) {
                ans.add("r" + jumps + rightPath);
            }
        }

        return ans;
    }

}