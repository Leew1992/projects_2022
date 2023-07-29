package learning_1.week_4;

import java.io.*;

public class ProductTest {

    public static void main(String[] args) {
        Product iphone = new Product("pr001", "iphone", "电子产品", 5000);
        Product ipad = new Product("pr002", "ipad", "电子产品", 3200);
        Product macbook = new Product("pr003", "macbook", "电子产品", 15000);
        Product iwatch = new Product("pr004", "iwatch", "电子产品", 4200);

        try {
            FileOutputStream fos = new FileOutputStream("d:\\imooc.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(iphone);
            oos.writeObject(ipad);
            oos.writeObject(macbook);
            oos.writeObject(iwatch);
            oos.writeObject(null);
            oos.flush();
            fos.close();
            oos.close();

            FileInputStream fis = new FileInputStream("d:\\imooc.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Product obj;
            while((obj = (Product)ois.readObject()) != null) {
                System.out.println(obj);
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
