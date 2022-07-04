package service;

import Repository.Pegawai;
import util.utilApp;

import javax.swing.plaf.multi.MultiToolTipUI;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class logicApp {



    Calendar calendar = Calendar.getInstance();
    Date dt = calendar.getTime();
    TiketService tiketService = new TiketService();
    utilApp util = new utilApp();

    Pegawai pegawai = new Pegawai();
    //judul
    public void showGaris(){
        System.out.println("> ----- < ");
    }
    public String Opsi(){
        Scanner scan = new Scanner(System.in);
        System.out.print("(y/n):");
        String opsi = scan.nextLine();
        return opsi;
    }
    public void showJudulAplikasi(){
        System.out.println();
        System.out.println();
        showGaris();
        System.out.println("Aplikasi Pelayanan Pemesanan Tiket Bisokop");
        showGaris();
        System.out.println("Lanjut ke menu ? y/n ");
        String value =Opsi();
        boolean isTrue=false;
        do {

            if(value.equals("y")){
                isTrue=true;
                showHeadbar();
            }else if(value.equals("n")){
                isTrue=true;
                System.out.println("Terimakasih Atas Kerjanya Hari ini ..");
                showGaris();
                System.exit(0);
            }else{
                System.out.println("Format Tidak sesuai Input Ulang y/n");
                value=Opsi();
                if(value.equals("y")){
                    isTrue=true;
                    showHeadbar();
                }else if(value.equals("n")){
                    isTrue=true;
                    System.out.println("Terimakasih Atas Kerjanya Hari ini ..");
                    showGaris();
                    System.exit(0);
                }else{
                    isTrue=false;
                }
            }

        }while(isTrue==false);


    }


    //headbar
    public void showHeadbar(){
        System.out.println("Haloo . .  . . .");
        System.out.println("Selamat datang di Bisokop Sejak Makmur");
        showGaris();
        System.out.println("Apakah anda sudah punya akun ? ");
        String value =Opsi();
        boolean isTrue;
        util.loading();
        do {

            if(value.equals("y")){
                System.out.println("benar");
                isTrue=true;

                if(pegawai.login()==true){

                    System.out.println("oke");
                    judul();
                    showMenu();
                }
            }else if(value.equals("n")){
                isTrue=true;
                System.out.print("Masukan Username :");
                String username =inputData();
                System.out.print("Masukan Password :");
                String password =inputData();
                util.loading();

                if(pegawai.tambahPegawai(username , password)==true){
                    pegawai.login();
                       judul();
                       showMenu();


                }
            }else{
                System.out.println("Format Tidak sesuai Input Ulang y/n");
                value=Opsi();
                if(value.equals("y")){
                    isTrue=true;
                   if( pegawai.login()==true){
                       showGaris();
                       judul();
                       showMenu();
                   }

                }else if(value.equals("n")){
                    isTrue=true;
                    System.out.print("Masukan Username :");
                    String username =inputData();
                    System.out.print("Masukan Password :");

                    String password =inputData();
                    util.loading();
                    if (pegawai.tambahPegawai(username , password)==true){
                        pegawai.login();
                        judul();
                        showMenu();
                    }
                }else{
                    isTrue=false;
                }
            }

        }while(isTrue==false);
    }

    public String inputData(){
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        return value;
    }

    //buat akun

    //login

    public void judul(){
        System.out.println("Berhasil Login . . .");

        System.out.println("Tanggal :"+dt);
        showGaris();
    }
    public void showMenu() {

        System.out.println("Menu Aplikasi ");
        System.out.println("1. Show Tiket");
        System.out.println("2. Tambah Tiket");
        System.out.println("3. Reservasi Tiket");
        System.out.println("4. Logout");
        System.out.println("Pilih Menu:");
        String opsi = inputData();
        util.loading();
        boolean isTrue=false;
        do {
            if(opsi.equals("1")){
                showGaris();
                if( tiketService.showTiket()==false){
                    showGaris();
                    System.out.println("Kembali Kemenu y Reservasi f");
                    var value =inputData();
                    if(value.equals("y")){
                        util.loading();
                    }else if(value.equals("f")){
                        //reservasi
                        util.loading();
                        if (tiketService.reservasiTiket()==true){
                            showMenu();
                        }

                    }
                }else{
                    System.out.println("Masukan Judul Film :");
                    String judul =inputData();
                    System.out.println("Masukan Harga ");
                    String harga = inputData();
                    util.loading();
                    int hargaInt = Integer.parseInt(harga.replaceAll("[a-zA-Z]",""));
                    if (tiketService.tambahTiket(judul , hargaInt)==true){
                        showMenu();
                    }else if(tiketService.tambahTiket(judul , hargaInt)==false){
                        System.out.println("Tambah Ulang . . .");
                        System.out.println("Masukan Judul Film :");
                        String judulBaru =inputData();
                        System.out.println("Masukan Harga ");
                        String hargaBaru = inputData();
                        util.loading();
                        int hargaIntBaru = Integer.parseInt(hargaBaru.replaceAll("[a-zA-Z]",""));
                        tiketService.tambahTiket(judulBaru ,hargaIntBaru);
                    }
                }
                isTrue=true;

            }else if(opsi.equals("2")){
                showGaris();
                System.out.println("Masukan Judul Film :");
                String judul =inputData();
                System.out.println("Masukan Harga ");
                String harga = inputData();
                int hargaInt = Integer.parseInt(harga.replaceAll("[a-zA-Z]",""));
                util.loading();
                if (tiketService.tambahTiket(judul , hargaInt)==true){
                    showMenu();
                }
                isTrue=true;
            }else if(opsi.equals("3")){
                showGaris();
                if (tiketService.reservasiTiket()==true){
                    showMenu();
                }
                isTrue=true;
            }else if(opsi.equals("4")){
                showGaris();
                logOut();
                isTrue=true;
            }else{
                isTrue=false;
                System.out.println("Pilihan Tidak ada Harap Input Ulang :");
                String value=inputData();
                {
                    if(value.equals("1")){
                        isTrue=true;
                    }else if(value.equals("2")){
                        isTrue=true;
                    }else if(value.equals("3")){
                        isTrue=true;
                    }else if(value.equals("4")){
                        isTrue=true;
                    }else{
                        isTrue=false;
                    }
                }
            }

        }while(isTrue==false);
    }
    //logout
    public void logOut(){

        util.loading();

        this.showHeadbar();

    }
}
