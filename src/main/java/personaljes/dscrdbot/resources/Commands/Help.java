package personaljes.dscrdbot.resources.Commands;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import personaljes.dscrdbot.resources.Log;

public class Help extends Command{

    private String name = "help";
    private String desc = "Listar comandos disponibles";


    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(String arg, User author, MessageChannel channel, Guild guild) {
        Log.debug("Enviando Mensaje help");
        channel.sendMessage("La lista de comandos es : \n" + super.toString()).complete();

    }
}
