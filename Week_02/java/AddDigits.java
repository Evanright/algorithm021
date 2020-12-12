
public class AddDigits {
    public static int addDigits(int num) {
        if(num<10) return num;
        int rst = 0;
        while(num != 0){
            rst += num % 10;
            num = num/10;
        }
        return addDigits(rst);
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
