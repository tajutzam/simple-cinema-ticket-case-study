package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    Map<String , String> map = new HashMap<>();
    List<String> da = new ArrayList<>();

    public void addMap(String data){
        map.put(data , data);

    }
    public void addList(String data){
        this.da.add(data);
    }

    public List<String> getDa() {
        return da;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.addMap("test");
        System.out.println(test.getMap());
        test.addMap("test1");
        System.out.println(test.getMap());
        test.addMap("test2");
        System.out.println(test.getMap());
        test.addList("oke");
        System.out.println(test.getDa());
        test.addList("oke1");
        System.out.println(test.getDa());
        test.addList("oke2");
        System.out.println(test.getDa());
    }
}
