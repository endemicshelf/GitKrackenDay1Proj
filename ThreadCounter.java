public class ThreadCounter extends Thread
{
	public ThreadCounter(){}

	public static void main(String args[])
	{
		long[] totalTotals = new long[1000];
		Thread[] list = new Thread[1000];

		for(int i = 0; i < list.length; i++)
		{

			int ind = i;
			list[i] = new Thread(() ->
			{
				long total = 0;
				for(int j =1; j <= 1000000; j++)
				{
					total += j;
				}

				totalTotals[ind] = total;
			});
		}

		for(Thread t: list)
		{
			try{t.join();}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		long finalTotalSum = 0;
		for(long tTotal : totals)
		{
			finalTotalSum += tTotal;
		}

		System.out.println("Final Sum: " + finalTotalSum);
	}
}