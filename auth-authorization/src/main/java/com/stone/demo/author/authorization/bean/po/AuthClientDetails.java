package com.stone.demo.author.authorization.bean.po;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/***
 *
 * 自定义ClientDetails
 *
 * @Class AuthClientDetails
 * @Descrip TODO
 * @author Stone
 * @data 21-4-1  下午5:41
 * @Version 1.0
 */
public class AuthClientDetails implements ClientDetails {

    private String clientId;

    private String resourceids;

    private String clientSecret;

    private String scope;

    private String grantTypes;

    private String redirectURL;

    private String authorities;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalinformation;

    private String autoapprovescopes;

    public AuthClientDetails(Clientdetails clientdetails){
        clientId = clientdetails.getAppid();
        resourceids = clientdetails.getResourceids();
        clientSecret = clientdetails.getAppsecret();
        scope = clientdetails.getScope();
        grantTypes = clientdetails.getGranttypes();
        redirectURL = clientdetails.getRedirecturl();
        authorities = clientdetails.getAuthorities();
        accessTokenValidity = clientdetails.getAccessTokenValidity();
        refreshTokenValidity = clientdetails.getRefreshTokenValidity();
        additionalinformation = clientdetails.getAdditionalinformation();
        autoapprovescopes = clientdetails.getAutoapprovescopes();
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return (Set<String>) Arrays.asList(resourceids.split(","));
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return (Set<String>) Arrays.asList(scope.split(","));
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return (Set<String>) Arrays.asList(grantTypes.split(","));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return (Set<String>) Arrays.asList(redirectURL.split(","));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Arrays.asList(authorities.split(",")).stream().map(item->new GrantedAuthorityImpl(item)).collect(Collectors.toList());
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return (Map<String, Object>)JSON.parse(additionalinformation);
    }


    class GrantedAuthorityImpl implements GrantedAuthority {

        private String authority;

        public GrantedAuthorityImpl(String s){
            authority = s;
        }

        /**
         * If the <code>GrantedAuthority</code> can be represented as a <code>String</code>
         * and that <code>String</code> is sufficient in precision to be relied upon for an
         * access control decision by an {@link AccessDecisionManager} (or delegate), this
         * method should return such a <code>String</code>.
         * <p>
         * If the <code>GrantedAuthority</code> cannot be expressed with sufficient precision
         * as a <code>String</code>, <code>null</code> should be returned. Returning
         * <code>null</code> will require an <code>AccessDecisionManager</code> (or delegate)
         * to specifically support the <code>GrantedAuthority</code> implementation, so
         * returning <code>null</code> should be avoided unless actually required.
         *
         * @return a representation of the granted authority (or <code>null</code> if the
         * granted authority cannot be expressed as a <code>String</code> with sufficient
         * precision).
         */
        @Override
        public String getAuthority() {
            return authority;
        }
    }
}
