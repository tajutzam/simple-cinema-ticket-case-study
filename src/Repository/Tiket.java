package Repository;

import Entity.CustomerEntity;
import Entity.TiketEntity;
import service.logicApp;
import util.utilApp;

import java.awt.*;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class Tiket {


    TiketEntity tiket = new TiketEntity();
    utilApp util = new utilApp();
    CustomerEntity customerEntity = new CustomerEntity();
    utilApp<String> stringutilApp = new utilApp<>();


    public boolean tambahDataTiket(String nama_tiket , int harga){
        boolean isSuce=false;
        boolean isFalse=false;

        do {
            //cek nama tiket sudah ada atau tidak pada map jika ada input ulang dengan judul berbeda
            if(tiket.getDataTiket().contains(nama_tiket)){
                System.out.println("Judul Tiket Sudah Tersedia");
                System.out.print("Masukan Judul :");
                var judul =util.inputData();

                isFalse=true;
                System.out.println("Masukan Harga :");
                var hargaS =util.inputData();
                int hargai = Integer.parseInt(hargaS);
                //add data tiket kedalam list
                tiket.getDataTiket().add(judul);
                tiket.getDataTiket().add(String.valueOf(hargai));
                //menambahkan data tiket pada list kedalam map
                tiket.getTiket().put(judul , tiket.getDataTiket());
                isFalse=false;

                isSuce=true;

            }else{
                tiket.getDataTiket().add(nama_tiket);
                tiket.getDataTiket().add(String.valueOf(harga));
                tiket.getTiket().put(nama_tiket , tiket.getDataTiket());
                isSuce=true;
            }
        }while(isFalse==true);
       return isSuce;
    }
    public boolean showTiket(){
        boolean isEmpty =false;
        //cek tiket kosong atau tidak
        if(tiket.getTiket().isEmpty()){
            System.out.println("Tiket Kosong Tambah Terlebih Dahulu . . .");
            isEmpty=true;
        }else{
            isEmpty=false;
            int i=0;
            //menampilkan data tiket yang ada pada map
            System.out.println("Judul Film pada Bisokop Sejak Makmur . . .");
            for(var value : tiket.getTiket().keySet()){
                i++;
                System.out.println(i+"."+value);
            }
        }
        return isEmpty;
    }
    public boolean reservasiTiket(){
        boolean isSucses=false;
        //jika kosong tambah tiket dulu
        if(tiket.getTiket().isEmpty()){
            System.out.println("Tiket Kosong Tambahkan Tiket Terlebih Dahulu");
            System.out.print("Masukan Judul :");
            String judul = util.inputData();
            System.out.print("Masukan Harga :");
            String harga =util.inputData();
            int hargaint = Integer.parseInt(harga);
            tambahDataTiket(judul , hargaint);
        }else {
            System.out.println("-------- Reservasi--------");
            System.out.print("Masukan Nama Customer  :");
            //set name customer
            customerEntity.setNamaCustomer(util.inputData());
            //membuat loading view
            util.loading();
            //menampilkan data
            showTiket();

            boolean isMatch =false;
            do{
                System.out.print("Silahkan Pilih Tiket sesuai dengan nama nya :");
                String key = util.inputData();
                //cek data ada atau tidak
                if (tiket.getTiket().containsKey(key)) {
                    isMatch=true;
                    System.out.println("---Data Tiket---");
                    System.out.println("Judul :" + tiket.getTiket().get(key).get(0));
                    System.out.println("Harga :" + tiket.getTiket().get(key).get(1));
                    System.out.print("Masukan Jumlah Tiket :");
                    String qty = util.inputData();
                    //parse harga tiket ke int
                    int hargaTiket = Integer.parseInt((String) tiket.getTiket().get(key).get(1));
                    //parse qty to int
                    int valueInt = Integer.parseInt(qty.replaceAll("[a-zA-Z]", ""));
                    //totalint is grand total
                    int totalInt = hargaTiket * valueInt;
                    util.loading();

                    System.out.println("Grand Total :" + totalInt);

                    utilApp<Integer> integerutilApp = new utilApp<>();
                    var isTrue = false;
                    do {
                        System.out.print("Bayar :");
                        int o = Integer.parseInt(util.inputData());
                        //if bayar < total int = istrue false for looping
                        if (o < totalInt) {
                            System.out.println("Jumlah Bayar Kurang  input ulang !");
                            isTrue = false;
                        } else {
                            int kembalian = o - totalInt;
                            isTrue = true;
                            System.out.println("Pemesanan Tiket Berhasil . . .");

                            util.loading();
                            System.out.println("    Data Pesanan Tiket");
                            System.out.println("  Bisokop Sido Jaya Makmur  ");

                            System.out.println("----------------------------------");
                            System.out.println("Tanggal  :" + stringutilApp.getTanggal());

                            System.out.println("Customer :" + customerEntity.getNamaCustomer());
                            System.out.println("----------------------------------");
                            System.out.println("           Data Tiket");
                            System.out.println("----------------------------------");

                            System.out.println("Judul  :" + tiket.getTiket().get(key).get(0));
                            System.out.println("Harga  :" + tiket.getTiket().get(key).get(1));
                            System.out.println("Jumlah :" + valueInt);
                            System.out.println("----------------------------------");

                            System.out.println("Grand Total :" + totalInt);
                            System.out.println("Bayar       :" + o);
                            System.out.println("Kembalian   :" + kembalian);

                            System.out.println("----------------------------------");
                            System.out.println("            Terimakasih             ");
                            isSucses=true;
                        }


                    } while (isTrue == false);

                } else {
                    isMatch=false;
                }
            }while(isMatch==false);

        }
        return  isSucses;
    }


}
