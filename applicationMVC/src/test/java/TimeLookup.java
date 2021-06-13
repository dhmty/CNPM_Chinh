        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minh
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

public class TimeLookup {

    public boolean isTimeSync() {
        String TIME_SERVER = "1.asia.pool.ntp.org";
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(TIME_SERVER);
        } catch (UnknownHostException ex) {
            Logger.getLogger(TimeLookup.class.getName()).log(Level.SEVERE, null, ex);
        }
        TimeInfo timeInfo = null;
        try {
            timeInfo = timeClient.getTime(inetAddress);
        } catch (IOException ex) {
            Logger.getLogger(TimeLookup.class.getName()).log(Level.SEVERE, null, ex);
        }
        long returnTime = timeInfo.getReturnTime();
        long localtime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        System.out.println(returnTime / 1000 - localtime + 25200);
        return Math.abs(returnTime / 1000 - localtime + 25200) < 60;
    }

    public static void main(String[] args) throws Exception {
        System.out.println((new TimeLookup()).isTimeSync());;
    }
}
