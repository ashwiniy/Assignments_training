import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class as{

public static void main(String[] args)
{
    double count = 0,countBuffer=0,countLine=0;
    String lineNumber = "";
    String filePath = "TestText.txt";
    BufferedReader br;
    String inputSearch ="<?php";
    String inputSear ="public";
    String inputSear1 ="end";
String classname ="class";

    String line = "";

    try {
        br = new BufferedReader(new FileReader(filePath));
        try {
            while((line = br.readLine()) != null)
            {
                //countLine++;
                //System.out.println(line);
                String[] words = line.split(" ");

                for (String word : words) 
		{

                  if (word.equals(inputSearch)) {
                    
                    System.out.println("its a php programming language");
                    //count++;
                    //countBuffer++;
                  }
				
		  

///////////////////////////////////////////

                  else if (word.equals(inputSear)) {
                    
                    System.out.println("its a java programming language");
                   // count++;
                    //countBuffer++;
                  }

////////////////////////////////////////////////

else if (word.equals(inputSear1)) {
                    
                    System.out.println("its a ruby programming language");
                   // count++;
                    //countBuffer++;
                  }

//////////////////////////////////////////////////
                }

               // if(countBuffer > 0)
               // {
                //    countBuffer = 0;
                //    lineNumber += countLine + ",";
              //  }

            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    System.out.println("Times found at--"+count);
    System.out.println("Word found at--"+lineNumber);
}
}
