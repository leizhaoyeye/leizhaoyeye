package com.example.zhaolei.suanfa;


import com.example.zhaolei.model.entity.TestAppraisalVm;
import com.example.zhaolei.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Test04 {

    public static void main(String[] args) {
        /*TestAppraisalVm vm = new TestAppraisalVm();
        vm.setClientUnit("晋中市公安局");
        vm.setClientTime("1614768570000");
        vm.setCaseName("*******案");
        vm.setCaseId("A47894651645616");

        vm.setClientName("赵乐际");
        vm.setJob("科员");
        vm.setClientTelephone("13854785247");

        vm.setClientName02("赵减");
        vm.setJob02("科员2");
        vm.setClientTelephone02("1385479999");

        vm.setClientUnitTelephone("99999999999");
        vm.setPostcode("031100");


        vm.setBriefInfomation("9999");
        vm.setSampleInfomation("9999");
        vm.setAppraisalDemand("999");
        vm.setCorpsApprovalOpinion("同意");
        vm.setKjcApprovalOpinion("同意");
        vm.setInspector("赵磊");

        vm.setClientTime("1615390825627");
        vm.setSubmitTime("1615390825627");
        vm.setApprovalTime("1615390825627");
        Map<String, String> map = buildMap(vm);

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key +" :" + value);
        }*/

        /*String i = "014";
        String substring = i.substring(0, 3);
        System.out.println(substring);*/


        String s ="014782";
        String substring = s.substring(0, 3);
        System.out.println(substring);
    }

    public static Map<String, String> buildMap(TestAppraisalVm testAppraisalVm) {
        HashMap<String, String> map = new HashMap<>();
        map.put("client_unit",testAppraisalVm.getClientUnit());
        map.put("ct", DateUtil.stringToDateString(testAppraisalVm.getClientTime()));
        map.put("case_name",testAppraisalVm.getCaseName());
        map.put("c_id",testAppraisalVm.getCaseId());
        map.put("name",testAppraisalVm.getClientName());
        map.put("job",testAppraisalVm.getJob());
        map.put("c_t",testAppraisalVm.getClientTelephone());
        if (StringUtils.isNotEmpty(testAppraisalVm.getClientName02())){
            map.put("name2",testAppraisalVm.getClientName02());
        }else {
            map.put("name2","  ");
        }
        if (StringUtils.isNotEmpty(testAppraisalVm.getJob02())){
            map.put("job2",testAppraisalVm.getJob02());
        }else {
            map.put("job2","  ");
        }
        if (StringUtils.isNotEmpty(testAppraisalVm.getClientTelephone02())){
            map.put("c_t2",testAppraisalVm.getClientTelephone02());
        }else {
            map.put("c_t2","  ");
        }
        map.put("c_un",testAppraisalVm.getClientUnit());
        map.put("pcode",testAppraisalVm.getPostcode());
        map.put("c_u_t",testAppraisalVm.getClientUnitTelephone());
        map.put("brief_infomation",testAppraisalVm.getBriefInfomation());
        map.put("sample_infomation",testAppraisalVm.getSampleInfomation());
        map.put("appraisal_demand",testAppraisalVm.getAppraisalDemand());
        map.put("corps_approval_opinion",testAppraisalVm.getCorpsApprovalOpinion());
        map.put("kjc_approval_opinion",testAppraisalVm.getKjcApprovalOpinion());
        map.put("inspector",testAppraisalVm.getInspector());
        map.put("y1",DateUtil.stringToDateString(testAppraisalVm.getClientTime()).substring(0, 4));
        map.put("m1",DateUtil.stringToDateString(testAppraisalVm.getClientTime()).substring(5, 7));
        map.put("d1",DateUtil.stringToDateString(testAppraisalVm.getClientTime()).substring(8, 10));

        map.put("y2",DateUtil.stringToDateString(testAppraisalVm.getSubmitTime()).substring(0, 4));
        map.put("m2",DateUtil.stringToDateString(testAppraisalVm.getSubmitTime()).substring(5, 7));
        map.put("d2",DateUtil.stringToDateString(testAppraisalVm.getSubmitTime()).substring(8, 10));

        map.put("y3",DateUtil.stringToDateString(testAppraisalVm.getApprovalTime()).substring(0, 4));
        map.put("m3",DateUtil.stringToDateString(testAppraisalVm.getApprovalTime()).substring(5, 7));
        map.put("d3",DateUtil.stringToDateString(testAppraisalVm.getApprovalTime()).substring(8, 10));
        return  map;
    }
}
