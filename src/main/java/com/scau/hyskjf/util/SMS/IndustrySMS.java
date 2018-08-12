package com.scau.hyskjf.util.SMS;

import com.scau.hyskjf.util.SMS.common.Config;
import com.scau.hyskjf.util.SMS.common.HttpUtil;
import com.scau.hyskjf.util.SMS.common.VerficationCode;

import java.net.URLEncoder;

/**
 * Created by supiccc on 2018-08-12 11:59
 */
public class IndustrySMS {
    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;
    private static String to = "";
    private static String smsContent = "";

    /**
     * 验证码通知短信
     */
    public static String execute(String phonenumber)
    {
        to = phonenumber;
        smsContent = "【华迪科技】您的验证码为";
        String verficationCode = VerficationCode.getCode();
        smsContent += verficationCode + "，请于5分钟内正确输入，如非本人操作，请忽略此短信。";
        String tmpSmsContent = null;
        try{
            tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
        }catch(Exception e){

        }
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
                + HttpUtil.createCommonParam();

        // 提交请求
        String result = HttpUtil.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);
        return verficationCode;
    }
}
