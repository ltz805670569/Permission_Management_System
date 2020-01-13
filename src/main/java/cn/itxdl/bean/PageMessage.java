package cn.itxdl.bean;

import java.io.Serializable;
import java.util.Objects;

public class PageMessage implements Serializable {
    private static final long serialVersionUID = -1060299985810498612L;
    private int pageNum;
    private int pages;
    private int pageSize;
    private int pagePre;
    private int pageNext;

    public PageMessage() {
    }

    public PageMessage(int pageNum, int pages, int pageSize, int pagePre, int pageNext) {
        this.pageNum = pageNum;
        this.pages = pages;
        this.pageSize = pageSize;
        this.pagePre = pagePre;
        this.pageNext = pageNext;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPagePre() {
        return pagePre;
    }

    public void setPagePre(int pagePre) {
        this.pagePre = pagePre;
    }

    public int getPageNext() {
        return pageNext;
    }

    public void setPageNext(int pageNext) {
        this.pageNext = pageNext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageMessage that = (PageMessage) o;
        return pageNum == that.pageNum &&
                pages == that.pages &&
                pageSize == that.pageSize &&
                pagePre == that.pagePre &&
                pageNext == that.pageNext;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNum, pages, pageSize, pagePre, pageNext);
    }

    @Override
    public String toString() {
        return "PageMessage{" +
                "pageNum=" + pageNum +
                ", pages=" + pages +
                ", pageSize=" + pageSize +
                ", pagePre=" + pagePre +
                ", pageNext=" + pageNext +
                '}';
    }
}
