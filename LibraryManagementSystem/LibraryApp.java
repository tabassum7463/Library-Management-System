
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("========= Library Management System =========");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Register Member");
            System.out.println("5. View Members");
            System.out.println("6. Issue Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: library.addBook(); break;
                case 2: library.viewBooks(); break;
                case 3: library.deleteBook(); break;
                case 4: library.registerMember(); break;
                case 5: library.viewMembers(); break;
                case 6: library.issueBook(); break;
                case 7: library.returnBook(); break;
                case 8: System.out.println("Thank you for using the Library Management System."); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
        scanner.close();
    }
}
