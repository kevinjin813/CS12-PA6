package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class KMeans {
	static Cluster c=new Cluster();
	public static void main(String[] args) throws FileNotFoundException
	{
		
		System.out.println("Please entere the file name:");
		Scanner in = new Scanner(System.in);
		String filename = in.nextLine();
		System.out.println("Number of clusters:");
		int num=in.nextInt();
		Cluster og=readFile(filename,num);
		Cluster[] newCluster=findClosest(og);
		for(int i=0;i<newCluster.length;i++)
		{
			printC(newCluster[i]);
		}
	}
	/**
	 * generate the clusters with picked point
	 * @param temp
	 * @return
	 */
	public static Cluster[] generateCluster(ArrayList<Sample> temp)
	{
		Cluster[] result=new Cluster[temp.size()];
		for(int i=0;i<temp.size();i++)
		{
			Sample curr=temp.get(i);
			result[i]=new Cluster(curr);
		
		}
		return result;
	}
	
	/**
	 * Read file and form the cluster
	 * @param filename
	 * @param num
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Cluster readFile(String filename,int num) throws FileNotFoundException
	{
		File map = new File(filename);
		Scanner data=new Scanner(map); 	
		double[] temp=new double[2];
		while(data.hasNextLine()==true)
		{
			String s=data.next();
			temp[0]=Integer.parseInt(s);
			s=data.next();
			temp[1]=Integer.parseInt(s);
			Sample x=new Sample(temp);
			c.add(x);
		}
		c.randomPick(num);
		return c;
	}
	
	/**
	 * find the closest cluster point
	 * @param c
	 * @return
	 */
	public static Cluster[] findClosest(Cluster c)
	{
		c.findClosest();
		Cluster[] result=generateCluster(c.temp);
		for(int i=0;i<c.c.size();i++)
		{
			for(int j=0;j<result.length;j++)
			{
				if(c.temp.contains(c.c.get(i))!=true)
				{
					if(c.c.get(i).closest.equalTo(result[j].s))
					{
						result[j].add(c.c.get(i));
					}
				}
				
			}
			
		}
		return result;
	}
	
	/**
	 * Print out the cluster
	 * @param c
	 */
	public static void printC(Cluster c)
	{
		System.out.println(c.toString());
	}
	
	/**
	 * original data
	 * @param c
	 * @return
	 */
	public ArrayList<Sample> originalData(Cluster c)
	{
		ArrayList<Sample> od=c.c;
		return od;
	}
	
	/**
	 * picked point
	 * @param c
	 * @param k
	 * @return
	 */
	public ArrayList<Sample> pickedPT(Cluster c, int k)
	{
		ArrayList<Sample> temp=c.temp;
		return temp;
	}
}
