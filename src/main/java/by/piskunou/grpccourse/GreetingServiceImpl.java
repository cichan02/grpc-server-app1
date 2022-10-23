package by.piskunou.grpccourse;

import by.piskunou.grpccourse.GreetingServiceGrpc.GreetingServiceImplBase;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceImplBase {
	@Override
	public void greeting(GreetingServiceOuterClass.HelloRequest request,
						 StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
		System.out.println(request);
		
		GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass
															.HelloResponse
															.newBuilder()
															.setGreeting("Hello from server, " + request.getName())
															.build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
