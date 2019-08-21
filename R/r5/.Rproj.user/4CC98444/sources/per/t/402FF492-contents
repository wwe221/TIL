body <- read.csv("health.csv")
str(body)
library(ggplot2)
body1<-aggregate(data=body,신장.5Cm단위.~연령대코드.5세단위.,mean)
colnames(body1)<-c("나이","키")
body$key<-body$신장.5Cm단위./100
body$bm<-body$체중.5Kg.단위./body$key/body$key
body$bmm<-ifelse(body$bm>30,"비만",
                 ifelse(body$bm>25,"과체중","정상"))
body
nmbody <-body[body$bmm=="정상","연령대코드.5세단위."]
bmbody <-body[body$bmm=="비만","연령대코드.5세단위."]
ovbody <-body[body$bmm=="과체중","연령대코드.5세단위."]
nmbody<-table(nmbody)
bmbody<-table(bmbody)
ovbody<-table(ovbody)
ovbody <-as.data.frame(ovbody)
ovbody$type<-c("과체중","과체중","과체중","과체중","과체중","과체중","과체중","과체중","과체중","과체중","과체중","과체중","과체중","과체중")


#나이대 별 정상인 사람의 수,
body3<-aggregate(data=body,연령대코드.5세단위.~bmm,table)
table(body$bmm)
body4<-aggregate(data=body,bmm~연령대코드.5세단위.,table)
body4$total <- body4$bmm.과체중
body4$over <-bmw$bmm[,1]
body4$bm <-bmw$bmm[,2]
body4$nm <-bmw$bmm[,3]
body4$total<- body4$over+body4$bm+body4$nm

str(body4)
bmw<-body4["bmm"]
str(bmw$bmm)
a <- bmw$bmm[,1]
ggplot(data=body,aes(x=연령대코드.5세단위.,y=bm, col=bmm)) + geom_point()

body2<-aggregate(data=body,체중.5Kg.단위.~연령대코드.5세단위.,mean)
colnames(body1)<-c("나이","키")
ggplot(data=body,aes(x=체중.5Kg.단위.,y=총콜레스테롤))+geom_col()
ggplot(data=body1,aes(x=신장.5Cm단위.,y=연령대코드.5세단위.))+geom_col()
