package dbtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class db {
	 public static void main(String[] args) {
	        
		 	//JSONParser(변환)과 json 값을 담아줄 JSONObject, JSONArray로 변환해줄 변수 선언
	        JSONParser json;
	        JSONObject jsonObj = new JSONObject();
	        JSONObject finalJsonObj1 = new JSONObject();
	        JSONArray jsonarr = null;
	        
	        //db에 연결할 변수 선언
	        Connection conn = null;
	        
	        //SQL구문을 미리 준비해주는 PreparedStatement 선언
	        PreparedStatement pstmt= null;
	        
	        //OracleDriver 선언
	        String driver = "oracle.jdbc.driver.OracleDriver";
	        
	        //DB URL 선언
	        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	        
	        // DB 로그인 설정값 
            String dbId = "kh";
            String dbPw = "kh";
            
            //sql구문
	        String sql = "INSERT INTO RECIPE VALUES(?, ?, ?, ?, ?, ?, TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?, ?, 0)";
	        
	        //json파일 경로 지정(프로젝트 상단에 있는 test.json)
	        String filePath = "./test.json";
	        try {
	        	 //파일 경로 잡기
	        	FileInputStream fileStream = new FileInputStream(filePath);
	                        
	            // 버퍼 선언(파일 내용을 하나하나씩 잡아옴)
	            byte[] readbuffer = new byte[fileStream.available()];
	            
	            //파일내용을 끝까지 다 읽지않았을때(내용이 비어있기 전 까지 계속실행)
	            while(fileStream.read(readbuffer) != -1){}
	            
	            //버퍼를 String으로 변환
	            String str = new String(readbuffer);
	            
	            json = new JSONParser();
	            
	            //변환한 버퍼를 다시 JSON 객체로 변환
	            jsonObj = (JSONObject) json.parse(str);
	            
	            //DATA를 찾아서 값을 배열로 변환
	            jsonarr = (JSONArray) jsonObj.get("DATA");
	            
	            //드라이버 설정
	            Class.forName(driver);
	            System.out.println("드라이버 연동 선공");
	            
	            // DB 연결
	            conn = DriverManager.getConnection(url, dbId, dbPw);
	            
	            // 구문 실행
	            pstmt = conn.prepareStatement(sql);   
	            
	            //파일 
	            for(int i=0; i < jsonarr.size(); i++) {
	            	System.out.println(jsonarr.get(i));
	                finalJsonObj1 = (JSONObject) jsonarr.get(i);
	                // MOVIES 테이블에 들어갈 값 선언
	                pstmt.setLong(1, (Long) finalJsonObj1.get("recipe_no"));
	                pstmt.setString(2, (String) finalJsonObj1.get("recipe_main_photo"));
	                pstmt.setString(3, (String) finalJsonObj1.get("member_id"));
	                pstmt.setString(4, (String) finalJsonObj1.get("recipe_title"));
	                pstmt.setString(5, (String) finalJsonObj1.get("recipe_photo"));
	                pstmt.setString(6, (String) finalJsonObj1.get("recipe_detail"));
	                pstmt.setString(7, (String) finalJsonObj1.get("recipe_regdate"));
	                pstmt.setString(8, (String) finalJsonObj1.get("recipe_material_one"));
	                pstmt.setString(9, (String) finalJsonObj1.get("cate_theme"));
	                pstmt.setString(10, (String) finalJsonObj1.get("cate_kind"));
	                pstmt.setString(11, (String) finalJsonObj1.get("recipe_material"));
	                // 쿼리 실행
	                pstmt.executeUpdate();
	            }
	            
	            // 쿼리 종료
	            pstmt.close();
	            conn.close();
	        // 상세 오류 확인
	        } catch(ClassNotFoundException e) {
	            e.getStackTrace(); 
	        } catch(SQLException e1) {
	            e1.getStackTrace();
	        } catch(FileNotFoundException e2) {
	            e2.getStackTrace();
	        } catch(IOException e3) {
	            e3.getStackTrace();
	        } catch(ParseException e4) {
	            e4.getStackTrace();
	        }
	    }
}
