package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PegawaiEntity {

    //membuat list untuk menampung data tiket
    private List<String> akun = new ArrayList<>();
    //membuat map untuk menampung data data yang ada pada list
    Map<String , List> map = new HashMap<>();
    //membuat Getter
    public Map<String, List> getMap() {
        return map;
    }
    //membuat Setter
    public List<String> getAkun() {
        return akun;
    }

    public void setAkun(List<String> akun) {
        this.akun = akun;
    }

    public void setMap(Map<String, List> map) {
        this.map = map;
    }
}
