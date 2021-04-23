/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafxchatserver.Javafxchatserver;
import javafxchatserver.ServerThread;
import socketconnection.RC;

/**
 * @author julien
 */
public class start extends Commands {

    private final String[] argument = {"-p", ""};
    final private int defaultport = 55555;

    public start(Javafxchatserver cli, String input) {
        super(cli, input);
    }

    @Override
    public RC run() {
        //-p argument
        RC rc = RC.failed;
        int ports = CLIFUNCTION.getnumberargument(super.getParsedcommands(), argument[0]);
        System.out.println(ports);
        if (ports == -2) {
            System.out.println("Invalid arguments");
            rc = RC.failed;
        } else if (ports == -1) {
            ports = defaultport;
            super.getCli().startserver(ports);
        } else if (CLIFUNCTION.isvalidport(ports)) {
            super.getCli().startserver(ports);

        }

        return rc;
    }


}
