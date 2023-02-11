#!/bin/sh

cd /etc/init.d/
ifconfig usb0 up
./usb0.sh &
cd ~
