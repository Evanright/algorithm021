import java.util.Arrays;

public class SearchMatrix {
    //74. 搜索二维矩阵
    public static boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length;
        if(x==0) return false;
        int y = matrix[0].length;
        int begin =0;
        int end = x*y-1;
        while(begin <= end){
            int mid = (begin + end)/2;          //mid 为矩阵元素长度的一半（即将二维数组看成一维数组，求mid的值一样）
            int mid_element = matrix[mid/y][mid%y]; //找二维数组中间位置的元素，行的值是 mid的值除以列取整， 列的值是mid的值除以列取
                                                    //  #余数（判断该行的第几个元素）
            if(mid_element == target)
                return true;
            else if(mid_element >=target)
                end = mid - 1;
            else
                begin = mid + 1;

        }
        return false;

    }

    public static void main(String[] args) {
//        int[][]tmp = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][]tmp = new int[][]{{1,1}};
        boolean b = searchMatrix(tmp, 2);
        System.out.println(b);
    }
}
