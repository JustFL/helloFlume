package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONUtils {
  public static boolean isJSONValidate(String log) {
    try {
      JSON.parseObject(log);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  //  public static void main(String[] args) {
  //    String json =
  // "{\"common\":{\"ar\":\"310000\",\"ba\":\"Xiaomi\",\"ch\":\"huawei\",\"is_new\":\"0\",\"md\":\"Xiaomi Mix2 \",\"mid\":\"mid_944929\",\"os\":\"Android 11.0\",\"uid\":\"631\",\"vc\":\"v2.1.134\"},\"displays\":[{\"display_type\":\"activity\",\"item\":\"1\",\"item_type\":\"activity_id\",\"order\":1,\"pos_id\":3},{\"display_type\":\"query\",\"item\":\"18\",\"item_type\":\"sku_id\",\"order\":2,\"pos_id\":4},{\"display_type\":\"query\",\"item\":\"11\",\"item_type\":\"sku_id\",\"order\":3,\"pos_id\":5},{\"display_type\":\"recommend\",\"item\":\"29\",\"item_type\":\"sku_id\",\"order\":4,\"pos_id\":4},{\"display_type\":\"query\",\"item\":\"7\",\"item_type\":\"sku_id\",\"order\":5,\"pos_id\":4},{\"display_type\":\"promotion\",\"item\":\"7\",\"item_type\":\"sku_id\",\"order\":6,\"pos_id\":1},{\"display_type\":\"query\",\"item\":\"7\",\"item_type\":\"sku_id\",\"order\":7,\"pos_id\":2}],\"page\":{\"during_time\":16089,\"page_id\":\"home\"},\"ts\":1679908184000}";
  //
  //    JSONObject obj = JSON.parseObject(json);
  //    Long ts = obj.getLong("ts");
  //
  //    JSONObject common = obj.getJSONObject("common");
  //    System.out.println(common);
  //
  //    System.out.println(common.getString("ar"));
  //
  //    JSONArray displays = obj.getJSONArray("displays");
  //    System.out.println(displays);
  //
  //    // {
  //    //            "display_type":"activity",
  //    //            "item":"1",
  //    //            "item_type":"activity_id",
  //    //            "order":1,
  //    //            "pos_id":3
  //    //        }
  //    JSONObject arrobj0 = displays.getJSONObject(0);
  //    System.out.println(arrobj0.getString("pos_id"));
  //
  //    System.out.println(ts);
  //  }
}
