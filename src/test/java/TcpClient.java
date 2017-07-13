import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * tcp协议客户端
 * Created by Administrator on 2017/6/11.
 */
public class TcpClient {
    public static void main(String[] args) {
        //参数1，服务器端ip
        //参数2,服务端port
        OutputStream os=null;
        try{
            Socket socket = new Socket("192.168.56.1",1003);
            System.out.println("客户端启动完成");
            os= socket.getOutputStream();
            os.write("TCP协议客户端".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {

               try{
                   if(os!=null){
                   os.close(); }
               }catch (IOException e){
                   e.printStackTrace();
               }

        }
    }
}
