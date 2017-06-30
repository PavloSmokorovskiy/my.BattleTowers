package my.BattleTowers.OldTrash;

/**
 * Created by Smokorovskiy on 12.03.2016.
 */


import java.io.*;

public class FileShow {

    public static void main(String[] args) throws IOException {

        File f= new File("C:\\Intel\\"); // current directory
        File f1 = new File("C:\\Intel\\f1.txt"); // current directory
        File f2 = new File("C:\\Intel\\f2.txt"); // current directory
        File f3 = new File("C:\\Intel\\f3.txt"); // current directory
        f1.createNewFile();
        f2.createNewFile();
        f3.createNewFile();
        PrintStream printStream1 = new PrintStream(f1);
        PrintStream printStream2 = new PrintStream(f2);
        PrintStream printStream3 = new PrintStream(f3);
        printStream1.println("Hello World#1");
        printStream2.println("Hello World#2");
        printStream3.println("Hello World#3");

//        File[] files = f.listFiles();

//        for (File file : files) {
//
//            System.out.print("     file:");
//            System.out.println(file);
//            printStream1.println(file);
//
//        }

        InputStream inputStream = new FileInputStream(f1);





//        FileOutputStream fos = new FileOutputStream(f);
//        PrintStream printStream = new PrintStream(f);
//        printStream.println("Hello World");
//        System.out.println(f.getAbsolutePath());
//        System.out.println(f.getPath());
//        System.out.println(f.lastModified());


    }

}