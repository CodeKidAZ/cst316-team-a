#!/bin/sh
x=0
for i in `find . | grep fxml`; do
    x=`expr $x + $(cat $i | wc -l)`;
done
echo $x

