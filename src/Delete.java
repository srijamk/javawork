import java.io.*;
import java.util.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;


class Delete {
    
    public static boolean delete (File file) {
        
        DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Date dateobj = new Date(file.lastModified());
        Date current = new Date();
        long diff = current.getTime() - dateobj.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        return diffDays > 120;
    }
    
    
    public static void main (String [] args) {
        File [] list = new File("/Users/Kiran/BitTorrent Sync/Srija_Work/lpthw/.git").listFiles();
        for (File file: list) {
            System.out.println(file.getName() + " " + delete(file));
        }
    }
    
    public static int show (File [] files) {
        return 0;
    }
}