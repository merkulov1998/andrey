package ru.rzd;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "Деталь")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Detail {

    @XmlElement(name = "ИдентификаторДетали")
    private String idDetail;

    @XmlElement(name = "НаименованиеДетали")
    private String nameDetail;

    @XmlElement(name = "КодПредприятия")
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
}
