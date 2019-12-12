# frameworkless-web-application
# Frameworkless Basic Web Application Kata

It's the late 1990s and the internet has just begun to flourish. You have a brilliant idea to build a Hello World web application however there are no MVC frameworks for you to use. Your mission is to implement a basic Hello World web application without using any frameworks. 

When calling the web application from a browser it should return a greeting with your name and the current date/time of the server. For instance, if your name was Bob when hitting the web server (http://localhost:8080) the browser would display "Hello Bob - the time on the server is 10:48pm on 14 March 2018" 

_(Yes, we know we said you were in the 1990s... but we want you to use your current servers date/time ;-))_

Oh, and of course you are one of those new age eXtreme programmers so you need to have appropriate tests! To make your life easier we have got starting points for Java and C#  

## To summarise 

* Keep with standard libraries, don't use frameworks like Spring/Dropwizard or equivalent  
* Try implement all the dispatching code manually.  
* Include in your solution a test case for proving that the "greeting" portion of the system is functioning correctly.  

## Java Starting Point

If you are working in Java, instead of using Spring/Dropwizard only deal with standard libraries and implement all the dispatching code manually. There is a standard library [HttpServer class](https://docs.oracle.com/javase/8/docs/jre/api/net/httpserver/spec/com/sun/net/httpserver/HttpServer.html) in the jdk.  

~~~
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Test {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
~~~

__It is worth mentioniong that using the com.sun. packages is generally a no-no, but for this exercise it is fine__
