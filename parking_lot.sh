#!/bin/sh

arg1=$1

##directory where jar file is located    
dir=./

##jar file name
jar_name=ParkingMain.jar

mvn clean install 

## Permform some validation on input arguments, one example below
if [ -z "$1" ] ; then
        java -jar $dir/$jar_name
        exit 1

else
	java -jar $dir/$jar_name $arg1

fi