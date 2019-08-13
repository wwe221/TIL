data <- data.frame(
  "a100" = c(90,80,40,60),
  "b101" = c(10,70,44,72),
  "c102" = c(20,46,77,53),
  "d103" = c(20,85,88,94),
  "e104" = c(30,60,100,76),
  "f105" = c(40,70,99,91),
  "g106" = c(60,80,40,100)
)
print(data)
each2<-c(sum(data[,1]),sum(data[,2]),sum(data[,3])
         ,sum(data[,4]),sum(data[,5]),sum(data[,6]),
         sum(data[,7]))
each3<-c(mean((data[,1])),
         mean((data[,2])),
         mean((data[,3])),
         mean((data[,4])),
         mean((data[,5])),
         mean((data[,6])),
         mean((data[,7])))
each4<-c(mean(as.numeric(data[1,])),
         mean(as.numeric(data[2,])),
         mean(as.numeric(data[3,])),
         mean(as.numeric(data[4,])),
         mean(as.numeric(data[5,])),
         mean(as.numeric(data[6,]))
         )
each5<-c(sum(as.numeric(data[1,])),
         sum(as.numeric(data[2,])),
         sum(as.numeric(data[3,])),
         sum(as.numeric(data[4,])),
         sum(as.numeric(data[5,])),
         sum(as.numeric(data[6,]))
)
print(each2);
print(data[6]);
data[5,]<-each3;
data[6,]<-each2;
data$avg<-each4;
data$sum<-each5;
print(data)
data2 <-data[data$a100 %% 2==0];
print(data2)
