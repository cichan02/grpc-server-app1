package by.piskunou.grpccourse;

import by.piskunou.grpccourse.GreetingServiceGrpc.GreetingServiceImplBase;
import by.piskunou.grpccourse.GreetingServiceOuterClass.HelloRequest;
import by.piskunou.grpccourse.GreetingServiceOuterClass.HelloResponse;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceImplBase {
	@Override
	public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
		System.out.println(request);		
		for (int i = 0; i < 10_000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			HelloResponse response = HelloResponse.newBuilder()
												  .setGreeting("Hello from server, " + request.getName())
												  .build();	
			responseObserver.onNext(response);
		}	
		responseObserver.onCompleted();
	}
}
