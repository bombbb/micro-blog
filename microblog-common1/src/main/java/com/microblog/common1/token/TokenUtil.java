package com.microblog.common1.token;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;


/**
 *功能描述 
 * @author lgj
 * @Description  TokenUtil
 * @date 3/1/19
*/
@Slf4j
public class TokenUtil {

    private static final Logger log = LoggerFactory.getLogger(TokenUtil.class);
    /**
     *功能描述 
     * @author lgj
     * @Description  从 HttpServletRequest 中获取Token
     * @date 3/1/19
     * @param:   HttpServletRequest
     * @return:  token
     *
    */

    public  static  String getTokenFromRequest(Function<String,String> fromHeader,Function<String,String> fromParameter)  throws TokenNotFoundException{

        String token;

        if(!StringUtils.isEmpty(token = fromHeader.apply(AuthConstants.HEADER_TOKEN_KEY))){
            return token;
        }
        else  if(!StringUtils.isEmpty(token = fromParameter.apply(AuthConstants.PARAM_TOKEN_KEY))){
            log.debug("paramToken = {}" , token);
            return token;
        }else {
            throw  new TokenNotFoundException("Token 未存在");
        }

    }


}
