package cn.lwb.quartz.pojo;

import java.util.Date;

public class ScheduleJob {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 任务名
     */
    private String  jobName;
    /**
     * 任务组
     */
    private String  jobGroup;
    /**
     * 要执行的方法的名称
     */
    private String  methodName;
    /**
     * 要执行的方法所在的class路径
     */
    private String  beanClass;
    /**
     * 定时任务状态，0表示正常，1表示停止
     */
    private Integer status;
    /**
     * 时间表达式
     */
    private String  cronExpression;
    /**
     * 参数
     */
    private String  params;
    /**
     * 备注
     */
    private String  remark;
    /**
     * 创建时间
     */
    private Date    createTime;
    /**
     * 修改时间
     */
    private Date    modifyTime;

    public ScheduleJob() {
    }

    public ScheduleJob(Integer id, String jobName, String jobGroup, String methodName,
                       String beanClass, Integer status, String cronExpression,
                       String params, String remark, Date createTime, Date modifyTime) {
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
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
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
        this.cronExpression = cronExpression;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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