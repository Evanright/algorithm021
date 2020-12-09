public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder rst = new StringBuilder();

        int left = 0;
        int right = 0;
        for(char c: S.toCharArray()){
            if(right>left) return "";

            if(c == '('){
                ++left;
                if(left>=2){
                    rst.append('(');
                }
            }
            if(c == ')'){
                ++right;
                if(right == left){
                    left = 0;
                    right = 0;
                }else{
                    rst.append(')');
                }
            }
        }
        return rst.toString();

    }
}
