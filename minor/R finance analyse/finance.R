library(quantmod)

#download google
getSymbols("GOOG", src = "yahoo", from="2019-01-01")
price_goog = Ad(GOOG)

#graphics
chartSeries(GOOG)
plot(price_goog)
hist(price_goog)

#statistics data
mean(price_goog)
median(price_goog)
sd(price_goog)
summary(price_goog)

#test norm
ks.test(price_goog, 'pnorm', mean=mean(price_goog), sd=sd(price_goog))
Gst=(price_goog - mean(price_goog))/sd(price_goog)
qqnorm(Gst)
qqline(Gst)

#download apple
getSymbols("AAPL", src = "yahoo", from="2019-01-01")
price_aapl = Ad(AAPL)

#graphics
chartSeries(AAPL)
plot(price_aapl)
hist(price_aapl, breaks=20, main="AAPL")

#statistic data
mean(price_aapl)
median(price_aapl)
sd(price_aapl)
summary(price_aapl)

#test norm
ks.test(price_aapl, 'pnorm', mean=mean(price_aapl), sd=sd(price_aapl))
Ast=(price_aapl - mean(price_aapl))/sd(price_aapl)
qqnorm(Ast)
qqline(Ast)


getwd()
#read GAZP
GAZP <- read.csv(file="GAZP.csv", header=TRUE, sep=";")
View(GAZP)
head(GAZP)
price_gazp <- GAZP$X.CLOSE.

#graphics
plot(price_gazp)
boxplot(price_gazp)
hist(price_gazp)

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
