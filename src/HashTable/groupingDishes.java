package HashTable;

import java.util.*;

/**
 * @ClassName:HashTables
 * @Auther: yyj
 * @Description:
 * @Date: 17/10/2022 11:37
 * @Version: v1.0
 */
public class groupingDishes {
//   new String[][]{
//        {"Salad", "Tomato", "Cucumber", "Salad", "Sauce"}
//                ,{"Pizza", "Tomato", "Sausage", "Sauce", "Dough"}
//                ,{"Quesadilla", "Chicken", "Cheese", "Sauce"}
//                ,{"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}
//    };
    String[][] solution(String[][] dishes) {
        HashMap<String, List<String>> ingredients_food = new HashMap<>();
        for(String[] dishe : dishes){
            String name = dishe[0];
            for(int i = 1;i<dishe.length;i++){
                List<String> list = ingredients_food.getOrDefault(dishe[i], new ArrayList<>());
                list.add(name);
                ingredients_food.put(dishe[i], list);
            }
        }
        TreeMap<String, List<String>> treemap = new TreeMap<>(ingredients_food);
        List<List<String>> ansList= new ArrayList<>();
        for(String key: treemap.keySet()){
            if(treemap.get(key).size()>=2){
                List<String> subList= treemap.get(key);
                Collections.sort(subList);
                subList.add(0,key);
                ansList.add(subList);
            }
        }
        String[][] ans = new String[ansList.size()][];
        for(int i = 0;i < ansList.size() ; i++){
            List<String> row = ansList.get(i);
            ans[i] = row.toArray(new String[row.size()]);
        }
        return ans;
    }


}
