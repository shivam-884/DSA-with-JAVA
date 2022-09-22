package Backtracking;

public class RatInAMaze {

    public static boolean ratInAMaze(int[][] maze){
        int n = maze.length;
        int[][] path = new int[n][n];
        return solveMaze(maze,0,0,path);
    }

    public static boolean solveMaze(int[][] maze,int i, int j, int path[][]){
        // Check if i and j cell is valid or not
        int n = maze.length;;
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
            return false;
        }
        // Include the cell in the current path
        path[i][j] = 1;

        // Destination cell
        if(i == n-1 && j == n-1){

            // This is for printing any one path
        /*    for(int r = 0; r<n; r++){
                for(int c = 0; c<n; c++){
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
         */
            return true;
        }

        // Explore further in all directions
        // top
        if(solveMaze(maze,i-1,j,path)){
            return true;
        }
        // right
        if(solveMaze(maze,i,j+1,path)){
            return true;
        }
        // down
        if (solveMaze(maze,i+1,j, path)){
            return true;
        }
        // left
        if(solveMaze(maze,i,j-1,path)){
            return true;
        }
        return false;
    }

    public static void printRatInAMaze(int[][] maze){
        int n = maze.length;
        int[][] path = new int[n][n];
        printAllPaths(maze,0,0,path);
    }
    public static void printAllPaths(int[][] maze,int i, int j, int path[][]){
        // Check if i and j cell is valid or not
        int n = maze.length;;
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
            return;
        }
        // Include the cell in the current path
        path[i][j] = 1;

        // Destination cell
        if(i == n-1 && j == n-1){
            // This is for printing any one path
            for(int r = 0; r<n; r++){
                for(int c = 0; c<n; c++){
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
            path[i][j] = 0;
            return;
        }

        // Explore further in all directions
        // top
        printAllPaths(maze,i-1,j,path);
        // right
        printAllPaths(maze,i,j+1,path);
        // down
        printAllPaths(maze,i+1,j, path);
        // left
        printAllPaths(maze,i,j-1,path);
        path[i][j] = 0;
    }

    public static void main(String[] args) {
        int[][] maze = {{1,1,1},{1,1,0},{0,1,1}}; // {1,1,0},{1,0,1},{0,1,1}
//        boolean pathPossible = ratInAMaze(maze);
//        System.out.println(pathPossible);

        // printing all possible path
        printRatInAMaze(maze);
    }
}
