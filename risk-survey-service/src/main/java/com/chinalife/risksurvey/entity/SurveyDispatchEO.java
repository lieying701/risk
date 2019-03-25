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
 * 派工表
 */
@Entity
@Table(name = "survey_dispatch")
public class SurveyDispatchEO extends AbstractBaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -666018357958480807L;
    /** 主键 */
    private String pkId;
    /** 风勘任务号 */
    private String surveyId;
    /** 任务号 */
    private String taskNo;
    /** 改派序号 */
    private BigDecimal num;
    /** 最新标识：1是、0否 */
    private String newFalg;
    /** 调度员代码 */
    private String dsptatchOperCode;
    /** 调度机构代码 */
    private String dsptatchDeptCode;
    /** 调度机构 */
    private String dsptatchDept;
    /** 调度时间 */
    private Date dsptatchTime;
    /** 执行人代码 */
    private String operatorCode;
    /** 执行人姓名 */
    private String operator;
    /** 执行人操作机构代码 */
    private String operateDeptCode;
    /** 执行人操作机构 */
    private String operateDept;
    /** 执行人电话 */
    private String operatorTel;
    /** 原执行人代码 */
    private String oldOperatorCode;
    /** 原执行人姓名 */
    private String oldOperator;
    /** 原执行人操作机构代码 */
    private String oldOperDeptCode;
    /** 原执行人操作机构 */
    private String oldOperDept;
    /** 派工类型 */
    private String redisptType;
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
     * 任务号
     * 
     * @return the taskNo
     */
    @Column(length = 50)
    public String getTaskNo() {
        return this.taskNo;
    }

    /**
     * 任务号
     * 
     * @param taskNo
     *            任务号
     */
    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * 改派序号
     * 
     * @return the num
     */

    public BigDecimal getNum() {
        return this.num;
    }

    /**
     * 改派序号
     * 
     * @param num
     *            改派序号
     */
    public void setNum(BigDecimal num) {
        this.num = num;
    }

    /**
     * 最新标识：1是、0否
     * 
     * @return the newFalg
     */
    @Column(length = 12)
    public String getNewFalg() {
        return this.newFalg;
    }

    /**
     * 最新标识：1是、0否
     * 
     * @param newFalg
     *            最新标识：1是、0否
     */
    public void setNewFalg(String newFalg) {
        this.newFalg = newFalg;
    }

    /**
     * 调度员代码
     * 
     * @return the dsptatchOperCode
     */
    @Column(length = 50)
    public String getDsptatchOperCode() {
        return this.dsptatchOperCode;
    }

    /**
     * 调度员代码
     * 
     * @param dsptatchOperCode
     *            调度员代码
     */
    public void setDsptatchOperCode(String dsptatchOperCode) {
        this.dsptatchOperCode = dsptatchOperCode;
    }

    /**
     * 调度机构代码
     * 
     * @return the dsptatchDeptCode
     */
    @Column(length = 50)
    public String getDsptatchDeptCode() {
        return this.dsptatchDeptCode;
    }

    /**
     * 调度机构代码
     * 
     * @param dsptatchDeptCode
     *            调度机构代码
     */
    public void setDsptatchDeptCode(String dsptatchDeptCode) {
        this.dsptatchDeptCode = dsptatchDeptCode;
    }

    /**
     * 调度机构
     * 
     * @return the dsptatchDept
     */
    @Column(length = 120)
    public String getDsptatchDept() {
        return this.dsptatchDept;
    }

    /**
     * 调度机构
     * 
     * @param dsptatchDept
     *            调度机构
     */
    public void setDsptatchDept(String dsptatchDept) {
        this.dsptatchDept = dsptatchDept;
    }

    /**
     * 调度时间
     * 
     * @return the dsptatchTime
     */

    public Date getDsptatchTime() {
        return this.dsptatchTime;
    }

    /**
     * 调度时间
     * 
     * @param dsptatchTime
     *            调度时间
     */
    public void setDsptatchTime(Date dsptatchTime) {
        this.dsptatchTime = dsptatchTime;
    }

    /**
     * 执行人代码
     * 
     * @return the operatorCode
     */
    @Column(length = 50)
    public String getOperatorCode() {
        return this.operatorCode;
    }

    /**
     * 执行人代码
     * 
     * @param operatorCode
     *            执行人代码
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    /**
     * 执行人姓名
     * 
     * @return the operator
     */
    @Column(length = 120)
    public String getOperator() {
        return this.operator;
    }

    /**
     * 执行人姓名
     * 
     * @param operator
     *            执行人姓名
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 执行人操作机构代码
     * 
     * @return the operateDeptCode
     */
    @Column(length = 50)
    public String getOperateDeptCode() {
        return this.operateDeptCode;
    }

    /**
     * 执行人操作机构代码
     * 
     * @param operateDeptCode
     *            执行人操作机构代码
     */
    public void setOperateDeptCode(String operateDeptCode) {
        this.operateDeptCode = operateDeptCode;
    }

    /**
     * 执行人操作机构
     * 
     * @return the operateDept
     */
    @Column(length = 120)
    public String getOperateDept() {
        return this.operateDept;
    }

    /**
     * 执行人操作机构
     * 
     * @param operateDept
     *            执行人操作机构
     */
    public void setOperateDept(String operateDept) {
        this.operateDept = operateDept;
    }

    /**
     * 执行人电话
     * 
     * @return the operatorTel
     */
    @Column(length = 32)
    public String getOperatorTel() {
        return this.operatorTel;
    }

    /**
     * 执行人电话
     * 
     * @param operatorTel
     *            执行人电话
     */
    public void setOperatorTel(String operatorTel) {
        this.operatorTel = operatorTel;
    }

    /**
     * 原执行人代码
     * 
     * @return the oldOperatorCode
     */
    @Column(length = 50)
    public String getOldOperatorCode() {
        return this.oldOperatorCode;
    }

    /**
     * 原执行人代码
     * 
     * @param oldOperatorCode
     *            原执行人代码
     */
    public void setOldOperatorCode(String oldOperatorCode) {
        this.oldOperatorCode = oldOperatorCode;
    }

    /**
     * 原执行人姓名
     * 
     * @return the oldOperator
     */
    @Column(length = 120)
    public String getOldOperator() {
        return this.oldOperator;
    }

    /**
     * 原执行人姓名
     * 
     * @param oldOperator
     *            原执行人姓名
     */
    public void setOldOperator(String oldOperator) {
        this.oldOperator = oldOperator;
    }

    /**
     * 原执行人操作机构代码
     * 
     * @return the oldOperDeptCode
     */
    @Column(length = 50)
    public String getOldOperDeptCode() {
        return this.oldOperDeptCode;
    }

    /**
     * 原执行人操作机构代码
     * 
     * @param oldOperDeptCode
     *            原执行人操作机构代码
     */
    public void setOldOperDeptCode(String oldOperDeptCode) {
        this.oldOperDeptCode = oldOperDeptCode;
    }

    /**
     * 原执行人操作机构
     * 
     * @return the oldOperDept
     */
    @Column(length = 120)
    public String getOldOperDept() {
        return this.oldOperDept;
    }

    /**
     * 原执行人操作机构
     * 
     * @param oldOperDept
     *            原执行人操作机构
     */
    public void setOldOperDept(String oldOperDept) {
        this.oldOperDept = oldOperDept;
    }

    /**
     * 派工类型
     * 
     * @return the redisptType
     */
    @Column(length = 12)
    public String getRedisptType() {
        return this.redisptType;
    }

    /**
     * 派工类型
     * 
     * @param redisptType
     *            派工类型
     */
    public void setRedisptType(String redisptType) {
        this.redisptType = redisptType;
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