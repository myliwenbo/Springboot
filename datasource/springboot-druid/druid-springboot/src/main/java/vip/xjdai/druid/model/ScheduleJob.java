package vip.xjdai.druid.model;

import java.io.Serializable;
import java.util.Date;

public class ScheduleJob implements Serializable
{
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.id
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.job_name
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private String jobName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.job_group
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private String jobGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.method_name
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private String methodName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.bean_class
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private String beanClass;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.status
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.cron_expression
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private String cronExpression;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.params
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private String params;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.remark
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.create_time
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column schedule_job.modify_time
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table schedule_job
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.id
     *
     * @return the value of schedule_job.id
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.id
     *
     * @param id the value for schedule_job.id
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.job_name
     *
     * @return the value of schedule_job.job_name
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public String getJobName()
    {
        return jobName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.job_name
     *
     * @param jobName the value for schedule_job.job_name
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setJobName(String jobName)
    {
        this.jobName = jobName == null ?
                null :
                jobName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.job_group
     *
     * @return the value of schedule_job.job_group
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public String getJobGroup()
    {
        return jobGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.job_group
     *
     * @param jobGroup the value for schedule_job.job_group
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setJobGroup(String jobGroup)
    {
        this.jobGroup = jobGroup == null ?
                null :
                jobGroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.method_name
     *
     * @return the value of schedule_job.method_name
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public String getMethodName()
    {
        return methodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.method_name
     *
     * @param methodName the value for schedule_job.method_name
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setMethodName(String methodName)
    {
        this.methodName = methodName == null ?
                null :
                methodName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.bean_class
     *
     * @return the value of schedule_job.bean_class
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public String getBeanClass()
    {
        return beanClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.bean_class
     *
     * @param beanClass the value for schedule_job.bean_class
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setBeanClass(String beanClass)
    {
        this.beanClass = beanClass == null ?
                null :
                beanClass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.status
     *
     * @return the value of schedule_job.status
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public Integer getStatus()
    {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.status
     *
     * @param status the value for schedule_job.status
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.cron_expression
     *
     * @return the value of schedule_job.cron_expression
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public String getCronExpression()
    {
        return cronExpression;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.cron_expression
     *
     * @param cronExpression the value for schedule_job.cron_expression
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setCronExpression(String cronExpression)
    {
        this.cronExpression = cronExpression == null ?
                null :
                cronExpression.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.params
     *
     * @return the value of schedule_job.params
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public String getParams()
    {
        return params;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.params
     *
     * @param params the value for schedule_job.params
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setParams(String params)
    {
        this.params = params == null ?
                null :
                params.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.remark
     *
     * @return the value of schedule_job.remark
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public String getRemark()
    {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.remark
     *
     * @param remark the value for schedule_job.remark
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setRemark(String remark)
    {
        this.remark = remark == null ?
                null :
                remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.create_time
     *
     * @return the value of schedule_job.create_time
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public Date getCreateTime()
    {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.create_time
     *
     * @param createTime the value for schedule_job.create_time
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column schedule_job.modify_time
     *
     * @return the value of schedule_job.modify_time
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public Date getModifyTime()
    {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column schedule_job.modify_time
     *
     * @param modifyTime the value for schedule_job.modify_time
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobName=").append(jobName);
        sb.append(", jobGroup=").append(jobGroup);
        sb.append(", methodName=").append(methodName);
        sb.append(", beanClass=").append(beanClass);
        sb.append(", status=").append(status);
        sb.append(", cronExpression=").append(cronExpression);
        sb.append(", params=").append(params);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}