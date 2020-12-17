FROM ubuntu:latest

ENV TZ=Europe/Kiev
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apt -y update
RUN apt -y install samba
COPY new_smb.conf /etc/samba/smb.conf

EXPOSE 80

CMD /etc/init.d/smbd start "daemon off;"
