package Repository;

import Entity.PegawaiEntity;

import java.util.*;

import util.utilApp;

public class Pegawai {


    PegawaiEntity pegawai = new PegawaiEntity();
    utilApp ap = new utilApp();
    PegawaiEntity pegawaiMap = new PegawaiEntity();

    public Map<String, List> getMap() {
        return pegawai.getMap();
    }
    public List<String> getAkun() {
        return pegawai.getAkun();
    }
    //membuat method untuk Tambah Pegawai
    public boolean tambahPegawai(String username , String password){
        boolean isSucses=false;
        if(pegawai.getMap().containsKey(username)){
            isSucses=false;
            System.out.println("data sudah ada");
        }else{
            pegawai.getAkun().add(username);
            pegawai.getAkun().add(password);
            //memasukan data dari List ke Map
            pegawai.getMap().put(username , pegawai.getAkun());


            Map<String , List > listTmp = new WeakHashMap<>();
            listTmp.put(username , pegawai.getAkun());
            pegawai.setMap(listTmp);

            isSucses=true;
        }
        return isSucses;
    }
    //membuat method untuk login
    public boolean login(){

        boolean isSuces=false;
        //jika username ada pada data maka bisa login
        System.out.println("Silahkan Login . . .");
        do{
            System.out.print("Masukan Username :");
            String username = ap.inputData();
            System.out.print("Masukan Password :");
            String password = ap.inputData();
            //jika key username ada pada data map dan value yang ada pada map pada indek ke 1 yaitu password ada pada data
            //maka berhasil login / mengembalikan nilai true
            for(int i=1; i < pegawai.getAkun().size() ; i++){
                if(pegawai.getAkun().get(i).equals(username) ){
                    System.out.println("----------");
                    System.out.println("Username :"+username);
                    isSuces=true;
                    //jika tidak maka melakukan perulangan
                    if (i==pegawai.getAkun().size()){
                        if(pegawai.getAkun().get(i).equals(username)){
                            isSuces=true;
                        }else{
                            isSuces=false;
                        }
                    }
                }
            }
            if(isSuces==false){
                System.out.println("Username atau password salah ! ulangi ");
            }
        }while(isSuces==false);

        return isSuces;

    }


}
