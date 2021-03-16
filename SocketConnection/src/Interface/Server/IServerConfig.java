package Interface.Server;

import java.util.Properties;

public interface IServerConfig {


    String getADMIN_USERNAME();

    @Override
    String toString();

    String getADMIN_PASSWORD();

    boolean isEnable_whitelist();

    int getMAXUSER();

    String getName();

    boolean isPASS_REQ();
}
