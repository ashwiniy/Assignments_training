import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String.*;


public class variable_ruby {

public static void main(String[] args)
{
    double count = 0,countBuffer=0,countLine=0;
    String lineNumber = "";
    String filePath = "rubyy.txt";
    BufferedReader br;
    String inputSearch = "class";
    String line = "";
	String word = " name:Ashwini";
	try
	{
		br = new BufferedReader(new FileReader(filePath));
		try
		{
			while((line = br.readLine()) != null)
			{
				countLine++;
				//System.out.println(line);
				String[] words = line.split(" ");
		
				for (int i=0; i<words.length; i++)
				{
					if (words[i].equals(inputSearch))
					{
						br.readLine();
						count++;
						countBuffer++;
						word = words[i];
					}
				}
				//public void printNames(String string) {
				int i = 0;
//System.out.println("done!!");
				//int found=-1;
				/*while (true)
				{

					//System.out.println("In while for getting classname");				//found = -1;	
					int found = line.indexOf("class");
					//System.out.println(found);
					if (found == -1) break;
					int start = found + 6; // start of actual name
					int end = line.indexOf(" ",start);
					System.out.println(line.substring(start, end));
					i = end + 1;  // advance i to start the next iteration
					line = br.readLine();
				
				}*/

/////////////////////////////////////////////////////////////////////
                                while (true)
				{

					//System.out.println("In while for getting classname");				//found = -1;	
					int found = line.indexOf("@");
					//System.out.println(found);
					if (found == -1) break;
					int start = found + 1; // start of actual name
					int end = line.indexOf(" ",start);
					System.out.println(line.substring(start, end));
					i = end + 1;  // advance i to start the next iteration
					line = br.readLine();
				
				}

///////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////
 
				

					/*//while (!true) {
    int found = word.lastIndexOf(":Ashwini");
    if (found == -1) break;
    int start = found -8; // start of actual name
    int end = word.indexOf(" ", start);
    System.out.println(word.substring(start, end));
    i = end - 1;  // advance i to start the next iteration
  //}
*/
////////////////////////////////////////////////////////////////////////////
 /*while (true)
				{

					//System.out.println("In while for getting methodname");						
					int found2 = line.indexOf("int", i);
					if (found2 == -1) break;
					int start2 = found2 + 4; // start of actual name
					int end2 = line.indexOf("(", start2);
					System.out.println(line.substring(start2, end2));
					i = end2 + 1;  // advance i to start the next iteration
				}*/
///////////////////////////////////////////////////////////////////////////
/*while(true)
{
String string = "It was hot (so hot!) I'm telling you.";

int left = string.indexOf("(");
int right = string.indexOf(")");

// pull out the text inside the parens
System.out.println(string.substring(left+1, right)); 
 }*/
///////////////////////////////////////////////////////////////////////////////
		

                		/*if(countBuffer > 0)
                		{
                		    countBuffer = 0;
                		    lineNumber += countLine + ",";
                		}*/	
			}
			br.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
        	}
	}
	catch (FileNotFoundException e)
	{
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	}


    System.out.println("Times found at--"+count);
    System.out.println("Word found at--"+lineNumber);
}
}
