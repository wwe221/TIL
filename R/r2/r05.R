st <-read.csv("student.csv",stringsAsFactors = FALSE)
print(st)
sts <-print(apply(st[,c(3:6)], 1, mean))
names(sts) <-st[,2]
print(sts)
print(colMeans(st[,c(3:6)]))
dsts <- as.data.frame(sts)
sort(dsts$sts)
