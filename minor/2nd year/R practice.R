#создать 2 выборки с норм распределением и си квадратным. +шистограмы, бокс плот, сумму разность 
#мат операции с выборками 

a<-rnorm(100, 0, 1)
b<-rchisq(100, 7)

plot(a, cex=2, main='normal')
ks.test(a, 'pnorm', mean=mean(a), sd=sd(a))
shapiro.test(a)
plot(b, cex=2, main='xi2')
ks.test(b, 'pnorm', mean=mean(b), sd=sd(b))
boxplot(a, b, main='two r normal and xi2')
shapiro.test(b)
bst=(b-mean(b))/sd(b)
ast=(a-mean(a))/sd(a)
qqnorm(ast)
qqline(ast)
qqnorm(bst)
qqline(bst)
hist(a, breaks=20, main="hist for norm")
hist(b, breaks=20, main="hist for xi2")

c=a+b
c=a*b
c=b/a
