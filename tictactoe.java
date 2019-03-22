import java.util.Scanner;
public class tictactoe {
    public String[][] a = new String[3][3];
    public void kthenull(String[][] b){
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = " ";
            }
        }
        a = b;

    }
    public void vizato(String[][] a){
        for(int i = 0 ;i<3 ; i++){
            for (int j = 0; j < 3; j++) {
                if(j==2){
                    System.out.print(a[i][j].toUpperCase() );
                }
                else {
                    System.out.print(a[i][j].toUpperCase() + " |");
                }
            }
            System.out.println();
            if(i==2) continue;

            System.out.println("---------" +
                    "");
        }
    }

    public void vizato2(String[][] a){
        String s = "                ";
        for(int i = 0 ;i<3 ; i++){
            for (int j = 0; j < 3; j++) {
                String d ;
                if(j!=2) {

                    if (a[i][j].equals(" ")) {
                        d = "(" +i + " " + j + ") |";
                        System.out.print(d + s.substring(d.length()));
                    } else {
                        d = a[i][j].toUpperCase() + " |";
                        System.out.print(d + s.substring(d.length()));
                    }
                }
                else {
                    if (a[i][j].equals(" ")) {
                        d = "(" +i + " " + j + ")";
                        System.out.print(d);
                    } else {
                        d= a[i][j].toUpperCase();
                        System.out.print(d);
                    }
                }
            }
            System.out.println();
            if(i==2) continue;

            System.out.println("--------------------------------------------");
        }

    }


    public boolean shikoFituesin(String[][] a , int pos1 , int pos2){
        boolean horizontalisht = false;
        boolean vertikalisht = false;
        boolean diagonalja1 = false;
        boolean diagonalja2 = false;

        if(a[pos1][0] == a[pos1][1] && a[pos1][1] == a[pos1][2]) horizontalisht = true;
        if(a[0][pos2] == a[1][pos2] && a[1][pos2] == a[2][pos2]) vertikalisht = true;
        if(pos1==pos2){
            if(a[0][0] == a[1][1] && a[1][1] == a[2][2])  diagonalja1 = true;
        }
        if((pos1==2 && pos2 ==0 ) || (pos1==0 && pos2==2) || (pos1==1 && pos2==1)){
            if(a[1][1] == a[2][0] && a[1][1] == a[0][2]) diagonalja2 = true;
        }
        return horizontalisht || vertikalisht || diagonalja1 || diagonalja2;
    }

    public boolean luaj(String x , int pos1 , int pos2){
        if(pos1 >2 && pos2 >2 ) return false;
        if(a[pos1][pos2].equals(" ") ) {
            a[pos1][pos2] = x;
            System.out.println( "Keni luajtur me sukses ne poziten " + pos1 + " , " + pos2);
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Shkruaj emrin e lojtarit te pare : ");
        String loj1 = scan.next();
        tictactoe ttt = new tictactoe();
        System.out.print("Per lojtarin " + loj1 + " zgjedhni X ose O : ");
        String vlera1 = scan.next();
        ttt.kthenull(ttt.a);
        while(!vlera1.toLowerCase().equals("x") && !vlera1.toLowerCase().equals("o")) {
            System.out.println("Keni dhene vlerat gabim");
            vlera1 = scan.next();
        }
        System.out.print("Shkruaj emrin e lojtarit te dyte : ");
        String loj2 = scan.next();
        String vlera2 ;
        if(vlera1.toLowerCase().equals("x")) vlera2 = "o";
        else vlera2 = "x";

        int count = 0;
        int pos1 = 0;
        int pos2 = 0;
        ttt.vizato2(ttt.a);
        while(count++!=9){
            System.out.println("Lojtari " + loj1.toUpperCase() + " luan ne poziten ");
            System.out.print("Rreshti : ");
            pos1 = scan.nextInt();
            System.out.print("Kolona : ");
            pos2 = scan.nextInt();
            while(!ttt.luaj(vlera1,pos1,pos2)){
                System.out.println("Keni luajtur gabim ! Provo perseri. ");
                System.out.print("Rreshti : ");
                pos1 = scan.nextInt();
                System.out.print("Kolona : ");
                pos2 = scan.nextInt();
            }
            count++;
            if(ttt.shikoFituesin(ttt.a,pos1,pos2)){
                System.out.println("Urime " + loj1.toUpperCase() + " ka fituar");
                break;
            }
            ttt.vizato2(ttt.a);
            if(count == 10 ) break;
            System.out.println("Lojtari " + loj2.toUpperCase() + " luan ne poziten ");
            System.out.print("Rreshti : ");
            pos1 = scan.nextInt();
            System.out.print("Kolona : ");
            pos2 = scan.nextInt();
            while(!ttt.luaj(vlera2,pos1,pos2)){
                System.out.println("Keni luajtur gabim ! Provo perseri");
                System.out.print("Rreshti : ");
                pos1 = scan.nextInt();
                System.out.print("Kolona : ");
                pos2 = scan.nextInt();

            }
            if(ttt.shikoFituesin(ttt.a,pos1,pos2)){
                System.out.println("Urime " + loj2.toUpperCase() + " ka fituar");
                break;
            }

            ttt.vizato2(ttt.a);

        }
        if(count==10) {
            System.out.println("Nuk ka fitues . Kjo loje eshte : ");
        }
        ttt.vizato(ttt.a);

    }
}
