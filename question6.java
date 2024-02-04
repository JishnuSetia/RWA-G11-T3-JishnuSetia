import java.util.Scanner;

public class question6 {
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
        System.out.println("1. Fill the matrix with prime numbers \n" + 
                "2. Display the input matrix\n" + 
                "3. Store the numbers on either side of the Left Diagonal (principal diagonal) in another\n" + 
                "matrix and display the same as shown below.\n" + 
                "4. Display the numbers above the right diagonal, the numbers on the top lefthand corner.\n" + 
                "5. Transpose the matrix");
        System.out.println("6. Exit");
        System.out.println("Enter choice number to proceed");
        int n=acceptNo();
        if(n<1||n>6){
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
    public static void main(String[] args) {
        question6 qn = new question6();
        System.out.println("Enter m:");
        int m=0;
        while(m<1){
            m=qn.acceptNo();
        }
        System.out.println("Enter n:");
        int n=0;
        while(n<2||n>21){
            n=qn.acceptNo();
        }
        int[][] matrix = new int[m][n];
        boolean transpose=false;
        while (true) {
            int in = qn.menu();
            if(in==6){
                break;
            }else if(in==1){
                qn.fillMatrix(matrix);
            }else if(in==2){
                qn.printMatrix(matrix);
            }else if(in==3){
                qn.createDiag(matrix);
            }else if(in==4){
                qn.rightDiag(matrix);
            }else if(in==5){
                int rows = matrix.length;
                int cols = matrix[0].length;
                matrix=new int[cols][rows];
                if(!transpose){
                    qn.verticalFill(matrix);
                    transpose=!transpose;
                }else{
                    qn.fillMatrix(matrix);
                    transpose=!transpose;
                }
            }
        }
    }
    private void verticalFill(int[][] matrix){
        int num=2;
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix.length;j++){
                while(true){
                    if(isPrime(num)){
                        matrix[j][i]=num;
                        num++;
                        break;
                    }
                    num++;
                }
            }
        }
    }
    private void rightDiag(int[][] matrix) {
        int i=0;
        int j=matrix[i].length-1;
        int it=1;
        while(j>=0&&it<matrix.length){
            matrix[i][j]=0;
            i++;
            if(i==matrix.length){
                i=it;
                it++;
                j--;
            }
        }
    }
    private void createDiag(int[][] matrix) {
        int i=0;
        int j=0;
        while(i<matrix.length&&j<matrix[i].length){
            matrix[i][j]=0;
            i++;
            j++;
        }
    }
    private void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print((matrix[i][j]<10?"   ":matrix[i][j]<100?"  ":matrix[i][j]<1000?" ":"")+matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    private void fillMatrix(int[][] matrix) {
        int num=2;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                while(true){
                    if(isPrime(num)){
                        matrix[i][j]=num;
                        num++;
                        break;
                    }
                    num++;
                }
            }
        }
    }
}
