package com.joymeter.wechatpay.config;

import com.github.wxpay.sdk.WXPayConfig;
import java.io.*;
/**
 * 微信公共号配置信息
 * appID
 * MchId
 * secretkey
 * @author Administrator
 *
 */
public class MyConfig implements WXPayConfig{

    private byte[] certData;

    public MyConfig() throws Exception {
    	String certPath = "C:\\Program Files\\Pay\\ss.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public String getAppID() {
        return "wxa8c9e5fe21169ce9";
    }

    public String getMchID() {
        return "1235528802";
    }

    public String getKey() {
        return "ada4a0169ee884000d9fc815f929fe1f";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
