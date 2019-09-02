package com.company.pjname

import android.text.TextUtils
import com.company.pjname.api.RequestService
import com.company.pjname.bean.drs.modification.AuthenticationModel
import com.company.pjname.bean.drs.modification.TimeRecordeModel
import com.company.pjname.util.L
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun jsonLogin(){
        val s = "[{\"code\":\"200\",\"errorMsg\":\"\",\"obj\":{\"limits\":[\"ua.com.streamsoft.pingtools\",\"com.xdja.jwt.sjhc\",\"com.xdja.jwt.kkhc\",\"com.xdja.jtgl\",\"com.xdja.jwt.law\",\"com.xdja.jwt.cyryhc\",\"com.xdja.jwt.zhcx\",\"com.xdja.aircert\",\"com.xdja.jwt.kshcnew\",\"com.xdja.mam.hd\",\"com.xdja.mam\",\"com.xdja.jxclient\",\"com.xdja.safeclient\",\"com.xdja.jwt.zhcx\",\"com.xdja.jwt.law\",\"com.xdja.jtgl\",\"com.xdja.zbsb\",\"com.xdja.jwt.cyryhc\",\"com.xdja.jwt.kkhc\",\"com.xdja.jwt.sjhc\",\"com.xdja.jwt.kshcnew\",\"com.company.pjname\"],\"position\":\"28\",\"sex\":\"1\",\"code\":\"100002\",\"depcode\":\"540100000000\",\"id\":\"ff8080816b87c3b9016b9bfba4990007\",\"hasPortrait\":false,\"police\":\"22\",\"name\":\"李鹏飞\",\"depid\":\"4028928a5261c25f015261cd3c540016\",\"personType\":\"1\",\"identifier\":\"410105199601090051\",\"mobile\":\"15890105849\",\"effectivedate\":\"1562840672223\"}}]"
        val json = s.substring(1).run {
            substring(0, length - 1)
        }
        val jsonObject = JSONObject(json)
        val code = jsonObject.getString("code")
        if (!TextUtils.isEmpty(code) && code != "200") {
            throw Exception(jsonObject.getString("errorMsg"))
        }
        RequestService.gson.fromJson(json, AuthenticationModel::class.java)
        L.e("att")
    }

    @Test
    fun jsonToObject(){
        val s = "[\n" +
                "  {\n" +
                "    \"code\": \"200\",\n" +
                "    \"count\": \"0\",\n" +
                "    \"data\": [\n" +
                "      {\n" +
                "        \"cjsj\": \"20190331\",\n" +
                "        \"hdxgxx\": \"乘车日期:20190331;出发地:汉口;目的地:合肥南;\",\n" +
                "        \"tablename\": \"T_RY_TLDPXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_铁路乘客信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"铁路\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20190329\",\n" +
                "        \"hdxgxx\": \"乘车日期:20190329;出发地:合肥南;目的地:黄石北;\",\n" +
                "        \"tablename\": \"T_RY_TLDPXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_铁路乘客信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"铁路\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20180525163058\",\n" +
                "        \"hdxgxx\": \"违法时间:20180525163058;违法地点:;违法行为:驾驶机动车违反道路交通信号灯通行的;\",\n" +
                "        \"tablename\": \"V_AJ_WFJL\",\n" +
                "        \"tablenameCn\": \"交管_交警六合一_驾驶员违法信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"违章\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20180409102300\",\n" +
                "        \"hdxgxx\": \"违法时间:20180409102300;违法地点:;违法行为:上道路行驶的机动车未按规定定期进行安全技术检验的;\",\n" +
                "        \"tablename\": \"V_AJ_WFJL\",\n" +
                "        \"tablenameCn\": \"交管_交警六合一_驾驶员违法信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"违章\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20171117080656\",\n" +
                "        \"hdxgxx\": \"违法时间:20171117080656;违法地点:;违法行为:机动车违反禁令标志的;\",\n" +
                "        \"tablename\": \"V_AJ_WFJL\",\n" +
                "        \"tablenameCn\": \"交管_交警六合一_驾驶员违法信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"违章\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20171106\",\n" +
                "        \"hdxgxx\": \"乘车日期:20171106;出发地:合肥南;目的地:南京南;\",\n" +
                "        \"tablename\": \"T_RY_TLDPXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_铁路乘客信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"铁路\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20171010170920\",\n" +
                "        \"hdxgxx\": \"违法时间:20171010170920;违法地点:;违法行为:通过有灯控路口时不按所需行进方向驶入导向车道的;\",\n" +
                "        \"tablename\": \"V_AJ_WFJL\",\n" +
                "        \"tablenameCn\": \"交管_交警六合一_驾驶员违法信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"违章\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170905101801\",\n" +
                "        \"hdxgxx\": \"违法时间:20170905101801;违法地点:;违法行为:违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的;\",\n" +
                "        \"tablename\": \"V_AJ_WFJL\",\n" +
                "        \"tablenameCn\": \"交管_交警六合一_驾驶员违法信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"违章\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170724\",\n" +
                "        \"hdxgxx\": \"乘车日期:20170724;出发地:宁波;目的地:合肥南;\",\n" +
                "        \"tablename\": \"T_RY_TLDPXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_铁路乘客信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"铁路\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170724\",\n" +
                "        \"hdxgxx\": \"乘车日期:20170724;出发地:宁波;目的地:合肥南;\",\n" +
                "        \"tablename\": \"T_RY_TLDPXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_铁路乘客信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"铁路\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170721\",\n" +
                "        \"hdxgxx\": \"乘车日期:20170721;出发地:合肥南;目的地:宁波;\",\n" +
                "        \"tablename\": \"T_RY_TLDPXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_铁路乘客信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"铁路\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170619151750\",\n" +
                "        \"hdxgxx\": \"违法时间:20170619151750;违法地点:;违法行为:违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的;\",\n" +
                "        \"tablename\": \"V_AJ_WFJL\",\n" +
                "        \"tablenameCn\": \"交管_交警六合一_驾驶员违法信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"违章\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170424155835\",\n" +
                "        \"hdxgxx\": \"违法时间:20170424155835;违法地点:;违法行为:机动车违反禁令标志的;\",\n" +
                "        \"tablename\": \"V_AJ_WFJL\",\n" +
                "        \"tablenameCn\": \"交管_交警六合一_驾驶员违法信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"违章\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170417113000\",\n" +
                "        \"hdxgxx\": \"起飞时间:20170417113000;起飞机场:泉州晋江;降落机场:合肥新桥;航班号:GS6533;\",\n" +
                "        \"tablename\": \"T_RY_MHCJXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_航班乘机信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"民航\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170414150500\",\n" +
                "        \"hdxgxx\": \"起飞时间:20170414150500;起飞机场:合肥新桥;降落机场:泉州晋江;航班号:GS6534;\",\n" +
                "        \"tablename\": \"T_RY_MHCJXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_航班乘机信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"民航\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170321130100\",\n" +
                "        \"hdxgxx\": \"违法时间:20170321130100;违法地点:;违法行为:违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的;\",\n" +
                "        \"tablename\": \"V_AJ_WFJL\",\n" +
                "        \"tablenameCn\": \"交管_交警六合一_驾驶员违法信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"违章\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20170305094618\",\n" +
                "        \"hdxgxx\": \"违法时间:20170305094618;违法地点:;违法行为:机动车违反禁令标志的;\",\n" +
                "        \"tablename\": \"V_AJ_WFJL\",\n" +
                "        \"tablenameCn\": \"交管_交警六合一_驾驶员违法信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"违章\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20161215091520\",\n" +
                "        \"hdxgxx\": \"盘查时间:20161215091520;盘查类型，01警务通;02客运中心站:01;\",\n" +
                "        \"tablename\": \"VW_RY_PCRY\",\n" +
                "        \"tablenameCn\": \"盘查人员\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"核查\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20161201\",\n" +
                "        \"hdxgxx\": \"乘车日期:20161201;出发地:宁波;目的地:合肥南;\",\n" +
                "        \"tablename\": \"T_RY_TLDPXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_铁路乘客信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"铁路\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"cjsj\": \"20161127\",\n" +
                "        \"hdxgxx\": \"乘车日期:20161127;出发地:合肥南;目的地:宁波;\",\n" +
                "        \"tablename\": \"T_RY_TLDPXX\",\n" +
                "        \"tablenameCn\": \"社会_治安_铁路乘客信息\",\n" +
                "        \"trailcode\": \"\",\n" +
                "        \"trailname\": \"铁路\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"msg\": \"标识成功\"\n" +
                "  }\n" +
                "]"
        val json = s.substring(1).run {
            substring(0,length-1)
        }
        val jsonObject = JSONObject(json)
        val test = RequestService.gson.fromJson(json, TimeRecordeModel::class.java)
        System.out.println("")
    }
}
