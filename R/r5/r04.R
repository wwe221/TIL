h<-c(100,110,120,130,140,150,160,170,180,190)
w<-c(25,30,35,40,45,50,55,65,76,85)
d <- data.frame("h"=h,"w"=w)
re<-cor.test(d$h,d$w)
result = lm (d$h~d$w)
result$coefficients