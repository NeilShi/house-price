package houseprice.nonentity.vo;

public class CommunityInfoVo {
    private int year;
    private int month;
    private String city;
    private String district;
    private String area;
    private String name;
    private String price;
    private String on_sale;

    public CommunityInfoVo(int year, int month, String city, String district, String area,
                           String name, String price, String on_sale) {
        this.year = year;
        this.month = month;
        this.city = city;
        this.district = district;
        this.area = area;
        this.name = name;
        this.price = price;
        this.on_sale = on_sale;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOn_sale() {
        return on_sale;
    }

    public void setOn_sale(String on_sale) {
        this.on_sale = on_sale;
    }
}
