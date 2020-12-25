import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        if(bills.length==0) return true;
        int five = 0;
        int ten = 0;
        for(int money: bills){
            switch(money){
                case 5:
                    five++;
                    break;
                case 10:
                    if(five==0)
                        return false;
                    five--;
                    ten++;
                    break;
                case 20:
                    if(ten>0&&five>0){
                        ten--;
                        five--;
                    }else if(five>2){
                        five-=3;
                    }else{
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = new int[]{5,5,5,10,20};
        boolean b = lemonadeChange(bills);
        System.out.println(b);
    }
}
