package cn.px.bean;

/**
 * Created by zhengjq on 2017/3/27.
 */
public class Student {


    public String getId() {
        return id;
    }

    public String getClas() {
        return clas;
    }

    public Double getScour() {
        return scour;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public void setScour(Double scour) {
        this.scour = scour;
    }

    private String id;
    private String clas;
    private Double scour;
}
