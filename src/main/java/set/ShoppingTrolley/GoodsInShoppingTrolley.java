package set.ShoppingTrolley;

/**
 * Author:sunlianyu
 * 2021/7/11 19:53
 */
public class GoodsInShoppingTrolley {


    private int price;//价格
    private int quality;//数量
    private String name;//商品的名称
    private String no;//编号

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public long CalculatetheTotalPrice() {
        return (long) this.price * this.quality;
    }
}
