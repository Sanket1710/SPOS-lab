import java.util.Scanner;
public class sjf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pid[]= new int[20];
		int atime[]= new int[20];
		int btime[]= new int[20];
		int ctime[]= new int[20];
		int wt[]= new int[20];
		int tat[]= new int[20];
		int f[]= new int[20];
		int k[]= new int[20];
		int tot=0,st=0;
		float avgwt=0,avgtat=0;
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter no of Process");
		int n=s.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Process "+(i+1)+" Arrival time");
			atime[i]=s.nextInt();
			System.out.println("Enter Process "+(i+1)+" Brust time");
			btime[i]=s.nextInt();
			k[i]=btime[i];
			f[i]=0;
			pid[i]=i+1;
		}
		
		while(true)
		{
			int min=99,c=n;
			if(tot==n)
			{
				break;
			}
			for(int i=0;i<n;i++)
			{
				if((atime[i]<=st) && f[i]==0 && (btime[i]<=min))
				{
					min=btime[i];
					c=i;
				}
			}
			if(c==n)
				st++;
			else
			{
				ctime[c]= st+btime[c];
				st+=btime[c];
				tat[c]=ctime[c]-atime[c];
				avgtat+=tat[c];
				wt[c]=tat[c]-btime[c];
				avgwt+=tat[c];
				f[c]=1;
				tot++;
			}
		}
		
		System.out.println("Process id\tArrival time\tBrust time\tCompleting time\tWaiting time\tTurn around time");
		for(int i=0;i<n;i++)
		{
			System.out.println("\tp"+pid[i]+"\t\t"+atime[i]+"\t\t"+btime[i]+"\t\t"+ctime[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
		}
		System.out.println("\nAverage waiting time "+(avgwt/n));
		System.out.println("Average turn around time "+(avgtat/n));
	}

}
