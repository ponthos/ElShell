package com.jiayuan.jr.viewmodule

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.jiayuan.jr.modelmodule.ArticResponse
import com.jiayuan.jr.viewmodule.databinding.ViewmoduleIndexListActivityBinding
import kotlinx.android.synthetic.main.viewmodule_index_list_activity.*
import okhttp3.*
import java.io.IOException

/**
 * @desc
 * @auth ${user}
 * time 2019-06-27 16:56
 */
@Suppress("DEPRECATION")
@Route(path = "/kite_module/index_list_activity")
class IndexListActivity : AppCompatActivity() {
//    @Inject
//    lateinit var mGson: Gson
    var viewmoduleIndexListActivityBinding: ViewmoduleIndexListActivityBinding? = null
    private var client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.viewmodule_index_list_activity)
        viewmoduleIndexListActivityBinding= DataBindingUtil.setContentView(this,R.layout.viewmodule_index_list_activity)
        try {
            post(
                "http://39.97.161.249:8080/article/getartic",
                "\"{\\\"function\\\":100011,\\\"date\\\":\\\"\\\",\\\"vid\\\":0,\" +\n" +
                        "                        \"\\\"author\\\":\\\"setAuthor\\\",\\\"md\\\":\\\"setMd\\\",\\\"monthDay\\\":\\\"Oct04\\\",\" +\n" +
                        "                        \"\\\"title\\\":\\\"setTitle\\\",\\\"article\\\":\\\"setArticle\\\",\\\"tags\\\":\\\"setTags\\\"}\""
            )
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    /**
     *okhttp 3.11post请求
     */
    @Throws(IOException::class)
    internal fun post(url: String, json: String){
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()
        OkHttpClient().newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                Toast.makeText(this@IndexListActivity,"请求失败",Toast.LENGTH_LONG)
            }

            override fun onResponse(call: Call, response: Response) {

//                //注意必须是javaObjectType，要不会被擦除泛型
//                val bean = Gson().fromJson(response.body().toString(), ArticResponse::class.javaObjectType)
//                val results = bean.article
//                //验证是否有数据
//                val s = results.toString()
//                Log.e("main",s)


                /**
                 * date : 1552366800000
                 * vid : 1
                 * author : setAuthor
                 * md : setMd
                 * title : setTitle
                 * article : setArticle
                 * tags : setTags
                 */
                response.body().toString()
                var infos = mutableListOf<ArticResponse>()
//                val add = infos.add(
//                    ArticResponse(
//                        1552366800000, 1, "setAuthor", "setMd"
//                        , "setTitle", "setArticle", "setTags"
//                    )
//                )
                infos.add(ArticResponse(1552366800000,1,"setAuthor","setMd"
                    ,"setTitle","setArticle","setTags"))
                infos.add(ArticResponse(1552366800000,1,"setAuthor","setMd"
                    ,"setTitle","setArticle","setTags"))
                infos.add(ArticResponse(1552366800000,1,"setAuthor","setMd"
                    ,"setTitle","setArticle","setTags"))
                RecyclerView.layoutManager=LinearLayoutManager(this@IndexListActivity)
                RecyclerView.adapter=ArticAdapter(infos,this@IndexListActivity)
            }
        })
    }

    companion object {
        val JSON = MediaType.get("application/json; charset=utf-8")!!
    }

}
