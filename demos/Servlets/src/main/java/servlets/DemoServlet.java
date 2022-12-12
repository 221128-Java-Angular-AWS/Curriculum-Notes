package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
This is a servlet class. Servlets contain a number of methods to handle different types of requests sent
to a specific endpoint (representing a specific resource). In this case, any requests sent to the "/demo" endpoint.
That means that the URL to access this resource would look something like this:
    www.host.com/contextpath/demo/
    
 */
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //let's demonstrate sending response text to the user. First we set up an object that we want
        //the mapper to serialize, in this case a list of strings.
        List<String> stringsList = new LinkedList<>();
        stringsList.add("Hello");
        stringsList.add("World!");

        //now let's set up our ObjectMapper. This comes from the Jackson FasterXML library.
        //The writeValueAsString() method converts an object into a JSON representation of that object
        //which can be used to reconstruct an equivalent object
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(stringsList);
        System.out.println("JSON String:\n");

        //now we can write this JSON to the response object body which will be sent back in
        //response to the original request by the webserver.
        resp.setStatus(200);
        resp.getWriter().println(json);
        //note how we are getting something from the request object here. We are getting the
        //writer object, an object just like the "out" in System.out.println(), this is an object
        //which is bound to some output location. System.out is bound to the STDOUT, the console.
        //The response writer object we get back from getWriter is the same thing, bound to the
        //response object's body.


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //let's demonstrate getting the JSON text out of the request body and sending it to the objectmapper
        //We need to get the text out of the body of the request object. There are a number of ways to do so...
        ObjectMapper mapper = new ObjectMapper();


        //As an inputStream object which we can just pass directly to the ObjectMapper
        InputStream stream = req.getInputStream();
        POJO pojo1 = mapper.readValue(stream, POJO.class);
        System.out.println(pojo1);

        //As a BufferedReader object which we can read and then pass the string to the mapper
        BufferedReader reader = req.getReader();
        StringBuilder builder = new StringBuilder();
        while(reader.ready()) {
            builder.append(reader.readLine());
        }
        String json = builder.toString();
        POJO pojo2 = mapper.readValue(json, POJO.class);
        System.out.println(pojo2);

        resp.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //let's use PUT as an example for pulling headers. Headers are key/value pairs stored in the
        //request object that act as metadata about the request itself.
        Enumeration<String> keys = req.getHeaderNames();

        //This Enumeration object is not a collection, but the following should be familiar after studying
        //the Iterable interface of collections API that makes enhanced for loops work. It has a hasMoreElements()
        //and a nextElement() method which are equivalent to the hasNext() and next() methods of Iterable.
        while(keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = req.getHeader(key);
            System.out.println("Header: [" + key + "] " + value);
        }

        resp.setHeader("Success", "true");
        resp.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //let's use doDelete to test fetching query parameters from the URL
        //This method is basically the same as the headers above. There are other ways to do this...
        //for instance, you could parse the whole URI and go looking for the parameter list at the end
        Enumeration<String> keys = req.getParameterNames();
        while(keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = req.getParameter(key);
            System.out.println("Header: [" + key + "] " + value);
        }


        /*
        Query and path params are different.
        This is a URL with query params at the end:
            www.host.com/contextpath/path/to/resource/file.txt?key1=value1&key2=value2
        At the end, the '?' character signifies the beginning of the query parameters. These are
        key value pairs where keys are separated from values with '=', and pairs are separated with '&'

        This is a URL with path parameters:
            www.host.com/contextpath/path/to/resources/3/accounts/123
        In this URL there are two path params, '3' and '123'. These are variables listed right in the URI tokens.
        There's no indicator, we would have to know and document where in the URI those should appear.

         */

        //Java servlets API doesn't have great support for using path params, because of the limited way in which
        //we can use the wildcard (*) in the servlet mapping. We can use the wildcard at the end of the mapping:
        //      /something/something/*

       /*
       But we can't have the wildcard appear in the middle of a URI. This means we can't have the webserver
       map URIs with variables in the middle to the proper servlets. But, where there's a will there's a way.
       We could send all URIs to a single servlet and from there parse the URI and direct it to another servlet.
       This is called the "Front Controller Design Pattern". We can tokenize the URI like below, and then
       perform all sorts of operations based on what was sent.

        Also if they were supported, we could mix and match query and path params:
            www.host.com/contextpath/path/to/resources/3/accounts?accountNum=900182&owner=123123
        We will see these used in Javalin and Spring Data
         */

        String uri = req.getRequestURI();
        String[] uriTokens = uri.split("/"); //breaks the string into an array of substrings separated by '/'
        for(int i = 0; i < uriTokens.length; i++) {
            System.out.println(uriTokens[i]);
        }

    }
}
