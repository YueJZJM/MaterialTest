package com.example.yuejz.materialtest;

import android.app.Application;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {

    final String SA_SERVER_URL = "https://test-hechun.datasink.sensorsdata.cn/sa?project=yuejianzhong&token=d28b875ed9ac268f";
    final SensorsDataAPI.DebugMode SA_DEBUG_MODE = SensorsDataAPI.DebugMode.DEBUG_AND_TRACK;
    @Override
    public void onCreate() {
        super.onCreate();
        initSA();
        SensorsDataAPI.sharedInstance().trackFragmentAppViewScreen();
    }
    private void initSA() {
        // 初始化 SDK
        SensorsDataAPI.sharedInstance(this, SA_SERVER_URL, SA_DEBUG_MODE);
        // 打开自动采集, 并指定追踪哪些 AutoTrack 事件
        List<SensorsDataAPI.AutoTrackEventType> eventTypeList = new ArrayList<>();

        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_START);
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_END);
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_CLICK);
        eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN);
        SensorsDataAPI.sharedInstance().enableAutoTrack(eventTypeList);
    }
}
