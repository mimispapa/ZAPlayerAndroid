package com.cn.zaplayer.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VideoListBean implements Serializable {
    @SerializedName("list")
    private ListBean listBean;

    public ListBean getListBean() {
        return listBean;
    }

    public void setListBean(ListBean listBean) {
        this.listBean = listBean;
    }

    public static class ListBean implements Serializable{
        @SerializedName("video")
        private List<Video> videos;

        @SerializedName("@pagecount")
        private int pageCount;

        @SerializedName("@pagesize")
        private int pageSize;

        @SerializedName("@recordcount")
        private int recordCount;


        public List<Video> getVideos() {
            return videos;
        }

        public void setVideos(List<Video> videos) {
            this.videos = videos;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getRecordCount() {
            return recordCount;
        }

        public void setRecordCount(int recordCount) {
            this.recordCount = recordCount;
        }
    }

    public static class Video implements Serializable{
        private String last;

        private String name;
        private String pic;

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }

//       <video>
//            <last>2018-04-28 16:16:09</last>
//            <id>26</id>
//            <tid>8</tid>
//            <name>
//                <![CDATA[钢铁骑士]]>
//            </name>
//            <type>科幻片</type>
//            <pic>https://tu.tianzuida.com/pic/upload/vod/2017-03-12/14892775540.jpg</pic>
//            <lang>英语</lang>
//            <area>美国</area>
//            <year>2016</year>
//            <state>0</state>
//            <note>
//                <![CDATA[BD1280高清中字版]]>
//            </note>
//            <actor>
//                <![CDATA[本·温切尔/玛丽亚·贝罗/乔什·布雷纳/]]>
//            </actor>
//            <director>
//                <![CDATA[斯特瓦特·亨德尔]]>
//            </director>
//            <dl>
//                <dd flag="zuidam3u8">
//                    <![CDATA[BD1280高清中字版$http://leshi.cdn-zuyida.com/20170910/3pJxFU9o/index.m3u8]]>
//                </dd>
//                <dd flag="zuidall">
//                    <![CDATA[BD1280高清中字版$http://leshi.cdn-zuyida.com/share/mz6BtSUQ1Nqj05JK]]>
//                </dd>
//            </dl>
//            <des>
//                <![CDATA[“钢铁骑士”曾是一款风行全球的男孩人偶玩具，也曾被拍成电视系列动画片，此次真人电影版的故事是《雷神2：黑暗世界》的编剧Christopher Yost原创的。故事讲述16岁男孩Max（本·温切尔 饰）和母亲居住在一个小镇上，他的科学家父亲当年在他出生后不久就神秘死亡了。Max拥有一种他自己都无法控制的超强能量，直到他遇到有着先进技术的外星人...简介：“钢铁骑士”曾是一款风行全球的男孩人偶玩具，也曾被拍成电视系列动画片，此次真人电影版的故事是《雷神2：黑暗世界》的编剧Christopher Yost原创的。故事讲述16岁男孩Max（本·温切尔 饰）和母亲居住在一个小镇上，他的科学家父亲当年在他出生后不久就神秘死亡了。Max拥有一种他自己都无法控制的超强能量，直到他遇到有着先进技术的外星人Steel（乔什·布雷纳 配音）后，Max才学会运用它，“钢铁骑士”就此诞生！]]>
//            </des>
//        </video>
}
