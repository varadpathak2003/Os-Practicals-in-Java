import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       System.out.println("Enter no of processes");
       int n=sc.nextInt();
       int a[]=new int[n];
       int bt[]=new int[n];
       int p[]=new int[n];
       int wt[]=new int[n];
       int tat[]=new int[n];
       System.out.println("Enter arrival time for each process");
       for (int i=0;i<n;i++){
           p[i]=i;
           a[i]=sc.nextInt();
       }
       System.out.println("Enter burst time for each process");
       for (int i=0;i<n;i++){
           bt[i]=sc.nextInt();
       }
       for (int i=0;i<n-1;i++){
           for (int j=i+1;j<n;j++){
               if (a[i]>a[j]){
                   int temp=a[i];
                   a[i]=a[j];
                   a[j]=temp;
                   
                   temp=p[i];
                   p[i]=p[j];
                   p[j]=temp;
                   
                   temp=bt[i];
                   bt[i]=bt[j];
                   bt[j]=temp;
               }
           }
       }
               for (int i=1;i<n;i++){
                   wt[i]=bt[i-1]+wt[i-1]-a[i];
                   if (wt[i]<0) wt[i]=0;
               }
               int atat=0,awt=0;
               for (int i=0;i<n;i++){
                   tat[i]=bt[i]+wt[i];
                   atat+=tat[i];
                   awt+=wt[i];
               }
        
           for (int i=0;i<n;i++){
               System.out.print("|  P"+p[i]+"  ");
           }
           int time[]=new int[n+1];
           
           for (int i=0;i<n;i++){
               time[i+1]=time[i]+bt[i];
           }
           System.out.println("");
           for (int i=0;i<n+1;i++)
           System.out.print(""+time[i]+"      ");
           System.out.println("");
            System.out.println("Process | ArrivalTime | BurstTime | WaitingTime | TurnAroundTime ");
        System.out.println("---------------------------------------------------------------");
            for (int i = 0; i < n; i++) {
            System.out.printf("%d            %d               %d           %d          %d\n", p[i], a[i], bt[i], wt[i], tat[i]);
        }
        
        System.out.println("Average turn around time : "+(float)atat/n);
        System.out.println("Average waiting time : "+(float)awt/n);
        
}              
}
