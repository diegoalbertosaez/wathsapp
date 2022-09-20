package diego;

import it.auties.whatsapp.api.ErrorHandler;
import it.auties.whatsapp.api.HistoryLength;
import it.auties.whatsapp.api.QrHandler;
import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.model.signal.auth.Version;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;

public class TestWhatsapp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("INICIANDO");


        var configuration =Whatsapp.Options.newOptions() // Implement only the options that you need!
                //.id(ThreadLocalRandom.current().nextInt()) // A random unique ID associated with the session
                .id(Integer.parseInt("2502"))

                .version(new Version(2,2234,13)) // The default version of this client
                .description("Colorín Colorado ChatBot") // The name of the service that is displayed in Whatsapp's devices tab
                .historyLength(HistoryLength.THREE_MONTHS) // The amount of chat history that Whatsapp sends to the client on the first scan
                .build(); // Creates an instance of WhatsappOptions

        var connection = Whatsapp.newConnection(configuration);



        connection.connect().get();

    }


}
