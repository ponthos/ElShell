package com.jiayuan.jr.kotlinmvpmodule.exception

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/24
 * Description :下载报的异常
 */
class DownloadException(val e: String) : RuntimeException(e)