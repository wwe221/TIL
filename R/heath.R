rhive <- function(){
  library(RJDBC);
  library(DBI);
  library(rJava);
  hive_lib <- '/home/centos/file/java_hive_lib';
  .jinit();
  .jaddClassPath(dir(hive_lib,full.names = T));
  .jclassPath();
  
  drv=JDBC(driverClass='org.apache.hive.jdbc.HiveDriver',
           'hive-jdbc-1.0.1.jar');
  conn=dbConnect(drv,"jdbc:hive2://70.12.114.195:10000",
                 "hive","111111");
  
  user=dbGetQuery(conn,"select * from health");
  dbDisconnect(conn);
  return (user);
}



cole <- function(){
  body <- rhive() 
  body15<-aggregate(data=body,health.totalcol~health.weight,mean)
  colnames(body15)<-c("weight","coles")
  return (body15)
}
keys<- function(){
  library(ggplot2)
  body <- rhive()
  body15<-aggregate(data=body,health.hight~health.old,mean)
  colnames(body15)<-c("height","age")
  #png("C:/Users/student/kh/TIL/Spring/bbaadd/web/img/keys.png",width=600,height=500)
  jpeg("/etc/tomcat/webapps/bbaadd/img/keys.jpg",width=600,height=500)
  print(ggplot(data=body15,aes(x=body15$height,y=body15$age))+ geom_count())
  dev.off()
  print("성공")
  return (body15)
}
bmper <- function(){
 
  library(ggplot2)

  body <- rhive()
  body1<-aggregate(data=body,health.hight~health.old,mean)
  colnames(body1)<-c("age","height")
  body$key<-body$hight.5cm./100
  body$bm<-body$weight.5kg./body$key/body$key
  body$bmm<-ifelse(body$bm>30,"obesity",
                   ifelse(body$bm>25,"overweight","normal"))
  nmbody <-body[body$bmm=="normal","old.5years."]
  bmbody <-body[body$bmm=="obesity","old.5years."]
  ovbody <-body[body$bmm=="overweight","old.5years."]
  nmbody<-table(nmbody)
  bmbody<-table(bmbody)
  ovbody<-table(ovbody)
  ovbody <-as.data.frame(ovbody)
  nmbody <-as.data.frame(nmbody)
  bmbody <-as.data.frame(bmbody)
  ovbody$type<-c("overweight","overweight","overweight","overweight","overweight","overweight","overweight","overweight","overweight","overweight","overweight","overweight","overweight","overweight")
  nmbody$type<-c("normal","normal","normal","normal","normal","normal","normal","normal","normal","normal","normal","normal","normal","normal")
  bmbody$type<-c("obesity","obesity","obesity","obesity","obesity","obesity","obesity","obesity","obesity","obesity","obesity","obesity","obesity","obesity")
  
  colnames(bmbody) <-c("name","Freq","type")
  new<-bmbody
  colnames(nmbody) <-c("name","Freq","type")
  new<-rbind(new,nmbody)
  colnames(ovbody) <-c("name","Freq","type")
  new<-rbind(new,ovbody)
  
  ggplot(data =new, aes(x=name , y=Freq , col =type))+geom_ribbon()
  library(plotly)
  p <- ggplot(data =new, aes(x=name , y=Freq , col =type))+geom_point()
  ggplotly(p)
}
