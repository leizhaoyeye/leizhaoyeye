package com.example.zhaolei.model.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class myTreeModel {

    private String id;
    private String name;
    private String pId;
    private String sort;
    private String recycle;
    private String rdDocumentDtos;
    private String children;
    private String flag;
    private String projectId;
    private String pIds;

    public myTreeModel() {
    }

    public myTreeModel(String id, String name, String pId, String sort, String recycle, String rdDocumentDtos, String children, String flag, String projectId, String pIds) {
        this.id = id;
        this.name = name;
        this.pId = pId;
        this.sort = sort;
        this.recycle = recycle;
        this.rdDocumentDtos = rdDocumentDtos;
        this.children = children;
        this.flag = flag;
        this.projectId = projectId;
        this.pIds = pIds;
    }
}
