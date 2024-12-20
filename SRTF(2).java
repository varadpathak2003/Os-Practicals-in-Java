import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of processes");
        int n = sc.nextInt();
        int[] at = new int[n];
        int[] bt = new int[n];
        int[] rt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        System.out.println("Enter arrival time for each process");
        for (int i = 0; i < n; i++) {
            at[i] = sc.nextInt();
        }
        System.out.println("Enter burst time for each process");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }
        int time = 0, completed = 0;
        float totalWT = 0, totalTAT = 0;
        List<String> ganttChart = new ArrayList<>();
        while (completed < n) {
            int minIndex = -1, minRT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0 && rt[i] < minRT) {
                    minRT = rt[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                ganttChart.add("Idle");
                time++;
                continue;
            }
            ganttChart.add("P" + minIndex);
            rt[minIndex]--;
            time++;
            if (rt[minIndex] == 0) {
                completed++;
                tat[minIndex] = time - at[minIndex];
                wt[minIndex] = tat[minIndex] - bt[minIndex];
                totalWT += wt[minIndex];
                totalTAT += tat[minIndex];
            }
        }
        System.out.println("Process | ArrivalTime | BurstTime | WaitingTime | TurnAroundTime");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d            %d               %d           %d              %d\n", i, at[i], bt[i], wt[i], tat[i]);
        }
        System.out.println("Average Waiting Time: " + totalWT / n);
        System.out.println("Average Turnaround Time: " + totalTAT / n);
        System.out.print("Gantt Chart:\n|");
        for (String s : ganttChart) {
            System.out.print(" " + s + " |");
        }
    }
}
