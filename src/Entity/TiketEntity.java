package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TiketEntity {
    //membuat list untuk menampung data data tiket
    private  List<String> dataTiket = new ArrayList<>();
    //membuat map untuk menampung data tiket yang ada pada list
    private  Map<String , List> tiket = new HashMap<>();
    //getter Map Tiket
    public Map<String, List> getTiket() {
        return tiket;
    }
    //setter
    public void setTiket(Map<String, List> tiket) {
        this.tiket = tiket;
    }
    //getter tiket
    public List<String> getDataTiket() {
        return dataTiket;
    }
}
