package app.dao;

import app.helper.MyHelper;
import app.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public int createUser(User user){
        int status=0;
        Connection connection = MyHelper.getInstance().getConnection();
        String query = "INSERT INTO user(name,email,phone,city) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getCity());
            status=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }
    public List<User> getAllUser() {
        Connection con=MyHelper.getInstance().getConnection();
        String query="SELECT * FROM user";
        List<User> users=new ArrayList<>();
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {
                User user =new User(rs.getInt("id"),rs.getString("name"),rs.getString("email"),
                        rs.getString("phone"),rs.getString("city"));
                users.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return users;
    }
    public int deleteUser(int id) {
        Connection con = MyHelper.getInstance().getConnection();
        String query = "DELETE FROM user WHERE id=?";
        int status=0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            status=ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }

    public User FindUser(int id) {
        Connection con = MyHelper.getInstance().getConnection();
        String query = "SELECT * FROM user WHERE id=?";
        User user = new User();
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setCity(rs.getString("city"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    public int editUser(User user) {
        Connection con = MyHelper.getInstance().getConnection();
        String query = "UPDATE user SET name=?, email=?, phone=?, city=? WHERE id=?";
        int id = user.getId();
        int status=0;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getCity());
            ps.setInt(5, user.getId());
            status=ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }
}
