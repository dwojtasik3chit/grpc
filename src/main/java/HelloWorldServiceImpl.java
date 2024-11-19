import io.grpc.stub.StreamObserver;
public class HelloWorldServiceImpl
        extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void hello( Hello.HelloRequest request, StreamObserver<Hello.HelloResponse> responseObserver) {

        System.out.println("Handling hello endpoint: " + request.toString());

        String text = "Hello World, " + request.getFirstname() + " " + request.getLastname();
        Hello.HelloResponse response = Hello.HelloResponse.newBuilder().setText(text).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();


    }
    @Override
    public void election ( Hello.ElectionData request, StreamObserver<Hello.ElectionResponse> responseObserver) {

        System.out.println("Handling hello endpoint: " + request.toString());

        String text = "Election results : Party: " + request.getName() + " Votes : " + request.getVotes();
        Hello.ElectionResponse response = Hello.ElectionResponse.newBuilder().setElectiontext(text).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();


    }


}