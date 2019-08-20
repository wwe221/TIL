library(KoNLP)
library(dplyr)
library(stringr)
txt <- readLines("hiphop.txt")
txt2<-str_replace_all(txt,"\\W"," ")
nouns <- extractNoun(txt2)
cnt<-table(unlist(nouns))
df_cnt <- as.data.frame(cnt,stringsAsFactors = F)
colnames(df_cnt) <- c("word","freq")
df_word<- filter(df_cnt,nchar(word)>=2)
df_word<-df_word[order(df_word$freq,decreasing = T),]
head(df_word,20)

library(wordcloud)
pal <- brewer.pal(8,"Dark2")
set.seed(4321)
wordcloud(words= df_word$word,
          freq= df_word$freq,
          min.freq = 2,
          max.words = 200,
          random.order=F,
          rot.per = .1,
          scale = c(4,0,3),
          colors= pal)

