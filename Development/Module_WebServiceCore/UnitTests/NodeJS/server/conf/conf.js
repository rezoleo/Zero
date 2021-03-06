/* 
 * File 	: ./server/conf/conf.js
 * Author(s)	: Zidmann
 * Function 	: This file defines the different configuration settings
 * Version  	: 1.1.0
 */

var floodprotection = require('./floodprotection.js'),
    http            = require('./http.js'),
    log             = require('./log.js'),
    mongo           = require('./mongo.js'),
    rest            = require('./rest.js'),
    service         = require('./service.js'),
    ssl             = require('./ssl.js');

module.exports = {
	floodprotection : floodprotection,
	http            : http,
	log	        : log,
	mongo           : mongo,
	rest            : rest,
	service         : service,
	ssl	        : ssl
}
