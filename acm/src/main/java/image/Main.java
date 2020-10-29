package image;

import java.io.File;
import java.net.URL;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class Main {
    public static void main(String[] args) throws Exception{
//        File file = new File("/Users/fnozoszzt/Downloads/WechatIMG3061.jpeg");
//        File file = new File("/Users/fnozoszzt/Downloads/WechatIMG174.jpeg");
//        File file = new File("/Users/fnozoszzt/Downloads/WechatIMG5.jpeg");
        File file = new File("/Users/fnozoszzt/Desktop/1d8029067be6737450d4f6159e719d02.jpg");
        printImageTags(file);
    }
    /**
     * 读取照片里面的信息
     */
    private static void printImageTags(File file) throws ImageProcessingException, Exception{
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        String lat="";
        String log="";
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                String tagName = tag.getTagName();  //标签名
                String desc = tag.getDescription(); //标签信息
                System.out.println(tagName+"   "+desc);//照片信息
                if (tagName.equals("GPS Latitude")) {
                    lat = pointToLatlong(desc);
                } else if (tagName.equals("GPS Longitude")) {
                    log = pointToLatlong(desc);
                }

            }
        }

        System.out.println("log " + log);
        System.out.println("lat " + lat);
        String add = getAdd(log, lat);
        JSONObject jsonObject = JSON.parseObject(add);
        JSONArray jsonArray = jsonObject.getJSONArray("addrList");
        JSONObject jso = jsonArray.getJSONObject(0);
        String allAdd = jso.getString("admName");
        String arr[] = allAdd.split(",");
        String adds = jso.getString("name");
        System.out.println("省："+arr[0]+"\n市："+arr[1]+"\n区："+arr[2]+"\n"+adds);
    }
    /**
     * 经纬度格式  转换
     * @param point 坐标点
     * @return
     */
    public static String pointToLatlong (String point ) {
        Double du = Double.parseDouble(point.substring(0, point.indexOf("°")).trim());
        Double fen = Double.parseDouble(point.substring(point.indexOf("°")+1, point.indexOf("'")).trim());
        Double miao = Double.parseDouble(point.substring(point.indexOf("'")+1, point.indexOf("\"")).trim());
        Double duStr = du + fen / 60 + miao / 60 / 60 ;
        return duStr.toString();
    }

    public static String getAdd(String log, String lat ){
        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l="+lat+","+log+"&type=010";
        String res = "";
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line+"\n";
            }
            in.close();
        } catch (Exception e) {
            System.out.println("error in wapaction,and e is " + e.getMessage());
        }
        //               System.out.println(res);
        return res;
    }


}