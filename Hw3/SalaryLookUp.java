import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * Write a description of class SalaryLookUp here.
 * 
 * At the momment salary look up calls my methods from PlayerSalaries and runs hard coded
 * values to show that they work and also runs bad values to show that they cant be found
 *
 * CSCI 221, Summer 2022, Programming HW 3
 * <Gavin Hammersley>
 * 
 * This work is entirely my own.
 */
public class SalaryLookUp
{
    public static void main (String [] args) throws FileNotFoundException
    {
       PlayerSalaries game = new PlayerSalaries("Salaries.csv");
       
       //examples of a year that does exist in the file, prints the avg salary of that year
       PlayerSalaries.averageSalaryInYear(2010);
       PlayerSalaries.averageSalaryInYear(1985);
       //example of a year that doesnt exist in the file
       PlayerSalaries.averageSalaryInYear(2022);
       
       
       
       //examples of players and years that do exist in the file and prints that player
       PlayerSalaries.findPlayerInYear("burleri01", 1985);
       PlayerSalaries.findPlayerInYear("benjami01", 1999);
       //example of player not in that year
       PlayerSalaries.findPlayerInYear("burleri01", 2030);
       //example of year existing but not the player
       PlayerSalaries.findPlayerInYear("gavin", 1985);


       
       //examples of salaries and years that do exist and prints the highest salary for that year
       PlayerSalaries.highestSalaryInYear(1986);
       PlayerSalaries.highestSalaryInYear(2016);
       //example of a year that doesnt exist in the file so it wont find a salary
       PlayerSalaries.highestSalaryInYear(2023);

       
       
       //examples of salaries and years that do exist and prints the lowest salary for that year
       PlayerSalaries.lowestSalaryInYear(1997);
       PlayerSalaries.lowestSalaryInYear(2013);
       //example of a year that doesnt exist in the file so it wont find a salary
       PlayerSalaries.lowestSalaryInYear(2033);

       
       
       //examples of teams and years that do exist and prints the highest salary for that year/team
       PlayerSalaries.highestSalaryInTeamInYear("ATL", 2011);
       PlayerSalaries.highestSalaryInTeamInYear("PIT", 1999);
       //example of a team and year not existing
       PlayerSalaries.highestSalaryInTeamInYear("SAM", 1999);
       PlayerSalaries.highestSalaryInTeamInYear("PIT", 2222);

       
       
       //examples of teams and years that do exist and prints the lowest salary for that year/team
       PlayerSalaries.lowestSalaryInTeamInYear("CLE", 2000);
       PlayerSalaries.lowestSalaryInTeamInYear("MON", 2001);
       //example of a team and year not existing
       PlayerSalaries.lowestSalaryInTeamInYear("SAM", 1985);
       PlayerSalaries.lowestSalaryInTeamInYear("CLE", 3033);
       
       
       
       //examples of league and years that do exist and prints the highest salary for that year/league
       PlayerSalaries.highestSalaryInLeagueInYear("AL", 1985);
       PlayerSalaries.highestSalaryInLeagueInYear("NL", 2011);
       //example of a league and year not existing
       PlayerSalaries.highestSalaryInLeagueInYear("AA", 2012);
       PlayerSalaries.highestSalaryInLeagueInYear("NL", 1500);

       
       //examples of league and years that do exist and prints the lowest salary for that year/league
       PlayerSalaries.lowestSalaryInLeagueInYear("NL", 2000);
       PlayerSalaries.lowestSalaryInLeagueInYear("AL", 2012);
       //example of a league and year not existing
       PlayerSalaries.lowestSalaryInLeagueInYear("BB", 2012);
       PlayerSalaries.lowestSalaryInLeagueInYear("AL", 1000);
    }
}
