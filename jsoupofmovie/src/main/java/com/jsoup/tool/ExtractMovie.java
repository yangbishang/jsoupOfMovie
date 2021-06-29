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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExtractMovie {
    static List<Movie> listMovie = new ArrayList<Movie>();


    public List<Movie> extractFilm(String vid,String vtitle,String vmember){

        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(5);

        //去掉上次查询存入session的结果
        String url = "";
        for(int i=0;i<10;i++ ){
            url = "https://movie.douban.com/top250?start="+(i*25)+"&filter=";   //https://movie.douban.com/top250?start=0&filter=
            ThreadReceive tr = new ThreadReceive(url,vid,vtitle,vmember, (ArrayList<Movie>) listMovie);
            service.execute(tr);
        }
        //阻止新来的线程
        service.shutdown();
        while(!service.isTerminated()){

        }
        return listMovie;
    }

/*    public static void main(String[] args) {
        ExtractMovie e = new ExtractMovie();
        System.out.println(e.extractFilm("2","",""));
    }*/
}
