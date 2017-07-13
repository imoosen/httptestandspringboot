import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/11.
 */
public class QQClient {
    public static void main(String[] args) {
        //参数1，服务器端ip
        //参数2,服务端port
        Socket accept=null;
        OutputStream os=null;
        InputStream in=null;
        try{
             accept= new Socket("192.168.56.1",1003);
            System.out.println("客户端启动完成");

            String msg="";
            do{
                in=accept.getInputStream();
                byte[] data = new byte[1024];
                int len = in.read(data);
                String str = new String(data,0,len);
                System.out.println("服务器端说:"+str);
                os= accept.getOutputStream();
                System.out.println("客户端说:");
                Scanner sc = new Scanner(System.in);
                msg= sc.next();
                os.write(msg.getBytes());

            }while (!("么么哒").equals(msg));
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            try{
                if(os!=null){
                    os.close(); }
                    if(in!=null){
                    in.close();
                    }
                    if(accept!=null){
                        accept.close();
                    }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

}
