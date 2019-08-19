audi <- mpg %>% filter(manufacturer=="audi")
a<-audi[order(audi$hwy , decreasing =T),]
a[c(1:5),]

cty<- aggregate(data=mpg,cty~class,mean)
cty<- cty[order(cty$cty, decreasing = T),]

comp<-aggregate(data=mpg,hwy~manufacturer,mean)
comp<- comp[order(comp$hwy, decreasing = T),]
comp[c(1:3),]

comp2 <-  mpg[mpg$class=="compact",]
comp2<-as.data.frame(table(comp2$manufacturer))
comp2<-comp2[order(comp2$Freq,decreasing = T),]