package set.ShoppingTrolley;

import java.util.Iterator;

/**
 * Author:sunlianyu
 * 2021/7/11 20:11
 * 作业：完成购物车功能：购物车的含义是如果添加的是同类商品，
 * 那么使其该商品的数量加1，否则，添加一种新商品。
 * 要求使用ArrayList来完成该实例
 * <p>
 * 不是应该使用map么？
 */
public class ShoppingMain {
    public static void main(String[] args) {

        GoodsInShoppingTrolley agood = new GoodsInShoppingTrolley();
        ShoppingTrolley car = new ShoppingTrolley();
        int quality = 0;
        agood.setName("炸鸡");
        agood.setQuality(5);
        agood.setPrice(10);
        agood.setNo("153453");
        quality = agood.getQuality();
        buy(agood, car,quality);
        buy(agood, car,quality);
        buy(agood, car,quality);
        buy(agood, car,quality);


        GoodsInShoppingTrolley bgood = new GoodsInShoppingTrolley();
        bgood.setName("牛奶");
        bgood.setQuality(5);
        bgood.setPrice(5);
        bgood.setNo("1345");
        quality = bgood.getQuality();
        buy(bgood, car,quality);
        buy(bgood, car,quality);
        System.out.println(agood.getQuality());

        System.out.println(car.getList().size());
    }

    //用迭代器来完成ArrayList 的遍历
    public static void buy(GoodsInShoppingTrolley agood, ShoppingTrolley car,int quality) {

        boolean flag = false;//标志该商品在购物车里是否存在 存在为True 不存在为False
        Iterator<GoodsInShoppingTrolley> it = car.getList().iterator();

        while (it.hasNext()) {
            GoodsInShoppingTrolley abgood = it.next();
//            System.out.println(abgood.getNo()+"*******"+agood.getNo());
            if (abgood.getNo().equals(agood.getNo())) {
                flag = true;
                agood.setQuality(quality+ agood.getQuality());
                System.out.println(agood.getNo() + "号商品已存在与购物车！已自动为您增加了数量" + "现在共" + abgood.getQuality() + "件");

            }
        }

        if (!flag) {
            car.getList().add(agood);
            System.out.println(agood.getNo() + "号商品" + "已购买成功" + agood.getQuality() + "件");
        }

        System.out.println();
    }
}
