import java.util.*;
class SPN{
    public static void main(String str[]){
        Scanner  sc=new Scanner(System.in);
        System.out.print("Enter number of process:\t");
        int n=sc.nextInt();
        String processname[]=new String[n];
        int arrivaltime[]=new int[n];
        int servicetime[]=new int[n];
        int completiontime[]=new int[n];
        int TATtime[]=new int[n];
        int i,sum=0,index=-1,max=1000,j;
        for(i=0;i<n;i++){
            System.out.print("Enter <processname> <arrivaltime> <servicetime>:\t");
            processname[i]=sc.next();
            arrivaltime[i]=sc.nextInt();
            servicetime[i]=sc.nextInt();
            sum+=servicetime[i];
            completiontime[i]=-1;
        }
        i=0;
        while(i<sum){
            index=-1;
            max=1000;
            for(j=0;j<n;j++){
                if(arrivaltime[j]<=i && completiontime[j]==-1){
                    if(servicetime[j]<max){
                        max=servicetime[j];
                        index=j;
                    }
                }
            }
            System.out.println("Process "+processname[index]+" is executed at "+i);
            i+=servicetime[index];
            completiontime[index]=i;
        }
        int totalTAT=0;
        System.out.println("Turn Around Time for processes:");
        for(i=0;i<n;i++){
            TATtime[i]=completiontime[i]-arrivaltime[i];
            System.out.println(processname[i]+": "+TATtime[i]);
            totalTAT+=TATtime[i];
        }
        System.out.print("Average TAT:"+(double)totalTAT/n);
    }
}
/*SAMPLE OUTPUT:

Enter number of process:	5
Enter <processname> <arrivaltime> <servicetime>:	A 0 3
Enter <processname> <arrivaltime> <servicetime>:	B 2 6
Enter <processname> <arrivaltime> <servicetime>:	C 4 4
Enter <processname> <arrivaltime> <servicetime>:	D 6 5
Enter <processname> <arrivaltime> <servicetime>:	E 8 2
Process A is executed at 0
Process B is executed at 3
Process E is executed at 9
Process C is executed at 11
Process D is executed at 15
Turn Around Time for processes:
A: 3
B: 7
C: 11
D: 14
E: 3
Average TAT:7.6
Process completed.

*/