import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Administrator on 2017/6/11.
 */
public class UdpSocketServer {

    public static void main(String[] args) throws SocketException {
        DatagramSocket datagramSocket =new DatagramSocket(9999);
        byte[] bytes = new byte[1024];
        try{
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
            datagramSocket.receive(datagramPacket);
            String ip = datagramPacket.getAddress().getHostAddress();
            System.out.println("ip"+ip);
            int port = datagramPacket.getPort();
            System.out.println("port"+port);
            byte[] msg =datagramPacket.getData();

            System.out.println("data"+new String(msg));
       }catch (Exception e){
            e.printStackTrace();
        }finally {
datagramSocket.close();
        }
    }
}
