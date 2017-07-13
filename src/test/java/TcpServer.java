import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/6/11.
 */
public class TcpServer {

    public static void main(String[] args) {
        //创建socket服务端
        ServerSocket  serverSocket=null;
        Socket accept=null;
       try {
           serverSocket=new ServerSocket(1003);
           System.out.println("服务器端启动成功");
           accept= serverSocket.accept();
           System.out.println("客户端连接上服务器端");
           System.out.println("ip==="+accept.getInetAddress().getHostAddress());
           InputStream in =accept.getInputStream();
           byte[] data = new byte[1024];
           int len = in.read(data);
           String str = new String(data,0,len);
           System.out.println(str);
       }catch (Exception e){

       }finally {
           try {
               if(accept!=null){
                   accept.close();
               }
               if(serverSocket!=null){
                   serverSocket.close();
               }
           }catch (Exception e){

           }
       }
    }
}
