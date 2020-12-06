public class PlusOne {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1;
        while(true){
            if(index>=0&&digits[index]==9){
                digits[index--]=0;
            }else if (index >= 0){
                digits[index] = digits[index]+1;
                break;
            }else{
                break;
            }
        }
        if(index == -1){
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

}
