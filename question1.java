import java.util.*;
public class question1 {
    public static void main(String[] args) {
        question1 qn = new question1();
        int n;
        while (true) {
            n=qn.menu();
            if(n==3){
                System.out.println("Goodbye!");
                break;
            }
            System.out.println("Enter Number");
            int in = qn.acceptNo();
            System.out.println(n==1?"Smith No:"+qn.smithNo(in):"Mobius Func:"+qn.mobiusFunc(in));
        }
    }
    public int acceptNo(){
        Scanner in = new Scanner(System.in);
        int n=0;
        boolean flag = false;
        try {
            n = in.nextInt();
        } catch (Exception e) {
            flag=true;
            n=-1;
        }
        return flag?acceptNo():n;
    }
    public int menu(){
        System.out.println("Choose your option:");
        System.out.println("1.Smith Number Checker");
        System.out.println("2.Mobius Function");
        System.out.println("3.Exit");
        System.out.println("Enter choice number to proceed");
        int n=acceptNo();
        if(n<1||n>3){
            System.out.println("Invalid Option!");
            return menu();
        }else{
            return n;
        }
    }
    public boolean isPrime(int num){
        if(num==1){
            return false;
        }
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public int[] primeFactors(int n){
        int ctr=0;
        int cpy=n;
        while(cpy>1&&!isPrime(cpy)){
            for(int i=cpy/2;i>=1;i--){
                if(cpy % i == 0 && isPrime(i)){
                    ctr++;
                    cpy = cpy/i;
                    break;
                }
            }
        }
        if(isPrime(cpy)){
            ctr++;
        }
        int[] arr=new int[ctr];
        cpy=n;
        int index=0;
        while(cpy>1&&!isPrime(cpy)){
            for(int i=cpy/2;i>=1;i--){
                if(cpy % i == 0 && isPrime(i)){
                    arr[index]=i;
                    index++;
                    cpy = cpy/i;
                    break;
                }
            }
        }
        if(isPrime(cpy)){
            arr[index]=cpy;
        }
        return arr;
    }
    public int sumOfDigitsPrimeFactors(int n){
        int[] factors = primeFactors(n);
        int sum=0;
        for(int i=0;i<factors.length;i++){
            sum+=sumOfDigits(factors[i]);
        }
        return sum;
    }
    public int sumOfDigits(int n){
        return n!=0?sumOfDigits(Integer.parseInt(Integer.toString(n).substring(0,Integer.toString(n).length()-1)==""?"0":Integer.toString(n).substring(0,Integer.toString(n).length()-1)))+Integer.parseInt(Character.toString(Integer.toString(n).charAt(Integer.toString(n).length()-1))):0;
    }
    public boolean smithNo(int n){
        return sumOfDigits(n<0?n*-1:n)==sumOfDigitsPrimeFactors(n<0?n*-1:n);
    }
    public boolean duplicateChk(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]&&i!=j){
                    return true;
                }
            }
        }
        return false;
    }
    public int mobiusFunc(int n){
        if(n==1){
            return 1;
        }
        int[] factors = primeFactors(n);
        return duplicateChk(factors)?0:(int)Math.pow(-1,factors.length);    
    }
}