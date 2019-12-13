FROM docker.elastic.co/logstash/logstash:7.0.1

RUN rm -f /usr/share/logstash/pipeline/logstash.conf
ADD logstash.conf /usr/share/logstash/pipeline/
RUN rm -f /usr/share/logstash/config/logstash.yml
ADD logstash.yml /usr/share/logstash/config/