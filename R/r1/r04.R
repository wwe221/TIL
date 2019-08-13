df1 <-data.frame(x=c(1:5),y=c(6:10),z=c(11:15));
print(df1);
print(df1[2]);
print(df1[2,])
print(df1[,3])
print(df1$x[3])
print(df1["x"])

df2 <- df1[c(2:5),c(2:3)]
print(df2)
