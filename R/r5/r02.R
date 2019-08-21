library(ggplot2)
str(mpg)
table(mpg$trans)
m2 <-(mpg[,c("trans","hwy")])
m2$type <- ifelse(substr(m2$trans,1,4) %in% "auto","AUTO","MANUAL")

t.test(data=m2,hwy~type,var.equal=T)
