/**
*@ Faraz Zamansani (386070)
*@ Version 1 (Modified last 14/04/2015)
*Assignment 1 DNA String processing tool
*/

import java.util.Scanner;

public class DNAProcessor
{
String dna = new String("");
    public static void main(String[] args) {
       System.out.println("DNA Processor"); //we are telling the user it is a dna proccessor
        int looplength,spacing,formattype;
        double errors;
        Scanner sc;
        Scanner spaceinput;
        Scanner forminput;
        String inputdna;
        sc = new Scanner(System.in);
        spaceinput = new Scanner(System.in);
        forminput = new Scanner(System.in);
        
        System.out.println("If you would like your format only type '1'");//instructions for user
        System.out.println("If you would like DNA type '2'");//the format of 1,2,3 was chosen to make it easier in the case of typo's or in format only spacing,caps etc can cause issues
        System.out.println("If you would like RNA type '3'");
        
        
   if (forminput.hasNextInt()) //this checks if the user has entered an integer if they have then formattype becomes what they have entered
   {                          
      formattype = forminput.nextInt(); //this is where user enters their choice
   }   else                             //if user entered an invalid option then formattype becomes 1 and user is told this
   {
       System.out.println("you entered an invalid option, option 1 has been chosen for you");
       formattype=1;
   }  
   if (formattype>3||formattype<1){     //if user enteres a number more then 3 or less then 1 then we tell them they have entered an invalid option and formattype=1
       System.out.println("you entered an invalid option, option 1 has been chosen for you");
       formattype=1;
   }
       
   
          System.out.println("please enter spacing"); //instructions for user
if (spaceinput.hasNextInt()) //this checks if the user has entered an integer if they have then spacing becomes what they have entered
   {                          
      spacing = spaceinput.nextInt(); //this is where user enters their choice
   }   else                             //if user entered an invalid option then spacing becomes 0 and user is told this
   {
       System.out.println("you entered an invalid option, spacing of 0 has been chosen");
       spacing=0;
   }   
          System.out.println("please enter DNA Seqence"); //instructions for user
       inputdna = sc.nextLine();//this is where use enters the dna squence in text box
       inputdna=inputdna.toUpperCase();//we are setting whatever the input is to capitals         
         
        looplength=(inputdna.length())-1;//looplength is used in our while statements,this way we arent doing the math in each while statement
                                         //we have -1 here because when i is same as string length we get an error

       
        int i=0;//defining values for these
        errors=0;

        System.out.println("Transcribed Result ");
if (formattype==1)//we are checking if the format chosen is format only, if so we do this while loop
        {
            while (i<=looplength)//while i is less then or equal to looplength we do the loop. i becomes i+1 each iteration
            {
                if (spacing!=0) //this checks if spacing is zero or not, if its not zero then we run the add spaces code, if it zero we do not run the code for adding spaces.
                if(i%spacing==0)//this code checks if the current location (i) if it is divided by spacing has a remainder
                                //if it doesnt then we add a space
                                //eg third run through, spacing 3, 3%3 has a remainder of 0 so we add a space
                {
                   System.out.print(" "); 
                }
                     char currentchar=  inputdna.charAt(i); //this sets currentchar to become the character at i position
                         if (currentchar=='G') //if currentchar is G we display G
                         {
                 System.out.print("G");
                         }
                           else if (currentchar=='A')//if currentchar is A we display A
                 System.out.print("A"); 
                           else if (currentchar=='T')//if currentchar is G we display G
                 System.out.print("T"); 
                           else if (currentchar=='C')//if currentchar is C we display C
                 System.out.print("C"); 
                           else{
                 System.out.print("?"); //if current char is none of the above then it must be an error so
                 errors++;              //we display a question mark and add +1 to our error counter
                           }
                       i++;//i becomes i+1 when this gets as large as the string length then the while statement ends
            }      
            }
        
else if (formattype==2)//we are checking if the format chosen is dna, if so we do this while loop (we have else if because its more efficient and if format is 1 theres no need to recheck this statement
        {
            while (i<=looplength)
            {
                if (spacing!=0) 
                if(i%spacing==0)
                {
                   System.out.print(" "); 
                }
                     char currentchar=  inputdna.charAt(i);
                         if (currentchar=='G')    //this while statement works the same as the one above except
                         {                        // with this one we are replacing G with C etc according to the DNA conversion formula
                 System.out.print("C");
                         }
                           else if (currentchar=='A')
                 System.out.print("T"); 
                           else if (currentchar=='T')
                 System.out.print("A"); 
                           else if (currentchar=='C')
                 System.out.print("G"); 
                           else{
                 System.out.print("?"); 
                 errors++;
                           }
                       i++;
            }      
            }
         
else  if (formattype==3)//we are checking if the format chosen is rna, if so we do this while loop (we have else if because its more efficient and if format is 1 theres no need to recheck this statement
        {
            while (i<=looplength)
            {
                if (spacing!=0)
                if(i%spacing==0)
                {
                   System.out.print(" "); 
                }
                     char currentchar=  inputdna.charAt(i);
                         if (currentchar=='G')//this while statement works the same as the one above except
                         {                    // with this one we are replacing A with U etc according to the RNA conversion fomula
                 System.out.print("C");
                         }
                           else if (currentchar=='A')
                 System.out.print("U"); 
                           else if (currentchar=='T')
                 System.out.print("A"); 
                           else if (currentchar=='C')
                 System.out.print("G"); 
                           else{
                 System.out.print("?"); 
                 errors++;
                           }
                       i++;
            }      
            }

 double errorsdoub= errors/(inputdna.length());//here we are calculating the error rate, based off of the the error counter divided by the string length
 
            System.out.println(" ");
            System.out.println(" you entered " + inputdna);  //this displays what the user has entered
            System.out.println(" you had " + errors +" errors"); //this displays the amount of errors the user had, eg 5 errors
            System.out.println(" length " +(inputdna.length())); //this displays the length of the input given
            System.out.println(" ERROR RATE:  " + errorsdoub);  //this displays the eror rate eg 0.50
    }
     
}