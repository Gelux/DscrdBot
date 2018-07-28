package personaljes.dscrdbot.resources.Commands;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

import java.util.List;

public class ListUsers extends Command{

    private String name = "listUsers";
    private String desc = "Listar usuarios del servidor";
    private static List<User> users;

    ListUsers(){
    }

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
        users = channel.getJDA().getUsers();

        for (int i = 0; i < users.size(); i++) {
            channel.sendMessage(users.get(i).getName()).complete();
        }
    }
}
