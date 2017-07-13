import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by Administrator on 2017/6/11.
 */
public class UdpSocketClient {

    //
    public static void main(String[] args) throws SocketException{
        DatagramSocket datagramSocket = new DatagramSocket();
        System.out.println("udp发送成功");
        String msg = "udp数据";
        byte[] bytes = msg.getBytes();
        try {
            InetAddress inetAddress =InetAddress.getByName("192.168.56.1");
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,inetAddress,9999);
       datagramSocket.send(datagramPacket);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }
    }
}
