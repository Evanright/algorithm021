public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        for(int i =0;i<len ;i+=2*k){
            int start = i;
            int end = (i+k<len)?i+k-1:len-1;
            while(start<=end){
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReverseStringII reverseStringII = new ReverseStringII();
        System.out.println(reverseStringII.reverseStr("dcba", 4));
    }

}
