package com.chinalife.risksurvey.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.chinalife.base.entity.AbstractBaseEntity;

/**
 * 客户信息
 */
@Entity
@Table(name = "survey_customer")
public class SurveyCustomerEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3016701831089678897L;
    /** 主键 */
    private String pkId;
    /** 风勘任务号 */
    private String surveyId;
    /** 序号 */
    private String serialNo;
    /** 关系人类型 */
    private String customerType;
    /** customerFlag */
    private String customerFlag;
    /** customerFlagName */
    private String customerFlagName;
    /** customerCode */
    private String customerCode;
    /** customerName */
    private String customerName;
    /** customereName */
    private String customereName;
    /** identifyType */
    private String identifyType;
    /** identifyName */
    private String identifyName;
    /** identifyNumber */
    private String identifyNumber;
    /** identifyEffectiveStartDate */
    private Date identifyEffectiveStartDate;
    /** identifyEffectiveEndDate */
    private Date identifyEffectiveEndDate;
    /** longtermEffectiveFlag */
    private String longtermEffectiveFlag;
    /** age */
    private BigDecimal age;
    /** 性别 */
    private String sex;
    /** sexName */
    private String sexName;
    /** birthdate */
    private Date birthdate;
    /** citizenship */
    private String citizenship;
    /** citizenshipName */
    private String citizenshipName;
    /** address */
    private String address;
    /** linkerPhoneNo */
    private String linkerPhoneNo;
    /** linkerMobile */
    private String linkerMobile;
    /** linkereMail */
    private String linkereMail;
    /** linkerPost */
    private String linkerPost;
    /** iswithinForeign */
    private String iswithinForeign;
    /** despositBankName */
    private String despositBankName;
    /** accountNo */
    private String accountNo;
    /** accountName */
    private String accountName;
    // /** 创建员代码 */
    // private String createUserID;
    // /** 修改员代码 */
    // private String updateUserID;
    /** 创建时间 */
    private Date createDate;
    /** 修改时间 */
    private Date updateDate;

    /**
     * 主键
     * 
     * @return the pkId
     */
    @Column(length = 50)
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getPkId() {
        return this.pkId;
    }

    /**
     * 主键
     * 
     * @param pkId
     *            主键
     */
    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    /**
     * 风勘任务号
     * 
     * @return the surveyId
     */
    @Column(length = 50)
    public String getSurveyId() {
        return this.surveyId;
    }

    /**
     * 风勘任务号
     * 
     * @param surveyId
     *            风勘任务号
     */
    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    /**
     * 序号
     * 
     * @return the serialNo
     */
    @Column(length = 50)
    public String getSerialNo() {
        return this.serialNo;
    }

    /**
     * 序号
     * 
     * @param serialNo
     *            序号
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 关系人类型
     * 
     * @return the customerType
     */
    @Column(length = 12)
    public String getCustomerType() {
        return this.customerType;
    }

    /**
     * 关系人类型
     * 
     * @param customerType
     *            关系人类型
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * customerFlag
     * 
     * @return the customerFlag
     */
    @Column(length = 12)
    public String getCustomerFlag() {
        return this.customerFlag;
    }

    /**
     * customerFlag
     * 
     * @param customerFlag
     *            customerFlag
     */
    public void setCustomerFlag(String customerFlag) {
        this.customerFlag = customerFlag;
    }

    /**
     * customerFlagName
     * 
     * @return the customerFlagName
     */
    @Column(length = 50)
    public String getCustomerFlagName() {
        return this.customerFlagName;
    }

    /**
     * customerFlagName
     * 
     * @param customerFlagName
     *            customerFlagName
     */
    public void setCustomerFlagName(String customerFlagName) {
        this.customerFlagName = customerFlagName;
    }

    /**
     * customerCode
     * 
     * @return the customerCode
     */
    @Column(length = 12)
    public String getCustomerCode() {
        return this.customerCode;
    }

    /**
     * customerCode
     * 
     * @param customerCode
     *            customerCode
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * customerName
     * 
     * @return the customerName
     */
    @Column(length = 120)
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * customerName
     * 
     * @param customerName
     *            customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * customereName
     * 
     * @return the customereName
     */
    @Column(length = 120)
    public String getCustomereName() {
        return this.customereName;
    }

    /**
     * customereName
     * 
     * @param customereName
     *            customereName
     */
    public void setCustomereName(String customereName) {
        this.customereName = customereName;
    }

    /**
     * identifyType
     * 
     * @return the identifyType
     */
    @Column(length = 12)
    public String getIdentifyType() {
        return this.identifyType;
    }

    /**
     * identifyType
     * 
     * @param identifyType
     *            identifyType
     */
    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }

    /**
     * identifyName
     * 
     * @return the identifyName
     */
    @Column(length = 120)
    public String getIdentifyName() {
        return this.identifyName;
    }

    /**
     * identifyName
     * 
     * @param identifyName
     *            identifyName
     */
    public void setIdentifyName(String identifyName) {
        this.identifyName = identifyName;
    }

    /**
     * identifyNumber
     * 
     * @return the identifyNumber
     */
    @Column(length = 50)
    public String getIdentifyNumber() {
        return this.identifyNumber;
    }

    /**
     * identifyNumber
     * 
     * @param identifyNumber
     *            identifyNumber
     */
    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    /**
     * identifyEffectiveStartDate
     * 
     * @return the identifyEffectiveStartDate
     */

    public Date getIdentifyEffectiveStartDate() {
        return this.identifyEffectiveStartDate;
    }

    /**
     * identifyEffectiveStartDate
     * 
     * @param identifyEffectiveStartDate
     *            identifyEffectiveStartDate
     */
    public void setIdentifyEffectiveStartDate(Date identifyEffectiveStartDate) {
        this.identifyEffectiveStartDate = identifyEffectiveStartDate;
    }

    /**
     * identifyEffectiveEndDate
     * 
     * @return the identifyEffectiveEndDate
     */

    public Date getIdentifyEffectiveEndDate() {
        return this.identifyEffectiveEndDate;
    }

    /**
     * identifyEffectiveEndDate
     * 
     * @param identifyEffectiveEndDate
     *            identifyEffectiveEndDate
     */
    public void setIdentifyEffectiveEndDate(Date identifyEffectiveEndDate) {
        this.identifyEffectiveEndDate = identifyEffectiveEndDate;
    }

    /**
     * longtermEffectiveFlag
     * 
     * @return the longtermEffectiveFlag
     */
    @Column(length = 12)
    public String getLongtermEffectiveFlag() {
        return this.longtermEffectiveFlag;
    }

    /**
     * longtermEffectiveFlag
     * 
     * @param longtermEffectiveFlag
     *            longtermEffectiveFlag
     */
    public void setLongtermEffectiveFlag(String longtermEffectiveFlag) {
        this.longtermEffectiveFlag = longtermEffectiveFlag;
    }

    /**
     * age
     * 
     * @return the age
     */

    public BigDecimal getAge() {
        return this.age;
    }

    /**
     * age
     * 
     * @param age
     *            age
     */
    public void setAge(BigDecimal age) {
        this.age = age;
    }

    /**
     * 性别
     * 
     * @return the sex
     */
    @Column(length = 12)
    public String getSex() {
        return this.sex;
    }

    /**
     * 性别
     * 
     * @param sex
     *            性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * sexName
     * 
     * @return the sexName
     */
    @Column(length = 50)
    public String getSexName() {
        return this.sexName;
    }

    /**
     * sexName
     * 
     * @param sexName
     *            sexName
     */
    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    /**
     * birthdate
     * 
     * @return the birthdate
     */

    public Date getBirthdate() {
        return this.birthdate;
    }

    /**
     * birthdate
     * 
     * @param birthdate
     *            birthdate
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * citizenship
     * 
     * @return the citizenship
     */
    @Column(length = 12)
    public String getCitizenship() {
        return this.citizenship;
    }

    /**
     * citizenship
     * 
     * @param citizenship
     *            citizenship
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * citizenshipName
     * 
     * @return the citizenshipName
     */
    @Column(length = 50)
    public String getCitizenshipName() {
        return this.citizenshipName;
    }

    /**
     * citizenshipName
     * 
     * @param citizenshipName
     *            citizenshipName
     */
    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    /**
     * address
     * 
     * @return the address
     */
    @Column(length = 500)
    public String getAddress() {
        return this.address;
    }

    /**
     * address
     * 
     * @param address
     *            address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * linkerPhoneNo
     * 
     * @return the linkerPhoneNo
     */
    @Column(length = 50)
    public String getLinkerPhoneNo() {
        return this.linkerPhoneNo;
    }

    /**
     * linkerPhoneNo
     * 
     * @param linkerPhoneNo
     *            linkerPhoneNo
     */
    public void setLinkerPhoneNo(String linkerPhoneNo) {
        this.linkerPhoneNo = linkerPhoneNo;
    }

    /**
     * linkerMobile
     * 
     * @return the linkerMobile
     */
    @Column(length = 50)
    public String getLinkerMobile() {
        return this.linkerMobile;
    }

    /**
     * linkerMobile
     * 
     * @param linkerMobile
     *            linkerMobile
     */
    public void setLinkerMobile(String linkerMobile) {
        this.linkerMobile = linkerMobile;
    }

    /**
     * linkereMail
     * 
     * @return the linkereMail
     */
    @Column(length = 120)
    public String getLinkereMail() {
        return this.linkereMail;
    }

    /**
     * linkereMail
     * 
     * @param linkereMail
     *            linkereMail
     */
    public void setLinkereMail(String linkereMail) {
        this.linkereMail = linkereMail;
    }

    /**
     * linkerPost
     * 
     * @return the linkerPost
     */
    @Column(length = 12)
    public String getLinkerPost() {
        return this.linkerPost;
    }

    /**
     * linkerPost
     * 
     * @param linkerPost
     *            linkerPost
     */
    public void setLinkerPost(String linkerPost) {
        this.linkerPost = linkerPost;
    }

    /**
     * iswithinForeign
     * 
     * @return the iswithinForeign
     */
    @Column(length = 12)
    public String getIswithinForeign() {
        return this.iswithinForeign;
    }

    /**
     * iswithinForeign
     * 
     * @param iswithinForeign
     *            iswithinForeign
     */
    public void setIswithinForeign(String iswithinForeign) {
        this.iswithinForeign = iswithinForeign;
    }

    /**
     * despositBankName
     * 
     * @return the despositBankName
     */
    @Column(length = 500)
    public String getDespositBankName() {
        return this.despositBankName;
    }

    /**
     * despositBankName
     * 
     * @param despositBankName
     *            despositBankName
     */
    public void setDespositBankName(String despositBankName) {
        this.despositBankName = despositBankName;
    }

    /**
     * accountNo
     * 
     * @return the accountNo
     */
    @Column(length = 50)
    public String getAccountNo() {
        return this.accountNo;
    }

    /**
     * accountNo
     * 
     * @param accountNo
     *            accountNo
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * accountName
     * 
     * @return the accountName
     */
    @Column(length = 120)
    public String getAccountName() {
        return this.accountName;
    }

    /**
     * accountName
     * 
     * @param accountName
     *            accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 创建时间
     * 
     * @return the createDate
     */

    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 创建时间
     * 
     * @param createDate
     *            创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 修改时间
     * 
     * @return the updateDate
     */

    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 修改时间
     * 
     * @param updateDate
     *            修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public void setId(Object id) {
        if (id != null) {
            this.pkId = (String) id;
        } else {
            this.pkId = null;
        }
    }

    @Override
    @Transient
    public Object getId() {
        return this.pkId;
    }

}