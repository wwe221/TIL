#클래스별 하이웨이 연비의 평균을 col로 그려라

library(ggplot2)
mpg2 <- aggregate(data=mpg,hwy~class,mean)
ggplot(data=mpg2,aes(x=class,y=hwy))+ geom_col()
ggplot(data=economics,aes(x=date,y=psavert))+ geom_line()
tail(economics)