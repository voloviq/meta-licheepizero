#!/bin/sh

# If you are booting Tiny Core from a very fast storage such as SSD / NVMe Drive and getting 
# "ifconfig: SIOCSIFADDR: No such Device" or "route: SIOCADDRT: Network is unreachable"
# error during system boot, use this sleep statemet, otherwise you can remove it -
sleep .2

# kill dhcp client for eth0
sleep 1
if [ -f /var/run/udhcpc.usb0.pid ]; then
kill `cat /var/run/udhcpc.usb0.pid`
sleep 0.1
fi

# configure interface usb0
ifconfig usb0 192.168.10.1 netmask 255.255.255.0 broadcast 192.168.10.255 up

# Start the DHCP Server Process once the Interface is Ready with the IP Add
sleep .1
udhcpd /etc/udhcpd.conf &
