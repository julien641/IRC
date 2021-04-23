package Commands;

import javafxchatserver.Javafxchatserver;
import socketconnection.RC;

public class quit extends Commands {
    public quit(Javafxchatserver cli, String commands) {
        super(cli, commands);
    }

    @Override
    public RC run() {


        stop stop = new stop(getCli(), "stop");
        stop.run();
        super.getCli().stop();
        return RC.success;


    }
}
