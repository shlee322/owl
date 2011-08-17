#!/bin/sh
cat /proc/net/dev|grep eth0:|awk '{print $2 " " $3 " " $10 " " $11}'