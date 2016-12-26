/*
 * Copyright (c) 2016, CauseCode Technologies Pvt Ltd, India.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are not permitted.
 */
package com.causecode.rest

grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = true

// For JSON body in the request.
grails.plugin.springsecurity.rest.login.usernamePropertyName = 'email'

grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName = 'com.causecode.user.AuthenticationToken'
grails.plugin.springsecurity.rest.token.storage.gorm.usernamePropertyName = 'email'
grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName = 'token'

grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token'

grails {
    plugin {
        springsecurity {
            rest {
                oauth {
                    // Update this URL as per the token handling on the client side.
                    frontendCallbackUrl = { String tokenValue ->
                        "${grails.serverURL}/userProfile?token=${tokenValue}"
                    }

                    google {
                        client = org.pac4j.oauth.client.Google2Client
                        key = '868928495887-819cg6s61g56rq90vu93bkgibm5qbt5s.apps.googleusercontent.com'
                        secret = 'ZnsDV9oJ-ti8ski2i6v2gupr'
                        scope = org.pac4j.oauth.client.Google2Client.Google2Scope.EMAIL_AND_PROFILE
                        defaultRoles = ['ROLE_USER', 'ROLE_GOOGLE']
                    }

                    twitter {
                        client = com.causecode.spring.rest.oauth.twitter.CustomTwitterClient
                        key = 'eXWuXe7Ilq1p38xHiaR1ZJH1W'
                        secret = 'VuwgVvOkLQVhl76RTaesa3l1kNhdZnmKc3hOIuIRo8xqKzPgJt'
                        defaultRoles = ['ROLE_USER', 'ROLE_TWITTER']
                    }

                    facebook {
                        client = org.pac4j.oauth.client.FacebookClient
                        key = '1859287567634381'
                        secret = 'fc19ac8ce1f289c15b8050d13c608203'
                        scope = 'email,user_location'
                        fields = 'id,name,first_name,middle_name,last_name,email,gender'
                        defaultRoles = ['ROLE_USER', 'ROLE_FACEBOOK']
                    }

                    linkedIn {
                        client = org.pac4j.oauth.client.LinkedIn2Client
                        key = '756n26f375vdk1'
                        secret = 'pdw4BxUxNcpCy10v'
                        scope = 'r_basicprofile,r_emailaddress'
                        defaultRoles = ['ROLE_USER', 'ROLE_LINKEDIN']
                    }
                }
            }
        }
    }
}