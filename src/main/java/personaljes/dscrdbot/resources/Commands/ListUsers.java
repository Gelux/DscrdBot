package personaljes.dscrdbot.resources.Commands;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class ListUsers extends Command{

    private String name = "listUsers";
    private String desc = "Listar usuarios del servidor";

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

    }
}
