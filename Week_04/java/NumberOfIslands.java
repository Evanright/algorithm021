

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int h = grid.length;
        int count = 0;
        if(h == 0) return 0;
        int l = grid[0].length;
        for(int i=0;i<h;i++){
            for(int j=0;j<l;j++){
                if(grid[i][j]=='1'){
                    removeIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void removeIsland(char[][] grid, int i, int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='1')
            return;
        grid[i][j]='0';
        removeIsland(grid,i-1,j);
        removeIsland(grid,i+1,j);
        removeIsland(grid,i,j-1);
        removeIsland(grid,i,j+1);
    }

    public static void main(String[] args) {
//        char[][] grid = new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        int i = numIslands(grid);
        System.out.println(i);
    }
}
