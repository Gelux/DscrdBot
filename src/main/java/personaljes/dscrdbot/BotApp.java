/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaljes.dscrdbot;

import java.text.MessageFormat;
import java.util.List;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import personaljes.dscrdbot.resources.Commands.Command;
import personaljes.dscrdbot.resources.Log;

/**
 *
 * @author Jes
 */
public class BotApp extends ListenerAdapter {

    public static Guild guild;

    public static void main(String[] args) {
        Log.init();
        try {
            
            JDA jdaBot = new JDABuilder(AccountType.BOT).setToken(
                    "Your Token Here").buildBlocking();
            Log.info("jdaBuilder iniciado.");

            jdaBot.addEventListener(new BotApp());
            
            
            List<Guild> guilds = jdaBot.getGuilds();
            int guildsLength = guilds.size();
            if(guildsLength != 0){
                Log.info("Bot conectado a: " + guilds.get(0).getName());
                guild = jdaBot.getGuilds().get(0);
            }else{
                //Permissions 2113142015
                String inviteBot = jdaBot.asBot().getInviteUrl(Permission.getPermissions(2113142015));
                
                Log.info("Añade el bot visitando este enlace: " + inviteBot);
            }

            //Fill command arraylist
            Command.init();
        } catch (Exception e) {
            Log.warn(e.toString());
        }

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        MessageChannel channel = event.getChannel();
        User author = event.getAuthor();

        if (message.startsWith("!")) {
            String log = MessageFormat.format("Usuario {0} envia {1}", author.getName(), message);
            Log.info(log);
            String respuesta = message.substring(1);
            String[] cmdarg = message.substring("!".length()).split(" ", 2);
            String cmd = cmdarg[0];
            String arg;
            Log.info(cmdarg[0]);
            try {
                arg = cmdarg[1];
            } catch (IndexOutOfBoundsException e) {
                arg = null;
            }

            Log.info(String.valueOf(Command.commandList.size()));

            for (Command command : Command.commandList){
                Log.debug(String.valueOf(Command.commandList.size()));
                if(command.compare(cmdarg[0])){
                    Log.debug(command.getName() + command.getDesc());
                    command.execute(arg, author, channel, guild);
                }
            }

            Log.info("Donete");
            Log.info(channel.getName());
            channel.sendMessage("Donete").complete();

            //channel.sendMessage("El comando que has usado es: " + respuesta + " a que si noob.").queue();
        }
    }
   
}
