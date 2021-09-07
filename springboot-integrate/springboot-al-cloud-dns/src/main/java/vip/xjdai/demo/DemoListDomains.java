package vip.xjdai.demo;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainsRequest;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.junit.Test;

import java.util.List;

public class DemoListDomains {

    private static IAcsClient client = null;

    static {
        String regionId = "cn-hangzhou"; //必填固定值，必须为“cn-hanghou”
        String accessKeyId = "LTAI4GAs2NuEiecsZj5EyDEf"; // your accessKey
        String accessKeySecret = "tFOafI8pyKyJRbPsWXC4Q63savLWV3";// your accessSecret
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        // 若报Can not find endpoint to access异常，请添加以下此行代码
        // DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Alidns", "alidns.aliyuncs.com");  
        client = new DefaultAcsClient(profile);
    }

    /**
     * 获取域名
     *
     * @throws Exception
     */
    @Test
    public void DescribeDomains() throws Exception {
        DescribeDomainsRequest request = new DescribeDomainsRequest();
        request.setActionName("DescribeDomains");
        // request.setKeyWord(""); //通过该字段进行搜索
        // request.setLang("");
        request.setPageNumber(1L);
        request.setPageSize(10L);
        try {
            DescribeDomainsResponse response = client.getAcsResponse(request);
            List<DescribeDomainsResponse.Domain> list = response.getDomains();
            for (DescribeDomainsResponse.Domain domain : list) {
                System.out.println(domain.getDomainName());
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DescribeDomainRecords() throws Exception {
        DescribeDomainsRequest request = new DescribeDomainsRequest();
        request.setActionName("DescribeDomainRecords");

        // request.setKeyWord(""); //通过该字段进行搜索
        // request.setLang("");
        request.setPageNumber(1L);
        request.setPageSize(10L);

    }

}