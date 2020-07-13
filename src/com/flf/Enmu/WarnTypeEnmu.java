package com.flf.Enmu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum WarnTypeEnmu {


    RED(1,"红色","#FF0000"),
    ORANGE(2,"橙色","#FF7F00"),
    YELLOW(3,"黄色","#EAEAAE"),
    BLUE(4,"蓝色","#32CD99");

    private  final  int value;
    private  final  String title;
    private  final  String colourNumber;


    public int getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public String getColourNumber() {
        return colourNumber;
    }

    private  WarnTypeEnmu(int value, String title,String colourNumber){
        this.title=title;
        this.value=value;
        this.colourNumber=colourNumber;
    }


    public  static  WarnTypeEnmu findByValue(int value){
        switch (value){
            case 1:
                return RED;
            case 2:
                return ORANGE;
            case 3:
                return YELLOW;
            case 4:
                return BLUE;
            default:
                return null;
        }

    }


    public  static List<Map<String,Object>> selectAll(){
        List<Map<String,Object>>  list =new ArrayList<>();
        for (WarnTypeEnmu warnType : WarnTypeEnmu.values()) {
            Map<String, Object> map = new HashMap<>();
            map.put("value",warnType.getValue());
            map.put("title",warnType.getTitle());
            map.put("colourNumber",warnType.getColourNumber());
            list.add(map);
        }
        return list;
    }


}
