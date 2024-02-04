import java.util.*;
public class question3 {
    int[][] leap;
    int[][] normal;
    public question3(){
        leap = new int[366][2];
        normal = new int[365][2];
        int in1=0;
        int in2=0;
        for(int i=1;i<=12;i++){
            in1=fillMonth(leap, i, in1, true);
        }
        for(int i=1;i<=12;i++){
            in2=fillMonth(normal, i, in2, false);
        }
    }
    public int fillMonth(int[][] arr, int month, int index, boolean leap){
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            for (int i = 1; i < 32; i++) {
                arr[index][0]=i;
                arr[index][1]=month;
                index++;
            }
        }else if(month==2){
            for (int i = 1; i < 30&&leap; i++) {
                arr[index][0]=i;
                arr[index][1]=month;
                index++;
            }
            for (int i = 1; i < 29&&!leap; i++) {
                arr[index][0]=i;
                arr[index][1]=month;
                index++;
            }
        }else{
            for (int i = 1; i < 31; i++) {
                arr[index][0]=i;
                arr[index][1]=month;
                index++;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        question3 qn = new question3();
        System.out.println("Day Number:");
        int dayNo = qn.acceptNo();
        System.out.println("Year:");
        int year = qn.acceptNo();
        System.out.println("Date after (N):");
        int n = qn.acceptNo();

        int dayNoPlusN = n+dayNo;

        String date = qn.getDate(dayNo,year);
        String dateN = qn.getDate(dayNoPlusN,year);
        System.out.println("Date1: "+date);
        System.out.println("Date2: "+dateN);
    }
    private String getDate(int dayNo,int year) {
        String date;
        while(true){
            if(year%4==0){
                if(dayNo>366){
                    dayNo-=366;
                    year+=1;
                    continue;
                }else{
                    date=leap[dayNo-1][0]+"/"+leap[dayNo-1][1]+"/"+year;
                    break;
                }
            }else{
                if(dayNo > 365){
                    dayNo-=365;
                    year+=1;
                    continue;
                }else{
                    date=normal[dayNo-1][0]+"/"+leap[dayNo-1][1]+"/"+year;
                    break;
                }
            }
        }
        return date;
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
}
