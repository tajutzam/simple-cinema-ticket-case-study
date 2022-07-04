package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class utilApp <T> {

    public void showGaris(){
        System.out.println("> ----- < ");
    }
    public String inputData(){
        Scanner scan = new Scanner(System.in);
        String value =scan.nextLine();
        return value;
    }
    public <T> T inputDataGenerik(){
        Scanner scan = new Scanner(System.in);
        T dt = (T) scan.next();
        return dt;
    }
    public <T> T getTanggal(){
        Date dts = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("mm/dd/yy");
        T date = (T) formater.format(dts);
        return date;

    }
    public void loading(){
        try{
            System.out.print("Loading .");
            Thread.sleep(100);
            System.out.print(".");
            Thread.sleep(100);
            System.out.print(".");
            Thread.sleep(100);
            System.out.print(".");
            Thread.sleep(100);
            System.out.println(".");

        }catch (InterruptedException e){

        }
    }
}
