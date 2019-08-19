library(dplyr)
library(readxl)
library(ggplot2)
st <- read_excel("st.xlsx")
st<- rename(st, MA=MATH)
st$AVG <- rowMeans(st[,c(3:5)])
#st$test <- ifelse(st$AVG>85 , "pass","fail")
#aggregate(AVG~test,st,mean)
st$GRADE <- ifelse(st$AVG>=90,"A",
                   ifelse(st$AVG>=85,"B",
                          ifelse(st$AVG >= 80,"C","F")))
qplot(st$GRADE)
ta<- table(st$GRADE)
as.data.frame(ta)
