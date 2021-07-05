package com.example.zhaolei.model.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuan
 * @since 2020-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Poem extends Model<Poem> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String dynasty;

    private String author;

    private String content;

    private String category;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
