package com.zhanghp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhanghp.bean.People;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HttpClientDemoApplicationTests {


    @Test
    public void getDemo() {
        CloseableHttpResponse response=null;
        CloseableHttpClient httpClient=null;
        try {
            //
            httpClient = HttpClients.createDefault();
            //
            URIBuilder uriBuilder = new URIBuilder("http://localhost:8090/demo");
            uriBuilder.addParameter("param","张三");
            HttpGet get = new HttpGet(uriBuilder.build());
            //
            response = httpClient.execute(get);
            String s = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(s);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void postDemo(){
        try {
            //
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //post
            HttpPost post = new HttpPost("http://localhost:8090/demo");
            ArrayList<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("param","李四"));
            HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
            post.setEntity(httpEntity);
            //
            CloseableHttpResponse respone = httpClient.execute(post);
            String s = EntityUtils.toString(respone.getEntity());
            System.out.println(s);
            //
            //
            // System.out.println(respone);
            respone.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void postDemo02(){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost("http://localhost:8090/demo2");

            ArrayList<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("name","王二六子"));
            params.add(new BasicNameValuePair("sno","1"));

            HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
            post.setEntity(httpEntity);

            CloseableHttpResponse response = httpClient.execute(post);
            String s = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            People people = objectMapper.readValue(s, People.class);
            System.out.println(people);
            //-->json
            String s1 = objectMapper.writeValueAsString(people);
            System.out.println(s1);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void postDemo3(){
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost("http://localhost:8090/demo3");
            CloseableHttpResponse response = httpClient.execute(post);
            String s = EntityUtils.toString(response.getEntity());


            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, People.class);
            List<People> l = objectMapper.readValue(s, javaType);
            System.out.println(l);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void postDemo4() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8090/demo4");

        List<People> listParam = new ArrayList<>();
        listParam.add(new People("zz",1));
        listParam.add(new People("zz",1));
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(listParam);
        HttpEntity httpEntity = new StringEntity(s, ContentType.APPLICATION_JSON);
        post.setEntity(httpEntity);

        CloseableHttpResponse execute = httpClient.execute(post);
        String s1 = EntityUtils.toString(execute.getEntity());
        System.out.println(s1);

    }
}
