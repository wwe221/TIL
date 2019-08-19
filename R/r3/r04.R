library(dplyr)
library(readxl)
library(ggplot2)
mid <- midwest
mid<-rename(mid,total=poptotal)
mid<-rename(mid,asian=popasian)
mid$Apers<-mid$asian / mid$total
hist(mid$Apers)
Aavg <-mean(mid$Apers)
mid$Asize <- ifelse(mid$Apers>Aavg,"large","small")
qplot(mid$Asize)

