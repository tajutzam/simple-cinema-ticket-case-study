package Repository;

import Entity.CustomerEntity;

public class Customer {


    CustomerEntity customerEntity = new CustomerEntity();
    //membuat method untuk mengambil data customer
    public void getCustomer(){
        customerEntity.getNamaCustomer();
    }
    //membuat method untuk memberikan value pada customer
    public void setCustomer(String nama){
        customerEntity.setNamaCustomer(nama);
    }

}
