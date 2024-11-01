
package jwtrest;

//import com.sun.xml.ws.security.impl.policy.Claims;
//import static com.sun.xml.ws.security.impl.policy.Constants.SignatureAlgorithm;
import static jwtrest.Constants.REMEMBERME_VALIDITY_SECONDS;
import io.jsonwebtoken.*;
import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;
//import java.security.SignatureException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import javax.annotation.PostConstruct;
import javax.inject.Named;

//@SessionScoped
@Named
public class TokenProvider implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(TokenProvider.class.getName());

    private static final String AUTHORITIES_KEY = "auth";

    private String secretKey;
    private String privateKey;
    private String publicKey;
    private PrivateKey myprivateKey;
    private PublicKey mypublicKey;
    private long tokenValidity;

    private long tokenValidityForRememberMe;

    @PostConstruct
    public void init() {
        // load from config
        this.secretKey = "my-secret-jwt-key";
        this.privateKey = "MIIFHDBOBgkqhkiG9w0BBQ0wQTApBgkqhkiG9w0BBQwwHAQISApP/lXOftwCAggA\n" +
"MAwGCCqGSIb3DQIJBQAwFAYIKoZIhvcNAwcECAJWVdWZ3zHdBIIEyE8NoX1rxf+s\n" +
"QUCPrTTyUAM4MPjVOEzN/EgA/GOGck5pA7uHuUM70EByNa7FIchq83FfNPOiI1iK\n" +
"u+F/F3rP5+BR9vzGCRCc1t1qKmwyI7ntyo4dESMKslEIwc9EjF8izhAa47nfus7u\n" +
"ozGT3mhbsPoWk6Pc/35zLLW1jelOY1AomAaNh5EOrPWaInzh8oW3fGVN1/6HqZUF\n" +
"WccGWyA3xSnSWBFwGlz66UkljUDd3ObKbqAc6a2VHluaF+ditFxiUcOQ3YwxXVTl\n" +
"Q9dkMHHrXzNe8SK6amKEUT7aA9koa6QEXo4BUj0hUlH0LGk3aSRWA9jF2c9wfq5q\n" +
"YDX22av9MxNhd6a/SpwiCkt7NH92BJkJhWQB6G9vME9vNoQ5HHHUAgpPr58wjKpQ\n" +
"Ndg5Sl4feKWcA51hGn8QiczTBSBr5BB7tPdvg27eL/fMTuWBcPwLcLl3Lz8jN2di\n" +
"Rhzu4HNPge3H/7Jptwl9z8DZLH4kVp6jJUbgsrzE1/wa0M754Ac32/PHk6XXE0Yi\n" +
"qBg2i00h+BEZAGfvyEWbVpodQVW4i2YjMZk3zO+nFRpfT1eYTd9lBizUjIcaX8Pz\n" +
"4lkNY6opA7iGi9bpUsHFoEpA+oUqRjSgXOi3N2Dhg/mMDxWcwt5FJQBqWpASn4t7\n" +
"G3jnOAmM4j5WRBjEHtA/2SqIOZOvxzwGD7QInhCkvKlQrPJrfKP9PaZpS2ZTP4d8\n" +
"r1kWjD3eau6yK2C/J5nLmGTnRSOu2WzmPAyPlT8D5WvHuH2/eONfkH7OWa3iM79T\n" +
"dzaVChcdEzIPkQKG7OqADhnYWK8zJYQFX6kf+CjeGdFwjZEaLqfg5hwYZLzlzuaa\n" +
"MKIXvzt0PoNPjM/7yYKbfA3i+PfnxJDfQJBCtEauXd3JfuX5xAHIpJl+ZFkh5yAM\n" +
"fx4FUDy69uIPDTK7XJ1LoExSmvWMkwdT9x6YWkeCANkMA4T4ovt11hS+KQTspg/H\n" +
"jxG7jtBZINIBMDy8gB3oGCSUTc0tXQfxE9u7TcL5+PHu/bLpwuGDny1v2DLglrLw\n" +
"Aw+/k2HdkO2iDzGWtQDQ9JBYUTBvtKG2UFvI9EDH/YogQPk9vwKGocZ2HpTa0nw3\n" +
"/Vv4o/kARuEt+9Utc91IZxoxOVF3GXPTS8iRNKr9HkcMnWLpLKWFpfqg7phXuWJb\n" +
"aNjKX9tuuIbBZrmut6VmhqL92KY9J2b7EnSYqP1rDGSKBCCDZ4hIWQtfVitEeKUa\n" +
"AhMMbExMj5p3gCQSYoORQI765wAPyP04yTpLB/w/wkKmE6O8ETtxQG00bzH/f5hU\n" +
"XeEMo2T07sjQH7Ha/i68FKb/4DUgIOTC2ysL5qq4+ZD0ie1zGxbGDCoJLUmiJwv0\n" +
"On6gbRRZKZPsIGtc0/iDRT3p+XQ0p++mg05Ih5tTvBZOMV6JXfmjKpu73BHVLA0y\n" +
"VB6lHEM1EDa64Ksv8EBvk539T6+48k7jfSz4u1VLDShX79p4lHxU3jsh6d3VYDzc\n" +
"oLx9rCoDI5ebDa7+JOkmYupzQ4MzFO3KCVC4eco7GL4i9J0Pzje8wpJ1q2jskhnd\n" +
"RIEzfdm+Dz4aoQ1OdFOGlf9YhjBehdd3lEexRQs5CoMOvyzgAksCLrqlVXUUhN14\n" +
"lOtKpQwz1Yo96ZJvOF+m4Q==";
       
 this.publicKey="MIIDsTCCApmgAwIBAgIERgdh4jANBgkqhkiG9w0BAQsFADCBiDELMAkGA1UEBhMC\n" +
"VUsxFzAVBgNVBAgTDldvcmNlc3RlcnNoaXJlMRYwFAYDVQQHEw1HcmVhdCBNYWx2\n" +
"ZXJuMRowGAYDVQQKExFQYXlhcmEgRm91bmRhdGlvbjEPMA0GA1UECxMGUGF5YXJh\n" +
"MRswGQYDVQQDExJsb2NhbGhvc3QtaW5zdGFuY2UwHhcNMTkwODI3MTQzOTE3WhcN\n" +
"MjkwODI0MTQzOTE3WjCBiDELMAkGA1UEBhMCVUsxFzAVBgNVBAgTDldvcmNlc3Rl\n" +
"cnNoaXJlMRYwFAYDVQQHEw1HcmVhdCBNYWx2ZXJuMRowGAYDVQQKExFQYXlhcmEg\n" +
"Rm91bmRhdGlvbjEPMA0GA1UECxMGUGF5YXJhMRswGQYDVQQDExJsb2NhbGhvc3Qt\n" +
"aW5zdGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCbDuDJF35N\n" +
"hX55m/dmO6YwC3ljXBA7Xg3seSZjw7eJd89kdOSdjXitPHgg5Rl8ajK3TLQ2xheu\n" +
"0nB3S4Ll/M3Ly41q4RsThiW2/FbDJOzhsNVOCAQOioHtbX5bQKMGCQDHI33KT/tV\n" +
"oyOj/idq486I67E5VlxehS91p35vFZfRbuEikO61NZRV08izSU4K74rvzi4Ygrtq\n" +
"JH4eAajM+gT4KWaRl07PzmP82IT3bB1bRzKvDOScfSGMqsglZXWNnxlPWMX2ZNRZ\n" +
"3o1lQYJfYktFM3dFEwnZuQXWX6p5nAl3eqK43A/NfY2tqnYNCb1c398AVg0k5HCz\n" +
"U0VVl9wfQNOrAgMBAAGjITAfMB0GA1UdDgQWBBTukv2mqrH3WcKSwF8ayLxZegGa\n" +
"MTANBgkqhkiG9w0BAQsFAAOCAQEAJENcQL1uN6gzlJIvsPz+pUaQ7XrbaJFPWmAs\n" +
"m7tl1OKwxSr5ZvykY3cu9DK3cK6jWSEd9H6I9xG4JkRE0Yo846lnXUqnmyBUyTvB\n" +
"btIdJ8DHC3U2IrvhXmxCQrmjxxOBtzc4GUUxBixgbbMi992lMWgar13cdRvN73Vq\n" +
"w/Tuy5k3Gt4MWd4+4ioscFa+ROdXBfBb2ZakTMkSDcfZxfDlrJ+FujZxWtEQ0mye\n" +
"VN5Mi3PXFma6FTORvcSibn192Ofbj7JbRLktf6D9IDIyOMTlqkLzff8/cSXiEeRB\n" +
"yrkRv9N3iztDUk/gcuru5eDxDlhGnkfHIIpzUMct04j9wW5H0A==";       
        
 
// byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);
//byte[] publicKeyBytes= Base64.getDecoder().decode(publicKey);
//try{
//KeyFactory kf = KeyFactory.getInstance("RSA"); // or "EC" or whatever
// myprivateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
// mypublicKey = kf.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
//}
//catch(Exception ex)
//{
//    ex.printStackTrace();
//}
        this.tokenValidity = TimeUnit.HOURS.toMillis(10);   //10 hours
        this.tokenValidityForRememberMe = TimeUnit.SECONDS.toMillis(REMEMBERME_VALIDITY_SECONDS);   //24 hours
    }

    public String createToken(String username, Set<String> authorities, Boolean rememberMe) {
        long now = (new Date()).getTime();
        long validity = rememberMe ? tokenValidityForRememberMe : tokenValidity;
        System.out.println("TokenProvider - In create Token");
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("localhost")
                .claim(AUTHORITIES_KEY, authorities.stream().collect(joining(",")))
                .signWith(SignatureAlgorithm.HS512, secretKey)
              //  .signWith(SignatureAlgorithm.RS256, myprivateKey)
                .setExpiration(new Date(now + validity))
                .compact();
    }

    public JWTCredential getCredential(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
               // .setSigningKey(mypublicKey)
                .parseClaimsJws(token)
                .getBody();
        System.out.println("TokenProvider - Token Provider - In Get Credential");
        Set<String> authorities
                = Arrays.asList(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .stream()
                        .collect(Collectors.toSet());

        return new JWTCredential(claims.getSubject(), authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            System.out.println("TokenProvider - TokenProvider - validate token");
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
          //Jwts.parser().setSigningKey(mypublicKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            LOGGER.log(Level.INFO, "Invalid JWT signature: {0}", e.getMessage());
            return false;
        }
    }
}
