package vip.xjdai.demo.mapper;

public class Account  {

    private static final long serialVersionUID = 1L;
    protected Long id;
    protected Boolean isValid;
    protected Long opTime;
    protected Integer lastVer;
    protected Byte status;
    protected Byte type;
    protected Long createTime;
    protected Long appId;
    /**
     * 用户名称
     */
    private String name;

    /**
     * 所属角色id
     */
    private Long roleId;

    /**
     * 用户登录名
     */
    private String userLogin;

    /**
     * 用户密码
     */
    private String password;

    private String ext;

    /**
     * 组织ID
     */
    private Long orgId;

    /**
     * 用户组织类型 1.组织用户 2.个人用户
     */
    private Byte orgType;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 省级id
     */
    private String provinceId;

    /**
     * 市级id
     */
    private String cityId;

    /**
     * 区级id
     */
    private String areaId;


    private Byte reviewStatus;

    /**
     * 审核不通过原因
     */
    private String reviewErrorMsg;

    public static final String NAME = "name";

    public static final String MOBILE = "mobile";

    public static final String ROLE_ID = "role_id";

    public static final String USER_LOGIN = "user_login";

    public static final String PASSWORD = "password";

    public static final String EXT = "ext";

    public static final String ORG_ID = "org_id";

    public static final String ORG_TYPE = "org_type";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getEXT() {
        return EXT;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Byte getOrgType() {
        return orgType;
    }

    public void setOrgType(Byte orgType) {
        this.orgType = orgType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Byte getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Byte reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewErrorMsg() {
        return reviewErrorMsg;
    }

    public void setReviewErrorMsg(String reviewErrorMsg) {
        this.reviewErrorMsg = reviewErrorMsg;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getMOBILE() {
        return MOBILE;
    }
}
