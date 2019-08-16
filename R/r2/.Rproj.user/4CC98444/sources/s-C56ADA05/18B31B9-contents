user <- read.csv("user.csv",header=FALSE, na.strings="NULL",
                 encoding = "EUC-KR",stringsAsFactors=FALSE)
colnames(user)<- c("ID","NAME","AGE","WIEGHT","HEIGHT")
print(user)
{
useravg <-c(mean(user$AGE),mean(user$WIEGHT,na.rm = TRUE),mean(user$HEIGHT,na.rm=TRUE))
names(useravg) <-c("age","wight","height")
print(useravg)
return(useravg)
}
write.csv(
  useravg,
  file="useravg.csv",
  row.names = FALSE,
)
