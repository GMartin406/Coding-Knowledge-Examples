/*
    Greg Martin
    TugOfWar.java
    11/29/18
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TugOfWar {
	
	private static String team(int[] kids)
	{
		int total=0,maxW,number,i,j,k,newW,bestResult;
		boolean[][] teams;
		String solution,team2;
		
		number=kids.length;
		for(int kid: kids)
		{
			total+=kid;
		}
		maxW=total/2;
		teams=new boolean [maxW+1][number+1];
		for(i=0;i<=maxW;i++)
		{
			for(j=0;j<=number;j++)
			{
				teams[i][j]=false;
			}
		}
		teams[0][0]=true;
		
		for(i=0;i<number;i++)
		{
			for(j=maxW;j>=0;j--)
			{
				if((teams[j][0])&&(j+kids[i]<= maxW)&&(!teams[j+kids[i]][0]))
				{
					newW=j+kids[i];
					for(k=0;k<=number;k++)
					{
						teams[newW][k]=teams[j][k];
					}
					teams[newW][i+1]=true;
				}
			}
		}
		bestResult=maxW;
		while(!teams[bestResult][0])
		{
			bestResult--;
		}
		solution="Team 1: ";
		team2=" ";
		for(i=0;i<number;i++)
		{
			if(teams[bestResult][i+1])
			{
				solution+=" "+kids[i];
			}
			else
			{
				team2+=" "+kids[i];
			}
		}
		solution+="\nTeam 2:"+team2+"\nThe weight difference is "+Math.abs(2*bestResult-total);
                System.out.println(solution);
		return solution;
               
	}

	public static void main(String[] args) {
		Scanner input=null;
		PrintWriter output=null;
		
		int number,i;
		int[] kids;
		
		try
		{
			input=new Scanner(new File("Unbalanced.txt"));
			output=new PrintWriter(new File("balancedOut.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File  not found");
			System.exit(1);
		}
                
		while(input.hasNextInt())
		{
			number=input.nextInt();
			kids=new int[number];
			
			input.nextInt();
			
			for(i=0;i<number;i++)
			{
				kids[i]=input.nextInt();
			}
			
			output.println(team(kids));
			
			if(input.hasNextInt())
			{
				output.println();
			}
		}
	
		output.flush();
		output.close();
		input.close();
	}

}