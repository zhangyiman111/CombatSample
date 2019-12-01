package util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 *@auther:张奕漫
 *@Date: 2019/12/1
 *@Time:19:57
 *@Description:
 * */
public class Util {
    private static Util util = new Util();

    public Util() {
    }

    public static Util getInstance() {
        return util;
    }

    @SuppressLint("StaticFieldLeak")
    public void getJson(final String Http, final MyCollBack myCollBack){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                if (TextUtils.isEmpty(s)){
                    myCollBack.onError(new Exception("请求失败"));
                }else{
                    myCollBack.getJson(s);
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                InputStream inputStream = null;
                String json = "";
                try {
                    URL url = new URL(Http);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(6000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                       inputStream = httpURLConnection.getInputStream();
                       json = io2String(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return json;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void getphoto (final String Http , final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                InputStream inputStream = null;
                Bitmap bitmap = null;
                try {
                    URL url = new URL(Http);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(6000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream = httpURLConnection.getInputStream();
                        bitmap = io2Bitmap(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return bitmap;
            }
        }.execute();
    }
    public String io2String (InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len = -1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json = new String(bytes1);
        return json;
    }

    public Bitmap io2Bitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }

    public interface MyCollBack{
        void getJson(String json);
        void onError(Throwable throwable);
    }

}
