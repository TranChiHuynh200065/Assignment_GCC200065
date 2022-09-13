package Assignment.Controller;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateLabelFormatController extends JFormattedTextField.AbstractFormatter {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object stringToValue(String text) throws ParseException {
        return sdf.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if(value != null){

            Calendar c = (Calendar) value;
            return sdf.format(c.getTime());
        }
        return "";
    }
}
