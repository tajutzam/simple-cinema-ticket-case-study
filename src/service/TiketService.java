package service;

import Repository.Tiket;
import util.utilApp;

public class TiketService {

    Tiket tiket = new Tiket();
    utilApp utilApp = new utilApp();

    public boolean showTiket(){

        boolean isEmpty;
        if(tiket.showTiket()==false){
            isEmpty=false;
        }else{
            isEmpty=true;
        }
        return isEmpty;
    }
    public boolean tambahTiket(String judul , int harga){
    boolean isSuces =false;
        boolean isTrue=false;

       if(tiket.tambahDataTiket(judul, harga)==true){
           System.out.println("Berhasil Menambahkan Tiket tekan y");
           String opsi =utilApp.inputData();
           do {
               if(opsi.equals("y")){
                   isTrue=true;
                   isSuces=true;
               }else{
                   boolean ulang=false;
                   do{
                       System.out.println("Input Salah , ulang !");
                       String opsiApp = utilApp.inputData();
                       if(opsiApp.equals("y")){

                           ulang=false;
                           isSuces=true;
                       }else{
                           ulang=true;
                       }

                   }while(ulang==false);

                   isSuces=false;
               }
           }while(isTrue==false);
       }else{
           isSuces=false;
       }
       return isSuces;
    }
    public boolean reservasiTiket(){
        return tiket.reservasiTiket();
    }

}
