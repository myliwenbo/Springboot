package vip.xjdai.springbootcommons.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName(value = "t_restaurant")
public class Restaurant {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * the En Name of the restaurant
     */
    @TableField(value = "`Name`")
    private String name;

    @TableField(value = "CnName")
    private String cnname;

    @TableField(value = "X")
    private Double x;

    @TableField(value = "Y")
    private Double y;

    /**
     * En location of the restaurant
     */
    @TableField(value = "`Location`")
    private String location;

    @TableField(value = "CnLocation")
    private String cnlocation;

    /**
     * city.district.neighbourhood
Example: Shanghai.Xuhui.Xujiahui
     */
    @TableField(value = "Area")
    private String area;

    @TableField(value = "CnArea")
    private String cnarea;

    /**
     * the information/descripton of the restaurant
     */
    @TableField(value = "Traffic")
    private String traffic;

    /**
     * Phone of the restaurant
     */
    @TableField(value = "Telephone")
    private String telephone;

    @TableField(value = "Email")
    private String email;

    @TableField(value = "Website")
    private String website;

    @TableField(value = "Cuisine")
    private String cuisine;

    @TableField(value = "AveragePrice")
    private String averageprice;

    /**
     * Average price of lunch
     */
    @TableField(value = "AvgLunchPrice")
    private BigDecimal avglunchprice;

    /**
     * Indtroduction of the restaurant
     */
    @TableField(value = "Introduction")
    private String introduction;

    /**
     * 1=Opened 0=Closed
     */
    @TableField(value = "`Status`")
    private Integer status;

    @TableField(value = "CreateDT")
    private Date createdt;

    /**
     * 1=Valid 0=Invalid
     */
    @TableField(value = "IsValid")
    private Short isvalid;

    /**
     * pics at the list, value would be:
basepath/original/picname
     */
    @TableField(value = "Thumbnail")
    private String thumbnail;

    @TableField(value = "OpenHours")
    private String openhours;

    /**
     * the percentage of people like it
     */
    @TableField(value = "LikeVotes")
    private Integer likevotes;

    /**
     * How many people votes
     */
    @TableField(value = "DislikeVotes")
    private Integer dislikevotes;

    /**
     * 设备
     */
    @TableField(value = "Amenities")
    private String amenities;

    /**
     * tags of the restaurant
     */
    @TableField(value = "Tags")
    private String tags;

    @TableField(value = "OpenDate")
    private Date opendate;

    @TableField(value = "closeDate")
    private Date closedate;

    /**
     * 城市id
     */
    @TableField(value = "CityId")
    private Integer cityid;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "Name";

    public static final String COL_CNNAME = "CnName";

    public static final String COL_X = "X";

    public static final String COL_Y = "Y";

    public static final String COL_LOCATION = "Location";

    public static final String COL_CNLOCATION = "CnLocation";

    public static final String COL_AREA = "Area";

    public static final String COL_CNAREA = "CnArea";

    public static final String COL_TRAFFIC = "Traffic";

    public static final String COL_TELEPHONE = "Telephone";

    public static final String COL_EMAIL = "Email";

    public static final String COL_WEBSITE = "Website";

    public static final String COL_CUISINE = "Cuisine";

    public static final String COL_AVERAGEPRICE = "AveragePrice";

    public static final String COL_AVGLUNCHPRICE = "AvgLunchPrice";

    public static final String COL_INTRODUCTION = "Introduction";

    public static final String COL_STATUS = "Status";

    public static final String COL_CREATEDT = "CreateDT";

    public static final String COL_ISVALID = "IsValid";

    public static final String COL_THUMBNAIL = "Thumbnail";

    public static final String COL_OPENHOURS = "OpenHours";

    public static final String COL_LIKEVOTES = "LikeVotes";

    public static final String COL_DISLIKEVOTES = "DislikeVotes";

    public static final String COL_AMENITIES = "Amenities";

    public static final String COL_TAGS = "Tags";

    public static final String COL_OPENDATE = "OpenDate";

    public static final String COL_CLOSEDATE = "closeDate";

    public static final String COL_CITYID = "CityId";
}