package vip.xjdai.domain;

import cn.lwb.generator.mybatis.base.BaseModel;
import java.util.Date;

public class ScheduleJob extends BaseModel {
    private Integer id;

    private String jobName;

    private String jobGroup;

    private String methodName;

    private String beanClass;

    private Integer status;

    private String cronExpression;

    private String params;

    private String remark;

    private Date createTime;

    private Date modifyTime;

    public ScheduleJob(Integer id, String jobName, String jobGroup, String methodName, String beanClass, Integer status, String cronExpression, String params, String remark, Date createTime, Date modifyTime) {
        this.id = id;
        this.jobName = jobName;
        this.jobGroup = jobGroup;
        this.methodName = methodName;
        this.beanClass = beanClass;
        this.status = status;
        this.cronExpression = cronExpression;
        this.params = params;
        this.remark = remark;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public ScheduleJob() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass == null ? null : beanClass.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}