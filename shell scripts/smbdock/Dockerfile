FROM ubuntu:latest

ENV TZ=Europe/Kiev
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apt-get -qq -y update
RUN apt-get -qq -y install nginx

COPY new_nginx.conf /etc/nginx/sites-available/new
RUN rm /etc/nginx/sites-enabled/default && ln -s /etc/nginx/sites-available/new /etc/nginx/sites-enabled/new && nginx -t

CMD nginx -g "daemon off;"
