import java.util.Objects;
import java.util.Scanner;

public class Poised {
    public static void main(String[] args) {
        String menuInput = null;
        while (!Objects.equals(menuInput, "e")) {
            System.out.println("""
                                            
                                            Menu
                    ----------------------------------------------------
                    np --> Generate new report
                    e --> Exit
                    ----------------------------------------------------
                    """);
            Scanner scanMenu = new Scanner(System.in);
            menuInput = scanMenu.nextLine();

            if (Objects.equals(menuInput, "np")){
                // Instructing user
                System.out.println("Please enter the following information:");
                //Attributes
                // Initialising scanner
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Project name:");
                String projectName = scan1.nextLine();

                System.out.println("Project number:");
                Scanner scan2 = new Scanner(System.in);
                int projectNum = scan2.nextInt();

                Scanner scan3 = new Scanner(System.in);
                System.out.println("Building type:");
                String buildType = scan3.nextLine();

                Scanner scan4 = new Scanner(System.in);
                System.out.println("Project Address");
                String projectAddress = scan4.nextLine();

                Scanner scan5 = new Scanner(System.in);
                System.out.println("ERF number:");
                int erfNumber = scan5.nextInt();

                Scanner scan6 = new Scanner(System.in);
                System.out.println("Total fee:");
                int totalFee= scan6.nextInt();

                Scanner scan7 = new Scanner(System.in);
                System.out.println("Total paid to date");
                int paidToDate = scan7.nextInt();

                Scanner scan8 = new Scanner(System.in);
                System.out.println("Deadline for project:");
                String deadline = scan8.nextLine();

                Scanner scan9 = new Scanner(System.in);
                System.out.println("Name of constructor:");
                String name = scan9.nextLine();

                Scanner scan10 = new Scanner(System.in);
                System.out.println("Surname of constructor:");
                String surname = scan10.nextLine();

                Scanner scan11 = new Scanner(System.in);
                System.out.println("Tell number of constructor:");
                String telNum = scan11.nextLine();

                Scanner scan12 = new Scanner(System.in);
                System.out.println("Email Address of constructor:");
                String emailAddress = scan12.nextLine();

                Scanner scan13 = new Scanner(System.in);
                System.out.println("Psychical address of constructor:");
                String physicalAddress = scan13.nextLine();

                // Getting info for class objects

                // Using class to display data
                ProjectInfo userInput = new ProjectInfo(projectName,projectNum,buildType,projectAddress,erfNumber,
                        totalFee,paidToDate,deadline);
                RoleInfo constructorInput = new RoleInfo(name,surname,"Constructor",telNum,emailAddress,
                        physicalAddress);
                System.out.println(userInput);
                System.out.println(constructorInput);
                System.out.println("""
                         ----------------------------------------------------------------
                        """);
            }
        }

    }

}
