package com.stone.demo.author.mango.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

/***
 *
 * @Class JwtParser
 * @Descrip TODO
 * @author Stone
 * @data 21-1-24  上午12:50
 * @Version 1.0
 */
public class JwtParser {

    public static void main(String[] args) {
        try {
//            解析token
            Claims claims = Jwts.parser()
                    .setSigningKey("abcdefgh")
                    .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsaXViZWkiLCJleHAiOjE2MTE1MzU1MzgsImNyZWF0ZWQiOjE2MTE0OTIzMzgyMDksImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJzeXM6bWVudTpkZWxldGUifSx7ImF1dGhvcml0eSI6InN5czpnZW5lcmF0b3I6dmlldyJ9LHsiYXV0aG9yaXR5Ijoic3lzOmRpY3Q6ZWRpdCJ9LHsiYXV0aG9yaXR5Ijoic3lzOmRpY3Q6ZGVsZXRlIn0seyJhdXRob3JpdHkiOiJzeXM6Y29uZmlnOmFkZCJ9LHsiYXV0aG9yaXR5Ijoic3lzOnN3YWdnZXI6dmlldyJ9LHsiYXV0aG9yaXR5Ijoic3lzOm1lbnU6YWRkIn0seyJhdXRob3JpdHkiOiJzeXM6dXNlcjphZGQifSx7ImF1dGhvcml0eSI6InN5czpkZXB0OmRlbGV0ZSJ9LHsiYXV0aG9yaXR5Ijoic3lzOnJvbGU6ZWRpdCJ9LHsiYXV0aG9yaXR5Ijoic3lzOmxvZzp2aWV3In0seyJhdXRob3JpdHkiOiJzeXM6cm9sZTp2aWV3In0seyJhdXRob3JpdHkiOiJzeXM6bG9nOmRlbGV0ZSJ9LHsiYXV0aG9yaXR5Ijoic3lzOmRpY3Q6dmlldyJ9LHsiYXV0aG9yaXR5Ijoic3lzOnVzZXI6ZGVsZXRlIn0seyJhdXRob3JpdHkiOiJzeXM6ZGVwdDp2aWV3In0seyJhdXRob3JpdHkiOiJzeXM6bW9uaXRvcjp2aWV3In0seyJhdXRob3JpdHkiOiJzeXM6ZHJ1aWQ6dmlldyJ9LHsiYXV0aG9yaXR5Ijoic3lzOm1lbnU6dmlldyJ9LHsiYXV0aG9yaXR5Ijoic3lzOmRpY3Q6YWRkIn0seyJhdXRob3JpdHkiOiJzeXM6b25saW5lOnZpZXcifSx7ImF1dGhvcml0eSI6InN5czpyb2xlOmFkZCJ9LHsiYXV0aG9yaXR5Ijoic3lzOnVzZXI6dmlldyJ9LHsiYXV0aG9yaXR5Ijoic3lzOmRlcHQ6ZWRpdCJ9LHsiYXV0aG9yaXR5Ijoic3lzOmxvZ2lubG9nOmRlbGV0ZSJ9LHsiYXV0aG9yaXR5Ijoic3lzOmNvbmZpZzplZGl0In0seyJhdXRob3JpdHkiOiJzeXM6Y29uc3VsOnZpZXcifSx7ImF1dGhvcml0eSI6InN5czpsb2dpbmxvZzp2aWV3In0seyJhdXRob3JpdHkiOiJzeXM6dXNlcjplZGl0In0seyJhdXRob3JpdHkiOiJzeXM6Y29uZmlnOnZpZXcifSx7ImF1dGhvcml0eSI6InN5czpjb25maWc6ZGVsZXRlIn0seyJhdXRob3JpdHkiOiJzeXM6ZGVwdDphZGQifSx7ImF1dGhvcml0eSI6InN5czpyb2xlOmRlbGV0ZSJ9LHsiYXV0aG9yaXR5Ijoic3lzOm1lbnU6ZWRpdCJ9XX0.6MbrsHw7g-9UfBbFHn-Xj-p6RmZbGGVcPNO7BHeHbyPeh__iq5qB6ZsCtwDnHztKKH3704f3FK54csUeCpePkQ")
                    .getBody();

            System.out.println(claims);
//            获取用户名
            String username = claims.getSubject();
            System.out.println("username:"+username);
//            获取权限
            String authority = claims.get("authorities").toString();
            System.out.println("权限："+authority);
        } catch (ExpiredJwtException e) {
            System.out.println("jwt异常");
        } catch (Exception e){
            System.out.println("异常");
        }
    }
}
