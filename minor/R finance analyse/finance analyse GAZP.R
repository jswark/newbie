library(quantmod)

getwd()
#read GAZP
GAZP <- read.csv(file="GAZP.csv", header=TRUE, sep=";")
View(GAZP)
head(GAZP)
price_gazp <- GAZP$X.CLOSE.
date_GAZP <- GAZP$X.DATE.

#graphics
ggplot(data = GAZP, aes(x=date_GAZP, y=price_gazp)) + geom_line()
boxplot(price_gazp)
ggplot(data = GAZP, aes(x=price_gazp)) + 
  geom_histogram(binwidth = 5,
                 fill = "blue",
                 color = "black") +
  geom_vline(xintercept = median(price_gazp), 
             color = "red",
             lty = 2)
ggplot(data = GAZP, aes(x=price_gazp)) + 
  geom_histogram(aes(y = ..density..), 
                 fill = "blue",
                 color = "black") +
  geom_density(col = "violetred")

#statistics data
mean(price_gazp)
median(price_gazp)
sd(price_gazp)
summary(price_gazp)

#test norm
ks.test(price_gazp, 'pnorm', mean=mean(price_gazp), sd=sd(price_gazp))
Zst=(price_gazp - mean(price_gazp))/sd(price_gazp)
qqnorm(Zst)
qqline(Zst)
