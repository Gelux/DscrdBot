package personaljes.dscrdbot.resources.Commands;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import personaljes.dscrdbot.resources.Log;

import java.util.ArrayList;
import java.util.Date;

public abstract class Command {

    private static int id = 0;
    private String name;
    private Date execDate;
    public static ArrayList<Command> commandList;

    public static void init(){

        commandList = new ArrayList<>();

        commandList.add(new Help());
        commandList.add(new ListUsers());
    }

    public boolean compare(String comm){
        return comm.equalsIgnoreCase(getName());
    }

    public abstract String getDesc();

    public abstract String getName();

    public abstract void execute(String arg, User author, MessageChannel channel, Guild guild);

    @Override
    public String toString() {
        Log.debug("pasando por toString");
        String strAux ="";

        strAux += "Lista de Comandos: \n";
        for (int i = 0; i < commandList.size(); i++) {
            strAux+="- Comando !" + commandList.get(i).getName() + " : " + commandList.get(i).getDesc() + "\n";
        }
        return strAux;
    }
}
