st <-read.csv("student.csv",stringsAsFactors = FALSE)
st[st$KO>80 & st$SI > 80,c("NAME")]

st$avg <-rowMeans(st[,c(3:6)])
st$class <-c(1,1,2,3,1,2,1,3)
aggregate(data=st[st$KO>80,], avg~class , mean)
