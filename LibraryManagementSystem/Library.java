
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        System.out.print("Enter Number of Copies: ");
        int copies = scanner.nextInt();
        books.add(new Book(id, title, author, copies));
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = scanner.nextInt();
        books.removeIf(book -> book.getId() == id);
        System.out.println("Book deleted if ID was found.");
    }

    public void registerMember() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        members.add(new Member(id, name));
        System.out.println("Member registered successfully!");
    }

    public void viewMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void issueBook() {
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        Member member = members.stream().filter(m -> m.getId() == memberId).findFirst().orElse(null);
        Book book = books.stream().filter(b -> b.getId() == bookId).findFirst().orElse(null);
        if (member != null && book != null && book.getAvailableCopies() > 0) {
            member.borrowBook(bookId);
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Error: Check Member ID, Book ID, or availability.");
        }
    }

    public void returnBook() {
        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt();
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        Member member = members.stream().filter(m -> m.getId() == memberId).findFirst().orElse(null);
        Book book = books.stream().filter(b -> b.getId() == bookId).findFirst().orElse(null);
        if (member != null && book != null && member.getBorrowedBookIds().contains(bookId)) {
            member.returnBook(bookId);
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Error: Check Member ID, Book ID, or borrowed status.");
        }
    }
}
