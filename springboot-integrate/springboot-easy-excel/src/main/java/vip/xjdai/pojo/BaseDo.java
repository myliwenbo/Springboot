package vip.xjdai.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;


@KeySequence("SEQ")
public class BaseDo<T extends Model> extends Model {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ID_WORKER)
    protected Long id;
    @TableField(value = "is_valid", fill = FieldFill.INSERT)
    @TableLogic
    protected Boolean isValid;
    @TableField(value = "op_time", fill = FieldFill.INSERT_UPDATE)
    protected Long opTime;
    @TableField(value = "last_ver", fill = FieldFill.INSERT)
    @Version
    protected Integer lastVer;
    @TableField(fill = FieldFill.INSERT)
    protected Byte status;
    protected Byte type;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected Long createTime;
    @TableField(value = "app_id")
    protected Long appId;
    @ExcelProperty(value = "统一社会信用代码")
    protected String onlyCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Long getOpTime() {
        return opTime;
    }

    public void setOpTime(Long opTime) {
        this.opTime = opTime;
    }

    public Integer getLastVer() {
        return lastVer;
    }

    public void setLastVer(Integer lastVer) {
        this.lastVer = lastVer;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }


    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


    public static final String STATUS = "status";

    public static final String TYPE = "type";

    public static final String OP_TIME = "op_time";

    public static final String CREATE_TIME = "create_time";
    public static final String APP_ID = "app_id";


    public String getOnlyCode() {
        return onlyCode;
    }

    public void setOnlyCode(String onlyCode) {
        this.onlyCode = onlyCode;
    }

}
