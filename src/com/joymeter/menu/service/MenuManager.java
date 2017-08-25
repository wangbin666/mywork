package com.joymeter.menu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joymeter.menu.bean.Button;
import com.joymeter.menu.bean.CommonButton;
import com.joymeter.menu.bean.ComplexButton;
import com.joymeter.menu.bean.Menu;
import com.joymeter.menu.util.MenuUtil;
/**
* 类名: MenuManager </br>
* 包名： com.souvc.weixin.main
* 描述:菜单管理器类 </br>
* 开发人员： liuhf </br>
* 创建时间：  2015-12-1 </br>
* 发布版本：V1.0  </br>
 */
public class MenuManager {
    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    public static void updataMenu() {

            // 调用接口创建菜单
            int result = MenuUtil.createMenu(getMenu());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("weui测试");
        btn11.setType("view");
        btn11.setUrl("http://64ef519f.ngrok.io/weuitest/jsp/f1.html");

        CommonButton btn12 = new CommonButton();
        btn12.setName("测试2");
        btn12.setType("view");
        btn12.setUrl("http://64ef519f.ngrok.io/weuitest/jsp/f2.html");

        CommonButton btn13 = new CommonButton();
        btn13.setName("周边搜索");
        btn13.setType("click");
        btn13.setKey("13");

        CommonButton btn14 = new CommonButton();
        btn14.setName("历史上的今天");
        btn14.setType("view");
//        btn14.setUrl("http://40ec4224.ngrok.io/wbweixin/index");
        btn14.setUrl("http://pay.qingcailuobo.cn/wbweixin/index");
        CommonButton btn21 = new CommonButton();
        btn21.setName("充值");
        btn21.setType("view");      
        //snsapi_base  snsapi_userinfo
        btn21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa8c9e5fe21169ce9&redirect_uri=http://pay.qingcailuobo.cn/wbweixin/index&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");

//        btn21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa8c9e5fe21169ce9&redirect_uri=https%3A%2F%2Fpay.qingcailuobo.cn%2Fwbweixin%2Findex&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
//        btn21.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxa8c9e5fe21169ce9&redirect_uri=https%3A%2F%2F40ec4224.ngrok.io%2Fwbweixin%2FpayServlet&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");

        CommonButton btn22 = new CommonButton();
        btn22.setName("经典游戏");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn23 = new CommonButton();
        btn23.setName("美女电台");
        btn23.setType("click");
        btn23.setKey("23");

        CommonButton btn24 = new CommonButton();
        btn24.setName("人脸识别");
        btn24.setType("click");
        btn24.setKey("24");

        CommonButton btn25 = new CommonButton();
        btn25.setName("聊天唠嗑");
        btn25.setType("click");
        btn25.setKey("25");

        CommonButton btn31 = new CommonButton();
        btn31.setName("Q友圈");
        btn31.setType("click");
        btn31.setKey("31");

        CommonButton btn32 = new CommonButton();
        btn32.setName("电影排行榜");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33 = new CommonButton();
        btn33.setName("幽默笑话");
        btn33.setType("click");
        btn33.setKey("33");



        
        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
        
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("生活助手");
        //一级下有4个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });

        
        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("休闲驿站");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24, btn25 });

        
        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("更多体验");
        mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33 });

        
        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }
}
