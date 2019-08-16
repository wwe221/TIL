student <-read.csv("student.csv",stringsAsFactors = FALSE)
print(student)
avg <-c(1:8)
avg2 <-c(1:ncol(student))
for (i in c(1:nrow(student))){
  avg[i] <-round(mean(as.numeric(student[i,c(3:6)])),1)
}
for(i in c(3:ncol(student2))){
  avg2[i] <-round(mean(student2[,i]),1)
}
avg2[1]<-"ID"
avg2[2]<-"AVG"
student2 <-cbind(student,avg)
student3 <-rbind(student2,avg2)
print(student2)
print(student3)
print(student3[9,])