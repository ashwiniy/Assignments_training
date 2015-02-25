/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessorClasses;

import java.io.File;
import java.util.Scanner;

/**
 *

 */
public class Parser {
    
    String filePath;
    public String output;

    public Parser(String filePath) {
        this.filePath = filePath;
    }
    
    
    
    public String parseRuby() throws Exception
    {
        output = "";
        
        Scanner read = new Scanner(new File(filePath));
        
        //int cnt = 0; FOR DEBUGGING
        while(read.hasNext())
        {
            //cnt++;
            String line,opLine = "";
            line = read.nextLine();
            line = line.trim();
            String[] tempData = line.split(" ");  //Words in a line
            
            if(line.contains("class")){ // FOR CLASS
                output += "---------CLASS---------" + "\n";
                
                opLine += "Access:" + "DEFAULT" + ";";
                opLine += "ClassName:" + tempData[1] + ";"; // CLASS NAME
                
            }
            
            /*ASSUMPTION: Access Specifiers For Methods Are Compulsory*/
            if(line.contains("def")) // FOR METHODS
            {
                String temp = getfilteredMethodName(tempData[1]);
                if(temp.toLowerCase().contains("get"))
                    opLine += "MethodType:" + "GET" + ";";
                else if(temp.toLowerCase().contains("set"))
                    opLine += "MethodType:" + "SET" + ";";
                else
                    opLine += "MethodType:" + "NON-STATIC" + ";";
                    
                opLine += "MethodName:" + temp + ";";
                
            }
            
            
            //-----------------------------------------------------------------------
            if(!opLine.equals("")){
                output += opLine + "\n";
            }
        }
        
        //return output + "\nCNT: " + cnt;
        return output;
    }
    
    
    public String parsePHP() throws Exception
    {
        output = "";
        
        Scanner read = new Scanner(new File(filePath));
        
        //int cnt = 0; FOR DEBUGGING
        while(read.hasNext())
        {
            //cnt++;
            String line,opLine = "";
            line = read.nextLine();
            line = line.trim();
            String[] tempData = line.split(" ");  //Words in a line
            
            if(line.contains("class")){ // FOR CLASS
                output += "---------CLASS---------" + "\n";
                
                opLine += "ClassName:" + tempData[1] + ";"; // CLASS NAME
                
            }
            
            /*ASSUMPTION: Access Specifiers For Methods Are Compulsory*/
            if(line.contains("function")) // FOR METHODS
            {
                opLine += "Access:" + getAccessSpecifier(line) + ";";
                
                String temp = getfilteredMethodName(tempData[2]);
                if(temp.toLowerCase().contains("get"))
                    opLine += "MethodType:" + "GET" + ";";
                else if(temp.toLowerCase().contains("set"))
                    opLine += "MethodType:" + "SET" + ";";
                else
                    opLine += "MethodType:" + "NON-STATIC" + ";";
                    
                    opLine += "MethodName:" + temp + ";";
                
            }
            
            
            //-----------------------------------------------------------------------
            if(!opLine.equals("")){
                output += opLine + "\n";
            }
        }
        
        //return output + "\nCNT: " + cnt;
        return output;
    }
    
    /**
     * Main Code resides here
     * 
     * @return Parsed Output as a String
     * @throws Exception 
     */
    public String parseJava() throws Exception
    {
        output = "";
        
        Scanner read = new Scanner(new File(filePath));
        
        //int cnt = 0; FOR DEBUGGING
        while(read.hasNext())
        {
            //cnt++;
            String line,opLine = "";
            line = read.nextLine();
            line = line.trim();
            String[] tempData = line.split(" ");  //Words in a line
            
            if(line.contains("class")){ // FOR CLASS
                output += "---------CLASS---------" + "\n";
                if(containAccessSpecifiers(line)){
                    opLine += "Access:" + getAccessSpecifier(line) + ";";
                    opLine += "ClassName:" + tempData[2] + ";"; // CLASS NAME
                }
                else{
                    opLine += "Access:" + "DEFAULT" + ";";
                    opLine += "ClassName:" + tempData[1] + ";"; // CLASS NAME
                }
            }
            
            /*ASSUMPTION: Access Specifiers For Methods Are Compulsory*/
            if(containAccessSpecifiers(line) && line.contains("(")) // FOR METHODS
            {
                opLine += "Access:" + getAccessSpecifier(line) + ";";
                
                if(tempData[1].equals("static")){
                    opLine += "MethodType:STATIC" + ";";
                    opLine += "MethodName:" + getfilteredMethodName(tempData[3]) + ";";
                    opLine += "ReturnType:" + tempData[2] + ";";
                }
                else
                {
                    String temp = getfilteredMethodName(tempData[2]);
                    if(temp.toLowerCase().contains("get"))
                        opLine += "MethodType:" + "GET" + ";";
                    else if(temp.toLowerCase().contains("set"))
                        opLine += "MethodType:" + "SET" + ";";
                    else
                        opLine += "MethodType:" + "NON-STATIC" + ";";
                    
                    opLine += "MethodName:" + temp + ";";
                    opLine += "ReturnType:" + tempData[1] + ";";
                }
            }
            
            
            //-----------------------------------------------------------------------
            if(!opLine.equals("")){
                output += opLine + "\n";
            }
        }
        
        //return output + "\nCNT: " + cnt;
        return output;
    }
    private boolean containAccessSpecifiers(String line)
    {
        for(String spec : AccessSpecifiersList)
        {
            if(line.contains(spec)) return true;
        }
        
        return false;
    }
    private String getAccessSpecifier(String line)
    {
        for(String spec : AccessSpecifiersList)
        {
            if(line.contains(spec)) return spec.toUpperCase();
        }
        return "";
    }
    private String getfilteredMethodName(String data)
    {
        data = data.trim();
        String name = "";
        char ch;
        for(int i=0; i<data.length(); i++){
            if( (ch = data.charAt(i)) == '(' )
                break;
            else
                name += ch;
        }
        return name.trim();
    }
    
    /**
     * FINAL DATA
     */
    private final String[] AccessSpecifiersList = new String[]{"public","private","protected"}; 
}
