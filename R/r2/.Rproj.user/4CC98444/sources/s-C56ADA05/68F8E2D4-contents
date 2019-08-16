user <- read.csv("user.csv",header=FALSE, na.strings="NA",
                 encoding = "EUC-KR",stringsAsFactors=FALSE)
print(user)
colnames(user)<- c("ID","NAME","AGE","WIEGHT","HEIGHT")
print(user)
user$NAME <-as.character(user$NAME)

write.csv(
  user,
  file="user01.csv",
  row.names = FALSE,
  fileEncoding = "EUC-KR"
)

  