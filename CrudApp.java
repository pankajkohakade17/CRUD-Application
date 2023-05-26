package CrudApp;
import java.util.ArrayList;
import java.util.Scanner;

public class CrudApp {
    private ArrayList<User> users = new ArrayList<>();
    private int lastId = 0;

    public static void main(String[] args) {
        CrudApp app = new CrudApp();
        app.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    readUser();
                    break;
                case 3:
                    updateUser(scanner);
                    break;
                case 4:
                    deleteUser(scanner);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private void createUser(Scanner scanner) {
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter age:");
        int age = scanner.nextInt();

        User user = new User(++lastId, name, age);
        users.add(user);

        System.out.println("User created with ID " + user.getId());
    }

    private void readUser() {
        System.out.println("NAME\t\tAGE");
        System.out.println("====================");
        for (User user : users) {
                System.out.println( user.getName()+"\t\t"+user.getAge());
        }
    }

    private void updateUser(Scanner scanner) {
        System.out.println("Enter ID:");
        int id = scanner.nextInt();

        for (User user : users) {
            if (user.getId() == id) {
                System.out.println("Enter new name:");
                String name = scanner.next();
                System.out.println("Enter new age:");
                int age = scanner.nextInt();

                user.setName(name);
                user.setAge(age);

                System.out.println("User updated.");
                return;
            }
        }

        System.out.println("User not found.");
    }
    private void deleteUser(Scanner scanner) {
        System.out.println("Enter ID:");
        int id = scanner.nextInt();

        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                System.out.println("User deleted.");
                return;
            }
        }
        System.out.println("User not found.");
    }
}
