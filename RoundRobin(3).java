import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of processes");
        int n = sc.nextInt();
        System.out.println("Enter time quantum");
        int q = sc.nextInt();
        int[] at = new int[n];
        int[] bt = new int[n];
        int[] rt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        int time = 0, completed = 0;
        float awt = 0, atat = 0; 
        System.out.println("Enter arrival time for each process");
        for (int i = 0; i < n; i++) {
            at[i] = sc.nextInt();
        }
        System.out.println("Enter burst time for each process");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }
        List<String> ganttChart = new ArrayList<>();
        while (completed < n) {
            //Boolean idle=true;
            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0) {
                    //idle=false;
                    int executionTime=Math.min(q,rt[i]);
                    time+=executionTime;
                    rt[i]-=executionTime;
                    for (int j=0;j<executionTime;j++){
                        ganttChart.add("P"+i);
                    }
                    if (rt[i] == 0) {
                        completed++;
                        tat[i] = time - at[i];
                        wt[i] = tat[i] - bt[i];
                        awt += wt[i];
                        atat += tat[i];
                    }
                }
            }
            /*if (idle){
                ganttChart.add("idle");
                time++;
            }*/
        }
        System.out.println("Process | ArrivalTime | BurstTime | WaitingTime | TurnAroundTime");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d            %d               %d           %d              %d\n", i, at[i], bt[i], wt[i], tat[i]);
        }
        System.out.println("Average Waiting Time: " + awt / n);
        System.out.println("Average Turnaround Time: " + atat / n);
        System.out.print("Gantt Chart:\n|");
        for (String s : ganttChart) {
            System.out.print(" " + s + " |");
        }
    }
}
