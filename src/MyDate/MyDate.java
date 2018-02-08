/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author User
 */
public class MyDate {
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     static  Calendar calendar = Calendar.getInstance();
       
     public static String getCurrentdate(){
          return dateFormat.format(calendar.getTime());
      }
}
