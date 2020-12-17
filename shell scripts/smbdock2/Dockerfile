FROM ubuntu:latest

ENV TZ=Europe/Kiev
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apt -y update
RUN apt -y install samba
COPY new_smb.conf /etc/samba/smb.conf
RUN echo "service smbd start" > run.sh
RUN chmod 777 run.sh

EXPOSE 80

CMD run.sh
