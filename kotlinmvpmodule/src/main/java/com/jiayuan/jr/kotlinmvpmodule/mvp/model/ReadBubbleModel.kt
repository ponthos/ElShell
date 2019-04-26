package com.jiayuan.jr.kotlinmvpmodule.mvp.model

import android.app.Application
import com.google.gson.Gson
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import com.jiayuan.jr.kotlinmvpmodule.mvp.contract.ReadBubbleContract
import com.jiayuan.jr.kotlinmvpmodule.mvp.model.service.CommonService
import com.jiayuan.jr.modelmodule.RequestModel.ArticRequest
import com.jiayuan.jr.modelmodule.ResponseModel.ArticResponse
import io.reactivex.Observable

import javax.inject.Inject

/**
 * 通过Template生成对应页面的MVP和Dagger代码,请注意输入框中输入的名字必须相同
 * 由于每个项目包结构都不一定相同,所以每生成一个文件需要自己导入import包名,可以在设置中设置自动导入包名
 * 请在对应包下按以下顺序生成对应代码,Contract->Model->Presenter->Activity->Module->Component
 * 因为生成Activity时,Module和Component还没生成,但是Activity中有它们的引用,所以会报错,但是不用理会
 * 继续将Module和Component生成完后,编译一下项目再回到Activity,按提示修改一个方法名即可
 * 如果想生成Fragment的相关文件,则将上面构建顺序中的Activity换为Fragment,并将Component中inject方法的参数改为此Fragment
 */


@ActivityScope
class ReadBubbleModel @Inject
constructor(repositoryManager: IRepositoryManager, private var mGson: Gson?, private var mApplication: Application?) :
    BaseModel(repositoryManager), ReadBubbleContract.Model {

    override fun onDestroy() {
        super.onDestroy()
        this.mGson = null
        this.mApplication = null
    }

    override fun getArticle(userid: Int): Observable<List<ArticResponse>> {
        //{"function":100011,"date":"","vid":0,"author":"setAuthor","md":"setMd","monthDay":"Oct04",
        // "title":"setTitle","article":"setArticle","tags":"setTags"}
        return mRepositoryManager.obtainRetrofitService(CommonService::class.java).
            getArticle(ArticRequest("",0,"setAuthor","setMd",
                "Oct04","setTitle","setArticle","setTags"))
    }

}