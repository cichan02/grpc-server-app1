package by.piskunou.grpccourse;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class App {
    public static void main( String[] args ) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
        							 .addService(new GreetingServiceImpl())
        							 .build();
        server.start();
        System.out.println("Server started");
        
        server.awaitTermination();
    }
}
