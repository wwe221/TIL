twit <- read.csv("twitter.csv",
                 header = T,
                 stringsAsFactors = F,
                 fileEncoding = "UTF-8")
twit<-rename(twit,
             no=번호,
             id=계정이름,
             data=작성일,
             tw=내용)

twit$tw<-str_replace_all(twit$tw,"\\W"," ")
nouns<- extractNoun(twit$tw)
wordcnt <- table(unlist(nouns))
df_w<- as.data.frame(wordcnt,stringsAsFactors = F)
colnames(df_w)<-c("word","freq")
df_w<-filter(df_w,nchar(word)>=2)
df_w<-df_w[order(df_w$freq,decreasing = T),]
top20 <- head(df_w,20)
pal<-brewer.pal(8,"Dark2")
set.seed(1234)
wordcloud(words= df_w$word,
          freq=df_w$freq,
          min.freq=10,
          max.word=200,
          random.order=F,
          rot.per=.1,
          scale = c(4,0.3),
          colors=pal)
