#!/bin/sh
while [ 1 ]
do
echo "Input what you wanna install (jdk , tomcat, eclipse, fw) or quit (q) "
read cmd
case $cmd in
	jdk)
		wget http://70.12.114.58/test/jdk1.8.tar.gz
		tar xvfz jdk1.8.tar.gz
		if [ -e /etc/jdk1.8 ]
		then
			echo "Already exits. wanna delete? (Y/N)"
			read cmdd
			if [ "$cmdd" = "Y" ]
			then
				rm -rf /etc/jdk1.8
			fi
		fi
		mv jdk1.8.0_221 /etc/jdk1.8		
		if [ -e /usr/bin/java ]
		then
			rm /usr/bin/java
		fi
		ln -s /etc/jdk1.8/bin/java /usr/bin/java
		echo "JDK install Complete";;
	tomcat)
		wget http://70.12.114.58/test/tomcat.tar.gz
		tar xvf tomcat.tar.gz
		fname=/etc/tomcat
		if [ -e $fname ]
		then
			echo "Already exits. wanna delete? (Y/N)"
			read cmdd
			if [ $cmdd = 'Y' ]
				then
					rm -rf $fname
			fi
		fi		 
		mv apache-tomcat-9.0.22 tomcat
		mv tomcat /etc/
		if [ -e /usr/bin/startcat ]
		then
		  rm /usr/bin/startcat
		fi
		if [ -e /usr/bin/stopcat ]
		then
		  rm /usr/bin/stopcat
		fi
		ln -s /etc/tomcat/bin/startup.sh /usr/bin/startcat
		ln -s /etc/tomcat/bin/shutdown.sh /usr/bin/stopcat
		echo "Tomcat install Complete";;
	eclipse)
		 if [ -d /etc/eclipse ]
		        then
                	echo "eclipse is already installed. do you want remove and reinstall it?[Y,N]"
	                read reinstall
	                until [ "$reinstall" = "Y" ] || [ "$reinstall" = "N" ]
        	   	     do
	                        echo "please input Y or N"
	                        read reinstall
		             done
                	if [ $reinstall = "N" ]
	        	then
        	                echo "install system stop.."
                        	return
	                else
                        rm -rf /etc/eclipse/
        	        fi
	        else
	                echo "install system is start"
		fi
	        echo "eclipse install start"
	        wget http://70.12.114.58/test/eclipse.tar.gz
	        tar xvfz eclipse.tar.gz
	        mv eclipse /etc/eclipse
	        if [ -e /usr/bin/eclipse ]
	        then
	                rm /usr/bin/eclipse
	        fi
	        ln -s /etc/eclipse/eclipse /usr/bin/eclipse
		echo "Tomcat install Complete";;
	q)
		break;;
	fw)
		firewall-cmd --permanent --add-service=http
		firewall-cmd --permanent --add-service=https
		firewall-cmd --permanent --add-port=1521/tcp		
		firewall-cmd --reload
		firewall-cmd --list
		systemctl restart network;;
	*)
		;;
esac
done
exit 0
