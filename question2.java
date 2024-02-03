import java.util.*;
public class question2 {
    public static void main(String[] args) {
        question2 qn = new question2();
        int n;
        while(true){
            n = qn.menu();
            if(n==3){
                System.out.println("Goodbye!");
                break;
            }
            System.out.println("Enter Text to Decrypt:");
            String text = qn.getInputForQ(n);
            System.out.println(n==1?qn.tech1(text):qn.tech2(text));
        }
    }
    private String getInputForQ(int n) {
        String text = acceptStr().toUpperCase().trim();
        if(n==1){
            while (true) {
                boolean chk = true;
                for(int i=0;i<text.length();i++){
                    if((text.charAt(i)<65||text.charAt(i)>90)&&text.charAt(i)!=32){
                        chk=false;
                        text = acceptStr().toUpperCase().trim();
                        break;
                    }
                }
                if(chk){
                    break;
                }
            }
        }else if(n==2){
            while (true) {
                boolean chk=true;
                for(int i=0;i<text.length();i++){
                    if((text.charAt(i)<48||text.charAt(i)>57)&&text.charAt(i)!=32){
                        chk=false;
                        text = acceptStr().toUpperCase().trim();
                        break;
                    }
                }
                if(chk){
                    break;
                }
            }
        }
        return text;
    }
    public String tech1(String txt){
        int n=0;
        while(!(n>=1&&n<=26)){
            System.out.println("Enter Shift:");
            n = acceptNo();
        }
        HashMap<String, String> decryptMap=decryptTech1Code(n);
        String[] txts=txt.split(" ");
        String s = "";
        for (int i = 0; i < txts.length; i++) {
            for(int j=0;j<txts[i].length();j++){
                s+=decryptMap.get(Character.toString(txts[i].charAt(j)));
            }
        }
        s=s.replaceAll("QQ", " ");
        return s;
    }
    private HashMap<String, String> decryptTech1Code(int n) {
        n=n-1;
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shift=alpha.substring(alpha.length()-n)+alpha.substring(0,alpha.length()-n);
        HashMap<String, String> tmp=new HashMap<String, String>();
        for (int i = 0; i < 26; i++) {
            tmp.put(Character.toString(shift.charAt(i)), Character.toString(alpha.charAt(i)));
        }
        return tmp;
    }
    public String tech2(String txt){
        String flip = "";
        for(int i=0;i<txt.length();i++){
            if(txt.charAt(i)==' '){
                continue;
            }
            flip=Character.toString(txt.charAt(i))+flip;
        }
        String text="";
        for(int i=0;i<flip.length();i++){
            if(Integer.parseInt(flip.substring(i,i+2))<65&&Integer.parseInt(flip.substring(i,i+2))!=32){
                if(i+3>flip.length()){
                    text += (char)(Integer.parseInt(flip.substring(i)));
                }else{
                    text += (char)(Integer.parseInt(flip.substring(i,i+3)));
                }
                i+=2;
            }else{
                text += (char)(Integer.parseInt(flip.substring(i,i+2)));
                i++;
            }
        }
        return text;
    }
    public int menu(){
        System.out.println("Choose your option:");
        System.out.println("1.Decyption Technique 1 (Shift Mthd)");
        System.out.println("2.Decyption Technique 2 (ASCII Mthd)");
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
    public String acceptStr(){
        Scanner in = new Scanner(System.in);
        String n;
        boolean flag = false;
        try {
            n = in.nextLine();
        } catch (Exception e) {
            flag=true;
            n="";
        }
        return flag?acceptStr():n;
    }
}
