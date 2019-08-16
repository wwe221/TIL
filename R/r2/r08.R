library(sqldf)
head(iris)
result <- sqldf('select Species,avg("Sepal.Length" ) 
                from iris group by Species')
print(result)

tt <- read.csv("titanic.csv",na.string="NA",stringsAsFactors = FALSE)
head(tt)

tt <-sqldf('select "pclass" ,"sex", avg("survived"),
            count(*) from tt group by "pclass" , "sex" 
            having avg("survived") > 0.5'
           )
      
print(tt)