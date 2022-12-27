///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package data;
//
//import business.User;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.LinkedHashMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author SMTan
// */
//public class UserDA {
//
//    private static final Logger LOG = Logger.getLogger(UserDA.class.getName());
//
//    public static int insert(User user) throws SQLException {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//
//        String query
//                = "INSERT INTO Userinfo (username, password, birthdate, LastName, status) "
//                + "VALUES (?, ?, ?, ?, ?, ?)";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, user.getUsername());
//            ps.setString(2, user.getPassword());
//            ps.setDate(3, Date.valueOf(user.getDateOfBirth()));
//            ps.setString(4, user.getEmail());
//            ps.setString(5, user.getStatus());
//            return ps.executeUpdate();
//
//        } catch (SQLException e) {
//            LOG.log(Level.SEVERE, "*** insert sql", e);
//            throw e;
//        } finally {
//            try {
//                ps.close();
//                pool.freeConnection(connection);
//            } catch (Exception e) {
//                LOG.log(Level.SEVERE, "*** insert null pointer?", e);
//                throw e;
//            }
//        }
//    }
//
//    public static int update(User user) throws SQLException {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//
//        String query = "UPDATE User SET "
//                + "Email = ?, "
//                + "Password = ? "
//                + "Status = ?"
//                + "WHERE UserName = ?";
//        try {
//            ps = connection.prepareStatement(query);
//            ps.setString(1, user.getEmail());
//            ps.setString(2, user.getPassword());
//            ps.setString(3, user.getStatus());
//            ps.setString(4, user.getUsername());
//
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            LOG.log(Level.SEVERE, "*** update sql", e);
//            throw e;
//        } finally {
//            try{
//                ps.close();
//                pool.freeConnection(connection);
//            }catch (Exception e){
//                LOG.log(Level.SEVERE, "*** update null pointer", e);
//                throw e;
//            }
//        }
//    }
//
//    public static LinkedHashMap<Integer, User> selectAll() throws SQLException {
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection connection = pool.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        String query = "SELECT * FROM Userinfo";
//        try {
//            ps = connection.prepareStatement(query);
//
//            rs = ps.executeQuery();
//            User user = null;
//            LinkedHashMap<Integer, User> users = new LinkedHashMap();
//
//            while (rs.next()) {
//                String username = rs.getString("UserName");
//                String email = rs.getString("Email");
//                String password = rs.getString("Password");
//                String status = rs.getString("Status");
//                LocalDate birthDate = rs.getDate("BirthDate").toLocalDate();
//                int userID = rs.getInt("UserID");
//                user = new User(username, password, birthDate, email, status, userID);
//                users.put(user.getUserID(), user
//                );
//            }
//            return users;
//        } catch (SQLException e) {
//            LOG.log(Level.SEVERE, "*** select all sql", e);
//            throw e;
//        } finally {
//            try {
//                rs.close();
//                ps.close();
//                pool.freeConnection(connection);
//            } catch (Exception e) {
//                LOG.log(Level.SEVERE, "*** select all null pointer?", e);
//                throw e;
//            }
//        }
//    }
//}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Comments;
import business.Post;
import business.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SMTan
 */
public class UserDA {

    private static final Logger LOG = Logger.getLogger(UserDA.class.getName());

    public static int insert(User user) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Userinfo (username, password, birthdate, Email, status) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setDate(3, Date.valueOf(user.getDateOfBirth()));
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getStatus());
            return ps.executeUpdate();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** insert sql", e);
            throw e;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** insert null pointer?", e);
                throw e;
            }
        }
    }
    
    public static int insert(Post post) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Posts (username, post, date) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, post.getUsername());
            ps.setString(2, post.getPost());
            ps.setTime(3, Time.valueOf(post.getTime().toString()));
            return ps.executeUpdate();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** insert sql", e);
            throw e;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** insert null pointer?", e);
                throw e;
            }
        }
    }
    
    public static int insert(Comments comment) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Comments (postid, username, comment, date) "
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, comment.getPostID() );
            ps.setString(2, comment.getUserName() );
            ps.setString(3, comment.getComment());
            ps.setTime(4, Time.valueOf(comment.getTime().toString()));
            return ps.executeUpdate();

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** insert sql", e);
            throw e;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** insert null pointer?", e);
                throw e;
            }
        }
    }

    public static int update(User user) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE Userinfo SET "
                + "Email = ?, "
                + "Password = ?, "
                + "Status = ? "
                + "WHERE Username = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getStatus());
            ps.setString(4, user.getUsername());

            return ps.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** update sql", e);
            throw e;
        } finally {
            try {
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** update null pointer", e);
                throw e;
            }
        }
    }

    // change the Linked hashmap to a String instead of Integer
    public static LinkedHashMap<String, User> selectAll() throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Userinfo";
        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            User user = null;
            //also change it here
            LinkedHashMap<String, User> users = new LinkedHashMap();

            while (rs.next()) {
                String username = rs.getString("UserName");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                String status = rs.getString("Status");
                LocalDate birthDate = rs.getDate("BirthDate").toLocalDate();
                int userID = rs.getInt("UserKey");
                user = new User(username, password, birthDate, email, status, userID);
                // change this to user.getUsername()
                users.put(user.getUsername(), user
                );
            }
            return users;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** select all sql", e);
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** select all null pointer?", e);
                throw e;
            }
        }
    }

    public static int selectUser(User user) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "Select * FROM Userinfo "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());

            rs = ps.executeQuery();

            return ps.executeUpdate();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** selectUser sql", e);
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** selectUser null pointer?", e);
                throw e;
            }
            return 1;
        }
    }
    
    public static LinkedHashMap<Integer, Post> selectOtherUsersPost(String UserName) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Posts "
                + "Where username = ? "
                + "Order By Date asc "
                + "limit 5";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, UserName);
            rs = ps.executeQuery();
            Post returnedPost = null;
            //also change it here
            LinkedHashMap<Integer, Post> posts = new LinkedHashMap();

            while (rs.next()) {
                String username = rs.getString("UserName");
                String post = rs.getString("Post");
                LocalDateTime time = rs.getTimestamp("Date").toLocalDateTime();
                int postID = rs.getInt("PostID");
                
                ArrayList<Comments> comments = new ArrayList<Comments>();
                
                returnedPost = new Post(postID, username, post, comments, time);
                // change this to user.getUsername()
                posts.put(returnedPost.getPostID(), returnedPost);
            }
            return posts;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "*** select all sql", e);
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
                pool.freeConnection(connection);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "*** select all null pointer?", e);
                throw e;
            }
        }
    }
}
