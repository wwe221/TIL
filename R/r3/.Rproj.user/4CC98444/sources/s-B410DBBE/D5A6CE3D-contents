library(dplyr)
library(readxl)
library(ggplot2)
st <- read_excel("st.xlsx")
st2 <- st[st$CLASS<=2,c("CLASS","ENG")]
st3 <- aggregate(data=st2,ENG~CLASS,mean)
st %>% filter(CLASS==1)
st[st$CLASS %in% c(2:3),]
st$AVG <-rowMeans(st[,c(3:5)])
st$SUM <-rowSums(st[,c(3:5)])
st$AVG2 <- apply(st[,c(3:5)],1,mean)
st$SUM2 <- apply(st[,c(3:5)],1,sum)
aggregate(data=st,AVG~CLASS,mean)