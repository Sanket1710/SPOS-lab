import java.util.Scanner;
public class priority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int atime[]= new int[20];
		int cputime[]= new int[20];
		int priority[]= new int[20];
		int wt[]= new int[20];
		int tat[]= new int[20];
		int pid[]= new int[20];
		int finish[]= new int[20];
		int sum=0,avgtat=0,avgwt=0;
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter no of process");
		int n=s.nextInt();
		
		for(int i=0; i<n; i++)
		{
			System.out.println("Enter process "+(i+1)+" arrival time");
			atime[i]=s.nextInt();
			System.out.println("Enter process "+(i+1)+" cpu time");
			cputime[i]=s.nextInt();
			System.out.println("Enter process "+(i+1)+" priority");
			priority[i]=s.nextInt();
			pid[i]=i+1;
		}
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(priority[i]>priority[j])
				{
					int temp=cputime[i];
					cputime[i]=cputime[j];
					cputime[j]=temp;
					
					temp=priority[i];
					priority[i]=priority[j];
					priority[j]=temp;
				}
			}
		}
		
		for(int i=0;i<n;i++)
		{
			sum=sum+cputime[i];
			finish[i]=sum;
		}
		
		for(int i=0;i<n;i++)
		{
			tat[i]=finish[i]-atime[i];
			avgtat+=tat[i];
			wt[i]=tat[i]-cputime[i];
			avgwt+=wt[i];
		}
		System.out.println("Process id\tArrival time\tCPU time\tPriority\tWaiting time\tTurn around time");
		for(int i=0;i<n;i++)
		{
			System.out.println("\tp"+pid[i]+"\t\t"+atime[i]+"\t\t"+cputime[i]+"\t\t"+priority[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
		}
		System.out.println("\nAverage waiting time "+(avgwt/n));
		System.out.println("Average turn around time "+(avgtat/n));
	}

}
