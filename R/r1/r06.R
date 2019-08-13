df1 <- data.frame(
  a = c(1:4),
  b = c(5:8),
  c = c(9:12),
  d = c("A", "B", "A", "A")
)
rownames(df1) <- c("aa", "bb", "cc", "dd")

print(df1)
df2 <- df1[, -4]
print(df2)
print(mean(df2$a))
print(df2[1, ])
print(class(df2[1, ]))
print(mean(as.numeric(df2[1, ])))

df3 <- df1[c(1:4),c(1:3)]
print(df3)

print(df1[,c("a","b")])

View(df3)
