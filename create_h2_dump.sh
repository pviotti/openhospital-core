#!/bin/bash
#org.h2.Driver
docker-compose up

mysqldump --compatible=ansi,no_table_options,no_field_options,no_key_options --hex-blob --skip-opt --extended-insert=FALSE --no-create-info --protocol tcp -u isf -pisf123 -h localhost oh > data.sql
mysqldump --compatible=ansi,no_table_options,no_field_options,no_key_options --hex-blob --skip-opt --no-data --protocol tcp -u isf -pisf123 -h localhost oh > schema.sql

docker-compose down

rm -f db-test.*

java -cp ~/.m2/repository/com/h2database/h2/1.4.200/h2-1.4.200.jar org.h2.tools.RunScript -url "jdbc:h2:./db-test;MODE=MySQL;DATABASE_TO_LOWER=TRUE;IGNORECASE=TRUE" -script dump.sql
