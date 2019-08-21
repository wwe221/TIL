library(ggplot2)
ggplot(data=economics,aes(x=unemploy, y = pce))+ geom_point()
economics
re<-cor.test(economics$unemploy,economics$pce)
if(re$p.value < 0.05){
  result = lm (economics$pce~economics$unemploy)
  result$coefficients
}else{
  
}
