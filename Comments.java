/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author SMTan
 */
public class Comments implements Serializable{
    private Integer CommentID;
    private Integer PostID;
    private String UserName;
    private String Comment;
    private LocalDateTime Time;

    public Comments() {
    }

    public Comments(Integer CommentID, Integer PostID, String UserName, String Comment, LocalDateTime Time) {
        this.CommentID = CommentID;
        this.PostID = PostID;
        this.UserName = UserName;
        this.Comment = Comment;
        this.Time = Time;
    }

    public Integer getCommentID() {
        return CommentID;
    }

    public void setCommentID(Integer CommentID) {
        this.CommentID = CommentID;
    }

    public Integer getPostID() {
        return PostID;
    }

    public void setPostID(Integer PostID) {
        this.PostID = PostID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public LocalDateTime getTime() {
        return Time;
    }

    public void setTime(LocalDateTime Time) {
        this.Time = Time;
    }
    
}
