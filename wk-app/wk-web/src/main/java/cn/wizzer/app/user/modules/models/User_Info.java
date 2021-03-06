package cn.wizzer.app.user.modules.models;

import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/3/22
 */
@Table("user_info")
public class User_Info implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Prev
    private Integer id;

    @Column
    @Comment("昵称")
    @ColDefine(type = ColType.VARCHAR, width = 50)
    private String nickName;

    @Name
    @Column("userName")
    @Comment("真实姓名")
    private String userName;

    @Column
    private String cardNo;

    @Column
    private String cardImg;

    @Column
    private int sex;

    @Column("papersTime")
    @ColDefine(type = ColType.DATETIME)
    private Date papersTime;

    @Column
    @Comment("工号")
    private String jobNumber;

    @Column
    @Comment("手机号")
    private String mobile;

    @Column
    private String password;

    @Column
    private String headImg;

    @Column
    private String papersImg;

    @Column
    private String personalImg;

    @Column
    @Comment("余额")
    private Double balance;

    @Column
    @Comment("员工类型")
    private int emptypeType;

    @Column
    @Comment("提成方式")
    private Double tcRatio;

    @Column
    private Integer djCnt;

    @Column
    private String nativePlace;

    @Column
    private String address;

    @Column
    private String emergencyContact;

    @Column
    private String emergencyContactTel;

    @Column
    @Comment("状态")
    private Integer workStatus;

    @Column
    private Integer userStatus;

    @Column
    private Date applyTime;

    @Column
    @Comment("APP版本")
    private String appVersion;

    @Column
    @Comment("入职时间")
    private Date hireDate;

    @Column
    private String location;

    @Column
    private Double lon;

    @Column
    private Double lat;

    @Column
    private String remark;

    @Column
    private String sysUnitId;

    @Column("geo_code")
    private String geoCode;

    @Column
    private String logonId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardImg() {
        return cardImg;
    }

    public void setCardImg(String cardImg) {
        this.cardImg = cardImg;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getPapersTime() {
        return papersTime;
    }

    public void setPapersTime(Date papersTime) {
        this.papersTime = papersTime;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getPapersImg() {
        return papersImg;
    }

    public void setPapersImg(String papersImg) {
        this.papersImg = papersImg;
    }

    public String getPersonalImg() {
        return personalImg;
    }

    public void setPersonalImg(String personalImg) {
        this.personalImg = personalImg;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getEmptypeType() {
        return emptypeType;
    }

    public void setEmptypeType(int emptypeType) {
        this.emptypeType = emptypeType;
    }

    public Double getTcRatio() {
        return tcRatio;
    }

    public void setTcRatio(Double tcRatio) {
        this.tcRatio = tcRatio;
    }

    public Integer getDjCnt() {
        return djCnt;
    }

    public void setDjCnt(Integer djCnt) {
        this.djCnt = djCnt;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactTel() {
        return emergencyContactTel;
    }

    public void setEmergencyContactTel(String emergencyContactTel) {
        this.emergencyContactTel = emergencyContactTel;
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSysUnitId()
    {
        return sysUnitId;
    }

    public void setSysUnitId(String sysUnitId)
    {
        this.sysUnitId = sysUnitId;
    }

    public Double getLat()
    {
        return lat;
    }

    public void setLat(Double lat)
    {
        this.lat = lat;
    }

    public Double getLon()
    {
        return lon;
    }

    public void setLon(Double lon)
    {
        this.lon = lon;
    }

    public String getGeoCode()
    {
        return geoCode;
    }

    public void setGeoCode(String geoCode)
    {
        this.geoCode = geoCode;
    }

    public String getLogonId()
    {
        return logonId;
    }

    public void setLogonId(String logonId)
    {
        this.logonId = logonId;
    }
}
