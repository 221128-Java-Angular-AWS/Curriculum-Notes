import io.javalin.Javalin;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    /*
    Unlike when working with servlets, with Javalin we aren't doing IoC, Inversion of Control.
    We still have a main method somewhere which kicks off the application and starts the server.
    Program execution will begin there, and will start up the Javalin server. That server will continue
    to run and service
    */


    public static void main(String[] args) {
        Javalin webApp = Javalin.create().start();


        webApp.get("/ping", (ctx) -> {
            ctx.result("pong!");
            ctx.status(200);
        });

        webApp.post("/storeData", ctx -> {
            String name = ctx.formParam("objectName");
            Object obj = ctx.bodyAsClass(Object.class);
            DataStore.storeObject(name, obj);
            ctx.status(201);
        });



        webApp.get("/retrieveData", ctx -> {
            String name = ctx.formParam("objectName");
            Object obj = DataStore.getObject(name);
            ctx.json(obj);
            ctx.status(200);
        });

        webApp.get("/retrieveDataByPathName/{name}", ctx -> {
            String name = ctx.pathParam("name");
            Object obj = DataStore.getObject(name);
            ctx.json(obj);
            ctx.status(200);
        });


        webApp.post("/testFormParams", ctx -> {
            System.out.println(ctx.formParams("test"));

            Map<String, List<String>> paramsMap = ctx.formParamMap();
            Set<String> keys =  paramsMap.keySet();

            for(String key : keys) {
                System.out.println(paramsMap.get(key));
            }

        });


    }

}
