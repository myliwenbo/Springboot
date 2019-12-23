package vip.xjdai.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class JwtAccount implements Serializable
{

    private static final long serialVersionUID = -895875540581785581L;

    /**
     * 令牌id
     */
    private String tokenId;

    /**
     * 客户标识(用户id)
     */
    private String subject;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 签发者(JWT令牌此项有值)
     */
    private String issuer;

    /**
     * 签发时间
     */
    private Date issuedAt;

    /**
     * 接收方(JWT令牌此项有值)
     */
    private String audience;

    /**
     * 访问主张-角色(JWT令牌此项有值)
     */
    private String roles;

    /**
     * 访问主张-资源(JWT令牌此项有值)
     */
    private String perms;

    /**
     * 客户地址
     */
    private String host;

    public JwtAccount()
    {

    }
}