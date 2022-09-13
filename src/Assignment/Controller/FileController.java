package Assignment.Controller;


import Assignment.Model.ProductsModel;
import Assignment.View.MotorcycleShopManagementSystem;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class FileController {
    private static MotorcycleShopManagementSystem motorcycleShopManagementSystem;

    public static void writeFile(String path, List<ProductsModel> productsModelList){

        File f = new File(path); //Neu chua co file tao file moi neu co roi ghi de len
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(f);
            byte[] arr = {10, 20, 30};
            fos.write(arr);
            fos.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void readFile(String path){

        File f = new File(path);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(f);
            int fileSize = (int) f.length();
            byte[] arr = new byte[fileSize];
            fis.read(arr);
            for(int i = 0; i < arr.length; i++){
                System.out.println(arr[i]);
            }
            fis.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void writeDataFile(String path){

        try{

            FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(5);
            dos.writeDouble(4.5);
            dos.writeUTF("Huynh");
            dos.close();
            fos.close();
        }catch (IOException e){

            System.out.println(e);
        }
    }

    public static void readDataFile(String path){

        try{

            FileInputStream fos = new FileInputStream(path);
            DataInputStream dos = new DataInputStream(fos);
            System.out.println(dos.readInt());
            System.out.println(dos.readDouble());
            System.out.println(dos.readUTF());
            dos.close();
            fos.close();
        }catch (IOException e){

            System.out.println(e);
        }
    }

    public static void  writeBuffer(String path, String text){

        try{
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.close();
            fw.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static String readBuffer(String path){

        StringBuilder sb = new StringBuilder();
        try{
            FileReader fr = new FileReader(path); // Not found files
            BufferedReader br = new BufferedReader(fr);
            //read first line
            String str = br.readLine();
            while(str != null){

                sb.append(str);
                //read next line
                str = br.readLine();
                if(str != null){

                    sb.append("\n");
                }
            }
            br.close();
            fr.close();
        }catch (IOException e){
            System.out.println(e);
        }
        return sb.toString();
    }

    public static void  writeObject(String path, Object o){

        try{
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(path)
            );
            oos.writeObject(o);
            oos.close();
        }catch (Exception e){
            System.err.println(e);
        }
    }

    public static Object readObject(String path){

        try{
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(path)
            );
            Object o = ois.readObject();
            ois.close();
            return o;
        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    motorcycleShopManagementSystem,
                    "The data archive file has been created. Path: "+ path,
                    "File Information!",
                    JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

    }
}
