#!/bin/sh
java -Dcgi.query_string=$QUERY_STRING -Dcgi.request_method=$REQUEST_METHOD -jar signup.jar $HTTP_COOKIE
