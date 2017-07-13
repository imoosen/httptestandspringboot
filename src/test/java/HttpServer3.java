import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/6/11.
 */
public class HttpServer3 {
    private ServerSocket serverSocket;
    private int PORTNUMBER=8080;
    private String space=" ";
    private String line="\r\n";
    public void start() throws IOException {
    serverSocket =new ServerSocket(8080);
        System.out.println("启动成功");
    accpetClient();

        close();
    }

    private void accpetClient()throws IOException{

        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        byte[] data = new byte[20480];
        int len = in.read(data);
        String dataStr = new String(data,0,len);
        System.out.println("dataStr<<<<"+dataStr);
        OutputStream os=socket.getOutputStream();
        Response res = new Response(os);
        String str = "<!DOCTYPE html><html><head><meta charset=UTF-8><title>Title</title></head><body>wo shi 营营,是个傻瓜</body></html>";
        res.createContentInfo(str);
        res.print(200);

    }

    private void close()throws IOException{

       if (serverSocket!=null){serverSocket.close();}
    }


    public static void main(String[] args) throws IOException{
        new HttpServer3().start();
    }

}
