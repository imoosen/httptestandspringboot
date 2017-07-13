import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/11.
 */
public class HttpServer2 {
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
        responseData(os);
       /* StringBuffer stringBuffer = new StringBuffer();
        String msg;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        while ((msg=bufferedReader.readLine()).length()>0){
            stringBuffer.append(msg+"\r\n");
            if(msg==null){
                break;
            }
        }
        System.out.println(stringBuffer);*/
    }

    public void responseData(OutputStream os)throws IOException{
        StringBuffer responseData = new StringBuffer();
        responseData.append("<!DOCTYPE html><html><head><meta charset=UTF-8><title>Title</title></head><body>wo shi imoosen</body></html>");
        StringBuffer response = new StringBuffer();

        response.append("HTTP/1.1").append(space).append("200").append(space).append("OK").append(line);
        response.append("Date:").append(space).append(new Date()).append(line);
        response.append("Content-Type: text/html;charset=UTF-8").append(line);

        response.append("Content-Length:").append(responseData.toString().getBytes().length).append(line);
        response.append(line);
        response.append(responseData.toString());
        System.out.println(responseData.toString());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write(response.toString());
        bw.flush();
        os.close();
        bw.close();
    }
    private void close()throws IOException{

       if (serverSocket!=null){serverSocket.close();}
    }


    public static void main(String[] args) throws IOException{
        new HttpServer2().start();
    }

}
