package com.example.zhaolei.suanfa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.zhaolei.model.entity.LogisticsUploadModel;
import com.example.zhaolei.util.EntityToArrayUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Test01 {


    /**
     *     List对象转string二维数组
     * @param args
     */
    public static void main(String[] args) {

        String s ="{\"total\":5,\"rows\":[{\"MD_ID\":\"7bf80c60ac6d04b8edbc208d7e083a1f\",\"APPTYPE\":\"1241047\",\"ORDER_ID\":" +
                "\"140236967574412653\",\"SENDER_NAME\":\"牧卡诺\",\"SENDER_TELEPHONE\":\"0576-83355866\",\"SENDER_ADDRESS\":" +
                "\"沙田洋经济开发区（统建村，老杨戈电器厂）\",\"RECEIVER_NAME\":\"赵磊\",\"RECEIVER_MOBILEPHONE\":\"13835448934\"," +
                "\"RECEIVER_ADDRESS\":\"开发区   山西工程技术学院15#419\",\"CAPTURE_TIME\":1524981005,\"EXPRESS_ORDER_NUM\":" +
                "\"491675124828\",\"EXPRESS_NAME\":\"07\",\"DELIVER_STATUS\":\"05\",\"PRIORITY\":8475018994,\"ACTION_TIME" +
                "\":1524981005,\"SENDER_CITY_NAME\":\"浙江省台州市三门县\",\"RECEIVER_CITY_NAME\":\"山西省阳泉市郊区\",\"DATA_SOURCE" +
                "\":\"890\",\"RESOURCEID\":\"134C3301001500186\"},{\"MD_ID\":\"56bd70dd05eb130ae53c87ed8ad76a31\",\"APPTYPE\":" +
                "\"1241006\",\"SENDER_NAME\":\"陶杰\",\"SENDER_MOBILEPHONE\":\"15700155887\",\"SENDER_TELEPHONE\":\"15700155887\"," +
                "\"SENDER_ADDRESS\":\"浙江省丽水市缙云县新建镇洋山工业区2区块2楼二十八间工作室，只收四通一达顺丰，如寄其他快递概不负责，拒收到付商品不影响" +
                "第二次销售无洗穿痕迹 建议使用官方推荐【上门取件服务】寄回\",\"RECEIVER_NAME\":\"赵磊\",\"RECEIVER_MOBILEPHONE\":\"13835448934\"," +
                "\"RECEIVER_TELEPHONE\":\"13835448934\",\"RECEIVER_ADDRESS\":\"山西省太原市小店区山西省太原市小店区太原高新技术产业开发区源缘园A座2" +
                "单元2001\",\"GOODS\":\"正常货物\",\"CAPTURE_TIME\":1578742294,\"EXPRESS_ORDER_NUM\":\"SF1016118512078\",\"EXPRESS_NAME\":" +
                "\"顺丰\",\"PRIORITY\":8421257606,\"GOODS_WEIGHT\":\"1.5\",\"GOODS_TYPE\":\"2\",\"ACTION_TIME\":1578742393,\"DATA_SOURCE\":\"115\",\"RESOURCEID\":\"134C3301001500186\"},{\"MD_ID\":\"56bd70dd05eb130ae53c87ed8ad76a31\",\"APPTYPE\":\"1241006\",\"SENDER_NAME\":\"陶杰\",\"SENDER_MOBILEPHONE\":\"15700155887\",\"SENDER_TELEPHONE\":\"15700155887\",\"SENDER_ADDRESS\":\"浙江省丽水市缙云县新建镇洋山工业区2区块2楼二十八间工作室，只收四通一达顺丰，如寄其他快递概不负责，拒收到付商品不影响第二次销售无洗穿痕迹 建议使用官方推荐【上门取件服务】寄回\",\"RECEIVER_NAME\":\"赵磊\",\"RECEIVER_MOBILEPHONE\":\"13835448934\",\"RECEIVER_TELEPHONE\":\"13835448934\",\"RECEIVER_ADDRESS\":\"山西省太原市小店区山西省太原市小店区太原高新技术产业开发区源缘园A座2单元2001\",\"GOODS\":\"正常货物\",\"CAPTURE_TIME\":1578742294,\"EXPRESS_ORDER_NUM\":\"SF1016118512078\",\"EXPRESS_NAME\":\"顺丰\",\"PRIORITY\":8421257606,\"GOODS_WEIGHT\":\"1.5\",\"GOODS_TYPE\":\"2\",\"ACTION_TIME\":1578742393,\"DATA_SOURCE\":\"115\",\"RESOURCEID\":\"134C3301001500186\"},{\"MD_ID\":\"dbe5a76e3e3bafcbeeec37e68834d43a\",\"APPTYPE\":\"1241009\",\"SENDER_NAME\":\"李小刚\",\"SENDER_MOBILEPHONE\":\"18634777840\",\"SENDER_POST\":\"140100\",\"SENDER_ADDRESS\":\"山西省太原市迎泽区淖马村\",\"RECEIVER_NAME\":\"赵磊\",\"RECEIVER_MOBILEPHONE\":\"13835448934\",\"RECEIVER_TELEPHONE\":\"13835448934\",\"RECEIVER_POST\":\"140100\",\"RECEIVER_ADDRESS\":\"南中环平阳路交叉口源缘园A座2单元2001\",\"GOODS\":\"物品\",\"CAPTURE_TIME\":1576986708,\"EXPRESS_ORDER_NUM\":\"52229455407326\",\"EXPRESS_NAME\":\"09\",\"PRIORITY\":8423013076,\"SENDER_IDENTIFICATION_TYPE\":\"990\",\"SENDER_IDENTIFICATION_CODE\":\"141124199202080117\",\"SHPR_NAME\":\"李志岗\",\"SHPR_PHONE\":\"18235842158\",\"SHPR_BRANCH\":\"太原建设北路分部\",\"ACTION_TIME\":1576986923,\"DATA_SOURCE\":\"115\",\"RESOURCEID\":\"134C3301001500186\",\"SENDER_PROVINCE_NAME\":\"山西省\",\"RECEIVER_PROVINCE_NAME\":\"山西省\",\"SENDER_DISTRICT_NAME\":\"太原市\",\"RECEIVER_DISTRICT_NAME\":\"太原市\"},{\"MD_ID\":\"dbe5a76e3e3bafcbeeec37e68834d43a\",\"APPTYPE\":\"1241009\",\"SENDER_NAME\":\"李小刚\",\"SENDER_MOBILEPHONE\":\"18634777840\",\"SENDER_POST\":\"140100\",\"SENDER_ADDRESS\":\"山西省太原市迎泽区淖马村\",\"RECEIVER_NAME\":\"赵磊\",\"RECEIVER_MOBILEPHONE\":\"13835448934\",\"RECEIVER_TELEPHONE\":\"13835448934\",\"RECEIVER_POST\":\"140100\",\"RECEIVER_ADDRESS\":\"南中环平阳路交叉口源缘园A座2单元2001\",\"GOODS\":\"物品\",\"CAPTURE_TIME\":1576986708,\"EXPRESS_ORDER_NUM\":\"52229455407326\",\"EXPRESS_NAME\":\"09\",\"PRIORITY\":8423013076,\"SENDER_IDENTIFICATION_TYPE\":\"990\",\"SENDER_IDENTIFICATION_CODE\":\"141124199202080117\",\"SHPR_NAME\":\"李志岗\",\"SHPR_PHONE\":\"18235842158\",\"SHPR_BRANCH\":\"太原建设北路分部\",\"ACTION_TIME\":1576986923,\"DATA_SOURCE\":\"115\",\"RESOURCEID\":\"134C3301001500186\",\"SENDER_PROVINCE_NAME\":\"山西省\",\"RECEIVER_PROVINCE_NAME\":\"山西省\",\"SENDER_DISTRICT_NAME\":\"太原市\",\"RECEIVER_DISTRICT_NAME\":\"太原市\"}]}";

        Map jsonToMap =  JSONObject.parseObject(s);
        List<LogisticsUploadModel> list = JSONArray.parseArray(JSON.toJSONString(jsonToMap.get("rows")), LogisticsUploadModel.class);
        for (LogisticsUploadModel model : list) {
            log.info(model.toString());
        }

        log.info("上传方法开始=====>>>>");
        //List对象转string二维数组
        String [] str={"SENDER_NAME","SENDER_MOBILEPHONE", "SENDER_ADDRESS","RECEIVER_NAME", "RECEIVER_MOBILEPHONE","RECEIVER_ADDRESS","GOODS","CAPTURE_TIME","EXPRESS_NAME","GOODS_WEIGHT","GOODS_VOLUME","INSURED_TYPE","INSURED_AMOUNT"};
        Object[][] data = EntityToArrayUtil.toArray(list, str);
        String[][] result =new String[data.length][str.length];

        for (int j = 0; j < data.length; j++) {
            for (int k = 0; k < str.length; k++) {
                System.out.print(data[j][k]+" ");

                if (data[j][k]!=null){
                    result[j][k]=data[j][k].toString();
                }
            }
            System.out.println();
        }
    }
}
