import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * Created by Administrator on 2017/6/3.
 */
public class Test {

    /**
     * @param args
     */
   /* public static void main(String[] args) {
        try {
            HttpEntity entity = new StringEntity("<table class=\\\"tc_tab1 tc_tab3\\\"><tr><th width=\\\"15%\\\">职业名称：</th><td>软件工程师</td><th width=\\\"15%\\\">级 别：</th><td>国家三级</td><td rowspan=\\\"3\\\" valign=\\\"top\\\"><img src=\\\"../../Content/ETP_images/smallcert3.jpg\\\" /></td></tr><tr><th> 证书编号：</th><td>200690130438481</td><th>理论成绩：</th><td></td></tr><tr><th>上报单位：</th><td></td><th>实操成绩：</th><td></td></tr></table> <div class=\\\"tc_div2 tc_div3\\\"></div><table class=\\\"tc_tab1 tc_tab3\\\"><tr><th width=\\\"15%\\\">职业名称：</th><td>程序员</td><th width=\\\"15%\\\">级 别：</th><td>国家四级</td><td rowspan=\\\"3\\\" valign=\\\"top\\\"><img src=\\\"../../Content/ETP_images/smallcert4.jpg\\\" /></td></tr><tr><th> 证书编号：</th><td>200590140440853</td><th>理论成绩：</th><td></td></tr><tr><th>上报单位：</th><td></td><th>实操成绩：</th><td></td></tr></table> <div class=\\\"tc_div2 tc_div3\\\"></div>\"", "UTF-8");
            //内容类型
            System.out.println("内容类型"+entity.getContentType());
            //内容的编码格式
            System.out.println("内容的编码格式"+entity.getContentEncoding());
            //内容的长度
            System.out.println("内容的长度"+entity.getContentLength());
            //把内容转成字符串
            System.out.println("内容转成字符串"+EntityUtils.toString(entity));
            //内容转成字节数组
            System.out.println("内容转成字节数组"+EntityUtils.toByteArray(entity).length);
            String bstr = new String(EntityUtils.toByteArray(entity));
            System.out.println("bstr==="+bstr);
            //还有个直接获得流
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            outStream.write(EntityUtils.toByteArray(entity));
           *//* InputStream in = entity.getContent();

            byte [] b =new byte[1024];
            int len=0;
            while ((len=in.read(b))!=-1){
                outStream.write(b,0,len);
            }
            in.close();*//*
            String encode = new String(Base64.encodeBase64(outStream.toByteArray()));
            String decode = new String(Base64.decodeBase64(encode));
            System.out.println("decode"+decode);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
        } catch (IOException e) {
        }


    }*/

    public void test(){


    }

}
