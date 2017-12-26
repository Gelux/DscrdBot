/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaljes.dscrdbot;

import java.text.MessageFormat;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author Jes
 */
public class BotApp extends ListenerAdapter {

    private static final Logger LOGGER = Logger.getLogger(BotApp.class.getName());
    private static final ConsoleHandler cHandler = new ConsoleHandler();

    public static void main(String[] args) {
        LOGGER.setLevel(Level.ALL);
        cHandler.setLevel(Level.ALL);

        LOGGER.addHandler(cHandler);

        try {
            LOGGER.finer("Iniciando jdaBuilder.");
            JDA jdaBot = new JDABuilder(AccountType.BOT).setToken("Mzk0OTcyMjE4MzkzNzU1NjQ4.DSQtyg.e22MYrdkWUUakdu_8UK0UzcchOA").buildBlocking();
            LOGGER.finer("jdaBuilder iniciado.");

            jdaBot.addEventListener(new BotApp());

        } catch (Exception e) {
            LOGGER.warning("Error: " + e);
        }

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        MessageChannel channel = event.getChannel();
        User author = event.getAuthor();
        
        if(message.startsWith("!")){
            String log = MessageFormat.format("Usuario {0} envia {1}", author.getName(), message);
            LOGGER.finer(log);
            String respuesta = message.substring(1);
            channel.sendMessage("El comando que has usado es: " + respuesta + " a que si noob.").queue();
        }
    }
}
