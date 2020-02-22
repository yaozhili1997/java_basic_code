package cn.itcast.web.utils;
import java.util.Base64;
import java.util.Base64.Encoder;
//import java.util.Base64.Decoder;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
//            Encoder encoder = Base64.getEncoder();
//            String encode = encoder.encodeToString(data);
            Encoder encoder = Base64.getEncoder();
            filename = "=?utf-8?B?" + encoder.encodeToString(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
