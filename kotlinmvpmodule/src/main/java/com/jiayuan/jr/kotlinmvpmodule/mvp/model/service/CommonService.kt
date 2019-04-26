package com.jiayuan.jr.kotlinmvpmodule.mvp.model.service

import com.jiayuan.jr.kotlinmvpmodule.app.Constant
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.entity.ImagesDetailInfo
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.entity.ImagesInfo
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.entity.SplashImageInfo
import com.jiayuan.jr.modelmodule.RequestModel.ArticRequest
import com.jiayuan.jr.modelmodule.ResponseModel.ArticResponse
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * Author : pans
 * Email : 1781929720@qq.com
 * Time :  2018/5/21
 * Description :api
 */
interface CommonService {


    /**
     * 根据key获取
     */
    @GET("{key}")
    fun getImagesByKey(@Path("key")tag:String, @Query("page") page: Int):Observable<List<ImagesInfo>>

    /**
     * 搜索套图
     */
    @GET("posts")
    fun searchImagesByKeyWords(@Query("page") page: Int, @Query("search") keyWords: String): Observable<List<ImagesInfo>>

    /**
     * 根据 id  获取详细的套图
     */
    @GET("i")
    fun getImagesDetailById(@Query("id") id: Int): Observable<ImagesDetailInfo>



    /**
     * 根据分类
     */
    @GET("posts")
    fun getImagesByCategory(
            @Query("tags") category: String,
            @Query("page") page: Int
    ): Observable<List<ImagesInfo>>

    /**
     * 启动页的图片  来自gank
     */
    @GET()
    fun getSplashImage(@Url url: String = Constant.SPLASH_IMAGE_URL): Observable<SplashImageInfo>

    /**
     * 下载图片
     */
    @GET()
    fun download(@Url url: String): Observable<ResponseBody>

    @POST("/article/getartic")//http://192.168.199.237:8080/artic/getartic///article/getartic
    fun getArticle(@Body bean: ArticRequest): Observable<List<ArticResponse>>
    //@Query("since")
}