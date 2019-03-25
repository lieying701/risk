package com.chinalife.risksurvey.ecifclient.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 自然人VO
 *
 * @author: marscheng
 * @date: 2017-12-02 下午4:11
 */
public class PlcCustomerVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8566910321030624400L;

    /** 关系人年龄 */
    private BigDecimal age;
    /** 关系人性别 */
    private String sex;
    /** 关系人性别名称 */
    private String sexName;
    /** 关系人出生日期 */
    private Date birthDate;
    /** 关系人户口所在地 */
    private String houseHoldAddress;
    /** 关系人地址 */
    private String address;
    /** 关系人国籍 */
    private String citizenship;
    /** 关系人国籍名称 */
    private String citizenshipName;
    /** 关系人民族 */
    private String nationality;
    /** 关系人民族名称 */
    private String nationalityName;
    /** 关系人身高 */
    private BigDecimal stature;
    /** 关系人体重 */
    private BigDecimal avoirdupois;
    /** 关系人年收入 */
    private BigDecimal salary;
    /** 关系人婚姻状况代码 */
    private String marriage;
    /** 关系人婚姻状况 */
    private String marriageName;
    /** 关系人结婚日期 */
    private Date marriageDate;
    /** 关系人联系电话 */
    private String phoneNumber;
    /** 单位电话 */
    private String unitPhoneNo;
    /** 关系人联系手机 */
    private String mobile;
    /** 关系人联系微信号 */
    private String weChat;
    /** 关系人联系邮箱 */
    private String email;
    /** 关系人邮政编码 */
    private String post;
    /** 关系人单位性质 */
    private String companyNature;
    /** 关系人单位性质名称 */
    private String companyNatureName;
    /** 关系人单位地址 */
    private String companyAddress;
    /** 关系人单位名称 */
    private String companyName;
    /** 关系人单位邮编 */
    private String companyPost;
    /** 关系人行业类别 */
    private String industryCategory;
    /** 关系人行业类别名称 */
    private String industryCategoryName;
    /** 关系人职业代码 */
    private String occupationCode;
    /** 关系人职业名称 */
    private String occupationCodeName;
    /** 关系人职业等级 */
    private String occupationGrade;
    /** 关系人职业等级名称 */
    private String occupationGradeName;
    /** 关系人职业类别 */
    private String occupationType;
    /** 关系人职业类别名称 */
    private String occupationTypeName;
    /** 关系人职业（工种） */
    private String workType;
    /** 关系人兼职（工种） */
    private String pluralityType;
    /** 关系人风险等级 */
    private String riskLevel;
    /** 关系人家庭地址 */
    private String homeAddress;
    /** 关系人通讯地址 */
    private String postalAddress;
    /** 关系人学历代码 */
    private String degree;
    /** 关系人学历名称 */
    private String degreeName;
    /** 关系人社保标志 */
    private String socialInsuFlag;
    /** 公费医疗标志 */
    private String socializedMedicineFlag;
    /** 职工基本医疗保险标志 */
    private String urbanEmployeeMedicallnsuranceFlag;
    /** 新型农村合作医疗标志 */
    private String newRuralCooperativeMedicalSystemFlag;
    /** 城镇居民基本医疗保险标志 */
    private String urbanDwellerMedicallnsuranceFlag;
    /** 医疗救助以及其他依据法律法规建立的社会医疗保险标志 */
    private String mediclaAidOrLawMedicallnsuranceFlag;
    /** 关系人社保登记号 */
    private String socialInsuNo;
    /** 关系人境内境外标志 */
    private String isWithinForeign;
    /** 关系人吸烟标志 */
    private String smokeFlag;
    /** 关系人驾照标志 */
    private String licenseFlag;
    /** 关系人驾照类型代码 */
    private String licenseType;
    /** 准驾车型 */
    private String drivingVehicle;
    /** 准驾车型名称 */
    private String drivingVehicleName;
    /** 驾驶员类别代码 */
    private String driverCategoryCode;
    /** 驾驶员类别名称 */
    private String driverCategory;
    /** 关系人是被保险人的 */
    private String insuredIdentity;
    /** 关系人与投保人关系代码 */
    private String relationToApplicantCode;
    /** 关系人与投保人关系名称 */
    private String relationToApplicantCodeName;
    /** 关联人序号 */
    private String linkSerialNo;
    /** 关系人残疾标志 */
    private String disabilityFlag;
    /** 关系人伤残部位 */
    private String disabilityPosition;
    /** 关系人残疾等级 */
    private String disabilityGrade;
    /** 关系人伤残等级代码 */
    private String disabilityDegreeCode;
    /** 主/连带被保险人类型代码 */
    private String isMainInsuredFlag;
    /** 主/连带被保险人类型名称 */
    private String isMainInsuredFlagName;
    /** 与主被保人关系代码 */
    private String relationToMainInsured;
    /** 与主被保人关系名称 */
    private String relationToMainInsuredName;
    /** 被保险人与受益人关联号 */
    private String linkNo;
    /** 受益人类型 */
    private String benefitType;
    /** 受益人类型名称 */
    private String benefitTypeName;
    /** 受益人顺序 */
    private String benefitSerialNo;
    /** 受益比例 */
    private BigDecimal benefitRate;

    /** 关系人伤残等级 */
    private String disabilityDegree;
    /** 关系人残疾分类代码 */
    private String disabilityClassifyCode;
    /** 关系人残疾分类 */
    private String disabilityClassify;
    /** 关系人残疾等级代码 */
    private String disabilityGradeCode;

    /** 省级代码 */
    private String provinceCode;
    /** 省级名称 */
    private String provinceName;
    /** 市级代码 */
    private String cityCode;
    /** 市级名称 */
    private String cityName;

    /** 所属行政区域 */
    private String districtCode;

    /** 所属行政区域名称 */
    private String districtName;

    /** 关系人职业（工种）名称 */
    private String workTypeName;
    /** 关系人兼职(工种）名称 */
    private String pluralityTypeName;

    /** 关系人职业（工种）中类 */
    private String workTypeMidClass;
    /** 关系人职业（工种）中类名称 */
    private String workTypeMidClassName;
    /** 关系人职业（工种）小类 */
    private String workTypeSmallClass;
    /** 关系人职业（工种）小类名称 */
    private String workTypeSmallClassName;
    /** 关系人兼职（工种）中类 */
    private String pluralityTypeMidClass;
    /** 关系人兼职（工种）中类名称 */
    private String pluralityTypeMidClassName;
    /** 关系人兼职（工种）小类 */
    private String pluralityTypeSmallClass;
    /** 关系人兼职（工种）小类类名称 */
    private String pluralitySmallClassName;
    /** 有无免疫接种不良反应史 */
    private String immResHistoryFlag;

    /** 创建员代码 */
    private String createUserId;
    /** 修改员代码 */
    private String updateUserId;
    /** 创建时间 */
    private Date createDate;
    /** 修改时间 */
    private Date updateDate;
    /** 机构ID */
    private String structureId;
    /** 所属人ID */
    private String ownerUserId;

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getHouseHoldAddress() {
        return houseHoldAddress;
    }

    public void setHouseHoldAddress(String houseHoldAddress) {
        this.houseHoldAddress = houseHoldAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    public BigDecimal getStature() {
        return stature;
    }

    public void setStature(BigDecimal stature) {
        this.stature = stature;
    }

    public BigDecimal getAvoirdupois() {
        return avoirdupois;
    }

    public void setAvoirdupois(BigDecimal avoirdupois) {
        this.avoirdupois = avoirdupois;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getMarriageName() {
        return marriageName;
    }

    public void setMarriageName(String marriageName) {
        this.marriageName = marriageName;
    }

    public Date getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(Date marriageDate) {
        this.marriageDate = marriageDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUnitPhoneNo() {
        return unitPhoneNo;
    }

    public void setUnitPhoneNo(String unitPhoneNo) {
        this.unitPhoneNo = unitPhoneNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public String getCompanyNatureName() {
        return companyNatureName;
    }

    public void setCompanyNatureName(String companyNatureName) {
        this.companyNatureName = companyNatureName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPost() {
        return companyPost;
    }

    public void setCompanyPost(String companyPost) {
        this.companyPost = companyPost;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getIndustryCategoryName() {
        return industryCategoryName;
    }

    public void setIndustryCategoryName(String industryCategoryName) {
        this.industryCategoryName = industryCategoryName;
    }

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getOccupationCodeName() {
        return occupationCodeName;
    }

    public void setOccupationCodeName(String occupationCodeName) {
        this.occupationCodeName = occupationCodeName;
    }

    public String getOccupationGrade() {
        return occupationGrade;
    }

    public void setOccupationGrade(String occupationGrade) {
        this.occupationGrade = occupationGrade;
    }

    public String getOccupationGradeName() {
        return occupationGradeName;
    }

    public void setOccupationGradeName(String occupationGradeName) {
        this.occupationGradeName = occupationGradeName;
    }

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }

    public String getOccupationTypeName() {
        return occupationTypeName;
    }

    public void setOccupationTypeName(String occupationTypeName) {
        this.occupationTypeName = occupationTypeName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getPluralityType() {
        return pluralityType;
    }

    public void setPluralityType(String pluralityType) {
        this.pluralityType = pluralityType;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getSocialInsuFlag() {
        return socialInsuFlag;
    }

    public void setSocialInsuFlag(String socialInsuFlag) {
        this.socialInsuFlag = socialInsuFlag;
    }

    public String getSocializedMedicineFlag() {
        return socializedMedicineFlag;
    }

    public void setSocializedMedicineFlag(String socializedMedicineFlag) {
        this.socializedMedicineFlag = socializedMedicineFlag;
    }

    public String getUrbanEmployeeMedicallnsuranceFlag() {
        return urbanEmployeeMedicallnsuranceFlag;
    }

    public void setUrbanEmployeeMedicallnsuranceFlag(String urbanEmployeeMedicallnsuranceFlag) {
        this.urbanEmployeeMedicallnsuranceFlag = urbanEmployeeMedicallnsuranceFlag;
    }

    public String getNewRuralCooperativeMedicalSystemFlag() {
        return newRuralCooperativeMedicalSystemFlag;
    }

    public void setNewRuralCooperativeMedicalSystemFlag(String newRuralCooperativeMedicalSystemFlag) {
        this.newRuralCooperativeMedicalSystemFlag = newRuralCooperativeMedicalSystemFlag;
    }

    public String getUrbanDwellerMedicallnsuranceFlag() {
        return urbanDwellerMedicallnsuranceFlag;
    }

    public void setUrbanDwellerMedicallnsuranceFlag(String urbanDwellerMedicallnsuranceFlag) {
        this.urbanDwellerMedicallnsuranceFlag = urbanDwellerMedicallnsuranceFlag;
    }

    public String getMediclaAidOrLawMedicallnsuranceFlag() {
        return mediclaAidOrLawMedicallnsuranceFlag;
    }

    public void setMediclaAidOrLawMedicallnsuranceFlag(String mediclaAidOrLawMedicallnsuranceFlag) {
        this.mediclaAidOrLawMedicallnsuranceFlag = mediclaAidOrLawMedicallnsuranceFlag;
    }

    public String getSocialInsuNo() {
        return socialInsuNo;
    }

    public void setSocialInsuNo(String socialInsuNo) {
        this.socialInsuNo = socialInsuNo;
    }

    public String getIsWithinForeign() {
        return isWithinForeign;
    }

    public void setIsWithinForeign(String isWithinForeign) {
        this.isWithinForeign = isWithinForeign;
    }

    public String getSmokeFlag() {
        return smokeFlag;
    }

    public void setSmokeFlag(String smokeFlag) {
        this.smokeFlag = smokeFlag;
    }

    public String getLicenseFlag() {
        return licenseFlag;
    }

    public void setLicenseFlag(String licenseFlag) {
        this.licenseFlag = licenseFlag;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getDrivingVehicle() {
        return drivingVehicle;
    }

    public void setDrivingVehicle(String drivingVehicle) {
        this.drivingVehicle = drivingVehicle;
    }

    public String getInsuredIdentity() {
        return insuredIdentity;
    }

    public void setInsuredIdentity(String insuredIdentity) {
        this.insuredIdentity = insuredIdentity;
    }

    public String getRelationToApplicantCode() {
        return relationToApplicantCode;
    }

    public void setRelationToApplicantCode(String relationToApplicantCode) {
        this.relationToApplicantCode = relationToApplicantCode;
    }

    public String getRelationToApplicantCodeName() {
        return relationToApplicantCodeName;
    }

    public void setRelationToApplicantCodeName(String relationToApplicantCodeName) {
        this.relationToApplicantCodeName = relationToApplicantCodeName;
    }

    public String getLinkSerialNo() {
        return linkSerialNo;
    }

    public void setLinkSerialNo(String linkSerialNo) {
        this.linkSerialNo = linkSerialNo;
    }

    public String getDisabilityFlag() {
        return disabilityFlag;
    }

    public void setDisabilityFlag(String disabilityFlag) {
        this.disabilityFlag = disabilityFlag;
    }

    public String getDisabilityPosition() {
        return disabilityPosition;
    }

    public void setDisabilityPosition(String disabilityPosition) {
        this.disabilityPosition = disabilityPosition;
    }

    public String getDisabilityGrade() {
        return disabilityGrade;
    }

    public void setDisabilityGrade(String disabilityGrade) {
        this.disabilityGrade = disabilityGrade;
    }

    public String getIsMainInsuredFlag() {
        return isMainInsuredFlag;
    }

    public void setIsMainInsuredFlag(String isMainInsuredFlag) {
        this.isMainInsuredFlag = isMainInsuredFlag;
    }

    public String getIsMainInsuredFlagName() {
        return isMainInsuredFlagName;
    }

    public void setIsMainInsuredFlagName(String isMainInsuredFlagName) {
        this.isMainInsuredFlagName = isMainInsuredFlagName;
    }

    public String getRelationToMainInsured() {
        return relationToMainInsured;
    }

    public void setRelationToMainInsured(String relationToMainInsured) {
        this.relationToMainInsured = relationToMainInsured;
    }

    public String getRelationToMainInsuredName() {
        return relationToMainInsuredName;
    }

    public void setRelationToMainInsuredName(String relationToMainInsuredName) {
        this.relationToMainInsuredName = relationToMainInsuredName;
    }

    public String getLinkNo() {
        return linkNo;
    }

    public void setLinkNo(String linkNo) {
        this.linkNo = linkNo;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getBenefitTypeName() {
        return benefitTypeName;
    }

    public void setBenefitTypeName(String benefitTypeName) {
        this.benefitTypeName = benefitTypeName;
    }

    public String getBenefitSerialNo() {
        return benefitSerialNo;
    }

    public void setBenefitSerialNo(String benefitSerialNo) {
        this.benefitSerialNo = benefitSerialNo;
    }

    public BigDecimal getBenefitRate() {
        return benefitRate;
    }

    public void setBenefitRate(BigDecimal benefitRate) {
        this.benefitRate = benefitRate;
    }

    public String getDisabilityDegree() {
        return disabilityDegree;
    }

    public void setDisabilityDegree(String disabilityDegree) {
        this.disabilityDegree = disabilityDegree;
    }

    public String getDisabilityClassifyCode() {
        return disabilityClassifyCode;
    }

    public void setDisabilityClassifyCode(String disabilityClassifyCode) {
        this.disabilityClassifyCode = disabilityClassifyCode;
    }

    public String getDisabilityClassify() {
        return disabilityClassify;
    }

    public void setDisabilityClassify(String disabilityClassify) {
        this.disabilityClassify = disabilityClassify;
    }

    public String getDisabilityGradeCode() {
        return disabilityGradeCode;
    }

    public void setDisabilityGradeCode(String disabilityGradeCode) {
        this.disabilityGradeCode = disabilityGradeCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getWorkTypeName() {
        return workTypeName;
    }

    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName;
    }

    public String getPluralityTypeName() {
        return pluralityTypeName;
    }

    public void setPluralityTypeName(String pluralityTypeName) {
        this.pluralityTypeName = pluralityTypeName;
    }

    public String getWorkTypeMidClass() {
        return workTypeMidClass;
    }

    public void setWorkTypeMidClass(String workTypeMidClass) {
        this.workTypeMidClass = workTypeMidClass;
    }

    public String getWorkTypeMidClassName() {
        return workTypeMidClassName;
    }

    public void setWorkTypeMidClassName(String workTypeMidClassName) {
        this.workTypeMidClassName = workTypeMidClassName;
    }

    public String getWorkTypeSmallClass() {
        return workTypeSmallClass;
    }

    public void setWorkTypeSmallClass(String workTypeSmallClass) {
        this.workTypeSmallClass = workTypeSmallClass;
    }

    public String getWorkTypeSmallClassName() {
        return workTypeSmallClassName;
    }

    public void setWorkTypeSmallClassName(String workTypeSmallClassName) {
        this.workTypeSmallClassName = workTypeSmallClassName;
    }

    public String getPluralityTypeMidClass() {
        return pluralityTypeMidClass;
    }

    public void setPluralityTypeMidClass(String pluralityTypeMidClass) {
        this.pluralityTypeMidClass = pluralityTypeMidClass;
    }

    public String getPluralityTypeMidClassName() {
        return pluralityTypeMidClassName;
    }

    public void setPluralityTypeMidClassName(String pluralityTypeMidClassName) {
        this.pluralityTypeMidClassName = pluralityTypeMidClassName;
    }

    public String getPluralityTypeSmallClass() {
        return pluralityTypeSmallClass;
    }

    public void setPluralityTypeSmallClass(String pluralityTypeSmallClass) {
        this.pluralityTypeSmallClass = pluralityTypeSmallClass;
    }

    public String getPluralitySmallClassName() {
        return pluralitySmallClassName;
    }

    public void setPluralitySmallClassName(String pluralitySmallClassName) {
        this.pluralitySmallClassName = pluralitySmallClassName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStructureId() {
        return structureId;
    }

    public void setStructureId(String structureId) {
        this.structureId = structureId;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getDrivingVehicleName() {
        return drivingVehicleName;
    }

    public void setDrivingVehicleName(String drivingVehicleName) {
        this.drivingVehicleName = drivingVehicleName;
    }

    public String getDriverCategoryCode() {
        return driverCategoryCode;
    }

    public void setDriverCategoryCode(String driverCategoryCode) {
        this.driverCategoryCode = driverCategoryCode;
    }

    public String getDriverCategory() {
        return driverCategory;
    }

    public void setDriverCategory(String driverCategory) {
        this.driverCategory = driverCategory;
    }

    public String getDisabilityDegreeCode() {
        return disabilityDegreeCode;
    }

    public void setDisabilityDegreeCode(String disabilityDegreeCode) {
        this.disabilityDegreeCode = disabilityDegreeCode;
    }

    public String getImmResHistoryFlag() {
        return immResHistoryFlag;
    }

    public void setImmResHistoryFlag(String immResHistoryFlag) {
        this.immResHistoryFlag = immResHistoryFlag;
    }
}
