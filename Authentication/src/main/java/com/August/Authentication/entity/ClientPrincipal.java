package com.August.Authentication.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A user.
 */
@Entity
public class ClientPrincipal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "clientId", length = 255, unique = true, nullable = false)
    private String clientId;
    @Column(name = "resource_ids", length = 255)
    private String resourceIds;
    @Column(name = "client_secret", length = 255)
    private String clientSecret;
    @Column(name = "scope", length = 255)
    private String scope;
    @Column(name = "authorized_grant_types", length = 255)
    private String authorizedGrantTypes;
    @Column(name = "web_server_redirect_uri", length = 255)
    private String redirectUri;
    @Column(name = "authorities", length = 255)
    private String authorities;
    @Column(name = "access_token_validity", length = 255)
    private Integer accessTokenValidity;
    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;
    @Column(name = "additional_information", length = 4096)
    private String additionalInformation;
    @Column(name = "autoapprove", length = 255)
    private String autoapprove;
    
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getAutoapprove() {
		return autoapprove;
	}

	public void setAutoapprove(String autoapprove) {
		this.autoapprove = autoapprove;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClientPrincipal user = (ClientPrincipal) o;
        return !(user.getClientId() == null || getClientId() == null) && Objects.equals(getClientId(), user.getClientId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClientId());
    }
}
