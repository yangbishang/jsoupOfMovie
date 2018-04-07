package com.jsoup.pojo;

public class Movie {
    private String title;
    private String miaoshu;
    private String id;
    private String member;
    private String rank;
    private String path;

    public Movie(){

    }

    public Movie(String title, String miaoshu, String id, String member, String rank, String path) {
        this.title = title;
        this.miaoshu = miaoshu;
        this.id = id;
        this.member = member;
        this.rank = rank;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return
                "\n\n电影名：" + title +
                        "\n分数：" + rank +
                        "\n描述：" + miaoshu +
                        "\n演员：" + member +
                        "\n排名：" + id  +
                        "\n路径：" + path;
    }
}
