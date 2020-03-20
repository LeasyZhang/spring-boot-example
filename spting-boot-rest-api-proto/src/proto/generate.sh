#!/usr/bin/env bash


SRC_DIR=`pwd`
DST_DIR=`pwd`../main/

echo source:            $SRC_DIR
echo destination root:  $DST_DIR

function gen(){
    D=$1
    echo $D
    OUT=$DST_DIR/$D
    mkdir -p $OUT
    protoc -I=$SRC_DIR --${D}_out=$OUT $SRC_DIR/customer.proto
}

gen java
gen python