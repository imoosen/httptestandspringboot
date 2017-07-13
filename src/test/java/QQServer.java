import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/11.
 */
public class QQServer {
    public static void main(String[] args) {
        //创建socket服务端
        OutputStream os=null;
        ServerSocket serverSocket=null;
        Socket accept=null;
        InputStream in=null;
        try {
            serverSocket=new ServerSocket(1003);
            System.out.println("服务器端启动成功");
            accept= serverSocket.accept();
            System.out.println("客户端连接上服务器端");
            System.out.println("ip==="+accept.getInetAddress().getHostAddress());

            String backMsg="";

            do{
                //回复客户端
                os=accept.getOutputStream();
                Scanner sc = new Scanner(System.in);
                System.out.println("服务器端说");
                backMsg = sc.next();
                os.write(backMsg.getBytes());
                in=accept.getInputStream();
                byte[] data = new byte[1024];
                int len = in.read(data);
                String str = new String(data,0,len);
                System.out.println("客户端说"+str);
            }while(!"么么哒".equals(backMsg));

        }catch (Exception e){

        }finally {
            try {
                if(os!=null){
                    os.close();
                }
                if(in!=null){
                    in.close();
                }
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
