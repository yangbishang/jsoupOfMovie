package com.jsoup.tool;

import com.jsoup.pojo.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadReceive implements Runnable{
    private String url;
    private String vid;
    private String vtitle;
    private String vmember;
    private ArrayList<Movie> list;

    //构造
    public ThreadReceive(){
    }
    public ThreadReceive(String url, String vid, String vtitle, String vmember, ArrayList<Movie> list) {
        this.url = url;
        this.vid = vid;
        this.vtitle = vtitle;
        this.vmember = vmember;
        this.list = list;
    }


    public void run() {
        //锁
        Lock lock = new ReentrantLock();

        try {
                Document doc = Jsoup.connect(url).timeout(5000).get();
                Elements ele = doc.select(".grid_view .item");

                lock.lock();
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
                        list.add(movie);
                    }

                }
                lock.unlock();

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
