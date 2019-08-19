library(ggplot2)
ggplot(data=mpg,aes(x= displ, y = hwy)) + geom_col()+
xlim(3,6) + ylim(10,30)
op <- as.data.frame(table(mpg$class))
ggplot(data=op,aes(y=Freq, x=Var1)) + geom_col()
ggplot(data=mpg,aes(x=class)) + geom_bar()
