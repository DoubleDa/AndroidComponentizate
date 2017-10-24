# 组件化架构实战

## 模块划分

- app：主项目
- co_index：首页
- co_discover：发现
- co_my：我的
- co_newsdetail：新闻详情
- co_order：订单
- lib_utils：工具类
- lib_img：图片加载库
- lib_net：网络相关
- module_common：公共依赖库

错误信息：

```java
10-24 04:05:48.439 20546-20546/com.dyx.aca E/AndroidRuntime: FATAL EXCEPTION: main
                                                             Process: com.dyx.aca, PID: 20546
                                                             android.content.ActivityNotFoundException: Unable to find explicit activity class {com.dyx.aca/com.dyx.aca.co.newsdetail.NewsDetailActivity}; have you declared this activity in your AndroidManifest.xml?
                                                                 at android.app.Instrumentation.checkStartActivityResult(Instrumentation.java:1805)
                                                                 at android.app.Instrumentation.execStartActivity(Instrumentation.java:1523)
                                                                 at android.app.Activity.startActivityForResult(Activity.java:4225)
                                                                 at android.support.v4.app.BaseFragmentActivityJB.startActivityForResult(BaseFragmentActivityJB.java:54)
                                                                 at android.support.v4.app.FragmentActivity.startActivityForResult(FragmentActivity.java:75)
                                                                 at android.support.v4.app.ActivityCompatJB.startActivityForResult(ActivityCompatJB.java:28)
                                                                 at android.support.v4.app.ActivityCompat.startActivityForResult(ActivityCompat.java:143)
                                                                 at android.support.v4.app.FragmentActivity.startActivityFromFragment(FragmentActivity.java:781)
                                                                 at android.support.v4.app.FragmentActivity$HostCallbacks.onStartActivityFromFragment(FragmentActivity.java:896)
                                                                 at android.support.v4.app.Fragment.startActivity(Fragment.java:981)
                                                                 at android.support.v4.app.Fragment.startActivity(Fragment.java:970)
                                                                 at com.dyx.aca.module.base.BaseFragment.intentToForName(BaseFragment.java:40)
                                                                 at com.dyx.aca.co.index.IndexFragment$2.onItemClick(IndexFragment.java:94)
                                                                 at com.dyx.aca.co.index.adapter.IndexAdapter$1.onClick(IndexAdapter.java:49)
                                                                 at android.view.View.performClick(View.java:5637)
                                                                 at android.view.View$PerformClick.run(View.java:22429)
                                                                 at android.os.Handler.handleCallback(Handler.java:751)
                                                                 at android.os.Handler.dispatchMessage(Handler.java:95)
                                                                 at android.os.Looper.loop(Looper.java:154)
                                                                 at android.app.ActivityThread.main(ActivityThread.java:6119)
                                                                 at java.lang.reflect.Method.invoke(Native Method)
                                                                 at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:886)
                                                                 at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:776)

```

## 问题解决

- [ButtonKnife在library报“Attribute value must be constant”](http://blog.csdn.net/huwan12345/article/details/77976533)
- [错误Conflict with dependency 'com.google.code.findbugs:jsr305' 解决方法](http://blog.csdn.net/anyway1919/article/details/53469318)
- [android自定义View时报error: No resource identifier found for attribute ‘XXX’ in package ‘](http://blog.csdn.net/asdf717/article/details/51393412)

 compile project(':lib_view')
 compile project(':co_newsdetail')
 都包含自定义View所以指错