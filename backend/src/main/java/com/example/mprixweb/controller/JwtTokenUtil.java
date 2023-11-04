package com.example.mprixweb.controller;

        import com.example.mprixweb.entities.User;
        import io.jsonwebtoken.Jwts;
        import io.jsonwebtoken.SignatureAlgorithm;
        import org.springframework.stereotype.Component;

        import java.util.Date;
        import java.util.HashMap;
        import java.util.Map;

@Component
public class JwtTokenUtil {
    private  final String CLAIMS_SUBJECT ="sub" ;
    private final String  CLAIMS_CREATED ="created" ;
    private Long TOKEN_VALIDITY = 604800L ;


    private String TOKEN_SECRET = "MprixTokenSecret12345"  ;



   public String generateToken(User users) {
       Map<String,Object> claims =new HashMap<>();
         claims.put(CLAIMS_SUBJECT,users.getEmail()) ;
        claims.put(CLAIMS_CREATED,new Date() ) ;

        return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(generatedExpirationDate())
                    .signWith(SignatureAlgorithm.HS512 , TOKEN_SECRET)
                    .compact() ;
    }

    private Date generatedExpirationDate() {
        return new Date(System.currentTimeMillis()+ TOKEN_VALIDITY * 1000)  ;
    }

    //clamims
    //expiration
    //sign
    //compact



}
