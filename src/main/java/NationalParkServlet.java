import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NationalParkServlet", urlPatterns = "/nps")
public class NationalParkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        //instantiate an array of strings
//        String[] nationalParks = {"Grand Canyon National Park", "Yosemite National Park", "Denali National Park", "Arches National Park", "Glacier National Park"};
//        // add a request attribute named "nationalParkList" that has the value of the array we instantiated above
//        request.setAttribute("nationalParkList", nationalParks);

        //What about a Java Object?
        Dog d1 = new Dog("YorkiePoo", "Luka", 1);

        request.setAttribute("myDog", d1);
        //forward the request and response objects, and display the jsp file.
         request.getRequestDispatcher("/nps.jsp").forward(request, response);
    }
}
