package org.wuzhe.tysfhelper.pojo;

import org.wuzhe.tysfhelper.utils.GsonUtils;

import java.util.List;

public class Data<T> {
    private Long total;
    private List<T> rows;

    public Data(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    public  String toJson(){
        return GsonUtils.getJsonStr(this);
    }
}
