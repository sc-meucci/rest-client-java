package rest;
import java.util.Scanner;

/**
 * Simone Carletti
 *
 * Rest client demo
 *
 */
public class App {

    public static void main(String[] args) {
        RestClient client = new RestClient("http://localhost:8080/api/tutorial/1.0/employees");
        System.out.println("Welcome to the employees manager dashboard.\n");

        boolean running = true;
        Scanner in = new Scanner(System.in);
        int id = -1;
        while (running) {

            System.out.println("\n(0) List all employees");
            System.out.println("(1) List detail of one employee");
            System.out.println("(2) Delete one employee");
            System.out.println("(3) Add new employee");
            System.out.println("(4) Update employee");
            System.out.println("(9) Exit");

            System.out.print("\n\nPlease select an option:  ");
            String option = in.nextLine();

            switch (option) {
                case "0":
                    System.out.println(client.getEmployees());
                    break;

                case "1":
                    System.out.print("Enter id: ");
                    boolean idValid = false;
                    while (!idValid) {
                        try {
                            id = Integer.parseInt(in.nextLine());
                            System.out.println(client.getEmployee(id));
                            idValid = true;
                        }
                        catch (Exception e) {
                            System.out.print("Inserted id is not valid. Please try again: ");
                            idValid = false;
                        }
                    }
                    break;

                case "2":
                    System.out.print("Enter id: ");
                    id = Integer.parseInt(in.nextLine());
                    System.out.print("\nResult -->  ");
                    System.out.println(client.deleteEmployee(id).getStatusInfo());
                    break;

                case "3":
                case "4":
                    System.out.print("Enter id: ");
                    boolean isInteger = false;
                    while (!isInteger) {
                        try {
                            id = Integer.parseInt(in.nextLine());
                            isInteger = true;
                        }
                        catch (Exception e) {
                            System.out.print("Inserted value is not a valid number. Please try again: ");
                            isInteger = false;
                        }
                    }

                    System.out.print("Enter name: ");
                    String name = in.nextLine();
                    System.out.print("Enter surname: ");
                    String surname = in.nextLine();
                    System.out.print("Enter email: ");
                    String email = in.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = in.nextLine();

                    System.out.print("\nResult -->  ");

                    if (option.equals("3")) {
                        System.out.println(client.addEmployee(new Employee(id, name, surname, email, phone)).getStatusInfo());
                    }
                    else if (option.equals("4")) {
                        System.out.println(client.updateEmployee(new Employee(id, name, surname, email, phone)).getStatusInfo());
                    }
                    break;

                case "9":
                    running = false;
                    break;

                default:
                    System.out.println("Option not valid");
                    break;
            }
        }

        System.out.println("Exited");

        in.close();
    }
}
