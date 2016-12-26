/*
 * Copyright (c) 2016, CauseCode Technologies Pvt Ltd, India.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are not permitted.
 */
package com.causecode.core

environments {
    development {
        grails {
            mail {
                username = "trialcausecode"
                password = "causecode.11"
                host = "smtp.gmail.com"
                port = 465
                props = ["mail.smtp.auth":"true",
                         "mail.smtp.socketFactory.port":"465",
                         "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
                         "mail.smtp.socketFactory.fallback":"false"]
            }
        }
    }
    test {
        grails.gorm.autoFlush = true
        asynchronous.mail.disable = true
    }
}

grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"

grails.plugin.springsecurity.interceptUrlMap = [
        [pattern: '/user/**', access: ['permitAll']],
        [pattern: '/oauth/**', access: ['permitAll']],
        [pattern: '/**', access: ['ROLE_USER']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/api/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,' +
        '-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter']
]

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.causecode.user.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.causecode.user.UserRole'
grails.plugin.springsecurity.authority.className = 'com.causecode.user.Role'