<%@page import="java.sql.DriverManager"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url = "jdbc:oracle:thin:@qclass.iptime.org:1521:xe";
	String user = "bigmaster03_semi";
	String password = "semi";
	Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	String sql;
	try{
		Class.forName("oracle.jdbc.driver.oracledriver");
		System.out.println("DB접속");
		con = DriverManager.getConnection(url, user, password);
		stmt = con.createStatement();
		sql = "SELECT * FROM RECIPE";
		res = stmt.executeQuery(sql);
		System.out.println(sql);
		JSONArray arr = new JSONArray();
		while(res.next()){
			int recipe_no = res.getInt(1);
			String recipe_main_photo = URLEncoder.encode(res.getString(2),"UTF-8");
			String member_id = URLEncoder.encode(res.getString(3),"UTF-8");
			String recipe_title = URLEncoder.encode(res.getString(4),"UTF-8");
			String recipe_photo = URLEncoder.encode(res.getString(5),"UTF-8");
			String recipe_detail = URLEncoder.encode(res.getString(6),"UTF-8");
			Date recipe_regdate = res.getDate(7);
			String recipe_material_one = URLEncoder.encode(res.getString(8),"UTF-8");
			int cate_theme = res.getInt(9);
			int cate_kind = res.getInt(10);
			String recipe_material = URLEncoder.encode(res.getString(11),"UTF-8");
			int recipe_likecount = res.getInt(12);
			
			JSONObject obj = new JSONObject();
			
			obj.put("recipe_no",recipe_no);
			obj.put("recipe_main_photo",recipe_main_photo);
			obj.put("member_id",member_id);
			obj.put("recipe_title",recipe_title);
			obj.put("recipe_photo",recipe_photo);
			obj.put("recipe_detail",recipe_detail);
			obj.put("recipe_regdate",recipe_regdate);
			obj.put("recipe_material_one",recipe_material_one);
			obj.put("cate_theme",cate_theme);
			obj.put("cate_kind",cate_kind);
			obj.put("recipe_material",recipe_material);
			obj.put("recipe_likecount",recipe_likecount);
			if(obj != null){
				arr.put(obj);
			}
			System.out.print(arr);
		}
	}catch(Exception e){
		System.out.println(e);
	}finally{
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>