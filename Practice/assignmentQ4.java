import java.util.*;

public class assignmentQ4 {
    public static void main(String[] args) {
        System.out.println("Creating a book object with given parameters: ");
        LibraryBook book =new LibraryBook("Rowling", "Harry Potter", "28354b12gi73221", 3, 2);
        System.out.print("Book 1: ");
        book.DisplayBookInfo();
        System.out.println("\nAccesing public member directly: ");
        System.out.println("Current title: " + book.title);
        book.title = "Percy Jackson";  //we can modify directly
        System.out.println("Modified title: " + book.title);

        System.out.println("\nAccessing private members through get methods:");
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Copies: " + book.getCopiesAvailable());
         System.out.println("\nProtected member Edition (Accessing inside package)\nCurrent Edition: " + book.edition);
        book.edition= 6;  //we can access in same class/package
        System.out.println("Modified edition: " + book.edition);

        System.out.println("\nValid Modifications Using Setters of ISBN and author");
        book.setIsbn("ABC1234567890");  // Valid: 13 chars alphanumeric
        book.setAuthor("Riordan");    // Valid: non-empty
        book.setCopiesAvailable(5);
        System.out.print("After Valid Modifications: ");
        System.out.println("Author: " + book.getAuthor()+ "\nISBN: " +book.getIsbn());

        System.out.println(" Testing Invalid Modifications:");
        System.out.println("Testing invalid ISBN:");
        book.setIsbn("2364w");
         System.out.println("Testing invalid author:");
        book.setAuthor("");
        System.out.println("Testing invalid Copies Available:");
        book.setCopiesAvailable(-2);
        //testing borrow functionality
        System.out.println("Testing Borrow Functions:");
        while(book.getCopiesAvailable() >0){
            book.BorrowBook();
        }
        System.out.println("Attempting to borrow when none available:");
        book.BorrowBook(); 
        //testing return method
        System.out.println("Testing Return Method: \nCopies Available Before returning Book: "+ book.getCopiesAvailable());
        book.ReturnBook();
            
    }
}
class LibraryBook{
    private String isbn;
    private String author;
    public  String title;
    protected int copiesSold;
    protected int edition;
    private int copiesAvailable;
    static public String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9]+$";

    public LibraryBook(String author, String title, String isbn, int copiesAvailable,int edition){      //Constructor With Parameters
        this.title = title;
        setIsbn(isbn);
        setAuthor(author);
        setCopiesAvailable(copiesAvailable);   
        this.edition =edition;
    }

    public LibraryBook(){
        title ="NA";
        author ="Umknown";
        copiesAvailable =0;
        isbn ="NA";
        edition =1;
    }

    public String getIsbn(){   //get method to access isbn of book
        return isbn;
    }

    public String getAuthor() {      // get method to access author
        return author;
    }

    public int  getCopiesAvailable() {   //get method to access copies available
        return copiesAvailable;
    }

    public void setIsbn(String isbn){      //setter method to update isbn
        int size =isbn.length();    //cehcks length of the string
        if(!isbn.matches(ALPHANUMERIC_PATTERN) || (size <13 || size<0)){     //validation check to see if isbn length is less than 13 then will not update isbn
            System.out.println("Incorrect ISBN ");
            return;
        }else{
            this.isbn =isbn;
        }
    }

    public void setAuthor(String author){   //set method to update author
        if(author ==null || author.trim().isEmpty()){       //if string contans space author wont be updated
            System.out.println("Incorrect author name" );
            return;
        }{
            System.out.println("Author Set Successfully ");
            this.author =author;
        }
    }

    public void setCopiesAvailable(int copiesAvailable){     //set method to update copies available of the book
        if(copiesAvailable <0){                //validation check to update copies available
            System.out.println("Incorrect ");
            return;
        }else{            //if number is greater than 0 it willl update
            System.out.println("Copies Available Set Successfully ");
            this.copiesAvailable =copiesAvailable; 
        }
    }

    public void DisplayBookInfo(){
        System.out.println("\nBook Name: " + title +"\nAuthor: " +author +"\nISBN: "+ isbn
        + " \nCopies Available: " + copiesAvailable+ "\nEdition: " + edition); //display Book Information
    }

    public  void BorrowBook(){  
        if(copiesAvailable >0){ //decrement books count if copies available are greater than 0
            copiesAvailable -=1;
            System.out.println("Book Borrowed Successfully, Books remaining: " + copiesAvailable);
        }else{
            System.out.println("No books remaining");
            return;
        }
    }

    public  void ReturnBook(){  
            copiesAvailable +=1; //increment books count if book is returned
            System.out.print("Book Returned Succesfully, Books Remaining: " +copiesAvailable);
    }
}