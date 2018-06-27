package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "vx")
public class VirusBean {

    @Id
    private int tID;
    private int vxCount;
    private int vxTotal;
    private String vxVirusName;
    private String vxMD5;
    private String vxSHA1;
    private String vxSHA256;
    private Date vxDate;
    private String vxEngine;
    private int vxAwareness;
    private String vxType;
    private String vxTypeImage;
    private String vxTimeStamp;

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public int getVxCount() {
        return vxCount;
    }

    public void setVxCount(int vxCount) {
        this.vxCount = vxCount;
    }

    public int getVxTotal() {
        return vxTotal;
    }

    public void setVxTotal(int vxTotal) {
        this.vxTotal = vxTotal;
    }

    public String getVxVirusName() {
        return vxVirusName;
    }

    public void setVxVirusName(String vxVirusName) {
        this.vxVirusName = vxVirusName;
    }

    public String getVxMD5() {
        return vxMD5;
    }

    public void setVxMD5(String vxMD5) {
        this.vxMD5 = vxMD5;
    }

    public String getVxSHA1() {
        return vxSHA1;
    }

    public void setVxSHA1(String vxSHA1) {
        this.vxSHA1 = vxSHA1;
    }

    public String getVxSHA256() {
        return vxSHA256;
    }

    public void setVxSHA256(String vxSHA256) {
        this.vxSHA256 = vxSHA256;
    }

    public Date getVxDate() {
        return vxDate;
    }

    public void setVxDate(Date vxDate) {
        this.vxDate = vxDate;
    }

    public String getVxEngine() {
        return vxEngine;
    }

    public void setVxEngine(String vxEngine) {
        this.vxEngine = vxEngine;
    }

    public int getVxAwareness() {
        return vxAwareness;
    }

    public void setVxAwareness(int vxAwareness) {
        this.vxAwareness = vxAwareness;
    }

    public String getVxType() {
        return vxType;
    }

    public void setVxType(String vxType) {
        this.vxType = vxType;
    }

    public String getVxTypeImage() {
        return vxTypeImage;
    }

    public void setVxTypeImage(String vxTypeImage) {
        this.vxTypeImage = vxTypeImage;
    }

    public String getVxTimeStamp() {
        return vxTimeStamp;
    }

    public void setVxTimeStamp(String vxTimeStamp) {
        this.vxTimeStamp = vxTimeStamp;
    }

    @Override
    public String toString() {
        return "VirusBean{" +
                "tID=" + tID +
                ", vxCount=" + vxCount +
                ", vxTotal=" + vxTotal +
                ", vxVirusName='" + vxVirusName + '\'' +
                ", vxMD5='" + vxMD5 + '\'' +
                ", vxSHA1='" + vxSHA1 + '\'' +
                ", vxSHA256='" + vxSHA256 + '\'' +
                ", vxDate=" + vxDate +
                ", vxEngine='" + vxEngine + '\'' +
                ", vxAwareness=" + vxAwareness +
                ", vxType='" + vxType + '\'' +
                ", vxTypeImage='" + vxTypeImage + '\'' +
                ", vxTimeStamp='" + vxTimeStamp + '\'' +
                '}';
    }
}
