/*
 * Copyright (c) 2016, CauseCode Technologies Pvt Ltd, India.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are not permitted.
 */
package com.causecode

import com.causecode.util.NucleusUtils
import grails.plugins.Plugin

/**
 * This is the Plugin descriptor file for Rest Security Core Plugin.
 */

class RestSecurityCoreGrailsPlugin extends Plugin {

    def grailsVersion = '3.2.0 > *'
    def pluginExcludes = []

    // TODO Fill in these fields
    def title = 'Rest Security Core Plugin' // Headline display name of the plugin
    def author = 'Causecode'
    def authorEmail = ''
    def description = '''\
            This plugin contains spring security core and spring security rest default configurations.
        '''

    def documentation = 'https://bitbucket.org/causecode/rest-spring-core'

    def loadBefore = ['spring-security-rest']

    /*
     * Note: Few default methods that were not required were removed. Please refer plugin docs if required.
     * Removed methods: doWithApplicationContext, doWithDynamicMethods, onChange, onConfigChange
     * and onShutdown.
     */

    Closure doWithSpring() { { ->
            /*
            * Merging configurations defined in DefaultConfig.groovy file from this plugin and installing application.
            */
            String springRestClassName = 'com.causecode.rest.DefaultSpringSecurityRestConfig'
            String springCoreClassName = 'com.causecode.core.DefaultSpringSecurityCoreConfig'

            ConfigObject springRestConfigAfterMerge = NucleusUtils.getMergedConfigurations(springRestClassName)
            ConfigObject springSecurityCoreConfigAfterMerge = NucleusUtils.getMergedConfigurations(springCoreClassName)

            (grailsApplication.config).merge(springSecurityCoreConfigAfterMerge)
            (grailsApplication.config).merge(springRestConfigAfterMerge)
        }
    }
}
