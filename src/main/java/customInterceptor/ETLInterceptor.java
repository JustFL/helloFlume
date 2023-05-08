package customInterceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;
import util.JSONUtils;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

public class ETLInterceptor implements Interceptor {

  public static void main(String[] args) {
    //
    String str = "{\"id\":1,\"name\":\"zhangsan\"}";
    System.out.println(JSONUtils.isJSONValidate(str));
  }

  @Override
  public void initialize() {}

  @Override
  public Event intercept(Event event) {
    byte[] body = event.getBody();
    String log = new String(body, StandardCharsets.UTF_8);
    return JSONUtils.isJSONValidate(log) ? event : null;
  }

  @Override
  public List<Event> intercept(List<Event> list) {

    Iterator<Event> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (intercept(iterator.next()) == null) {
        iterator.remove();
      }
    }
    return list;
  }

  @Override
  public void close() {}

  public static class Builder implements Interceptor.Builder {

    @Override
    public Interceptor build() {
      return new ETLInterceptor();
    }

    @Override
    public void configure(Context context) {}
  }
}
