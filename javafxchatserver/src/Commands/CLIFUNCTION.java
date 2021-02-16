/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

/**
 *
 * @author julien
 */
public class CLIFUNCTION {

	public static int locate(String[] command, String arguments) {
		boolean found = false;
		for (int i = 0; i < command.length; i++) {
			if (command[i].trim().equals(arguments)) {
				return i;
			}

		}
		return -1;
	}

	public static boolean isvalidport(int port) {

		try {
			return port > 49151 && port < 65536;

		} catch (NumberFormatException x) {
			return false;

		} catch (NoClassDefFoundError x) {

			return false;
		}

	}

	/**
	 * getnumberargument
	 *
	 *
	 *
	 *
	 *
	 * @param inputparsed command lined parsed at ' '
	 * @param argument Ex: -p
	 * @return -2 -1 or int -2 argument error -1 default port
	 *
	 */
	public static int getnumberargument(String[] inputparsed, String argument) {
		int rc;
		int portargument = CLIFUNCTION.locate(inputparsed, argument);
		if (portargument > 0 ) {
			if( inputparsed.length-1>portargument){
			try {
				rc = Integer.valueOf(inputparsed[portargument + 1].trim());

				} catch (NumberFormatException x) {
					rc = -2;

				} catch (NoClassDefFoundError x) {

					rc = -2;
				}

			} else {
				rc = -2;

			}

		} else {
			rc = -1;

		}
		return rc;
	}
}
