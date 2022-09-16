package vip.xjdai.springbootokhttp.test;

import okhttp3.*;

import java.io.IOException;

public class GetUtils {


    public static void getReuqest(String url) {
        OkHttpClient client = new OkHttpClient();
        //创建一个Request
        Request request = new Request.Builder()
                .get() // 发送 Get 请求
                .url(url)
                .build();
        //通过client发起请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    // 获取 返回的结果
                    System.out.println(string);
                }
            }
        });
    }
}
