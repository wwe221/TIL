library(ggplot2)
aggregate(data=mpg,cty~class,mean)
m<-mpg[mpg$class%in% c("compact","suv"),c("class","cty")]
table(m$class)
t.test(data=m,cty~class, var.equal=T)
