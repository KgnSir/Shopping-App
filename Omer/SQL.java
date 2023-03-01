package Omer;

import java.sql.*;
import java.util.*;


public class SQL
{
    public static boolean IsConnected(Connection con) // Tamamlandı
    {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException ignored) {}
    
        return false;
    }
    public static String[] ListDatabase(Statement stmt) //Tamamlandı
    {
        try 
        {
            List<String> dblistesi = new ArrayList<String>();
            ResultSet rs = stmt.executeQuery("SELECT datname FROM pg_database;"); //Veritaban isimler listeleme kodu
            while(rs.next()) 
            {
                dblistesi.add(rs.getString(1));
            }
            return dblistesi.toArray(new String[0]);
        } catch (Exception e) 
        {
            MessageBox.Show(e.getMessage());
            return null;
        }
    }
    public static void ListTable(Statement stmt) // Tamamlandı
    {
        //SELECT tablename FROM pg_catalog. pg_tables WHERE schemaname = 'public'
        try {
            ResultSet rs = stmt.executeQuery("SELECT tablename FROM pg_catalog. pg_tables WHERE schemaname = 'public'");
            while(rs.next()) 
            {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            MessageBox.Show(e);
        }
    }
    public static String[] ListTableStr(Statement stmt) // Devam ediyor..
    {
        try {
            ResultSet rs = stmt.executeQuery("SELECT tablename FROM pg_catalog. pg_tables WHERE schemaname = 'public'");
            List<String> tablolar = new ArrayList<String>();
            while(rs.next()) 
            {
                tablolar.add(rs.getString(1));
            }
            return tablolar.toArray(new String[0]);
        } catch (Exception e) {
            MessageBox.Show(e);
            return null;
        } 
    }
    public static boolean FindTable(Statement stmt, String Tabloİsim) // Denemedim
    {
        Boolean TabloVarmi = false;
        String[] tablolar = SQL.ListTableStr(stmt);
        if (tablolar.length != 0)
        {
            for (int i=0;i<tablolar.length;i++)
                TabloVarmi = tablolar[i].equals(Tabloİsim.toLowerCase()) ? true : TabloVarmi;
        }
        return TabloVarmi;
    }
    public static void UseDatabase(Connection con, String DatabaseName) // Denemedim
    {
        try 
        {
            //con.setCatalog(DatabaseName);
            con.setSchema(DatabaseName);
        } catch (Exception e) 
        {
            MessageBox.Show(e);
        }
    }
    public static String GetDatabase(Connection con)
    {
        try 
        {
            return con.getCatalog();
        } catch (Exception e) {
            return null;
        }
    }
    public static int GetCountOfRows(Statement stmt, String TableName)
    {
        try 
        {
            /*SELECT 
            COUNT(*) 
            FROM 
            musteri */
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM "+ TableName);
            return rs.getInt(1);
        } catch (Exception e) {
            return 0;   
        }
    }
}
