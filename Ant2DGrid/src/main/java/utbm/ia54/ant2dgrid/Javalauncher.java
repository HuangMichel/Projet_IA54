package utbm.ia54.ant2dgrid;


import java.util.logging.Level;
import io.janusproject.Boot;
import io.janusproject.util.LoggerCreator;

/**
 * Launcher of the simulation framework.
 *
 * This launcher needs the {@link http://www.janusproject.io Janus platform}.
 * 
 */
public class Javalauncher {
		
	public static void main(String[] args) throws Exception {
		Boot.setOffline(true);
		Boot.setVerboseLevel(LoggerCreator.toInt(Level.INFO));
		Boot.showJanusLogo();
				
		Boot.startJanus(
				Ant2DGrid.class
				);
	}
	
}