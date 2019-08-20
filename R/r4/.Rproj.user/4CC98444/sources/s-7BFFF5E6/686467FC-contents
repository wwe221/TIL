library(kormaps2014)
library(ggiraphExtra)
library(ggplot2)
library(dplyr)
install.packages("mapproj")
head(changeCode(korpop1))
str(korpop1)

kp <- korpop1
kp<-rename(korpop1, pop="총인구_명",name="행정구역별_읍면동")
ggChoropleth( data=kp,
               aes( fill= pop, map_id=code,tooltip=name),
               map=kormap1,
               interactive = T )
