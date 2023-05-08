import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateGenerator {

  @Test
  public void test() {
    GregorianCalendar c = new GregorianCalendar(2023, 0, 1);
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    while (c.get(Calendar.YEAR) == 2023) {
      String date = sf.format(c.getTime());
      int week_of_year = c.get(Calendar.WEEK_OF_YEAR);
      int day_of_week = c.get(Calendar.DAY_OF_WEEK);
      int day_of_month = c.get(Calendar.DAY_OF_MONTH);
      int month = c.get(Calendar.MONTH) + 1;
      int quarter = (month - 1) / 3 + 1;
      int year = c.get(Calendar.YEAR);

      int is_work_day = (day_of_week == 1 | day_of_week == 7) ? 0 : 1;

      System.out.printf(
          "%s\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t\\N      \n",
          date, week_of_year, day_of_week, day_of_month, month, quarter, year, is_work_day);

      c.add(Calendar.DATE, 1);
    }
  }
}
