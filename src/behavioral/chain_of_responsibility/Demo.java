package behavioral.chain_of_responsibility;

import behavioral.chain_of_responsibility.middlewares.Middleware;
import behavioral.chain_of_responsibility.middlewares.RoleCheckMiddleware;
import behavioral.chain_of_responsibility.middlewares.ThrottlingMiddeware;
import behavioral.chain_of_responsibility.middlewares.UserExistsMiddleware;
import behavioral.chain_of_responsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    public static void init(){
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        Middleware middleware = new ThrottlingMiddeware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do{
            System.out.println("Enter email:");
            String email = reader.readLine();
            System.out.println("Input password:");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while(!success);
    }
}
