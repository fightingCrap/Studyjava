import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by zhengjq on 2017/3/25.
 */
public class Calendars {
    public static void main(String[] args)
    {

        String[] weekday=new DateFormatSymbols().getShortWeekdays();
        //先创建一个日历对象gregoriancalendar，
        GregorianCalendar calendar=new GregorianCalendar();
        //获取当地的时间，以及这个月有几天。
        int today=calendar.get(Calendar.DAY_OF_MONTH);
        int mouthDays=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设定该月的第一天，获取第一天为星期几，
        calendar.set(Calendar.DAY_OF_MONTH,1);
        int firstDayWeek=calendar.get(Calendar.DAY_OF_WEEK);
        //通过循环打印星期
        int firstDayOfWeek=calendar.getFirstDayOfWeek();
        int count=0;
        for(int i=0;i<weekday.length;i++)
        {
            System.out.printf("%4s",weekday[i]);
        }
        System.out.println();
        //通过循环打印缩进
        for(int i=1;i<firstDayWeek;i++) {
            System.out.printf("%5s", " ");
            count++;
        }
        //输出日历的每一天，如果是今天打上*号标记，
        for(int i=1;i<=mouthDays;i++)
        {
            if(count==7)
        {
            System.out.println();
            count=0;
        }
            System.out.printf("%5s",i==today?i+"*":i);
            count++;
        }
    }
}
