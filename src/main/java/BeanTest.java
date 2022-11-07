import java.util.ArrayList;
import java.util.Date;

public class BeanTest {

    public static void main(String[] args) {
        Album album = new Album(1, "Childish Gambino", "BTI", new Date(2013), 100, "hip-hop");
        Album album2 = new Album(2, "Kid Cudi", "MOTM", new Date(2009), 75, "hip-hop");


        Author author = new Author(1, "john", "doe");
        Author author2 = new Author(2, "billy", "doe");


         Quote quote = new Quote(1, "don't panic plz!", author);
         Quote quote2 = new Quote(2, "don't stress plz!", author);

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quote);
        quotes.add(quote2);

        for(Quote quoteItem: quotes){
            System.out.println(quoteItem.getContent());
            System.out.println(quoteItem.getAuthor().getFirstName() + " " + quoteItem.getAuthor().getLastName());
        }
    }
}
