package Assignment.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringController {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Date stringToDate(String text){
        try{
            return sdf.parse(text);
        }catch (ParseException e){
            System.out.println(e);
            return null;
        }
    }

    public static String dateToString(Date d){
        try{
            return sdf.format(d);
        }catch (Exception e){
            return sdf.format(new Date());
        }
    }
}
