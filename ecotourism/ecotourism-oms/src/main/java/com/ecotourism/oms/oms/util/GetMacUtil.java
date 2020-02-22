package com.ecotourism.oms.oms.util;

import com.ecotourism.oms.common.utils.MD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetMacUtil {
    /**
     * 获取当前操作系统名称. return 操作系统名称 例如:windows xp,linux 等.
     */
    public static String getOSName() {
        return System.getProperty("os.name").toLowerCase();
    }

    /**
     * 获取unix网卡的mac地址. 非windows的系统默认调用本方法获取. 如果有特殊系统请继续扩充新的取mac地址方法.
     *
     * @return mac地址
     */
    public static String getUnixMACAddress() {
        String mac = "";
        try
        {
            Process p = new ProcessBuilder("ifconfig").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null)
            {
                Pattern pat = Pattern.compile("\\b\\w+:\\w+:\\w+:\\w+:\\w+:\\w+\\b");
                Matcher mat= pat.matcher(line);
                if(mat.find())
                {
                    mac=mat.group(0);
                }
            }
            br.close();
        }
        catch (IOException e) {
            return "00";
        }
        mac = mac.replace("-", "").replace(":", "").toUpperCase();
        System.out.println("本机MAC地址为:\n"+mac);
        return MD5.md5(mac);
}

    /**
     * 获取WindowsMAC地址
     *
     * @return
     * @throws Exception
     */
    public static String getWindowsMACAddress() {
        StringBuffer sb = new StringBuffer();
        try {
            // 获取本地IP对象
            InetAddress ia = InetAddress.getLocalHost();
            // 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
            byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
            // 下面代码是把mac地址拼装成String
            for (int i = 0; i < mac.length; i++) {
                // mac[i] & 0xFF 是为了把byte转化为正整数
                String s = Integer.toHexString(mac[i] & 0xFF);
                sb.append(s.length() == 1 ? 0 + s : s);
            }
        }
        catch (Exception ex) {
            System.out.println("未获取到网卡地址");
            return "00";
        }
        return MD5.md5(sb.toString().toUpperCase());
    }

    /**
     * 获取MAC地址
     *
     * @return
     * @throws Exception
     */
    public static String getMACAddress() {
        String osName = getOSName();
        String macAddress = "00";
        if("linux".equals(osName) || "LINUX".equals(osName) || "unix".equals(osName) || "UNIX".equals(osName)){
            macAddress = getUnixMACAddress();
        }else{
            macAddress = getWindowsMACAddress();
        }
        return macAddress;
    }


    public static boolean isNull(Object strData) {
        return strData == null || String.valueOf(strData).trim().equals("");
    }
    private static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
    public static void main(String[] args) {
        double x = 103.897554, y = 30.387472;
        System.out.println("x=============="+x);
        System.out.println("y=============="+y);
        double z =Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        x = z * Math.cos(theta) + 0.0065;
        y = z * Math.sin(theta) + 0.006;
        System.out.println("x1=============="+x);
        System.out.println("y1=============="+y);

    }
}
