import java.util.Scanner;
public class fcfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pid[]= new int[20];
		int etime[]= new int[20];
		int atime[]=new int[20];
		int tat[]= new int[20];
		int wt[]= new int[20];
		int avgwt=0,avgtat=0;
		Scanner s= new Scanner(System.in);
		System.out.println("Enter no of process");
		int n=s.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter process "+(i+1)+" execution time");
			etime[i]= s.nextInt();
			atime[i]=i;
			pid[i]=i+1;
		}
		wt[1]=0;
		for(int i=1;i<n;i++)
		{
			wt[i]=etime[i-1]+wt[i-1];
			avgwt +=wt[i];
		}
		for(int i=0;i<n;i++)
		{
			tat[i]=wt[i]+etime[i];
			avgtat +=tat[i];
		}
		System.out.println("Process id\tArrival time\tBrust time\tWaiting time\tTurn around time");
		for(int i=0;i<n;i++)
		{
			System.out.println("\tp"+pid[i]+"\t\t"+atime[i]+"\t\t"+etime[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
		}
	}

}
