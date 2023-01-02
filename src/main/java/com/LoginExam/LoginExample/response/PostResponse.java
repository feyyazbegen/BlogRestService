package com.LoginExam.LoginExample.response;

import com.LoginExam.LoginExample.entity.Post;
import lombok.Data;

@Data
public class PostResponse {

    private Long id;
    private String title;
    private String text;

    public PostResponse(Post entity){
        this.id= entity.getId();
        this.title = entity.getTitle();
        this.text = entity.getText();
    }
}
