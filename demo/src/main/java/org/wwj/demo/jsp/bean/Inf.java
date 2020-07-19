package jsp.demo.bean;

import java.util.Date;

public class Inf {

    public Integer id;
    public Integer sId;
    public String sName;
    public Integer tId;
    public Integer cId;


    public String cName;
    public String tName;
    public Date signTime;
    public String signStatus;
    public Integer otherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
    }

    public Integer getOtherId() {
        return otherId;
    }

    public void setOtherId(Integer otherId) {
        this.otherId = otherId;
    }

    @Override
    public String toString() {
        return "Inf{" +
                "id=" + id +
                ", sId=" + sId +
                ", sName='" + sName + '\'' +
                ", tId=" + tId +
                ", cId=" + cId +
                ", cName='" + cName + '\'' +
                ", tName='" + tName + '\'' +
                ", signTime=" + signTime +
                ", signStatus='" + signStatus + '\'' +
                ", otherId=" + otherId +
                '}';
    }
}
