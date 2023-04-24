/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rob
 */
import java.io.*;
import java.util.*;
import ch05.collections.*;
import support.FamousPerson;
public abstract class FamousBag implements BagInterface{

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) throws IOException 
  {
    // instantiate collection
    final int CAPACITY = 300;    
    ArrayCollection<FamousPerson> people = new ArrayCollection<FamousPerson>(CAPACITY);

    // set up file reading
    FileReader fin = new FileReader("input/FPDriver.txt");
    Scanner info = new Scanner(fin);
    info.useDelimiter("[,\\n]");  // delimiters are commas, line feeds
    
    Scanner scan = new Scanner(System.in);
    FamousPerson person;
    String fname, lname, fact;
    int year;

    // read the info from the file and put in collection
    while (info.hasNext())      
    {
      fname = info.next();   lname = info.next();
      year = info.nextInt(); fact = info.next();
      person = new FamousPerson(fname, lname, year, fact);
      people.add(person);
    }
    
    // interact with user, getting names and displaying info
    final String STOP = "X";     
    System.out.println("Enter names of Famous Person.");
    System.out.println("Enter: firstname lastname (" + STOP + " to exit)\n");
    fname = null; lname = null;
    while (!STOP.equals(fname))
    {
      System.out.print("Name> ");
      fname = scan.next(); 
      if (!STOP.equals(fname))
      {
         lname = scan.next();
         person = new FamousPerson(fname,lname,0,"");
         if (people.contains(person))
         {
            person = people.get(person);
            System.out.println(person);
         }
         else
            System.out.println("No information available\n");
      }
    }
  }
}