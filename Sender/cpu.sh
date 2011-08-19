#!/bin/sh
vmstat|tail -n1|awk '{print $13}'