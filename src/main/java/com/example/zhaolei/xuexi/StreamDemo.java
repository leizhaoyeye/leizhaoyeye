package com.example.zhaolei.xuexi;




import com.alibaba.fastjson.JSONObject;
import com.example.zhaolei.model.entity.PublicStaffInsuRegisterSaveDTO;
import com.example.zhaolei.model.entity.User;
import com.example.zhaolei.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import sun.plugin.javascript.navig.Array;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream 流
 */

@Slf4j
public class StreamDemo {

    public static List<User> users(){
        List<User> list = Arrays.asList(
                new User(1,"李星云","password"),
                new User(2,"陆林轩","password"),
                new User(3,"姬如雪", "password"),
                new User(4,"袁天罡", "password"),
                new User(5,"张子凡", "password"),
                new User(6,"姬如雪", "password"),
                new User(7,"陆佑劫", "password"),
                new User(8,"姬如雪", "password"),
                new User(9,"张天师", "password"),
                new User(10,"张天师", "password"),
                new User(11,"张天师", "password"),
                new User(12,"陆佑劫", "password"),
                new User(13,"蚩梦", "password"),
                new User(14,"陆佑劫", "password")
        );
        return list;
    }

    @Test
    public void test01() throws JSONException {

        /*String jsonStr = "{\"psnInsuRltsId\":\"14030000000000032161\",\"psnNo\":\"14000000000000000000028193\",\"begnYm\":\"202106\",\"endYm\":\"202112\",\"wag\":\"50000\"}";
        EmpclctWageApplyDTO empclctWageApplyDTO = JSONObject.parseObject(jsonStr, EmpclctWageApplyDTO.class);
        log.info(empclctWageApplyDTO.toString());*/
        /*Date date = new Date();
        SimpleDateFormat s =new SimpleDateFormat("yyyyMMdd");
        String format = s.format(date);
        System.out.println(format);*/
        //




    }

    /**
     * Json  字符串 转  ListM<对象>
     */
    @Test
    public void  test02(){
        String  s = "[{\"brdy\":821030400000,\"certno\":\"140302200006167351\",\"clctWay\":\"02\",\"crtInsuDate\":1624505749080,\"educ\":\"21\",\"email\":\"924634496@qq.com\",\"empFom\":\"1\",\"empInsuDate\":1624291200000,\"empMgtType\":\"01\",\"empName\":\"广东省连平县泥竹塘铁矿\",\"empNo\":\"14000000000000000000017105\",\"fstPatcJobDate\":1609430400000,\"gend\":\"1\",\"hsregAddr\":\"大苏打实打实\",\"liveAddr\":\"\",\"liveAddrPoscode\":\"030024\",\"mob\":\"17835395774\",\"naty\":\"01\",\"optChnl\":\"1\",\"polstas\":\"13\",\"psnCertType\":\"01\",\"psnInsuDate\":1624505749080,\"psnName\":\"徐洋平\",\"psnType\":\"11\",\"publicPsnInsuCDTOS\":[{\"acctCrtnYm\":\"202106\",\"clctRuleTypeCodg\":\"140300310101\",\"clctWay\":\"02\",\"clctstdCrtfRuleCodg\":\"140300310201\",\"crtInsuDate\":1624505749080,\"empFom\":\"1\",\"fstInsuYm\":\"Fri Jan 01 00:00:00 CST 2021\",\"insuAdmdvs\":\"140300\",\"insutype\":\"310\",\"insutypeRetrFlag\":\"0\",\"maxAcctprd\":\"202105\",\"poolareaNo\":\"140300\",\"psnInsuDate\":1609430400000},{\"acctCrtnYm\":\"202106\",\"clctRuleTypeCodg\":\"140300330101\",\"clctWay\":\"02\",\"clctstdCrtfRuleCodg\":\"140300330201\",\"crtInsuDate\":1624505749080,\"empFom\":\"1\",\"fstInsuYm\":\"Fri Jan 01 00:00:00 CST 2021\",\"insuAdmdvs\":\"140300\",\"insutype\":\"330\",\"insutypeRetrFlag\":\"0\",\"maxAcctprd\":\"202105\",\"poolareaNo\":\"140300\",\"psnInsuDate\":1609430400000}],\"resdAddrPoscode\":\"030024\",\"resdNatu\":\"20\",\"wag\":3333.0},{\"brdy\":636739200000,\"certno\":\"140302200006169234\",\"clctWay\":\"02\",\"crtInsuDate\":1624505749080,\"educ\":\"21\",\"email\":\"924633496@qq.com\",\"empFom\":\"1\",\"empInsuDate\":1624291200000,\"empMgtType\":\"01\",\"empName\":\"广东省连平县泥竹塘铁矿\",\"empNo\":\"14000000000000000000017105\",\"fstPatcJobDate\":1609430400000,\"gend\":\"1\",\"hsregAddr\":\"大苏打实打实\",\"liveAddr\":\"\",\"liveAddrPoscode\":\"030024\",\"mob\":\"17835395774\",\"naty\":\"01\",\"optChnl\":\"1\",\"polstas\":\"13\",\"psnCertType\":\"01\",\"psnInsuDate\":1624505749080,\"psnName\":\"贡蓉芬\",\"psnType\":\"11\",\"publicPsnInsuCDTOS\":[{\"acctCrtnYm\":\"202106\",\"clctRuleTypeCodg\":\"140300310101\",\"clctWay\":\"02\",\"clctstdCrtfRuleCodg\":\"140300310201\",\"crtInsuDate\":1624505749080,\"empFom\":\"1\",\"fstInsuYm\":\"Fri Jan 01 00:00:00 CST 2021\",\"insuAdmdvs\":\"140300\",\"insutype\":\"310\",\"insutypeRetrFlag\":\"0\",\"maxAcctprd\":\"202105\",\"poolareaNo\":\"140300\",\"psnInsuDate\":1609430400000},{\"acctCrtnYm\":\"202106\",\"clctRuleTypeCodg\":\"140300330101\",\"clctWay\":\"02\",\"clctstdCrtfRuleCodg\":\"140300330201\",\"crtInsuDate\":1624505749080,\"empFom\":\"1\",\"fstInsuYm\":\"Fri Jan 01 00:00:00 CST 2021\",\"insuAdmdvs\":\"140300\",\"insutype\":\"330\",\"insutypeRetrFlag\":\"0\",\"maxAcctprd\":\"202105\",\"poolareaNo\":\"140300\",\"psnInsuDate\":1609430400000}],\"resdAddrPoscode\":\"030024\",\"resdNatu\":\"20\",\"wag\":3333.0}]";
        System.out.println(123);


        List<PublicStaffInsuRegisterSaveDTO> publicStaffInsuRegisterSaveDTOS = JSONObject.parseArray(s, PublicStaffInsuRegisterSaveDTO.class);

    }

