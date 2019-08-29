package houseprice.constant;

public enum CityEnum {
    CHONGQING("cq", "重庆"),
    SHANGHAI("sh", "上海"),
    CHENGDU("cd", "成都"),
    BEIJING("bj", "北京"),
    CHANGSHA("cs", "长沙"),
    DONGGUAN("dg", "东莞"),
    DALIAN("dl", "大连"),
    FOSHAN("fs", "佛山"),
    GUANGZHOU("gz", "广州"),
    HANGZHOU("hz", "杭州"),
    HEFEI("hf", "合肥"),
    JINAN("jn", "济南"),
    NANJING("nj", "南京"),
    QINGDAO("qd", "青岛"),
    SHENZHEN("sz", "深圳"),
    SUZHOU("su", "苏州"),
    SHENYANG("sy", "沈阳"),
    TIANJIN("tj", "天津"),
    WUHAN("wh", "武汉"),
    XIAMEN("xm", "厦门"),
    YANTAI("yt", "烟台");

    private String code;

    private String name;

    CityEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
