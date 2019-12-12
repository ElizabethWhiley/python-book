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

# Frameworkless Basic Web Application Kata Enhancements 

This assumes you have already completed the [Basic Frameworkless Web Application](https://github.com/MYOB-Technology/General_Developer/blob/master/katas/kata-frameworkless-basic-web-application/kata-frameworkless-basic-web-application.md).

You've just completed the basic frameworkless web application. Suddenly mayhem ensues as the industry begins to enter the 2000 dot com boom. Eager investors find out about your system and would like to give you millions of dollars but before they will do this they want you to add some additional features to the system.

Their requirements are as follows:

* By default your web application should just great you with your name and the date however (assume for these examples your name is Bob)  
* You should be able to add additional people to the list. For example, say you want to add Mary to your hello world, after calling the appropriate http requests it should display "Hello Bob and Mary - the time on the server is 10:59pm on 14 March 2018" _(Yes, we know that's no the late 1990's!)   
* You should then be able to add Sue to your hello world, "Hello Bob, Mary and Sue - the time on the server is 10:59pm on 14 March 2018"    
* You can also remove people from the greeting, you could remove Mary while keeping Sue , "Hello Bob & Sue - the time on the server is 11:01pm on 14 March 2018"  
* You should be able to have a custom url to get just a list of people's names without the greetings  
* You should be able to change someones name, if you have already added Sue and Sue now want's to be called Dave, you should be able to do that.  
* You can never remove yourself from the world - in this world Bob will always be there, in your world you should always be there!   
* You can also assume that everyone in your hello world has a unique name, there is only ever one Bob, one Dave, one Mary, etc.  

You can have a UI to show the state of the resource, but you don’t need to worry about UI forms for adding/updating/removing people, just interact using curl or postman or your http tool of choice to send http requests to modify the state of the resource.

Oh, and of course you are still a big believer of autometed tests (this is sounding less and less like the 90's) so you need to have appropriate tests for all important logic! 
