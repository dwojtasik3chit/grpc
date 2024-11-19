import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloWorldClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);

        Hello.HelloResponse helloResponse = stub.hello(Hello.HelloRequest.newBuilder()
                .setFirstname("Max")
                .setLastname("Mustermann")
                .build());
        System.out.println( helloResponse.getText() );


        Hello.ElectionResponse electionResponse = stub.election(Hello.ElectionData.newBuilder()
                .setName("SPÖ")
                .setVotes(123)
                .build());
        System.out.println( electionResponse.getElectiontext());

        channel.shutdown();
    }

}
