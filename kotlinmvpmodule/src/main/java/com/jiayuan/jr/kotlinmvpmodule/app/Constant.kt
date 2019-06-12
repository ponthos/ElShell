package com.jiayuan.jr.kotlinmvpmodule.app

import android.os.Environment
import java.io.File

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/22
 * Description :
 */
object Constant {
    val API_HOST = "https://api.meizitu.net/wp-json/wp/v2/"
    val BMOB_APPLICATION_KEY = "39a0df90ea32771643ead11e26508d90"
    val SPLASH_IMAGE_URL = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/1/1"
    //splash图片的位置
    val SPLASH_LOCAL_PATH = Environment.getExternalStorageDirectory()
            .absolutePath + File.separator + "Envelope/image/"
    //splash图片的名字
    val SPLASH_LOCAL_NAME = "splash.jpg"
    val Debug = true
    //    val APP_DOMAIN = "http://yiziyinian.com"
    val APP_DOMAIN="http://192.168.199.237"
    val pic_1 = "http://39.97.161.249/img/ipad.png"
    val pic_2 = "http://39.97.161.249/img/dog.png"
    val pic_3 = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3006884240,1444133691&fm=27&gp=0.jpg"
}