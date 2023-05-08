package customInterceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class TimestampInterceptor implements Interceptor {

  @Override
  public void initialize() {}

  @Override
  public Event intercept(Event event) {

    String log = new String(event.getBody(), StandardCharsets.UTF_8);
    JSONObject obj = JSON.parseObject(log);
    Map<String, String> headers = event.getHeaders();
    headers.put("timestamp", obj.getString("ts"));

    return event;
  }

  @Override
  public List<Event> intercept(List<Event> list) {
    for (Event event : list) {
      intercept(event);
    }
    return list;
  }

  @Override
  public void close() {}

  public static class Builder implements Interceptor.Builder {

    @Override
    public Interceptor build() {
      return new TimestampInterceptor();
    }

    @Override
    public void configure(Context context) {}
  }
}
