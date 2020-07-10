package com.rulerbug.bugutils.Utils;

import com.rulerbug.bugutils.Domain.BugOkHttpDataBean;
import com.rulerbug.bugutils.Domain.BugOkHttpDataList;
import com.rulerbug.bugutils.Domain.BugOkHttpFileBean;
import com.rulerbug.bugutils.Domain.BugOkHttpFileList;
import okhttp3.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class BugOkHttpUtils {
    /**
     *
     * @param url   网住
     * @return   输入流
     */
    public static InputStream getInputStrem(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().byteStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param url  访问数据
     * @param path   保存地址
     * @return  文件
     */
    public static File getFile(String url, String path) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            InputStream inputStream = response.body().byteStream();
            File file = new File(path);
            OutputStream outStream = new FileOutputStream(file);
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            return file;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /**
     *

     * @param url  访问数据
     *  @param body  数据
     * @param path   保存地址
     * @return  文件
     */

    public static File postFile(String url, FormBody body, String path) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)      .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            InputStream inputStream = response.body().byteStream();
            File file = new File(path);
            OutputStream outStream = new FileOutputStream(file);
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            return file;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param url  网址
     * @return  借口返回的数据已字符串解析
     */
    public static String getString(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *
     * @param url  网址
     * @return  借口返回的数据已字符串解析
     */
    public static void getString(String url,Callback callbcak) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            client.newCall(request).enqueue(callbcak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param url  网址
     * @return  借口返回的数据
     */
    public static Response getHttp(String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param url  网址
     * @param body 数据
     * @return  借口返回的数据
     */
    public static Response postHttp(String url, FormBody body) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param url 请求网址
     * @param body  数据
     * @param callbcak 回调接口
     */
    public static void postHttp(String url, FormBody body, Callback callbcak) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            client.newCall(request).enqueue(callbcak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param url  接口地址
     * @param body  请求参数
     * @return  字符串
     */
    public static String postString(String url, FormBody body) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param url  接口地址
     * @param body  请求参数
     * @param callbcak  回调接口
     */
    public static void postString(String url, FormBody body, Callback callbcak) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            client.newCall(request).enqueue(callbcak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param url  接口地址
     * @param paramsMap  请求数据
     * @return   返回的数据，用字符串方式解析
     */
    public static String postString(String url, HashMap<String, String> paramsMap) {
        try {
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : paramsMap.keySet()) {
                builder.add(key, paramsMap.get(key));
            }
            RequestBody formBody = builder.build();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param url  上传地址
     * @param body  封装的文件
     * @param callbcak   回调接口
     */
    public static void postFile(String url, MultipartBody body, Callback callbcak) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            client.newCall(request).enqueue(callbcak);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param url  上传地址
     * @param body  封装的文件
     * @return    接口返回的数据
     */
    public static Response postFile(String url, MultipartBody body) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param dataList 键值对列表
     * @param fileList 文件列表
     * @return 可以拿来上传文件
     */
    public static MultipartBody getFileMultipartBody
            (List<BugOkHttpDataBean> dataList, List<BugOkHttpFileBean> fileList) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (  dataList != null && dataList .size() > 0) {
            for (BugOkHttpDataBean b : dataList) {
                builder.addFormDataPart(b.key, b.value);
            }
        }
            if (fileList != null  && fileList .size() > 0) {
        for (BugOkHttpFileBean b : fileList) {
            RequestBody fileBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), b.f);
            builder.addFormDataPart(b.name, b.filename, fileBody);
        }
            }
        return builder.build();
    }


    /**
     * @param dataList 键值对列表
     * @param fileList 文件列表
     * @return 可以拿来上传文件
     */
    public static MultipartBody getFileMultipartBody(BugOkHttpDataList
                                                             dataList, BugOkHttpFileList fileList) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (dataList != null && dataList.dataList != null && dataList.dataList.size() > 0) {
            for (BugOkHttpDataBean b : dataList.dataList) {
                builder.addFormDataPart(b.key, b.value);
            }
        }
        if (fileList != null && fileList.dataList != null && fileList.dataList.size() > 0) {
            for (BugOkHttpFileBean b : fileList.dataList) {
                RequestBody fileBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), b.f);
                builder.addFormDataPart(b.name, b.filename, fileBody);
            }
        }
        return builder.build();
    }
    /**
     * 通过list里的的Bean 普通post請求获得FormBody
     */
    public static FormBody getFormBody(List<BugOkHttpDataBean> dataList) {
        FormBody.Builder builder = new FormBody.Builder();
        if (dataList != null && dataList.size() > 0) {
            for (BugOkHttpDataBean b : dataList) {
                builder.add(b.key, b.value);
            }
        }
        return builder.build();
    }

    /**
     * 通过封装的Bean 普通post請求获得FormBody
     */
    public static FormBody getFormBody(BugOkHttpDataList dataList) {
        FormBody.Builder builder = new FormBody.Builder();
        if (dataList != null && dataList.dataList != null && dataList.dataList.size() > 0) {
            for (BugOkHttpDataBean b : dataList.dataList) {
                builder.add(b.key, b.value);
            }
        }
        return builder.build();
    }

}