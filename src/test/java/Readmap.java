import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrator on 2017/7/20.
 */
public class Readmap {
    public static Map<String,List<Integer>> save(String fileName)
    {

        int num = getline(fileName);
        Map<String,List<Integer>> map = new HashMap<>();
        String line=null;
        try
        {
            FileReader ff = new FileReader(fileName);
            BufferedReader bf=new BufferedReader(ff);
            String lineContent=null;
            List<Integer> list=null;
            int i = 0;
            while((lineContent=bf.readLine())!=null){
                list = new ArrayList<>();
                line =lineContent;
                for(int j= 0;j < line.length();j++){
                    int temp = Integer.parseInt(line.substring(j,j+1));
                    list.add(temp);
                }
                map.put(i+"",list);
 //               System.out.println();
                i++;
            }
            bf.close();
            ff.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return map;
    }



    public static int getline(String fileName){

        FileReader fr;
        int x = 0;   // 用于统计行数，从0开始
        try {
            fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while(br.readLine() != null) { //  readLine()方法是按行读的，返回值是这行的内容
                x++;   // 每读一行，则变量x累加1
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return x;  //返回总的行数
    }




    public static void main(String[] args) throws IOException{


        Map<String,List<Integer>> map1 = save("C:/Users/Administrator/Desktop/aa.txt");


        for (String s : map1.keySet()) {
            List<Integer> list = map1.get(s);
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }



    }
}
