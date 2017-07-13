import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

/**
 * 封装响应对象
 * Created by Administrator on 2017/6/11.
 */
public class Response {
    private StringBuffer createHeader;

    private StringBuffer contentInfo;

    private BufferedWriter bufferedWriter;

    private String space=" ";

    private String line="\r\n";

    private long len;

    public Response(OutputStream os){
        bufferedWriter= new BufferedWriter(new OutputStreamWriter(os));
        createHeader=new StringBuffer();
        contentInfo=new StringBuffer();

    }
    private void createHeader(int code){
        createHeader.append("HTTP/1.1").append(space);
        switch (code){
            case 200 :
                createHeader.append("200").append(space).append("OK").append(line);
                break;
            case 404:
                createHeader.append("404").append(space).append("not found").append(line);
                break;
            case 500:
                createHeader.append("500").append(space).append("server error").append(line);
                break;
                default:
                    break;

        }
        createHeader.append("Date:").append(space).append(new Date()).append(line);
        createHeader.append("Content-Type: text/html;charset=UTF-8").append(line);
        createHeader.append("Content-Length:").append(len).append(line);
        createHeader.append(line);
    }
    public Response createContentInfo(String str){
        contentInfo.append(str);
        len+=contentInfo.toString().getBytes().length;
        return this;
    }

    public void print(int code)throws IOException{
        createHeader(code);
        bufferedWriter.append(createHeader);
        bufferedWriter.append(contentInfo);

        bufferedWriter.flush();
        bufferedWriter.close();

    }

}
