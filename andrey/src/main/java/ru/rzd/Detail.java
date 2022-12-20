package ru.rzd;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"idDetail","nameDetail","idFactory"})
public class Detail {

    @XmlElement(name = "idDetail")
    private String idDetail;

    @XmlElement(name = "nameDetail")
    private String nameDetail;

    @XmlElement(name = "idFactory")
    private int idFactory;

    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    public String getNameDetail() {
        return nameDetail;
    }

    public void setNameDetail(String nameDetail) {
        this.nameDetail = nameDetail;
    }

    public int getIdFactory() {
        return idFactory;
    }

    public void setIdFactory(int idFactory) {
        this.idFactory = idFactory;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "idDetail='" + idDetail + '\'' +
                ", nameDetail='" + nameDetail + '\'' +
                ", idFactory=" + idFactory +
                '}';
    }
}
