package cn.lwb.xml.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseBoby {

    @XmlElement(name = "resultInfo")
    private ResultInfo resultInfo;

    @XmlElement(name = "medical_card_id")
    private String     medicalCardId;

    @XmlElement(name = "medical_card_no")
    private String     medicalCardNo;

    @XmlElement(name = "medical_card_validate_date")
    private String     medicalCardValidateDate;

    @XmlElement(name = "medical_card_status")
    private String     medicalCardStatus;

    @XmlElement(name = "medical_card_type")
    private String     medicalCardType;

    @XmlElement(name = "bank_card_no")
    private String     bankCardNo;

    @XmlElement(name = "out_user_account")
    private String     outUserAccount;

    @XmlElement(name = "out_user_id")
    private String     outUserId;

    @XmlElement(name = "out_real_name")
    private String     outRealName;

    @XmlElement(name = "out_user_card_type")
    private String     outUserCardType;

    @XmlElement(name = "out_user_card_no")
    private String     outUserCardNo;

    @XmlElement(name = "out_user_certify_pic")
    private String     outUserCertifyPic;

    @XmlElement(name = "social_card_no")
    private String     socialCardNo;

    @XmlElement(name = "extend_params")
    private String     extendParams;

    public String getMedicalCardId() {
        return medicalCardId;
    }

    public void setMedicalCardId(String medicalCardId) {
        this.medicalCardId = medicalCardId;
    }

    public String getMedicalCardNo() {
        return medicalCardNo;
    }

    public void setMedicalCardNo(String medicalCardNo) {
        this.medicalCardNo = medicalCardNo;
    }

    public String getMedicalCardValidateDate() {
        return medicalCardValidateDate;
    }

    public void setMedicalCardValidateDate(String medicalCardValidateDate) {
        this.medicalCardValidateDate = medicalCardValidateDate;
    }

    public String getMedicalCardStatus() {
        return medicalCardStatus;
    }

    public void setMedicalCardStatus(String medicalCardStatus) {
        this.medicalCardStatus = medicalCardStatus;
    }

    public String getMedicalCardType() {
        return medicalCardType;
    }

    public void setMedicalCardType(String medicalCardType) {
        this.medicalCardType = medicalCardType;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getOutUserAccount() {
        return outUserAccount;
    }

    public void setOutUserAccount(String outUserAccount) {
        this.outUserAccount = outUserAccount;
    }

    public String getOutUserId() {
        return outUserId;
    }

    public void setOutUserId(String outUserId) {
        this.outUserId = outUserId;
    }

    public String getOutRealName() {
        return outRealName;
    }

    public void setOutRealName(String outRealName) {
        this.outRealName = outRealName;
    }

    public String getOutUserCardType() {
        return outUserCardType;
    }

    public void setOutUserCardType(String outUserCardType) {
        this.outUserCardType = outUserCardType;
    }

    public String getOutUserCardNo() {
        return outUserCardNo;
    }

    public void setOutUserCardNo(String outUserCardNo) {
        this.outUserCardNo = outUserCardNo;
    }

    public String getOutUserCertifyPic() {
        return outUserCertifyPic;
    }

    public void setOutUserCertifyPic(String outUserCertifyPic) {
        this.outUserCertifyPic = outUserCertifyPic;
    }

    public String getSocialCardNo() {
        return socialCardNo;
    }

    public void setSocialCardNo(String socialCardNo) {
        this.socialCardNo = socialCardNo;
    }

    public String getExtendParams() {
        return extendParams;
    }

    public void setExtendParams(String extendParams) {
        this.extendParams = extendParams;
    }

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

}
