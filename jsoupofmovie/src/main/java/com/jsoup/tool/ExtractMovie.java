package com.jsoup.tool;


import com.jsoup.pojo.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExtractMovie {
    static List<Movie> listMovie = new ArrayList<Movie>();


    public List<Movie> extractFilm(String vid,String vtitle,String vmember){



        //去掉上次查询存入session的结果
        String url = "";
        //https://movie.douban.com/top250?start=0&filter=
        for(int i=0;i<10;i++ ){
            url = "https://movie.douban.com/top250?start="+(i*25)+"&filter=";
            try {
                Document doc = Jsoup.connect(url).timeout(5000).get();
                Elements ele = doc.select(".grid_view .item");
                for(Element e : ele){
                    Movie movie = new Movie();
                    //用选择器抓取数据
                    String title = e.select(".hd .title").text();
                    String member = e.select(".bd p").text();
                    String rank = e.select(".star .rating_num").text();
                    String miaoshu = e.select(".quote .inq").text();
                    String id = e.select(".pic em").text();
                    String path = e.select(".pic img").attr("src");

                    if(id.equals(vid)||title.equals(vtitle)||(member.indexOf(vmember)!= -1&&!vmember.equals(""))){

                        //将数据存入javaBean中
                        movie.setId(id);
                        movie.setMember(member);
                        movie.setRank(rank);
                        movie.setTitle(title);
                        movie.setMiaoshu(miaoshu);
                        movie.setPath(path);

                        //将对象存入集合中
                        listMovie.add(movie);
                    }

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listMovie;
    }

/*    public static void main(String[] args) {
        ExtractMovie e = new ExtractMovie();
        System.out.println(e.extractFilm("2","",""));
    }*/
}
