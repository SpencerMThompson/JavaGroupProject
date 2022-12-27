/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author SMTan
 */
public class Post implements Serializable{
    private Integer PostID;
    private String Username;
    private String Post;
    private LocalDateTime Time;
    private ArrayList<Comments> Comments;

    public Post() {
    }

    public Post(Integer PostID, String Username, String Post, ArrayList<Comments> Comments, LocalDateTime Time) {
        this.PostID = PostID;
        this.Username = Username;
        this.Post = Post;
        this.Comments = Comments;
        this.Time = Time;
    }

    public Integer getPostID() {
        return PostID;
    }

    public void setPostID(Integer PostID) {
        this.PostID = PostID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String Post) {
        this.Post = Post;
    }

    public ArrayList<Comments> getComments() {
        return Comments;
    }

    public void setComments(ArrayList<Comments> Comments) {
        this.Comments = Comments;
    }

    public LocalDateTime getTime() {
        return Time;
    }

    public void setTime(LocalDateTime Time) {
        this.Time = Time;
    }
    
}
