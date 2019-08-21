cole <- function(){
  body <- read.csv("health.csv")
  body15<-aggregate(data=body,총콜레스테롤~체중.5Kg.단위.,mean)
  colnames(body15)<-c("weight","coles")
  return (body15)
}
keys<- function(){
  body <- read.csv("health.csv")
  body15<-aggregate(data=body,신장.5Cm단위.~연령대코드.5세단위.,mean)
  colnames(body15)<-c("key","age")
  png("keys.png",width=600,height=500)
  ggplot(data=body15,aes(x=key,y=age))+ geom_count()
  dev.off()
  return (body15)
}