package com.microblog.common.utils.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 17/6/7.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 *
 * 备注:Demo工程编码采用UTF-8
 * 国际短信发送请勿参照此DEMO
 */

//@Slf4j
public class SmsUtil {

    private static final Logger log = LoggerFactory.getLogger(SmsUtil.class);
    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIZ9vHdEp2HHeB";
    static final String accessKeySecret = "T8zg5xPgXNI1EIyYQdTOYRfckzBf9i";

    //耗时1803ms
    public static SendSmsResponse sendSms(String phoneNum,String code) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        
       // request.setMethod(MethodType.POST);
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNum);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("蓝莓");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_130916740");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{ \"code\":\"" + code +  "\"}");

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutIdaa");

        log.debug("发送短信");
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sendSmsResponse.getCode() != null)
		{
			 log.debug("sendSmsResponse code = "  +  sendSmsResponse.getCode());
		}
		else {
			log.debug("sendSmsResponse code = null");
		}
		//查明细
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(sendSmsResponse.getBizId());
            log.debug("短信明细查询接口返回数据----------------");
            log.debug("Code=" + querySendDetailsResponse.getCode());
            log.debug("Message=" + querySendDetailsResponse.getMessage());
            int i = 0;
            for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
            {
                log.debug("SmsSendDetailDTO["+i+"]:");
                log.debug("Content=" + smsSendDetailDTO.getContent());
                log.debug("ErrCode=" + smsSendDetailDTO.getErrCode());
                log.debug("OutId=" + smsSendDetailDTO.getOutId());
                log.debug("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
                log.debug("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
                log.debug("SendDate=" + smsSendDetailDTO.getSendDate());
                log.debug("SendStatus=" + smsSendDetailDTO.getSendStatus());
                log.debug("Template=" + smsSendDetailDTO.getTemplateCode());
            }
            log.debug("TotalCount=" + querySendDetailsResponse.getTotalCount());
            log.debug("RequestId=" + querySendDetailsResponse.getRequestId());
        }
        
        return sendSmsResponse;
    }


    public static QuerySendDetailsResponse querySendDetails(String bizId) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber("15000000000");
        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }

    public static void main(String[] args) throws ClientException, InterruptedException 
    {
       // sendMsg("13925716752","123456");
    }

    public static  void sendMsg(String phoneNum,String code ) throws Exception {
        Date start = new Date();
        sendSms(phoneNum,code);
        Date end = new Date();
        log.debug("发送短信{}-{}成功,总共耗时{}",phoneNum,code,(end.getTime() - start.getTime()));
    }

}