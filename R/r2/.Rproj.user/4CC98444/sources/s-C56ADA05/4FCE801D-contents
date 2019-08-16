hh <- read.csv("health.csv",na.string="NA",stringsAsFactors = FALSE)
head(hh)
hh2 <- (hh)
print(hh2)
library(sqldf)
result1<- sqldf('select avg("신장.5Cm단위.") as "키",avg("체중.5Kg.단위.")as "체중",avg("연령대코드.5세단위."*5) as "나이" from hh group by "성별코드"')
print(result1)
result2<- sqldf('select "연령대코드.5세단위."*5 as "나이",avg("시력.좌.") ,avg("시력.우."), avg("수축기혈압"),avg("이완기혈압")
                from hh group by "연령대코드.5세단위."*5
                ')
print(result2)
result3<- sqldf('select ("체중.5Kg.단위.")as "체중",avg("신장.5Cm단위."),
                avg("허리둘레") , count(*)
                from hh where "허리둘레" != 999 group by "체중.5Kg.단위."' )
