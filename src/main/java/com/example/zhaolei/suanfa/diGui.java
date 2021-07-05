package com.example.zhaolei.suanfa;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.zhaolei.model.entity.LogisticsUploadModel;
import com.example.zhaolei.model.entity.myTreeModel;

import java.util.List;

public class diGui {

    public static void main(String[] args) {
        String s = "[\n" +
                "        {\n" +
                "            \"id\": \"0beaef0d237542e3a5b59b23185ac224\",\n" +
                "            \"name\": \"新目录\",\n" +
                "            \"pId\": \"2410\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2165\",\n" +
                "            \"name\": \"初始化根目录请自行改名\",\n" +
                "            \"pId\": \"-1\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2199\",\n" +
                "            \"name\": \"普通目录\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 1,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2269\",\n" +
                "            \"name\": \"0302\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 2,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2271\",\n" +
                "            \"name\": \"0301\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 3,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2307\",\n" +
                "            \"name\": \"0306\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 4,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2315\",\n" +
                "            \"name\": \"关联用\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 5,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2321\",\n" +
                "            \"name\": \"kk\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 6,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2366\",\n" +
                "            \"name\": \"子目录\",\n" +
                "            \"pId\": \"2321\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2410\",\n" +
                "            \"name\": \"就\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 7,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2422\",\n" +
                "            \"name\": \"20200601test\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 8,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2436\",\n" +
                "            \"name\": \"55\",\n" +
                "            \"pId\": \"2321\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2437\",\n" +
                "            \"name\": \"test\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 9,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2450\",\n" +
                "            \"name\": \"test\",\n" +
                "            \"pId\": \"2437\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2453\",\n" +
                "            \"name\": \"test1\",\n" +
                "            \"pId\": \"2437\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2455\",\n" +
                "            \"name\": \"123\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 11,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2457\",\n" +
                "            \"name\": \"0812\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 12,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2480\",\n" +
                "            \"name\": \"z123\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 13,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2509\",\n" +
                "            \"name\": \"冒烟测试\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 14,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2528\",\n" +
                "            \"name\": \"文件\",\n" +
                "            \"pId\": \"2321\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2559\",\n" +
                "            \"name\": \"test\",\n" +
                "            \"pId\": \"2455\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2563\",\n" +
                "            \"name\": \"z\",\n" +
                "            \"pId\": \"2455\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2564\",\n" +
                "            \"name\": \"zatt\",\n" +
                "            \"pId\": \"2455\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2565\",\n" +
                "            \"name\": \"a\",\n" +
                "            \"pId\": \"2455\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2566\",\n" +
                "            \"name\": \"c\",\n" +
                "            \"pId\": \"2455\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2595\",\n" +
                "            \"name\": \"冒烟测试0115\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 15,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2596\",\n" +
                "            \"name\": \"测试文件上传\",\n" +
                "            \"pId\": \"2595\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2626\",\n" +
                "            \"name\": \"1\",\n" +
                "            \"pId\": \"2455\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2651\",\n" +
                "            \"name\": \"上传文件白名单0407上线\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 16,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2680\",\n" +
                "            \"name\": \"新建目录1\",\n" +
                "            \"pId\": \"2165\",\n" +
                "            \"sort\": 17,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2772\",\n" +
                "            \"name\": \"回收站\",\n" +
                "            \"pId\": \"-1\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"34aa9e4d278b4d2cbc668cba2e6241e4\",\n" +
                "            \"name\": \"AAA\",\n" +
                "            \"pId\": \"\",\n" +
                "            \"sort\": 10,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"3728353b64884dcc8d8c3167f808692b\",\n" +
                "            \"name\": \"aaa\",\n" +
                "            \"pId\": \"2199\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"7b10b2f16329442aadf9b575fe59ebfe\",\n" +
                "            \"name\": \"123\",\n" +
                "            \"pId\": \"2457\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"90cdd26facbe40f99f4d26a8e9ccf1ea\",\n" +
                "            \"name\": \"新目录\",\n" +
                "            \"pId\": \"2480\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"cc265bd6672f4a2db52fe0f81c2fcd81\",\n" +
                "            \"name\": \"新目录\",\n" +
                "            \"pId\": \"90cdd26facbe40f99f4d26a8e9ccf1ea\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"e3fd7e9f92d9402ca169c597b35d32a7\",\n" +
                "            \"name\": \"新目录234\",\n" +
                "            \"pId\": \"2680\",\n" +
                "            \"sort\": null,\n" +
                "            \"recycle\": null,\n" +
                "            \"rdDocumentDtos\": null,\n" +
                "            \"children\": null,\n" +
                "            \"flag\": null,\n" +
                "            \"projectId\": null\n" +
                "        }\n" +
                "    ]";

        List<myTreeModel> list = JSONArray.parseArray(s, myTreeModel.class);

        for (myTreeModel myTreeModel : list) {

        }


    }
}
