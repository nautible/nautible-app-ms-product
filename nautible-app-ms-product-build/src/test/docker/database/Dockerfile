FROM mysql:5.7.30

# COPY ../../../src/main/database/* /docker-entrypoint-initdb.d/
COPY initdb.d/* /docker-entrypoint-initdb.d/
COPY conf.d/my.cnf /etc/

USER mysql

RUN touch /var/log/mysql/mysqld.log

CMD ["mysqld"]
