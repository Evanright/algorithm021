import java.util.ArrayList;
import java.util.List;

public class submissions {
    public List<String> generateParenthesis(int n) {
        List<String> rst= new ArrayList<String>();
        subFun(rst,0,0,n,"");
        return rst;
    }

    public void subFun(List<String> rst,int left, int right,int n, String subRst){
        if(left==n&&right==n) {
            rst.add(subRst);
            return;
        }

        if(left<n){
            subFun(rst,left+1,right,n, subRst+"(");
        }
        if(right<left){
            subFun(rst,left,right+1,n, subRst+")");
        }


    }
}
