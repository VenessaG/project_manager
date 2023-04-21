import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Poised {

    private static Object Architect;

    public Poised(String name, String surname, String telNumber, String email, String address) {
    }

    public static void main(String[] args) {

        try {
            
            // Request user input

            System.out.print("***** Welcome to Project Manager *****\n\n");

            System.out.print( """
                    Choose an option below:
                    1. Add new Project
                    2. View unfinished Projects
                    3. View Projects past due date
                    4. Edit or Finalise Project

                    Selection:\s""" );
            Scanner menuScanner = new Scanner(System.in);
            int menuSelection = menuScanner.nextInt();

            // Add new Project

            if(menuSelection == 1) {

                // Request user input for Customer details

                System.out.print("\n***** Customer Details ***** \n\n");

                Scanner input = new Scanner(System.in);

                System.out.print("Enter Name here: \n");
                input = new Scanner(System.in);
                String customerName = input.nextLine();

                System.out.print("Enter Surname: \n");
                input = new Scanner(System.in);
                String customerSurname = input.nextLine();

                System.out.print("Enter Telephone Number: \n");
                input = new Scanner(System.in);
                String customerTelNumber = input.nextLine();

                System.out.print("Enter email: \n");
                input = new Scanner(System.in);
                String customerEmail = input.nextLine();

                System.out.print("Enter address: \n");
                input = new Scanner(System.in);
                String customerAddress = input.nextLine();

                // Create 'Customer' objects
                // User input will be stored in variables and will be stored in the below variable as follows

                Customer customer = new Customer(customerName, customerSurname, customerTelNumber, customerEmail, customerAddress);

                // Request user input for Contractor details

                System.out.print("\n***** Contractor Details ***** \n\n");

                Scanner contractorInput = new Scanner(System.in);

                System.out.print("Enter Name: \n");
                contractorInput = new Scanner(System.in);
                String contractorName = contractorInput.nextLine();

                System.out.print("Enter Surname: \n");
                contractorInput = new Scanner(System.in);
                String contractorSurname = contractorInput.nextLine();

                System.out.print("Enter Telephone Number: \n");
                contractorInput = new Scanner(System.in);
                String contractorTelNumber = contractorInput.nextLine();

                System.out.print("Enter email: \n");
                contractorInput = new Scanner(System.in);
                String contractorEmail = contractorInput.nextLine();

                System.out.print("Enter address: \n");
                contractorInput = new Scanner(System.in);
                String contractorAddress = contractorInput.nextLine();

                // Create 'Contractor' objects

                Contractor contractor = new Contractor(contractorName, contractorSurname, contractorTelNumber, contractorEmail, contractorAddress);

                // Request user input for Architect details

                System.out.print("\n***** Architect Details ***** \n\n");

                Scanner architectInput = new Scanner(System.in);

                System.out.print("Enter Name: \n");
                architectInput = new Scanner(System.in);
                String architectName = architectInput.nextLine();

                System.out.print("Enter Surname: \n");
                architectInput = new Scanner(System.in);
                String architectSurname = architectInput.nextLine();

                System.out.print("Enter Telephone Number: \n");
                architectInput = new Scanner(System.in);
                String architectTelNumber = architectInput.nextLine();

                System.out.print("Enter email: \n");
                architectInput = new Scanner(System.in);
                String architectEmail = architectInput.nextLine();

                System.out.print("Enter address: \n");
                architectInput = new Scanner(System.in);
                String architectAddress = architectInput.nextLine();

                // Create 'Customer' objects

                // Declare project variable values
                // Request user input

                System.out.print("\n***** Project Details ***** \n\n");

                Scanner selection = new Scanner(System.in);

                System.out.print("Enter Project Number: \n");
                selection = new Scanner(System.in);
                int projectNumber = selection.nextInt();

                System.out.print("Enter Project Name: \n");
                selection = new Scanner(System.in);
                String projectName = selection.nextLine();

                System.out.print("Enter Building Type: \n");
                selection = new Scanner(System.in);
                String projectBuildingType = selection.nextLine();

                System.out.print("Enter Project Address: \n");
                selection = new Scanner(System.in);
                String projectAddress = selection.nextLine();

                System.out.print("Enter ERF Number: \n");
                selection = new Scanner(System.in);
                int projectErfNumber = selection.nextInt();

                System.out.print("Enter Total Project fee: \n");
                selection = new Scanner(System.in);
                double projectTotalFee = selection.nextDouble();

                System.out.print("Enter Paid to Date amount: \n");
                selection = new Scanner(System.in);
                double projectPaidToDate = selection.nextDouble();


                System.out.print("Enter Deadline (eg.01/12/2021): \n");
                selection = new Scanner(System.in);
                String projectDeadline = selection.nextLine();
                SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                Date newDate = formatDate.parse(projectDeadline);

                String finalised = "N";

                // If no project name is given, make project name customers name

                if( Objects.equals ( projectName, "" ) ) {
                    projectName = projectBuildingType + " " + customerSurname;
                }

                // Create Project objects

                Project house = new Project(projectNumber, projectName, projectBuildingType, projectAddress, projectErfNumber,
                        projectTotalFee, projectPaidToDate, projectDeadline, finalised);


                System.out.print("\nThe following details have successfully been recorded:\n\n ***** Project Details *****\n\n" + house);
                System.out.print("\n\nCustomer:\n\n" + customer);
                System.out.print("Contractor:\n\n" + contractor);
                System.out.print("Architect:\n\n" + Architect);

                // Write input details to project file
                try {

                    SimpleDateFormat formatDate1 = new SimpleDateFormat("dd/MM/yyyy");
                    Date currentDate = new Date();
                    String curDate = formatDate.format(currentDate);

                    double invoice = projectTotalFee - projectPaidToDate;
                    FileWriter projectWrite = new FileWriter("src\\Completed Project.txt", true);
                    BufferedWriter newWrite = new BufferedWriter(projectWrite);
                    newWrite.write(projectNumber + ", " + projectName + ", " + projectBuildingType + ", " +
                            projectAddress + ", " + projectErfNumber + ", " + projectTotalFee + ", " +
                            projectPaidToDate + ", " + projectDeadline + ", " + finalised + ", " +
                            customerName + " " + customerSurname + ", " + contractorName + " " + contractorSurname + ", " +
                            architectName + " " + architectSurname + ", " + curDate + ", " + invoice + "\n");
                    newWrite.close();

                    // Write input to customer file

                    FileWriter customerWrite = new FileWriter("src\\Customers.txt", true);
                    BufferedWriter secondWrite = new BufferedWriter(customerWrite);
                    secondWrite.write(projectNumber + ", " + projectName + ", " + customerName + ", " + customerSurname + ", " +
                            customerTelNumber + ", " + customerEmail + ", " + customerAddress + "\n");
                    secondWrite.close();

                    // Write input to the contractors file

                    FileWriter contractorWrite = new FileWriter("src\\Contractors.txt", true);
                    BufferedWriter thirdWrite = new BufferedWriter(contractorWrite);
                    thirdWrite.write(projectNumber + ", " + projectName + ", " + contractorName + ", " + contractorSurname + ", " +
                            contractorTelNumber + ", " + contractorEmail + ", " + contractorAddress + "\n");
                    thirdWrite.close();

                    // Write input to the architects file

                    FileWriter architectWrite = new FileWriter("src\\Architects.txt", true);
                    BufferedWriter fourthWrite = new BufferedWriter(architectWrite);
                    fourthWrite.write(projectNumber + ", " + projectName + ", " + architectName + ", " + architectSurname + ", " +
                            architectTelNumber + ", " + architectEmail + ", " + architectAddress + "\n");
                    fourthWrite.close();
                }
                catch(Exception e) {
                    System.out.print("The new file could not be created");
                }
            }

            // View unfinished projects

            else if(menuSelection == 2) {
                try {

                    FileReader projectFile = new FileReader("src\\Completed Project.txt");
                    BufferedReader projectReader = new BufferedReader(projectFile);
                    int lines  = 0;

                    while (projectReader.readLine() != null) {
                        lines++;
                    }
                    projectReader.close();

                    // Loop though all the lines in the file

                    FileReader projectFile2 = new FileReader("src\\Completed Project.txt");
                    BufferedReader projectReader2 = new BufferedReader(projectFile2);
                    for(int t = 0; t < lines; t++) {

                        String[] projectLine = projectReader2.readLine().strip().split(", ");

                        int numProject = Integer.parseInt(projectLine[0]);
                        String nameProject = projectLine[1];
                        String typeBuilding = projectLine[2];
                        String addressProject = projectLine[3];
                        int numErf = Integer.parseInt(projectLine[4]);
                        double amountTotal = Double.parseDouble(projectLine[5]);
                        double amountPaidToDate = Double.parseDouble(projectLine[6]);
                        String dateDue = projectLine[7];
                        String finalized1 = projectLine[8];

                        // Create object to display to user

                       Project unfinishedProjects = new Project(numProject, nameProject,typeBuilding, addressProject,
                                numErf, amountTotal,amountPaidToDate, dateDue, finalized1);

                        //Index [8] is the finalised project

                        if(projectLine[8].startsWith("N")) {
                            System.out.print("\n" + unfinishedProjects + "\n");
                        }
                    }
                    projectReader2.close();
                }
                catch (FileNotFoundException fnf) {
                    System.out.print("File not found!");
                }
                catch (IOException e) {
                    System.out.print("Could not read line!");
                }
            }

            // View all overdue projects

            else if(menuSelection == 3) {
                try {

                    FileReader projectFile = new FileReader("src\\Completed Project.txt");
                    BufferedReader projectReader = new BufferedReader(projectFile);
                    int lines  = 0;

                    while (projectReader.readLine() != null) {
                        lines++;
                    }
                    projectReader.close();

                    // Loop through all the lines in the file

                    FileReader projectFile2 = new FileReader("src\\Completed Projects.txt");
                    BufferedReader projectReader2 = new BufferedReader(projectFile2);
                    for(int i = 0; i < lines; i++) {
                        String[] projectLine = projectReader2.readLine().strip().split(", ");

                        int numProject = Integer.parseInt(projectLine[0]);
                        String nameProject = projectLine[1];
                        String typeBuilding = projectLine[2];
                        String addressProject = projectLine[3];
                        int numErf = Integer.parseInt(projectLine[4]);
                        double amountTotal = Double.parseDouble(projectLine[5]);
                        double amountPaidToDate = Double.parseDouble(projectLine[6]);
                        String dateDue = projectLine[7];
                        String finalized1 = projectLine[8];
                        String dateStarted = projectLine[12];

                        // Create object to print to the user

                        Project overdueProject = new Project(numProject, nameProject,typeBuilding, addressProject, numErf, amountTotal,
                                amountPaidToDate, dateDue, finalized1);

                        // Create the date

                        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                        Date currentDate = new Date();
                        String curDate = formatDate.format(currentDate);

                        // Format the dates

                        Date dueDate = formatDate.parse(dateDue);
                        Date currDate = formatDate.parse(curDate);

                        // Check if dates are the same and print overdue projects

                        if(dueDate.compareTo(currDate) < 0) {
                            System.out.print("\n" + overdueProject + "\n");
                        }
                    }
                    projectReader2.close();
                }
                catch(FileNotFoundException fnf) {
                    System.out.print("File not found!");
                }
                catch (IOException e) {
                    System.out.print("Couldn't read file!");
                }
            }

            // Edit or Finalize project

            else if(menuSelection == 4) {
                try {

                    // Request user input

                    System.out.print("Enter Project Number or Project Name:\s");
                    Scanner input1 = new Scanner(System.in);
                    String editSelection = input1.nextLine();

                    FileReader projectFile = new FileReader("src\\Completed Project.txt");
                    BufferedReader projectReader = new BufferedReader(projectFile);
                    int lines  = 0;

                    while (projectReader.readLine() != null) {
                        lines++;
                    }
                    projectReader.close();

                    // Loop through all the lines in the file

                    FileReader projectFile2 = new FileReader("src\\Completed Project.txt");
                    BufferedReader projectReader2 = new BufferedReader(projectFile2);
                    for(int t = 0; t < lines; t++) {

                        String[] projectLine = projectReader2.readLine().strip().split(", ");

                        int numProject = Integer.parseInt(projectLine[0]);
                        String nameProject = projectLine[1];
                        String typeBuilding = projectLine[2];
                        String addressProject = projectLine[3];
                        int numErf = Integer.parseInt(projectLine[4]);
                        double amountTotal = Double.parseDouble(projectLine[5]);
                        double amountPaidToDate = Double.parseDouble(projectLine[6]);
                        String dateDue = projectLine[7];
                        String finalized1 = projectLine[8];
                        String customer = projectLine[9];
                        String contractor = projectLine[10];
                        String architect = projectLine[11];
                        String creationDate = projectLine[12];
                        double invoice = Double.parseDouble(projectLine[13]);

                        // Create object to print to the user

                        Project editProject = new Project(numProject, nameProject,typeBuilding, addressProject, numErf, amountTotal,
                                amountPaidToDate, dateDue, finalized1);

                        // Create old data variable in order to compare to edited data later for replacement

                        String oldData = numProject + ", " + nameProject + ", " + typeBuilding + ", " + addressProject + ", " +
                                numErf + ", " + amountTotal + ", " + amountPaidToDate + ", " + dateDue + ", " + finalized1 + ", " + customer
                                + ", " + contractor + ", " + architect + ", " + creationDate + ", " + invoice;

                        // If the user input is the same as in the file request user to select the following options

                        if(editSelection.equals(projectLine[0]) || editSelection.equals(projectLine[1])) {
                            System.out.print("\n" + editProject);
                            System.out.print( """


                                    Do you want to edit or finalize this project?
                                    1. Edit
                                    2. Finalize

                                    Option:\s""" );
                            Scanner input2 = new Scanner(System.in);
                            int editChoice = input2.nextInt();

                            // Edit option selected
                            // Request user input

                            if(editChoice == 1) {
                                System.out.print( """

                                        What would you like to edit?(select number)
                                        1. Project Number
                                        2. Project Name
                                        3. Building Type
                                        4. Project Address
                                        5. ERF number
                                        6. Total Amount
                                        7. Paid to Date
                                        8. Due Date

                                        Option:\s""" );
                                Scanner input3 = new Scanner(System.in);
                                int edit = input3.nextInt();

                                // Request user input to update the option

                                if(edit == 1) {
                                    System.out.print("\nEnter new Project Number: ");
                                    Scanner input4 = new Scanner(System.in);
                                    numProject = input4.nextInt();
                                }
                                else if(edit == 2) {
                                    System.out.print("\nEnter new Project Name: ");
                                    Scanner input5 = new Scanner(System.in);
                                    nameProject = input5.nextLine();
                                }
                                else if(edit == 3) {
                                    System.out.print("\nEnter new Building Type: ");
                                    Scanner input6 = new Scanner(System.in);
                                    typeBuilding = input6.nextLine();
                                }
                                else if(edit == 4) {
                                    System.out.print("\nEnter new Project Address: ");
                                    Scanner input7 = new Scanner(System.in);
                                    addressProject = input7.nextLine();
                                }
                                else if(edit == 5) {
                                    System.out.print("\nEnter new ERF Number: ");
                                    Scanner input8 = new Scanner(System.in);
                                    numErf = input8.nextInt();
                                }
                                else if(edit == 6) {
                                    System.out.print("\nEnter new Total Amount: ");
                                    Scanner input9 = new Scanner(System.in);
                                    amountTotal = input9.nextDouble();
                                }
                                else if(edit == 7) {
                                    System.out.print("\nEnter new Paid to Date: ");
                                    Scanner input10 = new Scanner(System.in);
                                    amountPaidToDate = input10.nextDouble();
                                }
                                else if(edit == 8) {
                                    System.out.print("\nEnter new Due Date: ");
                                    Scanner input11 = new Scanner(System.in);
                                    dateDue = input11.nextLine();
                                }
                                else {
                                    System.out.print("You did not enter a valid option!");
                                }
                            }

                            // Finalize option

                            else if(editChoice == 2) {
                                finalized1 = "Y";
                                invoice = amountTotal - amountPaidToDate;

                                FileReader customerFile = new FileReader("src\\Customers.txt");
                                BufferedReader customerReader = new BufferedReader(customerFile);
                                int lines2 = 0;

                                while (customerReader.readLine() != null) {
                                    lines2++;
                                }
                                customerReader.close();

                                // Loop through all the lines in the file

                                FileReader customerFile2 = new FileReader("src\\Customers.txt");
                                BufferedReader customerReader2 = new BufferedReader(customerFile2);
                                for(int v = 0; v < lines2; v++) {

                                    String[] customerLine = customerReader2.readLine().split(", ");

                                    if(customerLine[0].equals(editSelection)) {

                                        String name = customerLine[2];
                                        String surname = customerLine[3];
                                        String telNumber = customerLine[4];
                                        String email = customerLine[5];
                                        String address = customerLine[6];

                                        // Create object

                                        Person newCustomer = new Person (name, surname, telNumber, email, address);

                                        // Set finalized date

                                        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                                        Date currentDate = new Date();
                                        String curDate = formatDate.format(currentDate);

                                        // If the difference in the total amount and amount due is 0

                                        if(invoice == 0) {
                                            System.out.print("\nProject finalised!"
                                                    + "\n\nCustomer:\n" + newCustomer + "Completion date: " +
                                                    curDate + "\n\nAmount paid in full."
                                                    + "Thank You");
                                        }

                                        // Generate invoice

                                        else {
                                            System.out.print("\nProject finalised!\n\nCustomer:\n" + newCustomer +
                                                    "Completion date: " + curDate + "\n\nProject Total Fee: R"
                                                    + amountTotal + "\nPaid to Date: R" + amountPaidToDate
                                                    + "\n\nTotal Invoice: R" + invoice);
                                        }
                                    }
                                }
                                customerReader2.close();
                            }
                        }

                        // Edit and replace project details

                        String updatedData = numProject + ", " + nameProject + ", " + typeBuilding + ", " + addressProject + ", " +
                                numErf + ", " + amountTotal + ", " + amountPaidToDate + ", " + dateDue + ", " + finalized1 + ", " + customer
                                + ", " + contractor + ", " + architect + ", " + creationDate + ", " + invoice;

                        // Write to the file

                        try {
                            String filePath = "src\\Completed Projects.txt";
                            Scanner sc = new Scanner(new File(filePath));
                            StringBuilder buffer = new StringBuilder ();
                            while (sc.hasNextLine()) {
                                buffer.append ( sc.nextLine () ).append ( System.lineSeparator () );
                            }
                            String fileContents = buffer.toString();
                            sc.close();
                            fileContents = fileContents.replaceAll( oldData, updatedData );
                            FileWriter writer = new FileWriter(filePath);
                            writer.append(fileContents);
                            writer.flush();
                        }
                        catch(Exception e) {
                            System.out.print("Could not write to file");
                        }
                    }
                    projectReader2.close();
                }

                catch(FileNotFoundException fnf) {
                    System.out.print("File not found!");
                }
                catch (IOException e) {
                    System.out.print("Could not read line!");
                }
            }
            else {
                System.out.print("\nYou did not enter a valid option!");
            }
        }


        //Add two try catch blocks
        //Print to user if incorrect input was given

        catch(InputMismatchException i) {
            System.out.println("The input provided was not a number");
        }
        catch(NoSuchElementException n) {
            System.out.println("No new line found");
        }
        catch (ParseException pe) {
            System.out.print("You did not enter the date in the correct format");
        }
    }
}
