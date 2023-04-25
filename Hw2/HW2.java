
/*
 * CSCI 221, Summer 2022, Programming HW 2
 * <Gavin Hammersley>
 *
 * This program analyzes movie review data to determine if words have a 
 * negative or positive meaning. If a word is used more often in positive 
 * reviews, it is assumed that the word is positive, and vice versa.
 * 
 * It will also accept file names from the user and analyze the positivity or negativity of them.
 * 
 * I created two files, negTest.txt and wordsList.txt that were used to test running
 * againt the code to see if the files were overall negative or positive
 * 
 * This work is entirely my own. 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW2
{
    public static void main(String[] args) throws FileNotFoundException 
    {

        //Initializing all of the variables that will be used through the program
        int reviewScore;
        int usrNum;
        int totalWords = 0;

        String reviewText;
        String word;
        String endOfInput;

        double counter = 0;
        double avg = 0;
        double total = 0; 
        double usrTotal;
        double avgScore = 0;

        //Setting up the board that will ask the user what they want to do
        do 
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("1: Get the score of a word");
            System.out.println("2: Get the average score of words in a file" 
                                + "(one word per line.)");
            System.out.println("3: Find the highest/lowest scoring words in a file");
            System.out.println("4: Sort words from a file into positive.text and" +
                                " negative.txt");
            System.out.println("5: Exit the program");
            System.out.print("Enter a number 1-5: ");

            usrNum = keyboard.nextInt(); 
            endOfInput = keyboard.nextLine();

        }
        while((usrNum <= 0) || (usrNum > 5));

        while(usrNum != 5)
        {
            //When the user selects the first option 
            while(usrNum == 1)
            {
                Scanner keyboard = new Scanner(System.in);
                File reviewFile = new File("movieReviews.txt");
                Scanner reviewScanner = new Scanner(reviewFile);

                System.out.println();
                System.out.print("Enter a word: ");
                word = keyboard.nextLine();

                counter = 0;
                total = 0;
                avg = 0;

                while(reviewScanner.hasNext())
                {
                    reviewScore = reviewScanner.nextInt();
                    reviewText = reviewScanner.nextLine();

                    //If the test contains the word the user is looking for 
                    //The total for the review score concatinats
                    //Along with the counter that will use to see how many times the 
                    //word appears
                    if(reviewText.contains(word))
                    {
                        total += reviewScore;
                        counter++;
                    }

                }

                if(counter != 0)
                    avg = total / counter;

                System.out.println(word + " appears " + counter + " times.");
                System.out.println("The average score for reviews containing the word " + 
                                    word + " is " + avg);
                System.out.println();

                //Again setting up the menu for the user
                do 
                {
                    System.out.println("What would you like to do?");
                    System.out.println("1: Get the score of a word");
                    System.out.println("2: Get the average score of words in a file" 
                                        + "(one word per line.)");
                    System.out.println("3: Find the highest/lowest scoring words in a file");
                    System.out.println("4: Sort words from a file into positive.text and" +
                                        " negative.txt");
                    System.out.println("5: Exit the program");
                    System.out.print("Enter a number 1-5: "); 

                    usrNum = keyboard.nextInt(); 
                    endOfInput = keyboard.nextLine();

                }
                while((usrNum <= 0) || (usrNum > 5));
            }
            //When the user selects the second option
            while (usrNum == 2)
            {
                Scanner keyboard = new Scanner(System.in);

                System.out.println();
                System.out.print("Enter the name of the file you want to find the average " +
                                 "for: ");

                //gettting set up to take the user input
                String fileName = keyboard.next();
                File reviewLine = new File(fileName);
                Scanner reviewFileLines = new Scanner(reviewLine);

                totalWords = 0;
                usrTotal = 0;
                total = 0; 
                counter = 0;

                while(reviewFileLines.hasNext())
                {
                    word = reviewFileLines.next();
                    File reviewFile = new File("movieReviews.txt");
                    Scanner reviewScanner = new Scanner(reviewFile);

                    total = 0;
                    counter = 0;
                    avg = 0; 

                    while(reviewScanner.hasNext())
                    {
                        reviewScore = reviewScanner.nextInt();
                        reviewText = reviewScanner.nextLine();

                        //If the file the user is looking for is a valid file
                        //The total will concatinate to the review score 
                        //Along with the counter that will use to see the average score 
                        //for the file
                        if(reviewText.contains(word))
                        {
                            total += reviewScore;
                            counter++;
                        }

                        if(counter != 0)
                            avg = total / counter;
                    }

                    totalWords++;
                    usrTotal += avg;
                }

                avgScore = usrTotal / totalWords;

                System.out.println("The average score of words in " + fileName + " is " 
                    + avgScore);

                //Declairing if the file is overall a positive or negative file
                if (avgScore >= 2.01)
                    System.out.println("The overall sentiment of " + fileName + " is positive.");
                else if (avgScore <= 1.99)
                    System.out.println("The overall sentiment of " + fileName + " is negative.");
                System.out.println();

                do 
                {
                    System.out.println("What would you like to do?");
                    System.out.println("1: Get the score of a word");
                    System.out.println("2: Get the average score of words in a file" 
                                        + "(one word per line.)");
                    System.out.println("3: Find the highest/lowest scoring words in a file");
                    System.out.println("4: Sort words from a file into positive.text and" +
                                        " negative.txt");
                    System.out.println("5: Exit the program");
                    System.out.print("Enter a number 1-5: "); 
                    usrNum = keyboard.nextInt(); 
                    endOfInput = keyboard.nextLine();

                }
                while((usrNum <= 0) || (usrNum > 5));
            }
            //If the user selects option 3
            while(usrNum == 3)
            {
                Scanner keyboard = new Scanner(System.in);

                System.out.println("Enter the name of the file with words you want to score: ");

                String fileName = keyboard.next();
                File reviewLine = new File(fileName);
                Scanner reviewFileLines = new Scanner(reviewLine);

                totalWords = 0; 
                usrTotal = 0;
                total = 0; 
                counter = 0; 


                String positiveWord = "";
                double topPositive = 0;
                String negativeWord = "";
                double topNegative = 0;

                int wordNums = 0; 

                while(reviewFileLines.hasNext())
                {
                    word = reviewFileLines.nextLine();
                    File reviewFile = new File("movieReviews.txt");
                    Scanner reviewScanner = new Scanner(reviewFile);

                    total = 0;
                    counter = 0;

                    while(reviewScanner.hasNext())
                    {
                        //Reading the score and the line that contains the word.
                        reviewScore = reviewScanner.nextInt();
                        reviewText = reviewScanner.nextLine();

                        if(reviewText.contains(word))
                        {
                            total += reviewScore;
                            counter++;
                        }
                        avg = total / counter;
                    }
                    //If the average is not 0 then the program will go through and find the case that 
                    //matches so it can evaluate which word in the users file is the most negative
                    // or the most positive.
                    if(avg != 0)
                    {
                        wordNums++;

                        if(wordNums == 1)
                        {
                            topPositive = avg;
                            positiveWord = word;

                            topNegative = avg;
                            negativeWord = word;
                        }   

                        if(avg > topPositive)
                        {
                            topPositive = avg;
                            positiveWord = word;
                        }

                        if(avg < topNegative)
                        {
                            topNegative = avg;
                            negativeWord = word;
                        }
                    }
                }
                System.out.println();
                System.out.println("The most positive word, with a score of " + topPositive +
                                    " is " + positiveWord);
                System.out.println("The most negative word, with a score of " + topNegative +
                                    " is " + negativeWord);
                System.out.println();
                do
                {
                    System.out.println("What would you like to do?");
                    System.out.println("1: Get the score of a word");
                    System.out.println("2: Get the average score of words in a file" 
                                        + "(one word per line.)");
                    System.out.println("3: Find the highest/lowest scoring words in a file");
                    System.out.println("4: Sort words from a file into positive.text and" +
                                        " negative.txt");
                    System.out.println("5: Exit the program");
                    System.out.print("Enter a number 1-5: "); 

                    usrNum = keyboard.nextInt(); 
                    endOfInput = keyboard.nextLine();

                }
                while((usrNum <= 0) || (usrNum > 5));
            }
        }
    }
}
