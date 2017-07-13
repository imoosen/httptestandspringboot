import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/6/11.
 */
public class HttpServer {
    private ServerSocket serverSocket;
    private int PORTNUMBER=8080;
    public void start() throws IOException {
    serverSocket =new ServerSocket(8080);
        System.out.println("启动成功");
    accpetClient();
        close();
    }

    private void accpetClient()throws IOException{

        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        StringBuffer stringBuffer = new StringBuffer();
        String msg;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        while ((msg=bufferedReader.readLine()).length()>0){
            stringBuffer.append(msg+"\r\n");
            if(msg==null){
                break;
            }
        }
        System.out.println(stringBuffer);
    }

    private void close()throws IOException{

       if (serverSocket!=null){serverSocket.close();}
    }


    public static void main(String[] args) throws IOException{
        new HttpServer().start();
    }

}
