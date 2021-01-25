import java.util.*;

//class Node implements Comparable<Node>{
//    int x;
//    int y;
//    int step;
//
//    @Override
//    public int compareTo(Node o) {
//        return this.step-o.step;
//    }
//}

/**
 * 1091. 二进制矩阵中的最短路径
 * BFS 慢
 */
public class ShortestPathInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]==1||grid[m-1][n-1]==1) return -1;
        if(m==1&&n==1) return 1;

        int[][] directions = {{1,1},{-1,1},{1,-1},{-1,-1},{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0]=1;

        queue.offer(new int[]{0,0});
        int pathLen = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size-->0) {
                int[] xy = queue.poll();
                for (int[] d : directions) {
                    int nextX = xy[0] + d[0];
                    int nextY = xy[1] + d[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n)
                        continue;
                    if (grid[nextX][nextY] != 1) {
                        grid[nextX][nextY] = 1;
                        System.out.println(nextX + ":" + nextY);
                        queue.offer(new int[]{nextX, nextY});
                    }
                    if (nextX == m - 1 && nextY == n - 1) {
                        return pathLen + 1;
                    }
                }
            }
            pathLen++;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
//        int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid = new int[][]{{0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

}
//"""
//000
//110
//110
//"""
