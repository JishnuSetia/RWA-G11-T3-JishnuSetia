import java.util.*;
public class question4 {
    public static int acceptNo(){
        Scanner in = new Scanner(System.in);
        int n=0;
        boolean flag = false;
        try {
            n = in.nextInt();
        } catch (Exception e) {
            flag=true;
            n=-1;
        }
        return flag?acceptNo():n>=100?n:acceptNo();
    }
    public static void main(String[] args) {
        System.out.println("Enter Number to Check if facinating:");
        int n = acceptNo();
        String nums = n+""+(n*2)+""+(n*3);
        boolean[] numUsed=new boolean[9];
        boolean rpt=false;
        for(int i=0;i<nums.length()&&!rpt;i++){
            if(nums.charAt(i)=='0'){
                continue;
            }
            numUsed[Integer.parseInt(Character.toString(nums.charAt(i)))-1]=true;
            for(int j=0;j<nums.length();j++){
                if(i!=j&&nums.charAt(i)==nums.charAt(j)){
                    rpt=true;
                    break;
                }
            }
        }
        boolean finalChk = true;
        for(int i=0;i<numUsed.length;i++){
            if(rpt||!numUsed[i]){
                finalChk=false;
                break;
            }
        }
        System.out.println(finalChk?"The number is fascinating.":"The number is not fascinating.");
    }
}
