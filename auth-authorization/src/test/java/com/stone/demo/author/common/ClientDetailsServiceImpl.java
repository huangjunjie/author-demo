package com.stone.demo.author.common;

import com.stone.demo.author.authorization.bean.po.AuthClientDetails;
import com.stone.demo.author.authorization.bean.po.Clientdetails;
import com.stone.demo.author.authorization.dao.ClientdetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/***
 *
 * @Class ClientDetailsServiceImpl
 * @Descrip TODO
 * @author Stone
 * @data 21-4-1  下午5:28
 * @Version 1.0
 */

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {


    @Lazy
    @Autowired
    private ClientdetailsMapper clientDetailsMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Clientdetails clientdetails = clientDetailsMapper.selectByPrimaryKey(clientId);
        if (clientdetails == null) {
            throw new ClientRegistrationException("该用户不存在");
        }
        return new AuthClientDetails(clientdetails);
    }
}
