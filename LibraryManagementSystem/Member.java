
import java.util.ArrayList;
import java.util.List;

public class Member {
    private int id;
    private String name;
    private List<Integer> borrowedBookIds;

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBookIds = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Integer> getBorrowedBookIds() { return borrowedBookIds; }

    public void borrowBook(int bookId) {
        borrowedBookIds.add(bookId);
    }

    public void returnBook(int bookId) {
        borrowedBookIds.remove(Integer.valueOf(bookId));
    }

    @Override
    public String toString() {
        return "Member ID: " + id + " | Name: " + name + " | Borrowed Books: " + borrowedBookIds;
    }
}
