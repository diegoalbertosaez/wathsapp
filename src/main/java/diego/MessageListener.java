package diego;

import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.listener.Listener;
import it.auties.whatsapp.listener.RegisterListener;
import it.auties.whatsapp.model.info.MessageInfo;
import it.auties.whatsapp.model.message.model.Message;
import it.auties.whatsapp.model.message.standard.TextMessage;

@RegisterListener
public record MessageListener(Whatsapp api) implements Listener {

    @Override
    public void onLoggedIn() {
        System.out.println("Conectado .....");
    }

    @Override
    public void onNewMessage(MessageInfo info) {
        System.out.println("RECIBIENDO MENSAGE DE ".concat(info.senderName()));

        Message content = info.message().content();
        if (content instanceof TextMessage text) {
            System.out.println(text.text());
            if(text.text().contains("Hola")){
                api.sendMessage(info.chat(), "Hola esta es una respuesta automática");
            }
        }
    }
}