    //  传一个string 字符串 判断 有无重复字母
    public boolean test03(){
        String s ="zhaolei";
        HashSet<Character> strings = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            if (!strings.add(c)){
                return Boolean.FALSE;
            }
        }
        return true ;
    }


    //  Stream流  练习
    @Test
    public void streamDemo(){
        List<User> users = users();
        //一、遍历/匹配（foreach）
        //users.stream().filter(user -> user.getId()>5).forEach(System.out::println);
        // anyMatch表示，判断的条件里，任意一个元素成功，返回true   就是只要有一个大于等于5
        boolean b = users.stream().anyMatch(user -> user.getId() >= 5);
        System.out.println(b);
        //  allMatch表示，判断条件里的元素，所有的都是，返回true   就是所有都大于等于0
        boolean b1 = users.stream().allMatch(user -> user.getId() >= 0);
        System.out.println(b1);
        // noneMatch跟allMatch相反，判断条件里的元素，所有的都不是，返回true
        boolean b2 = users.stream().noneMatch(user -> user.getId() > 5);
        System.out.println(b2);


        //find
/*
        User user2 = users.stream().filter(user -> user.getId() == 5).findFirst().get();
        User user = first.get();
        System.out.println(user);*/

/*        User user = users.parallelStream().filter(user1 -> user1.getId() > 6).findAny().get();
        User user = users.parallelStream().filter(user1 -> user1.getId() > 6).findAny().orElse(null);
        User user1 = any.get();
        System.out.println(user1);*/


        // 筛选条件 形成新的集合
        List<User> collect = users.stream().filter(user -> "姬如雪".equals(user.getUserName())).collect(Collectors.toList());
        for (User user : collect) {
            System.out.println(user);
        }

/*        User user1 = users.stream().max(Comparator.comparing(user -> user.getId())).get();
        System.out.println(user1);*/

/*        User user1 = users.stream().min(Comparator.comparing(user -> user.getId())).get();
        System.out.println(user1);*/


        long count = users.stream().filter(user -> user.getId() > 4).count();
        System.out.println(count);


        //  map

        List<User> collect1 = users.stream().map(user -> user.setId(10)).collect(Collectors.toList());
        for (User user : collect1) {
            System.out.println(user);
        }

        // flatMap   将流中的流合并
        List<Integer> collect2 = users.stream().map(User::getId).collect(Collectors.toList());

        List<User> users1 = users();

        List<User> collect3 = users.stream().filter(users1::contains).collect(Collectors.toList());

        for (User user : collect3) {
            System.out.println(user);
        }


        System.out.println("-------------分-------------割-------------线-------------");


        List<Integer> list = Arrays.asList(1, 10, 2, 8, 11, 42);

        Integer integer = list.stream().reduce((x, y) -> x + y).orElse(null);
        System.out.println("求和1 ："+integer);
        Integer integer1 = list.stream().reduce(Integer::sum).orElse(null);
        System.out.println("求和2 ："+integer1);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);
        System.out.println("求和3 ："+sum3);


        // 求乘积
        Integer integer2 = list.stream().reduce((x, y) -> x * y).get();
        System.out.println("乘积 ："+integer2);

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        System.out.println("求最大值方式1 ："+max);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);
        System.out.println("求最大值写法2 ："+max2);


        List<Integer> collect4 = list.stream().collect(Collectors.toList());
        Set<Integer> collect5 = list.stream().collect(Collectors.toSet());

        List<User> users2 = users();
        Map<Integer, String> collect6 = users2.stream().collect(Collectors.toMap(User::getId, User::getUserName));
        Set<Integer> integers = collect6.keySet();
        for (Integer integer3 : integers) {
            String s = collect6.get(integer3);
            System.out.println("key:"+integer3 +"value:"+s);
        }



        List<User> users3 = users();
        // 将id资是否高于5分组
        Map<Boolean, List<User>> collect7 = users3.stream().collect(Collectors.partitioningBy(user -> user.getId() > 5));
        System.out.println(collect7);
        // 按 姓名分组
        Map<String, List<User>> collect8 = users3.stream().collect(Collectors.groupingBy(User::getUserName));
        System.out.println(collect8);


        List<User> users4 = users();


        List<User> collect9 = users4.stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());


    }

}
